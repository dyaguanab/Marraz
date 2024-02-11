package com.masanz.marraz.io;

import java.io.File;

public class Archivo {

    /**
     * Se verifica si existe el archivo
     * @param path
     * @return
     */
    public static boolean existe(String path) {
        File file = new File(path);
        return file.exists() && !file.isDirectory();
    }
}
