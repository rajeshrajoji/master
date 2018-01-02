package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.sample.model.User;
import com.sample.repository.IUserRepository;


@SpringBootApplication
@ComponentScan(basePackages = { "com.sample" })
@EnableTransactionManagement
@ImportResource("context.xml")
//@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableCaching
@Transactional
public class Application implements CommandLineRunner{
	
	@Autowired
	IUserRepository userRepository;
	
	//private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder("ThisIsASecretSoChangeMe");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		User user = new com.sample.model.User("user", passwordEncoder().encode("user"));        
		userRepository.save(user);
		
	}
	
	@Bean
	 public FilterRegistrationBean securityFilterChainRegistration() {
	 DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
	 delegatingFilterProxy.setTargetBeanName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
	 FilterRegistrationBean registrationBean = new FilterRegistrationBean(delegatingFilterProxy);
	 registrationBean.setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
	 registrationBean.addUrlPatterns("/*");
	 return registrationBean;
	 }


}
