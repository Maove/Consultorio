package model;

public class Cita
{
    /**
     * Día, mes, año, hora y minuto de la cita
     */
    private int day, month, year, hora, minuto;

    /**
     * Paciente asignado a la cita
     */
    private Paciente pacienteAsignado;

    /**
     * Constructor de la clase Cita
     * @param d - Día de la cita
     * @param m - Mes de la cita
     * @param y - Año de la cita
     * @param pac - Paciente asignado para la nueva cita
     * @param h - Hora de la cita
     */
    public Cita(int d, int m, int y, Paciente pac, int h, int min)
    {
        day = d;

        month = m;

        year = y;

        pacienteAsignado = pac;

        hora = h;

        minuto = min;
    }

    /**
     * Devuelve el dia de la fecha de la cita
     * @return int - Día de la fecha de la cita indicada
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
     * Devuelve el mes en la fecha de la cita
     * @return int - Mes de la fecha de la cita indicada
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
     * Devuelve el año en la fecha de la cita
     * @return int - Año de la fecha de la cita indicada
     */
    public int getYear() {
        return year;
    }

    /**
     * Asigna un año a la fecha de la cita
     * @param year - Año a asignar en la fecha
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Devuelve el paciente asignado de la cita
     * @return Paciente - Paciente asignada a la cita
     */
    public Paciente getPacienteAsignado() { return pacienteAsignado; }

    /**
     * Asigna un paciente a la cita indicada
     * @param pacienteAsignado - Paciente a asignar a la cita
     */
    public void setPacienteAsignado(Paciente pacienteAsignado) { this.pacienteAsignado = pacienteAsignado; }

    public int getHora() { return hora; }

    public void setHora(int h) { hora = h; }

    public int getMinuto() { return minuto; }

    public void setMinuto(int min) { minuto = min; }

    public String toString()
    {
        if(minuto==30)
            return pacienteAsignado.darNombre() + " - " + hora + ":" + minuto;  //day + "/" + month + "/" + year;
        else
            return pacienteAsignado.darNombre() + " - " + hora + ":00";
    }
}