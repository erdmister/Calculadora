package Calculadora.controlador;

import Calculadora.modelo.*;
import Calculadora.vista.*;
import javax.swing.*;
import java.awt.*;

public class CalculadoraControlador {
    private final CalculadoraModelo modelo;
    private final panelMenu menuPanel;
    private final panelOperacion operacionPanel;
    private final JPanel mainPanel;
    private final CardLayout cardLayout;

    public CalculadoraControlador(panelMenu menuPanel, panelOperacion operacionPanel, JPanel mainPanel) {
        this.modelo = new CalculadoraModelo();
        this.menuPanel = menuPanel;
        this.operacionPanel = operacionPanel;
        this.mainPanel = mainPanel;
        this.cardLayout = (CardLayout) mainPanel.getLayout();

        configurarListenersMenu();
        configurarListenersOperacion();
    }

    public void configurarListenersMenu() {
        menuPanel.getSumaButton().addActionListener(e -> cambiarPanelOperacion("SUMA"));
        menuPanel.getRestaButton().addActionListener(e -> cambiarPanelOperacion("RESTA"));
        menuPanel.getMultiplicacionButton().addActionListener(e -> cambiarPanelOperacion("MULTIPLICACION"));
        menuPanel.getDivisionButton().addActionListener(e -> cambiarPanelOperacion("DIVISION"));
    }

    private void cambiarPanelOperacion(String operacion) {
        operacionPanel.limpiarCampos();
        operacionPanel.setTitulo(operacion);
        cardLayout.show(mainPanel, "OPERACION");
    }

    public void configurarListenersOperacion() {
        operacionPanel.getRegresarButton().addActionListener(e -> {
            operacionPanel.limpiarCampos();
            cardLayout.show(mainPanel, "MENU");
        });

        operacionPanel.getLimpiarButton().addActionListener(e -> {
            operacionPanel.limpiarCampos();
        });

        operacionPanel.getCalcularButton().addActionListener(e -> {
            try {
                // Validación unificada en un solo lugar
                validarEntrada();

                double num1 = Double.parseDouble(operacionPanel.getNumero1());
                double num2 = Double.parseDouble(operacionPanel.getNumero2());
                String operacion = operacionPanel.getTitulo();

                double resultado = realizarOperacion(num1, num2, operacion);
                operacionPanel.setResultado(resultado);

            } catch (IllegalArgumentException ex) {
                mostrarError(ex.getMessage());
            }
        });
    }

    private void validarEntrada() throws IllegalArgumentException {
        // Validar campos vacíos
        if (operacionPanel.getNumero1().trim().isEmpty() ||
                operacionPanel.getNumero2().trim().isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar ambos números");
        }

        // Validar que sean números válidos
        try {
            Double.parseDouble(operacionPanel.getNumero1());
            Double.parseDouble(operacionPanel.getNumero2());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Ingrese valores numéricos válidos");
        }

        // Validación específica para división
        if (operacionPanel.getTitulo().equals("DIVISION")) {
            double divisor = Double.parseDouble(operacionPanel.getNumero2());
            if (divisor == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        }
    }

    private double realizarOperacion(double num1, double num2, String operacion) {
        return switch (operacion) {
            case "SUMA" -> modelo.sumar(num1, num2);
            case "RESTA" -> modelo.restar(num1, num2);
            case "MULTIPLICACION" -> modelo.multiplicar(num1, num2);
            case "DIVISION" -> modelo.dividir(num1, num2);
            default -> 0;
        };
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(mainPanel, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}