package com.codenaiten.tools.filemanager.springboot.config;

import com.codenaiten.tools.filemanager.core.FileManager;
import com.codenaiten.tools.filemanager.core.FileManagerReader;
import com.codenaiten.tools.filemanager.core.FileManagerWritter;
import com.codenaiten.tools.filemanager.core.factory.FileManagerFactory;
import com.codenaiten.tools.filemanager.springboot.FileManagerSpringbootProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;



/**
 * Configuración de Spring Boot para el File Manager.
 * Define los beans relacionados con el módulo core del File Manager solo cuando se cumplan las condiciones especificadas.
 */
@AutoConfiguration
@ConditionalOnClass( FileManager.class )
@ConditionalOnProperty( prefix = FileManagerSpringbootProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true )
public class FileManagerSpringBootConfig extends FileManagerFactory {

    /**
     * Constructor que inyecta las dependencias necesarias.
     *
     * @param properties Las propiedades del File Manager.
     */
    @Autowired( required = false)
    public FileManagerSpringBootConfig( final FileManagerSpringbootProperties properties ) {
        super( properties );
    }


    /**
     * Define un bean de FileManagerReader en el contexto de Spring, si no hay otro bean del mismo tipo ya definido.
     *
     * @return Una instancia de {@link FileManagerReader}.
     */
    @ConditionalOnMissingBean
    @Bean
    @Override
    public FileManagerReader fileManagerReader() {
        return super.fileManagerReader();
    }


    /**
     * Define un bean de FileManagerWritter en el contexto de Spring, si no hay otro bean del mismo tipo ya definido.
     *
     * @return Una instancia de {@link FileManagerWritter}.
     */
    @ConditionalOnMissingBean
    @Bean
    @Override
    public FileManagerWritter fileManagerWritter() {
        return super.fileManagerWritter();
    }


    /**
     * Define un bean de FileManager en el contexto de Spring, si no hay otro bean del mismo tipo ya definido.
     *
     * @return Una instancia de {@link FileManager}.
     */
    @Bean
    @ConditionalOnMissingBean
    @Override
    public FileManager fileManager(){
       return super.fileManager();
    }
}
