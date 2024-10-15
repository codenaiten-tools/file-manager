package com.codenaiten.tools.filemanager.core.properties;

import java.util.Optional;

public class FileManagerProperties {

    private String defaultDirectory;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| SETTERS & GETTERS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public void setDefaultDirectory( final String defaultDirectory ) {
        this.defaultDirectory = defaultDirectory;
    }

    public Optional<String> getDefaultDirectory() {
        return Optional.ofNullable( this.defaultDirectory );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
