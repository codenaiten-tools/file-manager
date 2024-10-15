package com.codenaiten.tools.filemanager.core.dto;

import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;
import com.codenaiten.tools.filemanager.core.adapter.FileContentAdaptable;

import java.io.File;

public class FileData {

    private final File file;
    private final byte[] content;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    private FileData( final File file, final byte[] content ) {
        this.file = file;
        this.content = content;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| GETTERS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public File getFile() {
        return this.file;
    }

    public byte[] getContent() {
        return this.content;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDER METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static FileDataBuilder create( final File file, final byte[] content ) {
        if( file == null ) throw new IllegalArgumentException( "The file is required" );
        if( content == null ) throw new IllegalArgumentException( "The content is required" );

        return new FileDataBuilder().file( file ).content( content );
    }

    public static FileDataBuilder create(final FileAdaptable fileAdapter, final FileContentAdaptable fileContentAdapter ) {
        if( fileAdapter == null ) throw new IllegalArgumentException( "The file adapter is required" );
        if( fileContentAdapter == null ) throw new IllegalArgumentException( "The file content adapter is required" );

        final File file = fileAdapter.get();
        final byte[] content = fileContentAdapter.get();
        return create( file, content );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDER |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static class FileDataBuilder {
        private File file;
        private byte[] content;

        public FileDataBuilder file( final File file ) {
            if( file == null ) throw new IllegalArgumentException( "The file must not be null" );

            this.file = file;
            return this;
        }

        public FileDataBuilder content( final byte[] content ) {
            if( content == null ) throw new IllegalArgumentException( "The content must not be null" );
            if( content.length == 0 ) throw new IllegalArgumentException( "The content must not be empty" );

            this.content = content;
            return this;
        }

        public FileData build() {
            return new FileData( this.file, this.content );
        }
    }

// ------------------------------------------------------------------------------------------------------------------ \\
}
