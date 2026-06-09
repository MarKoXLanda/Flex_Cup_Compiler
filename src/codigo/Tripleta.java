/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

/**
 *
 * @author USUARIO
 */
public class Tripleta {
    private int indice;
    private String operador;
    private String operando1;
    private String operando2;
    private String resultado;
    
    public Tripleta(int indice, String operador, String operando1, String operando2, String resultado) {
        this.indice = indice;
        this.operador = operador;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
    }
    
    public int getIndice() {
        return indice;
    }
    
    public String getOperador() {
        return operador;
    }
    
    public String getOperando1() {
        return operando1;
    }
    
    public String getOperando2() {
        return operando2;
    }
    
    public String getResultado() {
        return resultado;
    }
    
    @Override
    public String toString() {
        return String.format("%-4d %-10s %-10s %-10s %-10s", 
            indice, operador, operando1, operando2, resultado);
    }
    
    // Formato para tabla visual
    public String toTableRow() {
        return String.format("| %-4d | %-10s | %-12s | %-12s | %-12s |", 
            indice, operador, operando1, operando2, resultado);
    }
}
