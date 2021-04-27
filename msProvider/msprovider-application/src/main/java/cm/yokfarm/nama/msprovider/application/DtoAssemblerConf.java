package cm.yokfarm.nama.msprovider.application;

/**
 *
 * @author Meudje
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