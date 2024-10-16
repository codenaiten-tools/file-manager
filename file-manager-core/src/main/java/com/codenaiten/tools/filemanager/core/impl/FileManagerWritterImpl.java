package com.codenaiten.tools.filemanager.core.impl;

import com.codenaiten.tools.filemanager.core.FileManagerWritter;
import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;
import com.codenaiten.tools.filemanager.core.adapter.FileContentAdaptable;
import com.codenaiten.tools.filemanager.core.dto.FileData;
import com.codenaiten.tools.filemanager.core.dto.FileInfo;
import com.codenaiten.tools.filemanager.core.properties.FileManagerProperties;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileManagerWritterImpl implements FileManagerWritter {

    private final FileManagerProperties fileManagerProperties;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public FileManagerWritterImpl( final FileManagerProperties fileManagerProperties ) {
        this.fileManagerProperties = fileManagerProperties;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENTED METHODS |---------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public FileInfo write( final FileData fileData ) throws IOException {
        return write( fileData.getFile(), fileData.getContent() );
    }

    @Override
    public List<FileInfo> write( final List<FileData> data ) throws IOException {
        final Map<File, byte[]> dataMap = data.stream().collect( Collectors.toMap( FileData::getFile, FileData::getContent ));
        return write( dataMap );
    }

    @Override
    public List<FileInfo> write( final Map<File, byte[]> data ) throws IOException {
        final List<FileInfo> result = new ArrayList<>();
        for( final Map.Entry<File, byte[]> entry : data.entrySet() ){
            result.add( write( entry.getKey(), entry.getValue() ));
        }
        return result;
    }

    @Override
    public FileInfo write( final File file, final byte[] content ) throws IOException {
        return writeHandler( file, content );
    }

    @Override
    public FileInfo write( final FileAdaptable fileAdapter, byte[] content ) throws IOException {
        return write( fileAdapter.get(), content );
    }

    @Override
    public FileInfo write( final File file, final FileContentAdaptable contentAdapter ) throws IOException {
        return write( file, contentAdapter.get() );
    }

    @Override
    public FileInfo write( final FileAdaptable fileAdapter, final FileContentAdaptable contentAdapter ) throws IOException {
        return write( fileAdapter.get(), contentAdapter.get() );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| PRIVATE METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    private FileInfo writeHandler( final File file, final byte[] content ) throws IOException {
        final Path path = file.toPath();
        Files.createDirectories( file.toPath().getParent() );
        Files.write( path, content );
        return FileInfo.create( file ).content( content ).build();
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
