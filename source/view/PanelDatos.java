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
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenu("Archivo"));
        add(menuBar, BorderLayout.NORTH);

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

        JPanel panelAux = new JPanel();

        panelAux.add(labNombre);
        panelAux.add(txtNombre);

        panelAux.add(labCedula);
        panelAux.add(txtCedula);

        panelAux.add(labFecha);
        panelAux.add(txtFecha);

        panelAux.add(labHora);
        panelAux.add(txtHora);

        //add(panelAux, BorderLayout.CENTER);
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