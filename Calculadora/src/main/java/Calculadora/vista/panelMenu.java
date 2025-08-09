package Calculadora.vista;

import javax.swing.*;

public class panelMenu {
    private JPanel principal;
    private JPanel panelBotones;
    private JButton sumaButton;
    private JButton restaButton;
    private JButton multiplicacionButton;
    private JButton divisionButton;

    // Getter para el panel principal (para agregarlo al JFrame)
    public JPanel getPrincipal(){
        return principal;
    }

    // Getters para los botones (el controlador los usará para añadir listeners)

    public JButton getSumaButton(){
        return sumaButton;
    }

    public JButton getRestaButton(){
        return  restaButton;
    }

    public JButton getMultiplicacionButton(){
        return multiplicacionButton;
    }

    public JButton getDivisionButton(){
        return divisionButton;
    }
}
