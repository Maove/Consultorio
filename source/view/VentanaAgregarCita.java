package view;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarCita extends JFrame
{
    private JLabel labPaciente, labFecha, labHora;

    private JComboBox pacientes;

    private JCalendar fecha;

    private JComboBox hora;

    private JButton btnAgregar, btnCancelar;

    public VentanaAgregarCita()
    {
        setTitle("Nueva Cita");
        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        labPaciente = new JLabel("Paciente: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(labPaciente,c);

        pacientes = new JComboBox();
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.ipadx = -100;
        c.gridx = 1;
        c.gridy = 0;
        add(pacientes,c);

        labFecha = new JLabel("Fecha: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(labFecha,c);

        fecha = new JCalendar();
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.ipadx = 40;
        c.gridx = 0;
        c.gridy = 2;
        add(fecha,c);

        labHora = new JLabel("Hora: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        add(labHora,c);

        hora = new JComboBox();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        add(hora,c);

        /*
        JLabel labVacio1 = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        add(labVacio1,c);

        JLabel labVacio2 = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        add(labVacio2,c);
        */

        btnAgregar = new JButton("Agregar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        add(btnAgregar,c);

        btnCancelar = new JButton("Cancelar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        add(btnCancelar,c);
    }

    public JComboBox getComboPacientes() { return pacientes; }

    public JCalendar getFecha() { return fecha; }

    public JComboBox getHora() { return hora; }

    public JButton getBtnAgregar() { return btnAgregar; }

    public JButton getBtnCancelar() { return btnCancelar; }
}