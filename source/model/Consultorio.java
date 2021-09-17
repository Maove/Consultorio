package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class Consultorio
{
    /**
     * Arreglo de odontólogos del consultorio
     */
    private Odontologo[] odontologos;

    /**
     * Listado de pacientes del consultorio
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Listado de citas del consultorio
     */
    private ArrayList<Cita> citas;

    /**
     * Constructor de la clase Consultorio
     */
    public Consultorio()
    {
        odontologos = new Odontologo[1];

        pacientes = new ArrayList<Paciente>();

        citas = new ArrayList<Cita>();
    }

    /**
     * Devuelve un arreglo que contiene los odontólogos del consultorio
     * @return Odontologo[] - Arreglo de odontólogos del consultorio
     */
    public Odontologo[] darOdontologos() { return odontologos; }

    /**
     *
     * @return ArrayList<Paciente> - Listado de pacientes del consultorio
     */
    public ArrayList<Paciente> darPacientes() { return pacientes; }

    /**
     *
     * @return ArrayList<Cita> - Listado de citas del consultorio
     */
    public ArrayList<Cita> darCitas() { return citas; }

    /**
     * Método para asignar un arreglo de odontólogos del consultorio
     * @param odon Arreglo a asignar
     */
    public void cambiarOdontologos(Odontologo[] odon) { odontologos = odon; }

    /**
     *
     * @param pacie
     */
    public void cambiarPacientes(ArrayList<Paciente> pacie) { pacientes = pacie; }

    /**
     *
     * @param cit - Cita a asignar
     */
    public void cambiarCitas(ArrayList<Cita> cit) { citas = cit; }

    /**
     * agregarPaciente - Adds new pacient to ArrayList pacientes
     * @param pacie - Patient to add
     * @return boolean - Returns true if patient could be added, or false otherwise
     */
    public boolean agregarPaciente(Paciente pacie)
    {
        boolean agregado = false;

        pacientes.add(pacie);
        agregado = true;

        return agregado;
    }

    /**
     * agregarCita - Adds new date to ArrayList citas
     * @param ci - Cita to add
     * @return boolean - Returns true if date could be added, or false otherwise
     */
    public boolean agregarCita(Cita ci)
    {
        boolean agregado = false;

        citas.add(ci);
        agregado = true;

        return agregado;
    }

    /**
     *
     * @param nom
     * @return
     */
    public Paciente buscarPacientePorNombre(String nom)
    {
        Paciente buscado = null;

        for(int i = 0; i < pacientes.size(); i++)
        {
            Paciente pacienteActual = (Paciente) pacientes.get(i);

            if(pacienteActual.darNombre().equalsIgnoreCase(nom))
                buscado = pacienteActual;
        }

        return buscado;
    }

    /**
     *
     * @param ced
     * @return
     */
    public Paciente buscarPacientePorCedula(String ced)
    {
        Paciente buscado = null;

        for(int i = 0; i < pacientes.size(); i++)
        {
            Paciente pacienteActual = (Paciente) pacientes.get(i);

            if(pacienteActual.darCedula().equalsIgnoreCase(ced))
                buscado = pacienteActual;
        }

        return buscado;
    }

    /**
     *
     * @param pac
     * @return
     */
    public Cita buscarCitaPorPaciente(Paciente pac)
    {
        Cita buscada = null;

        for(int i = 0; i < citas.size(); i++)
        {
            Cita citaActual = (Cita) citas.get(i);

            if(citaActual.getPacienteAsignado() == pac)
                buscada = citaActual;
        }

        return buscada;
    }

    /**
     *
     * @param d
     * @param m
     * @param y
     * @return
     */
    public ArrayList<Cita> buscarCitasPorFecha(int d, int m, int y)
    {
       ArrayList<Cita> listaCitasFecha = new ArrayList<>();

       for(int i = 0; i < citas.size(); i++)
       {
           Cita citaActual = citas.get(i);

           int day = citaActual.getDay();
           int month = citaActual.getMonth();
           int year = citaActual.getYear();

           boolean condicion = Integer.compare(day,d) == 0 && Integer.compare(month,m) == 0 && Integer.compare(year,y) == 0;

           if(condicion)
               listaCitasFecha.add(citaActual);
       }

       return listaCitasFecha;
    }

    public ArrayList<Cita> buscarCitasPorSemana(int d)
    {
        ArrayList<Cita> listaCitasSemana = new ArrayList<>();

        for(int i = 0; i<citas.size(); i++)
        {
            Cita citaActual = citas.get(i);

            Date fechaActual = new Date(citaActual.getDay(), citaActual.getMonth(), citaActual.getYear());
            System.out.println(fechaActual);

            //TODO
            if(citaActual.getDay() == d)
                listaCitasSemana.add(citaActual);
        }


        return listaCitasSemana;
    }

    public ArrayList<Cita> buscarCitasPorMes(int m)
    {
        ArrayList<Cita> listaCitasMes = null;

        return listaCitasMes;
    }

    /**
     *
     * @param pacie
     * @return
     */
    public boolean eliminarPaciente(Paciente pacie)
    {
        boolean eliminado = false;

        Paciente buscado = buscarPacientePorCedula(pacie.darCedula());
        Cita citaBuscada = buscarCitaPorPaciente(buscado);

        if(buscado!=null)
        {
            pacientes.remove(pacie);
            eliminado = true;
        }

        return eliminado;
    }

    /**
     *
     * @param pac
     * @return
     */
    public boolean eliminarCita(Paciente pac)
    {
        boolean eliminado = false;

        Cita buscada = buscarCitaPorPaciente(pac);

        if(buscada!=null)
        {
            citas.remove(buscada);
            eliminado = true;
        }

        return eliminado;
    }

    public ArrayList<Cita> ordenarCitasDelDiaPorHora(ArrayList<Cita> citasDia)
    {
        Collections.sort(citasDia);

        return citasDia;
    }
}