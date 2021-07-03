package view;

import javax.swing.*;
import java.awt.*;

public class PanelTabs extends JPanel
{
    private JTabbedPane tabs;

    private PanelListaPacientes panelListaPacientes;

    private PanelListaCitas panelListaCitas;

    public PanelTabs()
    {
        setBorder(BorderFactory.createTitledBorder("Tabs"));
        setLayout(new BorderLayout());

        tabs = new JTabbedPane();

        add(tabs, BorderLayout.CENTER);

        panelListaPacientes = new PanelListaPacientes();
        panelListaCitas = new PanelListaCitas();

        tabs.addTab("Citas", panelListaCitas);
        tabs.addTab("Pacientes", panelListaPacientes);
    }

    public JTabbedPane darTab() { return tabs; }

    public PanelListaCitas darPanelListaCitas() { return panelListaCitas; }

    public PanelListaPacientes darPanelListaPacientes() { return panelListaPacientes; }
}
