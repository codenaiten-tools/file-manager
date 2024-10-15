package com.codenaiten.tools.filemanager.core.dto;

import com.codenaiten.tools.filemanager.core.type.ContentType;
import com.codenaiten.tools.filemanager.core.type.ContentTypeEnum;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

public class FileInfo {

    private final File file;
    private final ContentType contentType;
    private final byte[] content;
    private final String extension;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    private FileInfo( final File file, final ContentType contentType, final byte[] content ) {
        this.file = file;
        this.contentType = contentType;
        this.content = content;
        this.extension = getFileExtension( file ).orElse( null );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| GETTERS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public File getFile() {
        return this.file;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public String getMimeType() {
        return this.contentType.getMimeType();
    }

    public byte[] getContent() {
        return this.content != null ? this.content : new byte[0];
    }

    public byte[] getContent( final Long size ) {
        if( size == null ) throw new IllegalArgumentException( "The size cannot be null" );
        if( size < 0 ) throw new IllegalArgumentException( "The size cannot be negative" );
        if( size > this.content.length ) throw new IllegalArgumentException( "The size cannot be greater than the content size" );

        final byte[] result = new byte[ size.intValue() ];
        System.arraycopy( this.content, 0, result, 0, size.intValue() );
        return result;
    }

    public String getContentAsString() {
        return new String( this.content );
    }

    public Optional<String> getExtension() {
        return Optional.ofNullable( this.extension );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| UTILITY METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static Optional<String> getFileExtension( final File file ) {
        Optional<String> result = Optional.empty();
        final String fileName = file.getName();
        final int lastIndexOfDot = fileName.lastIndexOf(".");

        // Verifica si el archivo tiene una extensión
        if( lastIndexOfDot > 0 && lastIndexOfDot < fileName.length() - 1 ){
            result = Optional.of( fileName.substring(lastIndexOfDot + 1) );
        }

        return result;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CREATION METHODS |------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static FileInfo.FieInfoBuilder create( final File file ) {
        if( file == null ) throw new IllegalArgumentException( "The file is required" );

        return new FileInfo.FieInfoBuilder().file( file );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDER |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static class FieInfoBuilder {
        private File file;
        private ContentType contentType;
        private byte[] content;

        public FieInfoBuilder file( final File file ) {
            if( file == null ) throw new IllegalArgumentException( "The file cannot be null" );

            this.file = file;
            return this;
        }

        public FieInfoBuilder file( final Path path ) {
            if( path == null ) throw new IllegalArgumentException( "The path cannot be null" );

            this.file = path.toFile();
            return this;
        }

        public FieInfoBuilder file( final String stringPath ) {
            if( stringPath == null ) throw new IllegalArgumentException( "The path cannot be null" );
            if( stringPath.isEmpty() ) throw new IllegalArgumentException( "The path cannot be empty" );

            this.file = new File( stringPath );
            return this;
        }

        public FieInfoBuilder contentType( final ContentTypeEnum contentTypeEnum ) {
            if( contentTypeEnum == null ) throw new IllegalArgumentException( "The content type cannot be null" );

            this.contentType = ContentType.of( contentTypeEnum );
            return this;
        }

        public FieInfoBuilder contentType( final String contentType ) {
            if( contentType == null ) throw new IllegalArgumentException( "The content type cannot be null" );
            if( contentType.isEmpty() ) throw new IllegalArgumentException( "The content type cannot be empty" );

            this.contentType = ContentType.of( contentType );
            return this;
        }

        public FieInfoBuilder content( final byte[] content ) {
            if( content == null ) throw new IllegalArgumentException( "The content cannot be null" );
            if( content.length == 0 ) throw new IllegalArgumentException( "The content cannot be empty" );

            this.content = content;
            return this;
        }

        public FileInfo build() {
            FileInfo result = new FileInfo( this.file, this.contentType, this.content );
            if( this.contentType != null ) {
                final ContentTypeEnum contentTypeEnum = ContentTypeEnum.fromFileInfo( result );
                if( contentTypeEnum != null ) {
                    result = new FileInfo( this.file, ContentType.of( contentTypeEnum ), this.content );
                }
            }
            return result;
        }
    }

// ------------------------------------------------------------------------------------------------------------------ \\
}
