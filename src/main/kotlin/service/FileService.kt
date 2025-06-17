package com.morgana.ide.service

import java.io.File

object FileService {
    fun readFile(file: File): String =
        file.readText()

    fun writeFile(file: File, content: String) {
        file.writeText(content)
    }
}
