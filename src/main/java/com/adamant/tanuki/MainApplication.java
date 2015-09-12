package com.adamant.tanuki;

import com.adamant.tanuki.controller.CalculationController;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by igor on 03.09.2015.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"com.adamant.tanuki.controller", "com.adamant.tanuki.service"})
@EnableJpaRepositories(basePackages = "com.adamant.tanuki.db")
@EntityScan(basePackages = "com.adamant.tanuki.model")
public class MainApplication extends SpringBootServletInitializer {
    @Autowired
    @Bean(name="sessionFactory")
    public SessionFactory sessionFactory(HibernateEntityManagerFactory factory) {
        return factory.getSessionFactory();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<MainApplication> applicationClass = MainApplication.class;

}
