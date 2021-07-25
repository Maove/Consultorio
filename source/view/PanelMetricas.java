package view;

import javax.swing.*;
import java.awt.*;

public class PanelMetricas extends JPanel
{
    private JLabel labCitasSemana, labCitasMes, citasSemana, citasMes;



    public PanelMetricas()
    {
        setLayout(new GridLayout(2,2));

        labCitasSemana = new JLabel("Citas de la semana");
        add(labCitasSemana);

        labCitasMes = new JLabel("Citas del mes");
        add(labCitasMes);

        citasSemana = new JLabel();
        add(citasSemana);

        citasMes = new JLabel();
        add(citasMes);
    }

    public JLabel darLabCitasSemana() { return citasSemana; }

    public JLabel darLabCitasMes() { return citasMes; }
}