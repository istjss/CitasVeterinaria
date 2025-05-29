package Clases;

import Clases.Archivo;
import Clases.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class ArchivoClientes implements Archivo{
    
    @Override
    public String GuardarDatos(String CliName, String CliNum, String CliEmail, String PetName, String PetGen, String PetType, String PetSubType, String PetColor, String PetAge, String PetDetails1, String PetDetails2){
        try{
            File f = new File("Clientes.txt");
            FileWriter fw = new FileWriter(f,true);
            fw.write(CliName + ";" + CliNum + ";" + CliEmail + ";" + PetName + ";" + PetGen + ";" + PetType + ";" + PetSubType + ";" + PetColor + ";" + PetAge + ";" + PetDetails1 + ";" + PetDetails2 + "\n");
            fw.close();
            return "¡Cliente Guardado!";
        }
        catch (Exception e){
            return "Error al guardar" + 0;
        }
    }
    
    
    @Override
    public LinkedList<Cliente> LeerArchivo() { // Tipo de retorno corregido
        LinkedList<Cliente> lista = new LinkedList<>(); // Instanciación de LinkedList corregida
        try {
            File f = new File("Clientes.txt");
            FileReader fr = new FileReader(f);
            BufferedReader buf = new BufferedReader(fr);
            String dato = buf.readLine();

            while (dato != null) {
                String ar[] = dato.split(";");
                // Asegúrate de que el orden de los parámetros coincida con tu constructor de Cliente
                // Cliente(NombreCliente, NumeroCliente, Email, NombreMascota, GeneroMascota, Especie, Raza, Color, Edad, DetallesMedicos, Observaciones)
                Cliente p = new Cliente(ar[0], ar[1], ar[2], ar[3], ar[4], ar[5], ar[6], ar[7], Integer.parseInt(ar[8]), ar[9], ar[10]); // 'Edad' es ar[8] asumiendo que es el 9º elemento en tu archivo
                lista.add(p);
                dato = buf.readLine();
            }
            buf.close(); // Cierra el BufferedReader para liberar recursos
            fr.close(); // Cierra el FileReader
        } catch (Exception e) {
            System.err.println("Error al leer el archivo Clientes.txt: " + e.getMessage());
            // Opcionalmente, podrías relanzar la excepción o devolver null para indicar un fallo
            return null; // Devuelve null en caso de un error
        }
        return lista; // Devuelve la lista de clientes
    }

}


