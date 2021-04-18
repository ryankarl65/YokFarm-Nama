package cm.yokfarm.nama.msprovider.application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryank
 */




import dtoassembler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoAssemblerConf {
    
     @Bean("dtoToEntity")
    public DtoToEntity dtoToEntity() {
        return new DtoToEntityImpl();
    }
    @Bean("entityToDto")
    public EntityToDto entityToDto() {
        return new EntityToDtoImpl();
    }   
}

