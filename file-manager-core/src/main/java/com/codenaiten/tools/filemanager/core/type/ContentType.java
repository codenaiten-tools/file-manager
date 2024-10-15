package com.codenaiten.tools.filemanager.core.type;

import java.util.Optional;

public class ContentType {

    private final ContentTypeEnum contentTypeEnum;
    private final String mimeType;
    private final String extension;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    private ContentType( final ContentTypeEnum contentTypeEnum ) {
        this.contentTypeEnum = contentTypeEnum;
        this.mimeType = contentTypeEnum.getMimeType();
        this.extension = contentTypeEnum.getExtension();
    }

    private ContentType( final String mimeType ){
        this( mimeType, null );
    }

    private ContentType( final String mimeType, final String extension ){
        String newMimeType = mimeType;
        String newExtension = extension;
        ContentTypeEnum newContentTypeEnum = ContentTypeEnum.fromMimeType( mimeType );
        if( newContentTypeEnum == null ) newContentTypeEnum = ContentTypeEnum.fromExtension( extension );

        if( newContentTypeEnum != null ){
            newMimeType = newContentTypeEnum.getMimeType();
            newExtension = newContentTypeEnum.getExtension();
        }

        this.contentTypeEnum = newContentTypeEnum;
        this.mimeType = newMimeType;
        this.extension = newExtension;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| GETTERS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public Optional<ContentTypeEnum> getContentTypeEnum() {
        return Optional.ofNullable( this.contentTypeEnum );
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Optional<String> getExtension() {
        return Optional.ofNullable( this.extension );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDER METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static ContentType of( final ContentTypeEnum contentTypeEnum ){
        return new ContentType( contentTypeEnum );
    }

    public static ContentType of( final String mimeType, final String extension ){
        return new ContentType( mimeType, extension );
    }

    public static ContentType of( final String mimeType ){
        return new ContentType( mimeType );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
