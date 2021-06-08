package model;

public class Paciente
{
    private String nombre, cedula;

    private Cita citaAsignada;

    public Paciente(String nom, String ced)
    {
        nombre = nom;

        cedula = ced;
    }

    public String darNombre() { return nombre; }

    public String darCedula() { return cedula; }

    public Cita darCitaAsignada() { return citaAsignada; }

    public void cambiarNombre(String nom) { nombre = nom; }

    public void cambiarCedula(String ced) { cedula = ced; }

    public void cambiarCitaAsignada(Cita ci) { citaAsignada = ci; }

    public String toString()
    {
        return nombre;
    }
}