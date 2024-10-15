package com.codenaiten.tools.filemanager.core.impl;

import com.codenaiten.tools.filemanager.core.FileManagerReader;
import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;
import com.codenaiten.tools.filemanager.core.dto.FileInfo;
import com.codenaiten.tools.filemanager.core.properties.FileManagerProperties;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileManagerReaderImpl implements FileManagerReader {

    private final FileManagerProperties fileManagerProperties;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public FileManagerReaderImpl( final FileManagerProperties fileManagerProperties ) {
        this.fileManagerProperties = fileManagerProperties;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENTED METHODS |---------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public Optional<FileInfo> read( final File file ) throws IOException {
        return this.readHandler( file );
    }

    @Override
    public List<FileInfo> read( final File... files ) throws IOException {
        final List<FileInfo> result = new ArrayList<>();
        boolean finish = false;
        for( int i = 0 ; i < files.length && !finish ; i++ ){
            final Optional<FileInfo> fileInfo = this.read( files[i] );
            if( fileInfo.isPresent() ){
                result.add( fileInfo.get() );
            }
            else{
                finish = true;
                result.clear();
            }
        }
        return result;
    }

    @Override
    public Optional<FileInfo> read( final FileAdaptable fileAdapter ) throws IOException {
        return this.read( fileAdapter.get() );
    }

    @Override
    public List<FileInfo> read( final FileAdaptable... filesAdapters ) throws IOException {
        final File[] result = Arrays.stream( filesAdapters ).map( FileAdaptable::get ).toArray( File[]::new );
        return this.read( result );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public Optional<String> readAsString( final File file ) throws IOException {
        final Optional<FileInfo> fileInfo = this.read( file );
        return fileInfo.map( FileInfo::getContentAsString );
    }

    @Override
    public List<String> readAsString( final File... files ) throws IOException {
        return this.read( files ).stream().map( FileInfo::getContentAsString ).toList();
    }

    @Override
    public Optional<String> readAsString( final FileAdaptable fileAdapter ) throws IOException {
        return this.readAsString( fileAdapter.get() );
    }

    @Override
    public List<String> readAsString( final FileAdaptable... filesAdapters ) throws IOException {
        final File[] files = Arrays.stream( filesAdapters ).map( FileAdaptable::get ).toArray( File[]::new );
        return this.read( files ).stream().map( FileInfo::getContentAsString ).toList();
    }

// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public Optional<byte[]> readAsBytes( final File file ) throws IOException {
        return this.read( file ).map( FileInfo::getContent );
    }

    @Override
    public List<byte[]> readAsBytes( final File... files ) throws IOException {
        return this.read( files ).stream().map( FileInfo::getContent ).toList();
    }

    @Override
    public Optional<byte[]> readAsBytes( final FileAdaptable fileAdapter ) throws IOException {
        return this.read( fileAdapter.get() ).map( FileInfo::getContent );
    }

    @Override
    public List<byte[]> readAsBytes( final FileAdaptable... filesAdapters ) throws IOException {
        final File[] files = Arrays.stream( filesAdapters ).map( FileAdaptable::get ).toArray( File[]::new );
        return this.read( files ).stream().map( FileInfo::getContent ).toList();
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| PRIVATE METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    private Optional<FileInfo> readHandler( final File file ) throws IOException {
        //TODO: Implement readHandler( File file )
        throw new IllegalStateException( "Not implemented" );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
