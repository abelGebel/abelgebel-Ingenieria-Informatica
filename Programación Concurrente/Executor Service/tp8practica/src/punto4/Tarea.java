package punto4;

import java.io.File;

public class Tarea implements Runnable {
    private final String carpeta = "C:\\Users\\abelg\\OneDrive\\Escritorio\\Punto4"; // Ruta a la carpeta

    private File[] archivosAnteriores = new File[0];

    @Override
    public void run() {
        // Cargar los nombres de archivos en la carpeta
        File carpetaActual = new File(carpeta);
        File[] archivosActuales = carpetaActual.listFiles();
        
        // Verificar si se ha creado un nuevo archivo
        for (File archivo : archivosActuales) {
            if (!archivo.isDirectory() && !contieneArchivo(archivo, archivosAnteriores)) {
                System.out.println("Nuevo archivo " + archivo.getName() + ", con tamano " + archivo.length() + " bytes");
                // Copiar el archivo a la carpeta correspondiente
            }
        }
        
        // Actualizar la lista de archivos anteriores
        archivosAnteriores = archivosActuales;
    }

    private boolean contieneArchivo(File archivo, File[] archivos) {
        for (File arch : archivos) {
            if (archivo.getName().equals(arch.getName())) {
                return true;
            }
        }
        return false;
    }
}