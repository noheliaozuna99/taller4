package py.nohelia.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


// Habilitar el modulo MVC de spring
@EnableWebMvc

//Cargar los paquetes del controller y dao
@ComponentScan(basePackageClasses = { })
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	// Indicamos que es un objeto de configuracion 

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		//Prefijo de la pagina
		resolver.setPrefix("/static/");
		
		//Extencion del archivo
		resolver.setSuffix(".html");
		return resolver;
	}
	//Habilitar las peticiones para recursos estáticos dentro de AppWebConfiguration.
		@Override
			public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
				configurer.enable();
			}


		//paquete package org.springframework.format.datetime
		@Bean  	
		public FormattingConversionService mvcConversionService() 
		{ 	
		 	DefaultFormattingConversionService conversionService =  	new DefaultFormattingConversionService(true);
		 	DateFormatterRegistrar registrar = new DateFormatterRegistrar(); 
		 	registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));  
		 	registrar.registerFormatters(conversionService); 
		 	return conversionService; 
		 	} 
		 


}
