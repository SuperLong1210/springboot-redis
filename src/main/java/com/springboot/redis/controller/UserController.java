package com.springboot.redis.controller;

import com.springboot.redis.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 测试
 *
 * @author WangLonglong
 * @email caption1215@gmail.com
 * @date 2019/3/20 13:40
 */
@RestController
public class UserController {

    @RequestMapping("getUser")
    @Cacheable(value = "user-key")
    public User getUser() {
        User user = new User(1L, "a.126.com", "a", "a12345", "aa", "123");
        System.err.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    /**
     * 打开 http://localhost:8080/uid ,同时打开 Redis Desktop ，会发现页面中的值和 redis 中存的值一致
     * 说明 Session 已经在 Redis 里面进行有效的管理
     *
     * @param session
     * @return
     */
    @RequestMapping("uid")
    public String uid(HttpSession session) {
        UUID uuid = (UUID) session.getAttribute("uid");
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid", uuid);

        return session.getId();
    }
}
