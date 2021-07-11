package view;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;

public class PanelOpciones extends JPanel
{
    private JButton btnAgregarPaciente, btnAgregarCita;

    public PanelOpciones()
    {
        setLayout(new GridLayout(6,1));

        Icon iconPaciente = new ImageIcon("./files/user.png");
        btnAgregarPaciente = new JButton(iconPaciente);
        btnAgregarPaciente.setToolTipText("Click para generar ventana de creación de paciente");
        add(btnAgregarPaciente);

        Icon iconCita = new ImageIcon("./files/date.png");
        btnAgregarCita = new JButton(iconCita);
        btnAgregarCita.setToolTipText("Click para generar ventana de creación de cita");
        add(btnAgregarCita);
    }

    public JButton darBtnAgregarPaciente() { return btnAgregarPaciente; }

    public JButton darBtnAgregarCita() { return btnAgregarCita; }
}