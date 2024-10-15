package com.codenaiten.tools.filemanager.core.impl;

import com.codenaiten.tools.filemanager.core.FileManager;
import com.codenaiten.tools.filemanager.core.FileManagerReader;
import com.codenaiten.tools.filemanager.core.FileManagerWritter;
import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;
import com.codenaiten.tools.filemanager.core.adapter.FileContentAdaptable;
import com.codenaiten.tools.filemanager.core.dto.FileData;
import com.codenaiten.tools.filemanager.core.dto.FileInfo;
import com.codenaiten.tools.filemanager.core.properties.FileManagerProperties;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FileManagerImpl implements FileManager {

    private final FileManagerProperties fileManagerProperties;
    private final FileManagerReader fileManagerReader;
    private final FileManagerWritter fileManagerWritter;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public FileManagerImpl(
            final FileManagerProperties fileManagerProperties,
            final FileManagerReader fileManagerReader,
            final FileManagerWritter fileManagerWritter
    ) {
        this.fileManagerProperties = fileManagerProperties;
        this.fileManagerReader = fileManagerReader;
        this.fileManagerWritter = fileManagerWritter;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| FileManagerReader Implemented Methods |---------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public Optional<FileInfo> read( final File file ) throws IOException {
        return this.fileManagerReader.read( file );
    }

    @Override
    public List<FileInfo> read( final File... files ) throws IOException {
        return this.fileManagerReader.read( files );
    }

    @Override
    public Optional<FileInfo> read( final FileAdaptable fileAdapter ) throws IOException {
        return this.fileManagerReader.read( fileAdapter );
    }

    @Override
    public List<FileInfo> read( final FileAdaptable... filesAdapters ) throws IOException {
        return this.fileManagerReader.read( filesAdapters );
    }

    @Override
    public Optional<String> readAsString( final File file ) throws IOException {
        return this.fileManagerReader.readAsString( file );
    }

    @Override
    public List<String> readAsString( final File... files ) throws IOException {
        return this.fileManagerReader.readAsString( files );
    }

    @Override
    public Optional<String> readAsString( final FileAdaptable fileAdapter ) throws IOException {
        return this.fileManagerReader.readAsString( fileAdapter );
    }

    @Override
    public List<String> readAsString( final FileAdaptable... filesAdapters ) throws IOException {
        return this.fileManagerReader.readAsString( filesAdapters );
    }

    @Override
    public Optional<byte[]> readAsBytes( final File file ) throws IOException {
        return this.fileManagerReader.readAsBytes( file );
    }

    @Override
    public List<byte[]> readAsBytes( final File... files ) throws IOException {
        return this.fileManagerReader.readAsBytes( files );
    }

    @Override
    public Optional<byte[]> readAsBytes( final FileAdaptable fileAdapter ) throws IOException {
        return this.fileManagerReader.readAsBytes( fileAdapter );
    }

    @Override
    public List<byte[]> readAsBytes( final FileAdaptable... filesAdapters ) throws IOException {
        return this.fileManagerReader.readAsBytes( filesAdapters );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| FileManagerWritter Implemented Methods |--------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public FileInfo write( final FileData fileData ) throws IOException {
        return this.fileManagerWritter.write( fileData );
    }

    @Override
    public List<FileInfo> write( final List<FileData> data ) throws IOException {
        return this.fileManagerWritter.write( data );
    }

    @Override
    public List<FileInfo> write( final Map<File, byte[]> data ) throws IOException {
        return this.fileManagerWritter.write( data );
    }

    @Override
    public FileInfo write( final File file, final byte[] content ) throws IOException {
        return this.fileManagerWritter.write( file, content );
    }

    @Override
    public FileInfo write(final FileAdaptable fileAdapter, final byte[] content ) throws IOException {
        return this.fileManagerWritter.write( fileAdapter, content );
    }

    @Override
    public FileInfo write( final File file, final FileContentAdaptable contentAdapter ) throws IOException {
        return this.fileManagerWritter.write( file, contentAdapter );
    }

    @Override
    public FileInfo write(final FileAdaptable fileAdapter, final FileContentAdaptable contentAdapter ) throws IOException {
        return this.fileManagerWritter.write( fileAdapter, contentAdapter );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| FileManager Implemented Methods |---------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public boolean delete( final File file ) throws IOException {
        //TODO: Implement delete( File file )
        throw new IllegalStateException( "Not implemented" );
    }

    @Override
    public boolean delete( final File... files ) throws IOException {
        //TODO: Implement delete( File... files )
        throw new IllegalStateException( "Not implemented" );
    }

    @Override
    public boolean delete( final FileAdaptable fileAdapter ) throws IOException {
        return this.delete( fileAdapter.get() );
    }

    @Override
    public boolean delete( final FileAdaptable... filesAdapters ) throws IOException {
        final File[] files = Arrays.stream( filesAdapters ).map( FileAdaptable::get ).toArray( File[]::new );
        return this.delete( files );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public FileInfo rename( final File file, final String newFileName ) throws IOException {
        //TODO: Implement rename( File file, String newFileName )
        throw new IllegalStateException( "Not implemented" );
    }

    @Override
    public FileInfo rename(final FileAdaptable file, final String newFileName ) throws IOException {
        return this.rename( file.get(), newFileName );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public boolean exists( final File file ) {
        //TODO: Implement exists( File file )
        throw new IllegalStateException( "Not implemented" );
    }

    @Override
    public boolean exists( final File... files ) {
        //TODO: Implement exists( File... files )
        throw new IllegalStateException( "Not implemented" );
    }

    @Override
    public boolean exists( final FileAdaptable fileAdapter ) {
        return this.exists( fileAdapter.get() );
    }

    @Override
    public boolean exists( final FileAdaptable... filesAdapters ) {
        final File[] files = Arrays.stream( filesAdapters ).map( FileAdaptable::get ).toArray( File[]::new );
        return this.exists( files );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
