package Calculadora;

import Calculadora.controlador.CalculadoraControlador;
import Calculadora.vista.vistaCalculadora;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            vistaCalculadora vista = new vistaCalculadora();
            // Pasa los componentes necesarios al controlador
            new CalculadoraControlador(
                    // Le pasamos los componentes necesario para que pueda controlar la interfaz
                    vista.getPanelPrincipal(),
                    vista.getOperacionPanel(),
                    vista.getMainPanel()
            );
            vista.setVisible(true);
        });
    }
}