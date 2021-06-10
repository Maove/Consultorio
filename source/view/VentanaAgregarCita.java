package view;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarCita extends JFrame
{
    /**
     *
     */
    private JLabel labPaciente, labFecha, labHora;

    /**
     *
     */
    private JComboBox pacientes;

    /**
     *
     */
    private JCalendar fecha;

    /**
     *
     */
    private JComboBox hora;

    /**
     *
     */
    private JButton btnAgregar, btnCancelar;

    /**
     *
     */
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
        //c.insets = new Insets(0,-10,0,0);
        c.gridx = 1;
        c.gridy = 0;
        add(pacientes,c);

        labFecha = new JLabel("Fecha: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        add(labFecha,c);

        fecha = new JCalendar();
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.ipadx = 40;
        c.gridx = 0;
        c.gridy = 3;
        add(fecha,c);

        labHora = new JLabel("Hora: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(labHora,c);

        hora = new JComboBox();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        add(hora,c);

        btnAgregar = new JButton("Agregar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        add(btnAgregar,c);

        btnCancelar = new JButton("Cancelar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        add(btnCancelar,c);
    }

    /**
     *
     * @return
     */
    public JComboBox getComboPacientes() { return pacientes; }

    /**
     *
     * @return
     */
    public JCalendar getFecha() { return fecha; }

    /**
     *
     * @return
     */
    public JComboBox getHora() { return hora; }

    /**
     *
     * @return
     */
    public JButton getBtnAgregar() { return btnAgregar; }

    /**
     *
     * @return
     */
    public JButton getBtnCancelar() { return btnCancelar; }
}