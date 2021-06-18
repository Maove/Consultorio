package controller;

import model.Cita;
import model.Consultorio;
import model.Paciente;
import view.VentanaAgregarCita;
import view.VentanaAgregarPaciente;
import view.VentanaPrincipal;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main
{
    /**
     * Relation with model
     */
    private static Consultorio modelo;

    /**
     * Relation with view
     */
    private static VentanaPrincipal ventanaPrincipal;

    /**
     * Executable main method
     * @param args - Array of arguments for execution
     */
    public static void main(String[] args)
    {
        inicializarVentanaPrincipal();
        inicializarBotonesVentanaPrincipal();
        inicializarBotonesVentanaAgregarPaciente();
        inicializarBotonesVentanaAgregarCita();
        inicializarListaPacientes();
        inicializarListaCitas();
        inicializarCalendario();

        inicializarModelo();

        int day = ventanaPrincipal.darPanelCalendario().darCalendario().getDayChooser().getDay();
        int month = ventanaPrincipal.darPanelCalendario().darCalendario().getMonthChooser().getMonth()+1;
        int year = ventanaPrincipal.darPanelCalendario().darCalendario().getYearChooser().getYear();

        JOptionPane.showMessageDialog(null, "Para hoy se tienen: " + modelo.buscarCitasPorFecha(day, month, year).size() + " citas programadas","Citas de hoy", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Initializes application model
     */
    private static void inicializarModelo()
    {
        modelo = new Consultorio();

        try
        {
            FileReader fileReader = new FileReader("./files/pacientes.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String lineActual = br.readLine();

            while(lineActual!=null)
            {
                String[] datos = lineActual.split(";");

                Paciente nuevoPaciente = new Paciente(datos[0], datos[1]);
                modelo.darPacientes().add(nuevoPaciente);

                lineActual = br.readLine();
            }

            br.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            FileReader fileReader = new FileReader("./files/citas.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String lineActual = br.readLine();

            while(lineActual!=null)
            {
                String[] datos = lineActual.split(";");
                Paciente pacienteaAsignar = modelo.buscarPacientePorCedula(datos[4]);
                Cita nuevaCita = new Cita(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), pacienteaAsignar, Integer.parseInt(datos[5]));
                modelo.darCitas().add(nuevaCita);

                lineActual = br.readLine();
            }

            br.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        Date fecha = new Date();

        int d = fecha.getDate();
        int m = fecha.getMonth()+1;
        int y = fecha.getYear();

        ventanaPrincipal.darPanelTabs().darPanelListaCitas().cambiarListaCitas(modelo.buscarCitasPorFecha(d,m,2021));
        //ventanaPrincipal.darPanelListaPacientes().cambiarListaPacientes(modelo.darPacientes());

        //modelo.ordenarCitasDelDiaPorHora(modelo.buscarCitasPorFecha(16,m,2021));
    }

    /**
     * Initializes main JFrame for Application
     */
    private static void inicializarVentanaPrincipal()
    {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }

    /**
     * Initializes buttons in main JFrame
     */
    private static void inicializarBotonesVentanaPrincipal()
    {
        ventanaPrincipal.darPanelOpciones().darBtnAgregarPaciente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarVentanaAgregarPaciente();
            }
        });

        ventanaPrincipal.darPanelOpciones().darBtnAgregarCita().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarVentanaAgregarCita();
            }
        });
    }

    /**
     * Initializes JFrame for VentanaAgregarPaciente
     */
    private static void inicializarVentanaAgregarPaciente()
    {
        VentanaAgregarPaciente ventanaAgregarPaciente = ventanaPrincipal.darVentanaAgregarPaciente();
        ventanaAgregarPaciente.setVisible(true);
    }

    /**
     * Initializes JFrame for VentanaAgregarCita
     */
    private static void inicializarVentanaAgregarCita()
    {
        VentanaAgregarCita ventanaAgregarCita = ventanaPrincipal.darVentanaAgregarCita();
        ArrayList<Paciente> pacientes = modelo.darPacientes();
        for(int i=0;i<pacientes.size();i++)
        {
            ventanaAgregarCita.getComboPacientes().addItem(pacientes.get(i));
        }

        for(int i=7;i<=20;i++)
        {
            for(int j=0;j<=30;j+=30)
            {
                if(j==0)
                    ventanaAgregarCita.getHora().addItem(i + ":" + j + "0");
                else
                    ventanaAgregarCita.getHora().addItem(i + ":" + j);
            }
        }

        ventanaAgregarCita.setVisible(true);
    }

    /**
     * Initializes buttons in JFrame VentanaAgregar
     */
    private static void inicializarBotonesVentanaAgregarPaciente()
    {
        ventanaPrincipal.darVentanaAgregarPaciente().getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePaciente = ventanaPrincipal.darVentanaAgregarPaciente().getTxtNombre().getText();
                String cedulaPaciente = ventanaPrincipal.darVentanaAgregarPaciente().getTxtCedula().getText();

                if(!nombrePaciente.equals(""))
                {
                    try
                    {
                        Paciente nuevoPaciente = new Paciente(nombrePaciente, cedulaPaciente);
                        modelo.agregarPaciente(nuevoPaciente);

                        FileWriter fileWriter = new FileWriter("./files/pacientes.txt", true);
                        BufferedWriter bw = new BufferedWriter(fileWriter);
                        bw.write(nombrePaciente + ";" + cedulaPaciente);
                        bw.newLine();
                        bw.close();

                        JOptionPane.showMessageDialog(null,"El paciente se ha agregado con éxito!","Proceso exitoso", JOptionPane.INFORMATION_MESSAGE);
                        ventanaPrincipal.darVentanaAgregarPaciente().dispose();
                        ventanaPrincipal.darVentanaAgregarPaciente().getTxtNombre().setText("");
                        ventanaPrincipal.darVentanaAgregarPaciente().getTxtCedula().setText("");

                        ventanaPrincipal.darPanelListaPacientes().cambiarListaPacientes(modelo.darPacientes());

                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"El nombre del paciente no puede ser vacío","Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        ventanaPrincipal.darVentanaAgregarPaciente().getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.darVentanaAgregarPaciente().dispose();
            }
        });
    }

    /**
     * Initializes buttons in JFrame VentanaAgregarCita
     */
    public static void inicializarBotonesVentanaAgregarCita()
    {
        ventanaPrincipal.darVentanaAgregarCita().getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.darVentanaAgregarCita().getComboPacientes().getSelectedIndex();
            }
        });

        ventanaPrincipal.darVentanaAgregarCita().getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.darVentanaAgregarCita().dispose();
            }
        });
    }

    /**
     * Initializes list ListaPacientes
     */
    private static void inicializarListaPacientes()
    {
        ventanaPrincipal.darPanelListaPacientes().darListaPacientes().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Paciente pacienteSeleccionado = (Paciente) ventanaPrincipal.darPanelListaPacientes().darListaPacientes().getSelectedValue();
                ventanaPrincipal.darPanelDatos().darTxtNombre().setText(pacienteSeleccionado.darNombre());
                ventanaPrincipal.darPanelDatos().darTxtCedula().setText(pacienteSeleccionado.darCedula());
            }
        });
    }

    /**
     * Initializes list ListaCitas
     */
    private static void inicializarListaCitas()
    {
        ventanaPrincipal.darPanelTabs().darPanelListaCitas().darListaCitas().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Cita citaSeleccionada = (Cita) ventanaPrincipal.darPanelTabs().darPanelListaCitas().darListaCitas().getSelectedValue();
                ventanaPrincipal.darPanelDatos().darTxtNombre().setText(citaSeleccionada.getPacienteAsignado().darNombre());
                ventanaPrincipal.darPanelDatos().darTxtCedula().setText(citaSeleccionada.getPacienteAsignado().darCedula());
                ventanaPrincipal.darPanelDatos().darTxtFecha().setText(citaSeleccionada.getDay() + "/" + citaSeleccionada.getMonth() + "/" + citaSeleccionada.getYear());
                ventanaPrincipal.darPanelDatos().darTxtHora().setText("" + citaSeleccionada.getHora());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    /**
     * Initializes class Calendario
     */
    private static void inicializarCalendario()
    {
        ventanaPrincipal.darPanelCalendario().darCalendario().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                int day = ventanaPrincipal.darPanelCalendario().darCalendario().getDayChooser().getDay();
                int month = ventanaPrincipal.darPanelCalendario().darCalendario().getMonthChooser().getMonth()+1;
                int year = ventanaPrincipal.darPanelCalendario().darCalendario().getYearChooser().getYear();

                ventanaPrincipal.darPanelTabs().darPanelListaCitas().cambiarListaCitas(modelo.buscarCitasPorFecha(day, month, year));
            }
        });
    }
}