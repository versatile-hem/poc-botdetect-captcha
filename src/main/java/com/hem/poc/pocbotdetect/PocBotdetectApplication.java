package com.hem.poc.pocbotdetect;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.captcha.botdetect.web.servlet.SimpleCaptchaServlet;

/**
 * @author hem
 *
 */
@SpringBootApplication
public class PocBotdetectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocBotdetectApplication.class, args);
	}

	/**
	 * Adding URL for captcha endpoint
	 * @return
	 */
	@Bean
	ServletRegistrationBean captchaServletRegistration() {
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new SimpleCaptchaServlet());
		srb.addUrlMappings("/simple-captcha-endpoint");
		return srb;

	}

	/**
	 * Initializing BDC_configFileLocation by the botdetect.xml
	 * @return
	 */
	@Bean
	public ServletContextInitializer initializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.setInitParameter("BDC_configFileLocation", "/resources/botdetect.xml");
			}
		};
	}

}
