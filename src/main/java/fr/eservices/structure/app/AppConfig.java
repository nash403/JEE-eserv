package fr.eservices.structure.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan({"fr.eservices.structure.app","fr.eservices.structure.dao","fr.eservices.structure.model","fr.eservices.structure.srv"})
public class AppConfig {

	@Bean
	  public InternalResourceViewResolver urlBasedViewResolver()
	    {
	        InternalResourceViewResolver res = new InternalResourceViewResolver();
	        res.setPrefix("/WEB-INF/views/");
	        res.setSuffix(".jsp");

	        return res;
	    }
}
