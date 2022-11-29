import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException { //throws IOException para que no me tire error  linea 33

        List<Perro> listaPerros = new ArrayList<>();

        Perro perro1 = new Perro();
        perro1.setNombre("Fido");
        perro1.setEdad(3);
        perro1.setRaza("Pastor Aleman");
        perro1.setDireccion("Calle 1");

        Perro perro2 = new Perro();
        perro2.setNombre("Firulais");
        perro2.setEdad(5);
        perro2.setRaza("Pastor Aleman");
        perro2.setDireccion("Calle 2");

        listaPerros.add(perro1);
        listaPerros.add(perro2);

        FileOutputStream archivoSalida = null;
        ObjectOutputStream archivoPerroEnBytes = null;
        try { //Para crear un archivo serializado
            archivoSalida = new FileOutputStream("perros.txt");
            archivoPerroEnBytes = new ObjectOutputStream(archivoSalida);
            archivoPerroEnBytes.writeObject(listaPerros);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) { //IOException no me tire error linea 24
            throw new RuntimeException(e);
        } finally {
            archivoPerroEnBytes.close();
        }

        //Para deserialize el archivo
        FileInputStream archivoEntrada = null;
        ObjectInputStream archivoPerroEnBytesRead = null;
        try { //Para crear un archivo serializado
            archivoEntrada = new FileInputStream("perros.txt");
            archivoPerroEnBytesRead = new ObjectInputStream(archivoEntrada);
            List<Perro> listaPerritosRecuperada = (ArrayList) archivoPerroEnBytesRead.readObject();
            for (Perro p : listaPerritosRecuperada) {
                System.out.println("Nombre" + p.getNombre());
                System.out.println("Edad"+ p.getEdad());
                System.out.println("Raza" + p.getRaza());
                System.out.println("Direccion" + p.getDireccion());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) { //IOException no me tire error linea 24
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            archivoPerroEnBytes.close();
        }


    }
}