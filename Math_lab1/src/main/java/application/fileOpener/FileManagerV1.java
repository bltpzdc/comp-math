package application.fileOpener;

import application.readers.Reader;

import java.io.File;
import java.io.FileNotFoundException;

public class FileManagerV1 implements FileManager {

    @Override
    public File findFile(Reader consoleReader) {
        System.out.println("Введите путь к файлу (Полный или относительный).");
        System.out.println("Изначальная директория - " + new File(".").getAbsolutePath());
        while (true) {
            File file = new File(consoleReader.read());
            if (!file.exists()){
                System.err.println("Файла не существует.");
            } else if (file.isDirectory()){
                System.err.println("Вы ввели название директории.");
            } else if (!file.canRead()){
                System.err.println("Нет прав на чтение файла.");
            }
            else{
                return file;
            }
        }
    }

}
