package com.codenaiten.tools.filemanager.core;

import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;
import com.codenaiten.tools.filemanager.core.dto.FileInfo;

import java.io.File;
import java.io.IOException;

public interface FileManager extends FileManagerReader, FileManagerWritter{

// ------------------------------------------------------------------------------------------------------------------ \\
// ---| DELETE |----------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    boolean delete( File file ) throws IOException;

    boolean delete( File... files ) throws IOException;

    boolean delete( FileAdaptable fileAdapter ) throws IOException;

    boolean delete( FileAdaptable... filesAdapters ) throws IOException;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| RENAME |----------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    FileInfo rename( File file, String newFileName ) throws IOException;

    FileInfo rename(FileAdaptable file, String newFileName ) throws IOException;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| EXISTS |----------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    boolean exists( File file );

    boolean exists( File... files );

    boolean exists( FileAdaptable fileAdapter );

    boolean exists( FileAdaptable... filesAdapters );

// ------------------------------------------------------------------------------------------------------------------ \\

}
