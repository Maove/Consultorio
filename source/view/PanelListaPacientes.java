package view;

import model.Paciente;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelListaPacientes extends JPanel
{
    private JList listaPacientes;

    private JScrollPane scrollLista;

    public PanelListaPacientes()
    {
        setBorder(new TitledBorder("Pacientes"));
        setLayout(new GridLayout(1,1));

        listaPacientes = new JList();
        listaPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollLista = new JScrollPane();
        scrollLista.setViewportView(listaPacientes);

        add(scrollLista);
    }

    public JList darListaPacientes() { return listaPacientes; }

    public void cambiarListaPacientes(ArrayList nuevaLista)
    {
        Paciente[] array_pacientes = new Paciente[nuevaLista.size()];

        for(int i = 0; i < nuevaLista.size(); i++)
        {
            array_pacientes[i] = (Paciente) nuevaLista.get(i);
        }
        listaPacientes.setListData(array_pacientes);
    }
}