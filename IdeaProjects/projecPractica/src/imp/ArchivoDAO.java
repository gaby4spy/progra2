package imp;

import Autos.Autos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.Principal;

public class ArchivoDAO  implements  iCrud{

    String nomreArchivo="C:/Users/gabri/Desktop/Autos.txt";
    File archivo = new File(nomreArchivo);


    @Override
    public void leer() {

    }

    @Override
    public void aregar(Autos auto) {

        try {
            var salida = new PrintWriter(new FileWriter(archivo,true));
            var nuevoContenido = "fiat,argo,9999";
            salida.println(nuevoContenido);
        } catch (Exception e) {

        }

    }
}
