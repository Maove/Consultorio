package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelDatos extends JPanel
{
    private JLabel labNombre, labCedula, labFecha, labHora;

    private JTextField txtNombre, txtCedula, txtFecha, txtHora;

    public PanelDatos()
    {
        setBorder(new TitledBorder("Datos del Paciente"));
        setLayout(new GridLayout(4,2));

        labNombre = new JLabel("Nombre: ");
        labCedula = new JLabel("Cédula: ");
        labFecha = new JLabel("Fecha: ");
        labHora = new JLabel("Hora");

        txtNombre = new JTextField();
        txtNombre.setEditable(false);

        txtCedula = new JTextField();
        txtCedula.setEditable(false);

        txtFecha = new JTextField();
        txtFecha.setEditable(false);

        txtHora = new JTextField();
        txtHora.setEditable(false);

        add(labNombre);
        add(txtNombre);

        add(labCedula);
        add(txtCedula);

        add(labFecha);
        add(txtFecha);

        add(labHora);
        add(txtHora);
    }

    public JLabel darLabNombre()
    {
        return labNombre;
    }

    public JLabel darLabCedula() { return labCedula; }

    public JLabel darLabFecha() { return labFecha; }

    public JLabel darLabHora() { return labHora; }

    public JTextField darTxtNombre()
    {
        return txtNombre;
    }

    public JTextField darTxtCedula()
    {
        return txtCedula;
    }

    public JTextField darTxtFecha() { return txtFecha; }

    public JTextField darTxtHora() { return txtHora; }
}