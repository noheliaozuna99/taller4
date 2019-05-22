package py.nohelia.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// propio de Spring para gestionar
@EnableTransactionManagement 
public class JPAConfiguration { 
 	 
 	@Bean                                                                                                                                                                          
 	public LocalContainerEntityManagerFactoryBean  	entityManagerFactory(){                                                                                                                                                                                                     
 	LocalContainerEntityManagerFactoryBean em = new  	LocalContainerEntityManagerFactoryBean();  	em.setDataSource(dataSource());  
 	em.setPackagesToScan(new String[]  	{ "py.nohelia.martinez.entidad" });  	JpaVendorAdapter vendorAdapter =  	new HibernateJpaVendorAdapter();  	em.setJpaVendorAdapter(vendorAdapter);  	em.setJpaProperties(additionalProperties()); 
 	return em; 
 	} 
 	@Bean
	public DataSource dataSource() {
 		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		                                                       //clase
		dataSource.setUrl("jdbc:postgresql://localhost:5432/bd_proyecto");
		            //usuario y contrsenha
		dataSource.setUsername("postgres");
		dataSource.setPassword("12345");
		return dataSource;
	} 
 	 
Properties additionalProperties() {
		Properties properties = new Properties();
		
		                                        //actualizar el esquema
		                                        
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		// properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
 
 	@Bean 
 	public PlatformTransactionManager 
transactionManager 
 	(EntityManagerFactory emf){ 
 	JpaTransactionManager transactionManager =  	new JpaTransactionManager(); 
 	transactionManager.setEntityManagerFactory(emf);  	return transactionManager; 
 	} 
 	 
} //FIN CLASE JPAConfiguration
