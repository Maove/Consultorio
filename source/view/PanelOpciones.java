package view;

import javax.swing.*;
import java.awt.*;

public class PanelOpciones extends JPanel
{
    private JButton btnAgregarPaciente, btnAgregarCita;

    public PanelOpciones()
    {
        setLayout(new GridLayout(6,1));

        btnAgregarPaciente = new JButton("Nuevo Paciente");
        btnAgregarPaciente.setToolTipText("Click para generar ventana de creación de paciente");
        add(btnAgregarPaciente);

        btnAgregarCita = new JButton("Nueva Cita");
        btnAgregarCita.setToolTipText("Click para generar ventana de creación de cita");
        add(btnAgregarCita);
    }

    public JButton darBtnAgregarPaciente() { return btnAgregarPaciente; }

    public JButton darBtnAgregarCita() { return btnAgregarCita; }
}