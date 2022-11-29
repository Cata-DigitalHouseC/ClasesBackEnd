import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        try {
            String texto = "Hola mundo que quiero guardar en archivo y leerlo desde el notepad";

            File archivo = new File("arhivo.txt");

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter writer = new FileWriter(archivo.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(texto);
            bw.close();

        }catch (IOException e) {
                throw new RuntimeException(e);
            }


    }
}