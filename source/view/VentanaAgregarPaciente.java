package view;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarPaciente extends JFrame
{
    private JLabel labNombre, labCedula;

    private JTextField txtNombre, txtCedula;

    private JButton btnAgregar, btnCancelar;

    public VentanaAgregarPaciente()
    {
        setTitle("Nuevo Paciente");
        setSize(300,150);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,2));

        labNombre = new JLabel("Nombre: ");
        labCedula = new JLabel("Cédula: ");

        txtNombre = new JTextField();
        txtNombre.setEditable(true);

        txtCedula = new JTextField();
        txtCedula.setEditable(true);

        JLabel labVacio1 = new JLabel();
        JLabel labVacio2 = new JLabel();

        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");

        add(labNombre);
        add(txtNombre);
        add(labCedula);
        add(txtCedula);
        add(labVacio1);
        add(labVacio2);
        add(btnAgregar);
        add(btnCancelar);
    }

    public JTextField getTxtNombre() { return txtNombre; }

    public JTextField getTxtCedula() { return txtCedula; }

    public JButton getBtnAgregar() { return btnAgregar; }

    public JButton getBtnCancelar() { return btnCancelar; }
}