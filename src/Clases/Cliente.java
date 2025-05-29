package Clases;

public class Cliente {
    
    public String NombreCliente, NumeroCliente, Email, NombreMascota, GeneroMascota, Especie, Raza, Color, DetallesMedicos, Observaciones;
    public int Edad;
    
        public Cliente (String NombreCliente, String NumeroCliente, String Email, String NombreMascota, String GeneroMascota, String Especie, String Raza, String Color, int Edad, String DetallesMedicos, String Observaciones){
            this.NombreCliente = NombreCliente;
            this.NumeroCliente= NumeroCliente;
            this.Email = Email;
            this.NombreMascota = NombreMascota;
            this.GeneroMascota = GeneroMascota;
            this.Especie = Especie;
            this.Raza = Raza;
            this.Color = Color;
            this.Edad = Edad;
            this.DetallesMedicos = DetallesMedicos;
            this.Observaciones = Observaciones;
    }
}
