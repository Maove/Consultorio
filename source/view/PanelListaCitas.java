package view;

import model.Cita;
import model.Paciente;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelListaCitas extends JPanel
{
    private JList listaCitas;

    private JScrollPane scrollLista;

    public PanelListaCitas()
    {
        setBorder(new TitledBorder("Agenda del día"));
        setLayout(new GridLayout(1,1));

        listaCitas = new JList();
        listaCitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollLista = new JScrollPane();
        scrollLista.setViewportView(listaCitas);

        add(scrollLista);
    }

    public JList darListaCitas() { return listaCitas; }

    public void cambiarListaCitas(ArrayList nuevaLista)
    {
        Cita[] array_citas = new Cita[nuevaLista.size()];

        for(int i = 0; i < nuevaLista.size(); i++)
        {
            array_citas[i] = (Cita) nuevaLista.get(i);
        }
        listaCitas.setListData(array_citas);
    }
}