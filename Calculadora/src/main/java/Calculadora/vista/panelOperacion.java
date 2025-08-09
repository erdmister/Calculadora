package Calculadora.vista;

import javax.swing.*;
import java.awt.*;

public class panelOperacion {
    private JPanel panelPrincipal;
    private JLabel tituloLabel;
    private JPanel panelContenido;
    private JPanel panelJlabel;
    private JPanel panelTextArea;
    private JPanel panelBotones;
    private JTextField textFieldNumero1;
    private JTextField textFieldNumero2;
    private JTextField textFieldResultado;
    private JButton calcularButton;
    private JButton regresarButton;
    private JButton limpiarButton;

    /** Constructor **/
    public panelOperacion() {
        configurarComponentes(); // Llamamos al configurador en el constructor
    }


    /** Metodo **/
    private void configurarComponentes() {
        textFieldResultado.setEditable(false);  // Configurar el campo de resultado como no editable
        textFieldResultado.setFocusable(false);
        textFieldResultado.setBackground(new Color(240, 240, 240));
        textFieldResultado.setHorizontalAlignment(JTextField.RIGHT);
    }

    public void limpiarCampos() {
        textFieldNumero1.setText("");
        textFieldNumero2.setText("");
        textFieldResultado.setText("");
    }

    /** Setters **/
    // Setter para personalisar el titulo segun la operacion
    public void setTitulo(String titulo) {
        tituloLabel.setText(titulo);
    }

    public void setResultado(double resultado) {
        textFieldResultado.setText(String.format("%.2f", resultado));
    }

    /** Getters **/
    public JPanel getPrincipal(){
        return panelPrincipal;
    }

    public String getNumero1(){
        return textFieldNumero1.getText();
    }

    public String getNumero2(){
        return textFieldNumero2.getText();
    }

    public JButton getCalcularButton(){
        return calcularButton;
    }

    public JButton getRegresarButton(){
        return regresarButton;
    }

    public JButton getLimpiarButton(){
        return limpiarButton;
    }

    public String getTitulo() {
        return tituloLabel.getText(); // Devuelve el texto actual del JLabel
    }


}
