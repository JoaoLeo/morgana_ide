package com.morgana.ide.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class FileService {

    public static String readFile(File file) throws IOException {
        return Files.readString(file.toPath());
    }

    public static void writeFile(File file, String content) throws IOException {
        Files.writeString(file.toPath(), content);
    }

    public static File[] getFilesAndDirs(String path) throws FileNotFoundException {
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new FileNotFoundException("Diretório não encontrado ou inválido: " + path);
        }
        return directory.listFiles();
    }
}
