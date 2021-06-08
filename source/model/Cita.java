package model;

import java.sql.Time;

public class Cita
{
    /**
     *
     */
    private int day, month, year, hora;

    private Paciente pacienteAsignado;

    /**
     *
     * @param d
     * @param m
     * @param y
     * @param pac
     */
    public Cita(int d, int m, int y, Paciente pac, int h)
    {
        day = d;

        month = m;

        year = y;

        pacienteAsignado = pac;

        hora = h;
    }

    /**
     *
     * @return
     */
    public int getDay() {
        return day;
    }

    /**
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     *
     * @return
     */
    public int getMonth() {
        return month;
    }

    /**
     *
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public Paciente getPacienteAsignado() { return pacienteAsignado; }

    /**
     *
     * @param pacienteAsignado
     */
    public void setPacienteAsignado(Paciente pacienteAsignado) { this.pacienteAsignado = pacienteAsignado; }

    public int getHora() { return hora; }

    public void setHora(int h) { hora = h; }

    public String toString()
    {
        return pacienteAsignado.darNombre() + " - " + hora + ":00";  //day + "/" + month + "/" + year;
    }
}