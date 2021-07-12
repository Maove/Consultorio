package view;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;

public class PanelOpciones extends JPanel
{
    private JButton btnAgregarPaciente, btnAgregarCita, btnReportes, btnOpcion1, btnOpcion2, btnOpcion3;

    public PanelOpciones()
    {
        setLayout(new GridLayout(6,1));

        Icon iconPaciente = new ImageIcon("./files/user.png");
        btnAgregarPaciente = new JButton(iconPaciente);
        btnAgregarPaciente.setToolTipText("Click para generar ventana de creación de paciente");
        add(btnAgregarPaciente);

        Icon iconCita = new ImageIcon("./files/date.png");
        btnAgregarCita = new JButton(iconCita);
        btnAgregarCita.setToolTipText("Crear una cita");
        add(btnAgregarCita);

        Icon iconReportes = new ImageIcon("./files/report.png");
        btnReportes = new JButton(iconReportes);
        btnReportes.setToolTipText("Consulta reportes de pacientes");
        add(btnReportes);

        Icon iconOpcion1 = new ImageIcon("./files/options.png");
        btnOpcion1 = new JButton(iconOpcion1);
        btnOpcion1.setToolTipText("Opción 1");
        add(btnOpcion1);

        Icon iconOpcion2 = new ImageIcon("./files/options.png");
        btnOpcion2 = new JButton(iconOpcion2);
        btnOpcion2.setToolTipText("Opción 2");
        add(btnOpcion2);

        Icon iconOpcion3 = new ImageIcon("./files/options.png");
        btnOpcion3 = new JButton(iconOpcion3);
        btnOpcion3.setToolTipText("Opción 3");
        add(btnOpcion3);
    }

    public JButton darBtnAgregarPaciente() { return btnAgregarPaciente; }

    public JButton darBtnAgregarCita() { return btnAgregarCita; }
}