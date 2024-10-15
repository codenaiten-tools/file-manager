package com.codenaiten.tools.filemanager.core.adapter.impl;

import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;

import java.io.File;
import java.nio.file.Path;

public class FileAdapter implements FileAdaptable {

    private final File file;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    private FileAdapter( final File file ) {
        this.file = file;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENTED METHODS |---------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public File get() {
        return this.file;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDER METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static FileAdapter of( final Path path ) {
        final File file = path.toFile();
        return new FileAdapter( file );
    }

    public static FileAdapter of( final String stringPath ) {
        final Path path = Path.of( stringPath );
        return of( path );
    }

    public static FileAdapter of( final String stringFilePath, final String fileName ) {
        final Path path = Path.of( stringFilePath, fileName );
        return of( path );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
