package model;

public class Odontologo {
    private String nombre, cedula, idCorporativo, especialidad;

    public Odontologo(String nom, String ced, String idCorp, String espe) {
        nombre = nom;

        cedula = ced;

        idCorporativo = idCorp;

        especialidad = espe;
    }

    public String darNombre() { return nombre; }

    public String darCedula() { return cedula; }

    public String darIdCorporativo() { return idCorporativo; }

    public String darEspecialidad() { return especialidad; }

    public void cambiarNombre(String nom) { nombre = nom; }

    public void cambiarCedula(String ced) { cedula = ced; }

    public void cambiarIdCorporativo(String idCorp) { idCorporativo = idCorp; }

    public void cambiarEspecialidad(String espe) { especialidad = espe; }
}