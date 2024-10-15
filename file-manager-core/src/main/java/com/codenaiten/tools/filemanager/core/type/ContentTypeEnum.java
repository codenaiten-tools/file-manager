package com.codenaiten.tools.filemanager.core.type;

import com.codenaiten.tools.filemanager.core.dto.FileInfo;

public enum ContentTypeEnum {

    // Texto y documentos
    JSON("application/json", "json", new byte[] {0x7B}),
    XML("application/xml", "xml", new byte[] {0x3C, 0x3F, 0x78, 0x6D, 0x6C}),
    HTML("text/html", "html", new byte[] {0x3C, 0x21, 0x44, 0x4F, 0x43, 0x54, 0x59, 0x50, 0x45}),
    PLAIN_TEXT("text/plain", "txt", null),
    CSV("text/csv", "csv", null),
    PDF("application/pdf", "pdf", new byte[] {0x25, 0x50, 0x44, 0x46}),
    DOC("application/msword", "doc", new byte[] {(byte) 0xD0, (byte) 0xCF, 0x11, (byte) 0xE0}),
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx", new byte[] {0x50, 0x4B, 0x03, 0x04}),
    XLS("application/vnd.ms-excel", "xls", new byte[] {(byte) 0xD0, (byte) 0xCF, 0x11, (byte) 0xE0}),
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx", new byte[] {0x50, 0x4B, 0x03, 0x04}),
    PPT("application/vnd.ms-powerpoint", "ppt", new byte[] {(byte) 0xD0, (byte) 0xCF, 0x11, (byte) 0xE0}),
    PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx", new byte[] {0x50, 0x4B, 0x03, 0x04}),

    // Imágenes
    JPEG("image/jpeg", "jpeg", new byte[] {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF}),
    PNG("image/png", "png", new byte[] {(byte) 0x89, 0x50, 0x4E, 0x47}),
    GIF("image/gif", "gif", new byte[] {0x47, 0x49, 0x46, 0x38}),
    BMP("image/bmp", "bmp", new byte[] {0x42, 0x4D}),
    TIFF("image/tiff", "tiff", new byte[] {0x49, 0x49, 0x2A, 0x00}),
    SVG("image/svg+xml", "svg", null),
    WEBP("image/webp", "webp", new byte[] {0x52, 0x49, 0x46, 0x46}),

    // Audio
    MP3("audio/mpeg", "mp3", new byte[] {(byte) 0xFF, (byte) 0xFB}),
    WAV("audio/wav", "wav", new byte[] {0x52, 0x49, 0x46, 0x46}),
    OGG("audio/ogg", "ogg", new byte[] {0x4F, 0x67, 0x67, 0x53}),
    AAC("audio/aac", "aac", null),
    FLAC("audio/flac", "flac", new byte[] {0x66, 0x4C, 0x61, 0x43}),

    // Video
    MP4("video/mp4", "mp4", new byte[] {0x00, 0x00, 0x00, 0x18, 0x66, 0x74, 0x79, 0x70}),
    AVI("video/x-msvideo", "avi", new byte[] {0x52, 0x49, 0x46, 0x46}),
    MOV("video/quicktime", "mov", new byte[] {0x00, 0x00, 0x00, 0x14, 0x66, 0x74, 0x79, 0x70}),
    WEBM("video/webm", "webm", new byte[] {0x1A, 0x45, (byte) 0xDF, (byte) 0xA3}),
    MKV("video/x-matroska", "mkv", new byte[] {0x1A, 0x45, (byte) 0xDF, (byte) 0xA3}),

    // Archivos comprimidos
    ZIP("application/zip", "zip", new byte[] {0x50, 0x4B, 0x03, 0x04}),
    RAR("application/vnd.rar", "rar", new byte[] {0x52, 0x61, 0x72, 0x21}),
    GZIP("application/gzip", "gz", new byte[] {0x1F, (byte) 0x8B}),
    TAR("application/x-tar", "tar", null),
    BZIP("application/x-bzip", "bz", new byte[] {0x42, 0x5A, 0x68}),
    BZIP2("application/x-bzip2", "bz2", new byte[] {0x42, 0x5A, 0x68}),

    // Fuentes
    TTF("font/ttf", "ttf", new byte[] {0x00, 0x01, 0x00, 0x00}),
    OTF("font/otf", "otf", new byte[] {0x4F, 0x54, 0x54, 0x4F}),
    WOFF("font/woff", "woff", new byte[] {0x77, 0x4F, 0x46, 0x46}),
    WOFF2("font/woff2", "woff2", new byte[] {0x77, 0x4F, 0x46, 0x32}),

    // JSON especificaciones
    JSON_LD("application/ld+json", "jsonld", new byte[] {0x7B}),
    JSON_API("application/vnd.api+json", "json", new byte[] {0x7B}),

    // Otros
    OCTET_STREAM("application/octet-stream", "bin", null),
    FORM_DATA("multipart/form-data", "", null);

// ------------------------------------------------------------------------------------------------------------------ \\

    private final String mimeType;
    private final String extension;
    private final byte[] headers;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    ContentTypeEnum( final String mimeType, final String extension, final byte[] headers ) {
        this.mimeType = mimeType;
        this.extension = extension;
        this.headers = headers;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| GETTERS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public String getMimeType() {
        return this.mimeType;
    }

    public String getExtension() {
        return this.extension;
    }

    public byte[] getHeaders() {
        return this.headers != null ? this.getHeaders() : new byte[0];
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| VALIDATION METHODS |----------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public boolean check( final String extension ){
        final String extensionNormalized = normalizeExtension( extension );
        return this.extension.equalsIgnoreCase( extensionNormalized );
    }

    public boolean check( final byte[] bytes ) {
        final byte[] headers = this.getHeaders();
        if( bytes == null || bytes.length < headers.length ){
            return false;
        }

        for( int i = 0 ; i < headers.length ; i++ ){
            if( bytes[ i ] != headers[ i ]){
                return false;
            }
        }
        return true;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDER METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static ContentTypeEnum fromMimeType( final String mimeType ) {
        final String mimeTypeNormalized = normalizeMimeType( mimeType );
        for( final ContentTypeEnum contentTypeEnum : ContentTypeEnum.values() ){
            if( contentTypeEnum.getMimeType().equals( mimeTypeNormalized )){
                return contentTypeEnum;
            }
        }
        return null;
    }

    public static ContentTypeEnum fromExtension( final String extension ) {
        for( final ContentTypeEnum contentTypeEnum : ContentTypeEnum.values() ){
            if( contentTypeEnum.check( extension )){
                return contentTypeEnum;
            }
        }
        return null;
    }

    public static ContentTypeEnum fromBytes( final byte[] bytes ){
        for( final ContentTypeEnum contentTypeEnum : ContentTypeEnum.values() ){
            if( contentTypeEnum.check( bytes )){
                return contentTypeEnum;
            }
        }
        return null;
    }

    public static ContentTypeEnum fromFileInfo( final FileInfo fileInfo ){
        final String fileExtension = fileInfo.getExtension().orElse( "" );
        final byte[] fileContent = fileInfo.getContent(10L );
        for( final ContentTypeEnum contentTypeEnum : ContentTypeEnum.values() ){
            if( contentTypeEnum.check( fileExtension ) || contentTypeEnum.check( fileContent )){
                return contentTypeEnum;
            }
        }
        return null;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| UTILITY METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static String normalizeExtension( final String extension ){
        String result = extension.toLowerCase().trim();
        if( result.startsWith( "." )) result = result.substring( 1 );
        return result;
    }

    public static String normalizeMimeType( final String mimeType ){
        return mimeType.toLowerCase().trim();
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
