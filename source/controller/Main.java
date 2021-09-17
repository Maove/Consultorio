package controller;

import model.Cita;
import model.Consultorio;
import model.Paciente;
import view.VentanaAgregarCita;
import view.VentanaAgregarPaciente;
import view.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * Relation with view VentanaAgregarCita
     */
    private static VentanaAgregarCita ventanaAgregarCita;

    /**
     * Connection to MySQL database
     */
    private static Connection conexionDB;

    /**
     * Executable main method
     * @param args - Array of arguments for execution
     */
    public static void main(String[] args)
    {
        conexionDB = null;

        inicializarVentanaPrincipal();
        inicializarBotonesVentanaPrincipal();
        inicializarBotonesVentanaAgregarPaciente();
        inicializarBotonesVentanaAgregarCita();
        inicializarListaPacientes();
        inicializarListaCitas();
        inicializarCalendario();

        inicializarModelo();
        colorearDias();



        int day = ventanaPrincipal.darPanelCalendario().darCalendario().getDayChooser().getDay();
        int month = ventanaPrincipal.darPanelCalendario().darCalendario().getMonthChooser().getMonth()+1;
        int year = ventanaPrincipal.darPanelCalendario().darCalendario().getYearChooser().getYear();

        //System.out.println(ventanaPrincipal.darPanelCalendario().darCalendario());

        ventanaPrincipal.darPanelMetricas().darLabCitasSemana().setText(""+modelo.buscarCitasPorSemana(day).size());
        ventanaPrincipal.darPanelMetricas().darLabCitasMes().setText(""+modelo.buscarCitasPorMes(month).size());

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
            String url = "jdbc:mysql://localhost:3306/consultorio";
            String user = "root";
            String pwd = "root";
            conexionDB = DriverManager.getConnection(url, user, pwd);

            Statement stmtPacientes = conexionDB.createStatement();
            ResultSet rsPacientes = stmtPacientes.executeQuery("SELECT * FROM pacientes");

            while(rsPacientes.next())
            {
                Paciente nuevoPaciente = new Paciente(rsPacientes.getString(1), rsPacientes.getString(2));
                modelo.agregarPaciente(nuevoPaciente);
            }

            System.out.println("Los pacientes del consultorio han sido cargados correctamente");



            /*
            FileReader fileReader = new FileReader("./files/pacientes.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String lineActual = br.readLine();

            while(lineActual!=null)
            {
                String[] datos = lineActual.split(";");

                Paciente nuevoPaciente = new Paciente(datos[0], datos[1]);
                modelo.darPacientes().add(nuevoPaciente);

                stmt.execute("INSERT INTO `pacientes`(`nombre`, `id`) VALUES ('" + datos[0] + "','" + datos[1] + "')");
                lineActual = br.readLine();
            }
            con.close();
            br.close();
            */
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No es posible conectarse con la base de datos", "Error Base de datos", JOptionPane.ERROR_MESSAGE);
        }

        try
        {
            Statement stmtCitas = conexionDB.createStatement();
            ResultSet rsCitas = stmtCitas.executeQuery("SELECT * FROM citas");


            while(rsCitas.next())
            {
                Cita nuevaCita = new Cita(rsCitas.getInt(2), rsCitas.getInt(3), rsCitas.getInt(4), modelo.buscarPacientePorNombre(rsCitas.getString(7)), rsCitas.getInt(5), rsCitas.getInt(6));
                modelo.agregarCita(nuevaCita);
            }

            System.out.println("Las citas del consultorio cargadas correctamente");

            conexionDB.close();


            /*FileReader fileReader = new FileReader("./files/citas.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String lineActual = br.readLine();

            while(lineActual!=null)
            {
                String[] datos = lineActual.split(";");
                Paciente pacienteaAsignar = modelo.buscarPacientePorCedula(datos[4]);
                Cita nuevaCita = new Cita(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), pacienteaAsignar, Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
                modelo.darCitas().add(nuevaCita);

                lineActual = br.readLine();
            }

            br.close();
            */
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No es posible conectarse con la base de datos", "Error Base de datos", JOptionPane.ERROR_MESSAGE);
        }

        Date fecha = new Date();

        int d = fecha.getDate();
        int m = fecha.getMonth()+1;
        int y = Calendar.getInstance().get(Calendar.YEAR);

        ventanaPrincipal.darPanelTabs().darPanelListaCitas().cambiarListaCitas(modelo.ordenarCitasDelDiaPorHora(modelo.buscarCitasPorFecha(d,m,y)));
        //ventanaPrincipal.darPanelTabs().darPanelListaCitas().cambiarListaCitas(modelo.buscarCitasPorFecha(d,m,y));
        ventanaPrincipal.darPanelTabs().darPanelListaPacientes().cambiarListaPacientes(modelo.darPacientes());

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
        ventanaAgregarCita = ventanaPrincipal.darVentanaAgregarCita();
        ArrayList<Paciente> pacientes = modelo.darPacientes();
        if(ventanaAgregarCita.getComboPacientes().getSelectedItem() == null)
        {
            for(int i=0;i<pacientes.size();i++)
            {
                ventanaAgregarCita.getComboPacientes().addItem(pacientes.get(i));
            }
        }

        if(ventanaAgregarCita.getComboHora().getSelectedItem() == null)
        {
            for(int i=7;i<=20;i++)
            {
                for(int j=0;j<=30;j+=30)
                {
                    if(j==0)
                        ventanaAgregarCita.getComboHora().addItem(i + ":" + j + "0");
                    else
                        ventanaAgregarCita.getComboHora().addItem(i + ":" + j);
                }
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
                    if(!cedulaPaciente.equals(""))
                    {
                        Pattern pat = Pattern.compile("[0-9]*");
                        Matcher mat = pat.matcher(cedulaPaciente);
                        if(mat.matches())
                        {
                            if(cedulaPaciente.length() >= 6 && cedulaPaciente.length() <= 10)
                            {
                                try
                                {
                                    if(modelo.buscarPacientePorCedula(cedulaPaciente)==null)
                                    {
                                        Paciente nuevoPaciente = new Paciente(nombrePaciente, cedulaPaciente);
                                        modelo.agregarPaciente(nuevoPaciente);

                                        String url = "jdbc:mysql://localhost:3306/consultorio";
                                        String user = "root";
                                        String pwd = "root";
                                        Connection con= DriverManager.getConnection(url, user, pwd);

                                        Statement stmt = con.createStatement();
                                        String query = "INSERT INTO pacientes(nombre, id) VALUES ('" + nombrePaciente + "', '" + cedulaPaciente + "'); ";
                                        System.out.println(query);
                                        stmt.execute(query);

                                        con.close();

                                        JOptionPane.showMessageDialog(null,"El paciente se ha agregado con éxito!","Proceso exitoso", JOptionPane.INFORMATION_MESSAGE);
                                        ventanaPrincipal.darVentanaAgregarPaciente().dispose();
                                        ventanaPrincipal.darVentanaAgregarPaciente().getTxtNombre().setText("");
                                        ventanaPrincipal.darVentanaAgregarPaciente().getTxtCedula().setText("");

                                        ventanaPrincipal.darPanelListaPacientes().cambiarListaPacientes(modelo.darPacientes());
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null, "La cédula ya se encuentra registrada", "Error", JOptionPane.ERROR_MESSAGE);
                                } catch (Exception ex)
                                {
                                    ex.printStackTrace();
                                }
                            }
                            else
                                JOptionPane.showMessageDialog(null, "La cédula debe contener de 6 a 10 carácteres", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "La cédula no puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "La cédula del paciente no puede ser vacía", "Error", JOptionPane.ERROR_MESSAGE);

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
                Paciente pacienteAAsignar = (Paciente) ventanaPrincipal.darVentanaAgregarCita().getComboPacientes().getSelectedItem();
                String hora = (String) ventanaPrincipal.darVentanaAgregarCita().getComboHora().getSelectedItem();
                String[] date = hora.split(":");
                int ano = ventanaPrincipal.darVentanaAgregarCita().getFecha().getYearChooser().getYear();
                int mes = ventanaPrincipal.darVentanaAgregarCita().getFecha().getMonthChooser().getMonth()+1;
                int dia = ventanaPrincipal.darVentanaAgregarCita().getFecha().getDayChooser().getDay();

                try
                {
                    String url = "jdbc:mysql://localhost:3306/consultorio";
                    String user = "root";
                    String pwd = "root";
                    Connection con= DriverManager.getConnection(url, user, pwd);

                    Statement stmt = con.createStatement();
                    String query = "INSERT INTO `citas`(`day`, `month`, `year`, `hour`, `min`, `paciente`) VALUES (" + dia + ", " + mes + ", " + ano + ", " + date[0] + ", " + date[1] + ", '" + pacienteAAsignar.darNombre() + "');";
                    stmt.execute(query);
                    con.close();

                    JOptionPane.showMessageDialog(null,"Cita agregada exitosamente!","Proceso exitoso", JOptionPane.INFORMATION_MESSAGE);
                } catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                Cita nuevaCita = new Cita(dia, mes, ano, pacienteAAsignar, Integer.parseInt(date[0]), Integer.parseInt(date[1]));
                modelo.darCitas().add(nuevaCita);

                ventanaPrincipal.darPanelTabs().darPanelListaCitas().cambiarListaCitas(modelo.ordenarCitasDelDiaPorHora(modelo.buscarCitasPorFecha(dia,mes,ano)));
                //ventanaPrincipal.darPanelTabs().darPanelListaCitas().cambiarListaCitas(modelo.buscarCitasPorFecha(dia, mes, ano));

                ventanaPrincipal.darVentanaAgregarCita().dispose();
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
        ventanaPrincipal.darPanelTabs().darPanelListaPacientes().darListaPacientes().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Paciente pacienteSeleccionado = (Paciente) ventanaPrincipal.darPanelTabs().darPanelListaPacientes().darListaPacientes().getSelectedValue();
                System.out.println(pacienteSeleccionado);
                ventanaPrincipal.darPanelDatos().darTxtNombre().setText(pacienteSeleccionado.darNombre());
                ventanaPrincipal.darPanelDatos().darTxtCedula().setText(pacienteSeleccionado.darCedula());
                //ventanaPrincipal.darPanelDatos().darTxtFecha().setText(citaSeleccionada.getDay() + "/" + citaSeleccionada.getMonth() + "/" + citaSeleccionada.getYear());
                //ventanaPrincipal.darPanelDatos().darTxtHora().setText("" + citaSeleccionada.getHora() + ":" + citaSeleccionada.getMinuto());
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
                ventanaPrincipal.darPanelDatos().darTxtHora().setText("" + citaSeleccionada.getHora() + ":" + citaSeleccionada.getMinuto());

                if(e.getClickCount() == 2)
                {
                    JOptionPane.showMessageDialog(null,"Hola","Hi",JOptionPane.INFORMATION_MESSAGE);
                }
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

                ventanaPrincipal.darPanelTabs().darPanelListaCitas().cambiarListaCitas(modelo.ordenarCitasDelDiaPorHora(modelo.buscarCitasPorFecha(day,month,year)));

                // colorearDias();
            }
        });
    }

    private static void colorearDias()
    {
        /*JPanel jpanel = ventanaPrincipal.darPanelCalendario().darCalendario().getDayChooser().getDayPanel();
        Component components[] = jpanel.getComponents();

        for(int i = 0; i<modelo.darCitas().size();i++)
        {
            int dia = ((Cita)modelo.darCitas().get(i)).getDay();
            if(Integer.hashCode(dia) !=null)
            {

            }

            components[dia+ventanaPrincipal.darPanelCalendario().darCalendario().getCalendar().get(Calendar.DAY_OF_WEEK)+5].setBackground(Color.pink);

        }
         */
    }
}