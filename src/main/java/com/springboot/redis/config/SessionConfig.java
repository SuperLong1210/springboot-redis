package com.springboot.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Spring Session 提供了一套创建和管理 Servlet HttpSession 的方案。
 * Spring Session 提供了集群 Session（Clustered Sessions）功能，默认采用外置的 Redis 来存储 Session 数据，
 * 以此解决 Session 共享的问题。
 *
 * @author WangLonglong
 * @email caption1215@gmail.com
 * @date 2019/3/20 13:56
 */
@Configuration
/**
 * 设置 Session 失效时间，使用 Redis Session 之后，原 SpringBoot 的 server.session.timeout 属性不再生效
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 3)
public class SessionConfig {

}
