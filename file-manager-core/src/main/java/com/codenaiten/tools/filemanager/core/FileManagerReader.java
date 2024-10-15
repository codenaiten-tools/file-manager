package com.codenaiten.tools.filemanager.core;

import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;
import com.codenaiten.tools.filemanager.core.dto.FileInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FileManagerReader {

// ------------------------------------------------------------------------------------------------------------------ \\
// ---| READ |------------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    Optional<FileInfo> read( File file ) throws IOException;

    List<FileInfo> read( File... files ) throws IOException;

    Optional<FileInfo> read( FileAdaptable fileAdapter ) throws IOException;

    List<FileInfo> read( FileAdaptable... filesAdapters ) throws IOException;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| READ AS STRING |--------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    Optional<String> readAsString( File file ) throws IOException;

    List<String> readAsString( File... files ) throws IOException;

    Optional<String> readAsString( FileAdaptable fileAdapter ) throws IOException;

    List<String> readAsString( FileAdaptable... filesAdapters ) throws IOException;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| READ AS BYTES |---------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    Optional<byte[]> readAsBytes( File file ) throws IOException;

    List<byte[]> readAsBytes( File... files ) throws IOException;

    Optional<byte[]> readAsBytes( FileAdaptable fileAdapter ) throws IOException;

    List<byte[]> readAsBytes( FileAdaptable... filesAdapters ) throws IOException;

// ------------------------------------------------------------------------------------------------------------------ \\

}
