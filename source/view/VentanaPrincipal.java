package view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    private PanelDatos panelDatos;

    private PanelOpciones panelOpciones;

    private PanelListaPacientes panelListaPacientes;

    private PanelListaCitas panelListaCitas;

    private PanelCalendario panelCalendario;

    private VentanaAgregarPaciente ventanaAgregarPaciente;

    private VentanaAgregarCita ventanaAgregarCita;

    public VentanaPrincipal()
    {
        setTitle("Andrea Ramírez Odontología");
        setSize(800,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        panelDatos = new PanelDatos();
        add(panelDatos, BorderLayout.NORTH);

        panelListaPacientes = new PanelListaPacientes();
        //add(panelListaPacientes, BorderLayout.EAST);

        panelListaCitas = new PanelListaCitas();
        add(panelListaCitas, BorderLayout.EAST);

        panelOpciones = new PanelOpciones();
        add(panelOpciones, BorderLayout.SOUTH);

        panelCalendario = new PanelCalendario();
        add(panelCalendario, BorderLayout.CENTER);

        ventanaAgregarPaciente = new VentanaAgregarPaciente();

        ventanaAgregarCita = new VentanaAgregarCita();
    }

    public PanelDatos darPanelDatos() { return panelDatos; }

    public PanelOpciones darPanelOpciones() { return panelOpciones; }

    public PanelListaPacientes darPanelListaPacientes() { return panelListaPacientes; }

    public PanelListaCitas darPanelListaCitas() { return panelListaCitas; }

    public PanelCalendario darPanelCalendario() { return panelCalendario; }

    public VentanaAgregarPaciente darVentanaAgregarPaciente() { return ventanaAgregarPaciente; }

    public VentanaAgregarCita darVentanaAgregarCita() { return ventanaAgregarCita; }
}
