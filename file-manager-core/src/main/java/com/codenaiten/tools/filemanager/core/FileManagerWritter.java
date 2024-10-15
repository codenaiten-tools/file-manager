package com.codenaiten.tools.filemanager.core;

import com.codenaiten.tools.filemanager.core.adapter.FileAdaptable;
import com.codenaiten.tools.filemanager.core.adapter.FileContentAdaptable;
import com.codenaiten.tools.filemanager.core.dto.FileData;
import com.codenaiten.tools.filemanager.core.dto.FileInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileManagerWritter {

// ------------------------------------------------------------------------------------------------------------------ \\

    FileInfo write( FileData fileData ) throws IOException;

    List<FileInfo> write( List<FileData> data ) throws IOException;

// ------------------------------------------------------------------------------------------------------------------ \\

    List<FileInfo> write( Map<File, byte[]> data ) throws IOException;

    FileInfo write( File file, byte[] content ) throws IOException;

    FileInfo write( FileAdaptable fileAdapter, byte[] content ) throws IOException;

    FileInfo write( File file, FileContentAdaptable contentAdapter ) throws IOException;

    FileInfo write( FileAdaptable fileAdapter, FileContentAdaptable contentAdapter ) throws IOException;

// ------------------------------------------------------------------------------------------------------------------ \\

}
