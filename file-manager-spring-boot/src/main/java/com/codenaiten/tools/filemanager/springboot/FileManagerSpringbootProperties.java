package com.codenaiten.tools.filemanager.springboot;

import com.codenaiten.tools.filemanager.core.properties.FileManagerProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Propiedades del File Manager.
 */
@Component
public class FileManagerSpringbootProperties extends FileManagerProperties {

    /** Prefijo bajo el que se encuentran las propiedades del File Manager. */
    public static final String PREFIX = "codenaiten.filemanager";


    /**
     * Establece el directorio de almacenamiento por defecto.
     *
     * @param defaultDirectory El directorio de almacenamiento por defecto.
     */
    @Value( "${" + PREFIX + ".default.directory:}" )
    @Override
    public void setDefaultDirectory( final String defaultDirectory ) {
        super.setDefaultDirectory(defaultDirectory);
    }

}
