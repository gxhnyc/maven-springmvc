package springmvc.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity //开启WebSecurity组件功能，获得了SpringSecurityFilterChain组件

public class SecurityConfig {
	// 默认所有请求都需要登录，对于这个后台管理系统来说，可以不改
	
	@Bean
    public UserDetailsService userDetailsService() {
        // 提供用户详情，用于检查登录的用户名和密码,创建了两个用户，密码为加密后的‘123456’,一个账户对应一个会话
        InMemoryUserDetailsManager um = new InMemoryUserDetailsManager();
        um.createUser(User
                .withUsername("zs")
                .password("$2a$10$pyhoz7k3QLux1jrJmuE.ZOenAbfrGpa8cSMYa4xs9reYaDsUyXsfG")
                .authorities("图书管理员").build());
        um.createUser(User
                .withUsername("ls")
                .password("$2a$10$pyhoz7k3QLux1jrJmuE.ZOenAbfrGpa8cSMYa4xs9reYaDsUyXsfG")
                .authorities("管理参观者").build());
        return um;
    }
}
