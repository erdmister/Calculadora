package Calculadora.vista;

import Calculadora.controlador.CalculadoraControlador;

import javax.swing.*;
import java.awt.*;

public class vistaCalculadora extends JFrame{
    private JPanel panelPrincipal; // Panel con CardLayout
    private panelMenu menuPanel;
    private panelOperacion operacionPanel;

    /** Constructor **/
    public vistaCalculadora(){
        super("Calculadora"); // Titulo del Jframe - ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando se cierre el programa la ejecucion termina
        setSize(400, 300); // Tamaño inicial
        setLocationRelativeTo(null);

        // Configuracion de CardLayout en el panel principal
        panelPrincipal = new JPanel(new CardLayout());
        add(panelPrincipal);

        // Inicializar los paneles
        menuPanel = new panelMenu();
        operacionPanel = new panelOperacion();

        // Agrega los paneles al CardLayout con nombres identificativos
        panelPrincipal.add(menuPanel.getPrincipal(), "MENU");
        panelPrincipal.add(operacionPanel.getPrincipal(), "OPERACION");

        // Muestra el panel del menu inicial
        ((CardLayout) panelPrincipal.getLayout()).show(panelPrincipal, "MENU");

        // Inicializa el controlador y pasa los componenres necesarios
        new CalculadoraControlador(menuPanel, operacionPanel, panelPrincipal);
    }

    public panelMenu getPanelPrincipal() {
        return menuPanel;
    }

    public panelOperacion getOperacionPanel() {
        return operacionPanel;
    }

    public JPanel getMainPanel() {
        return panelPrincipal;
    }
}
