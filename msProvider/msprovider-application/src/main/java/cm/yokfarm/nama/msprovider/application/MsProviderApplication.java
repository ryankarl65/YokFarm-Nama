/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.yokfarm.nama.msprovider.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author ryank
 */

@SpringBootApplication
//@EntityScan(basePackages = {""})
//@EnableJpaRepositories(basePackages = {""})
@PropertySource("classpath:application.properties")
@EnableScheduling
public class MsProviderApplication //extends SpringBootServletInitializer 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MsProviderApplication.class, args);
    }
    
}
