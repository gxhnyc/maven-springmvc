package springmvc.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //开启WebSecurity组件功能，获得了SpringSecurityFilterChain组件
@EnableGlobalMethodSecurity(prePostEnabled=true)//开启方法级别权限检查支持（@preAuthorize）

public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	// 默认所有请求都需要登录，对于这个后台管理系统来说，可以不改
	/**
	 * 登录逻辑说明：
	 * 1.用户名：zs	，密码：123456
	 * 2.验证、处理：post/login
	 * 		UserDetails user=UserDetailsServiceImpl.loadUserByUserName("zs");
	 * 		String encodePassword=user.getPassword();
	 * 		boolean passwordOk=passwordEncoder.matches("123456",encodePassword);
	 * 	if(passwordOk==true){
	 * 		将用户详情放入会话；重定向到触发登录的页面或者默认登录成功页（可配置）
	 * }else 回到登录页面，显示错误消息（用户名或密码错误）
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()//请求页面配置授权
		.antMatchers("/login").permitAll()//login页面允许所有用户访问，包括匿名用户
		.antMatchers("/**").authenticated()//其他页面仅限于用户登录后访问
		.and()
		.formLogin()//配置表单登录
		.loginPage("/login")//指定登录页面的路径：显示表单（自己写） GET /login；提交表单（springsecurity自带） POST /login
		.defaultSuccessUrl("/operators/operator-list");//指定默认登录成功页面（比如直接访问登录页面，而不是其他需要登录的页面触发的）
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Bean
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
    }*/
}
