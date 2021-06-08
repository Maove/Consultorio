package view;

import javax.swing.*;
import java.awt.*;

public class PanelTabs extends JPanel
{
    private JTabbedPane tabs;

    public PanelTabs()
    {
        setBorder(BorderFactory.createTitledBorder("Tabs"));
        setLayout(new BorderLayout());

        tabs = new JTabbedPane();

        add(tabs, BorderLayout.NORTH);

        tabs.addTab("Pestaña 1", new JButton("Este es un botón de prueba 1"));
        //tabs.add(new JButton("Este es un botón de prueba"));
        tabs.addTab("Pestaña 2", new JButton("Este es un botón de prueba 2"));
    }

    public JTabbedPane darTab() { return tabs; }
}
