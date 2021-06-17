package view;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
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
    private JComboBox pacientes, hora;

    /**
     *
     */
    private JCalendar fecha;

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
        setSize(400,300);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panelAux1 = new JPanel();
        panelAux1.setLayout(new GridLayout(2,2));
        labPaciente = new JLabel("Paciente: ");
        panelAux1.add(labPaciente);
        pacientes = new JComboBox();
        pacientes.setSize(new Dimension(200,0));
        panelAux1.add(pacientes);
        labHora = new JLabel("Hora: ");
        panelAux1.add(labHora);
        hora = new JComboBox();
        panelAux1.add(hora);

        add(panelAux1, BorderLayout.NORTH);

        labFecha = new JLabel("Fecha: ");
        fecha = new JCalendar();
        JPanel panelFecha = new JPanel();
        panelFecha.setLayout(new BorderLayout());
        panelFecha.add(labFecha, BorderLayout.NORTH);
        panelFecha.add(fecha, BorderLayout.CENTER);

        add(panelFecha, BorderLayout.CENTER);

        JPanel panelAux2 = new JPanel();
        panelAux2.setLayout(new GridLayout(1,2));
        btnAgregar = new JButton("Agregar");
        panelAux2.add(btnAgregar);
        btnCancelar = new JButton("Cancelar");
        panelAux2.add(btnCancelar);

        add(panelAux2, BorderLayout.SOUTH);


        //setLayout(new GridBagLayout());
        /*GridBagConstraints c = new GridBagConstraints();

        labPaciente = new JLabel("Paciente: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        add(labPaciente,c);

        pacientes = new JComboBox();
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.insets = new Insets(0,-10,0,0);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        add(pacientes,c);

        labFecha = new JLabel("Fecha: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        add(labFecha,c);

        fecha = new JCalendar();
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.ipadx = 40;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        add(fecha,c);

        labHora = new JLabel("Hora: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(labHora,c);

        hora = new JComboBox();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        add(hora,c);

        btnAgregar = new JButton("Agregar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        add(btnAgregar,c);

        btnCancelar = new JButton("Cancelar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        add(btnCancelar,c);

         */
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