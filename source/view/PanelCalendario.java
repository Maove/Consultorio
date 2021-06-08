package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import java.awt.*;

public class PanelCalendario extends JPanel
{
    /**
     * JCalendar - Calendar for application
     */
    private JCalendar calendario;

    /**
     * Class PanelCalendario constructor
     */
    public PanelCalendario()
    {
        setBorder(new TitledBorder("Calendario del mes"));
        setLayout(new GridLayout(1,1));

        calendario = new JCalendar();
        add(calendario);
    }

    /**
     * Method darCalendario to get application's JCalendar calendario
     * @return calendario - JCalendar calendario
     */
    public JCalendar darCalendario() { return calendario; }
}