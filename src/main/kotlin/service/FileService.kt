package com.morgana.ide.service

import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Files

object FileService {
    fun readFile(file: File): String =
        file.readText()

    fun writeFile(file: File, content: String) {
        file.writeText(content)
    }

    fun getFilesAndDirs(path: String): Array<File>? {
        val directory : File = File(path)
        if(!directory.exists() || !directory.isDirectory) throw FileNotFoundException()
        val filesAndDirs: Array<File>? = directory.listFiles()
        return filesAndDirs

    }

}
