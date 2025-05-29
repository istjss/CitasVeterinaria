package Clases;

import java.util.LinkedList;

public interface Archivo {
    
    public LinkedList<Cliente> LeerArchivo();
    public String GuardarDatos(String CliName, String CliNum, String CliEmail, String PetName, String PetGen, String PetType, String PetSubType, String PetColor, String PetAge, String PetDetails1, String PetDetails2);
}
