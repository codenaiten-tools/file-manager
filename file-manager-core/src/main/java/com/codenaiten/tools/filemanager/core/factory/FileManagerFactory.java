package com.codenaiten.tools.filemanager.core.factory;

import com.codenaiten.tools.filemanager.core.FileManager;
import com.codenaiten.tools.filemanager.core.FileManagerReader;
import com.codenaiten.tools.filemanager.core.FileManagerWritter;
import com.codenaiten.tools.filemanager.core.impl.FileManagerImpl;
import com.codenaiten.tools.filemanager.core.impl.FileManagerReaderImpl;
import com.codenaiten.tools.filemanager.core.impl.FileManagerWritterImpl;
import com.codenaiten.tools.filemanager.core.properties.FileManagerProperties;

public abstract class FileManagerFactory {

    protected final FileManagerProperties fileManagerProperties;

    public FileManagerFactory( final FileManagerProperties fileManagerProperties) {
        this.fileManagerProperties = fileManagerProperties;
    }

    public FileManagerReader fileManagerReader() {
        return new FileManagerReaderImpl( this.fileManagerProperties );
    }

    public FileManagerWritter fileManagerWritter() {
        return new FileManagerWritterImpl( this.fileManagerProperties );
    }

    public FileManager fileManager() {
        return new FileManagerImpl( this.fileManagerProperties, this.fileManagerReader(), this.fileManagerWritter() );
    }
}
