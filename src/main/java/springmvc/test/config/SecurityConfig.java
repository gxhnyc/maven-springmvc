package springmvc.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public UserDetailsService userDetailsService() {
        // 提供用户详情，用于检查登录的用户名和密码
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
