package Clases;

public abstract class Cita {
    protected int IDcita;
    protected String NombreCliente,Mascota,Motivo,Fecha,Hora,MetodoDePago,Observaciones,Status;
    
    protected Cita(){}
    
    protected Cita(int IDcita, String NombreCliente, String Mascota, String Motivo, String Fecha, String Hora, String MetodoDePago, String Observaciones, String Status){
        this.IDcita = IDcita;
        this.NombreCliente = NombreCliente;
        this.Mascota = Mascota;
        this.Motivo = Motivo;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.MetodoDePago = MetodoDePago;
        this.Observaciones = Observaciones;
        this.Status = Status;
    }
    
    public abstract String GuardarDatos(int IDcita, String NombreCliente, String Mascota, String Motivo, String Fecha, String Hora, String MetodoDePago, String Observaciones, String Status);
}