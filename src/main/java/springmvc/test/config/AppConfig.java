package springmvc.test.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("springmvc.test")
@EnableWebMvc //开户WebMvc基础设施支持
@MapperScan("springmvc.test.mapper")
@PropertySource("classpath:jdbc.properties")
/**
 * springmvc配置类（dataSource,sqlsessionFactoryBean）
 * @author Administrator
 *
 */
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public DataSource dataSource(Environment env) {
		
		DriverManagerDataSource dmds=new DriverManagerDataSource(
				env.getProperty("jdbc.url"),
				env.getProperty("jdbc.username"),
				env.getProperty("jdbc.password")
				);
		dmds.setDriverClassName(env.getProperty("jdbc.driverClassName"));		
		
		return dmds;		
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		
		SqlSessionFactoryBean sb=new SqlSessionFactoryBean();
		sb.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sb.setDataSource(dataSource);
		return sb;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);		
		return passwordEncoder;		
	} 
	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// book-list -> /WEB-INF/jsp/book-list.jsp
		// 对于控制器方法返回的字符串，会用以下规则解析成jsp路径，然后forward
		// 前缀 + 返回字符串 + 后缀 = jsp路径
		//            		前缀       后缀
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	
}
