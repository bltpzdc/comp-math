package application.fileOpener;

import application.readers.Reader;

import java.io.File;

public interface FileManager {
    File findFile(Reader consoleReader);
}
