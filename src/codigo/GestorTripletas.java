/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class GestorTripletas {
    private List<Tripleta> tripletas;
    private int contadorTemporales;
    private int indiceTripleta;
    
    public GestorTripletas() {
        this.tripletas = new ArrayList<>();
        this.contadorTemporales = 0;
        this.indiceTripleta = 0;
    }
    
    /**
     * Genera un nuevo nombre de temporal
     */
    public String nuevoTemporal() {
        return "t" + (contadorTemporales++);
    }
    
    /**
     * Agrega una tripleta para operación binaria
     */
    public String agregarTripleta(String operador, String op1, String op2) {
        String temp = nuevoTemporal();
        Tripleta t = new Tripleta(indiceTripleta++, operador, op1, op2, temp);
        tripletas.add(t);
        return temp;
    }
    
    /**
     * Agrega una tripleta para asignación
     */
    public void agregarAsignacion(String variable, String valor) {
        Tripleta t = new Tripleta(indiceTripleta++, "=", valor, "-", variable);
        tripletas.add(t);
    }
    
    /**
     * Agrega una tripleta para operación unaria (ej: incremento)
     */
    public void agregarUnaria(String operador, String operando, String resultado) {
        Tripleta t = new Tripleta(indiceTripleta++, operador, operando, "-", resultado);
        tripletas.add(t);
    }
    
    /**
     * Agrega una tripleta de declaración
     */
    public void agregarDeclaracion(String tipo, String variable) {
        Tripleta t = new Tripleta(indiceTripleta++, "DECL", tipo, "-", variable);
        tripletas.add(t);
    }
    
    /**
     * Agrega tripletas para la secuencia de Fibonacci con operaciones intermedias
     */
    public String agregarFibonacci(int n) {
        // Declarar variables iniciales
        String a = "0";
        String b = "1";
        String temp;
        String result;
        
        if (n == 0) {
            result = nuevoTemporal();
            Tripleta t = new Tripleta(indiceTripleta++, "=", "0", "-", result);
            tripletas.add(t);
            return result;
        }
        
        if (n == 1) {
            result = nuevoTemporal();
            Tripleta t = new Tripleta(indiceTripleta++, "=", "1", "-", result);
            tripletas.add(t);
            return result;
        }
        
        // Inicializar a = 0
        String tA = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "=", "0", "-", tA));
        
        // Inicializar b = 1
        String tB = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "=", "1", "-", tB));
        
        // Loop desde i=2 hasta n
        for (int i = 2; i <= n; i++) {
            // temp = a + b
            temp = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "+", tA, tB, temp));
            
            // a = b
            String nuevoA = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "=", tB, "-", nuevoA));
            
            // b = temp
            String nuevoB = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "=", temp, "-", nuevoB));
            
            tA = nuevoA;
            tB = nuevoB;
        }
        
        // El resultado final está en tB
        result = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "=", tB, "-", result));
        
        return result;
    }
    
    /**
     * Agrega tripletas para el factorial con operaciones intermedias
     */
    public String agregarFactorial(int n) {
        if (n == 0 || n == 1) {
            String result = nuevoTemporal();
            Tripleta t = new Tripleta(indiceTripleta++, "=", "1", "-", result);
            tripletas.add(t);
            return result;
        }
        
        // resultado = 1
        String resultado = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "=", "1", "-", resultado));
        
        // Loop desde i=2 hasta n
        for (int i = 2; i <= n; i++) {
            // resultado = resultado * i
            String temp = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "*", resultado, String.valueOf(i), temp));
            resultado = temp;
        }
        
        return resultado;
    }
    
    /**
     * Agrega tripletas para sin usando Taylor con operaciones intermedias
     */
    public String agregarSinTaylor(double x, int terminos) {
        // resultado = 0
        String resultado = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "=", "0", "-", resultado));
        
        for (int n = 0; n < terminos; n++) {
            // exponente = 2*n + 1
            int exponente = 2 * n + 1;
            String tExp = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "=", String.valueOf(exponente), "-", tExp));
            
            // x^exponente
            String tPow = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "^", String.valueOf(x), tExp, tPow));
            
            // factorial(exponente)
            String tFact = agregarFactorial(exponente);
            
            // termino = x^exponente / factorial(exponente)
            String termino = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "/", tPow, tFact, termino));
            
            // Alternar signos
            if (n % 2 == 0) {
                // resultado = resultado + termino
                String temp = nuevoTemporal();
                tripletas.add(new Tripleta(indiceTripleta++, "+", resultado, termino, temp));
                resultado = temp;
            } else {
                // resultado = resultado - termino
                String temp = nuevoTemporal();
                tripletas.add(new Tripleta(indiceTripleta++, "-", resultado, termino, temp));
                resultado = temp;
            }
        }
        
        return resultado;
    }
    
    /**
     * Agrega tripletas para cos usando Taylor con operaciones intermedias
     */
    public String agregarCosTaylor(double x, int terminos) {
        // resultado = 0
        String resultado = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "=", "0", "-", resultado));
        
        for (int n = 0; n < terminos; n++) {
            // exponente = 2*n
            int exponente = 2 * n;
            String tExp = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "=", String.valueOf(exponente), "-", tExp));
            
            // x^exponente
            String tPow = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "^", String.valueOf(x), tExp, tPow));
            
            // factorial(exponente)
            String tFact = agregarFactorial(exponente);
            
            // termino = x^exponente / factorial(exponente)
            String termino = nuevoTemporal();
            tripletas.add(new Tripleta(indiceTripleta++, "/", tPow, tFact, termino));
            
            // Alternar signos
            if (n % 2 == 0) {
                // resultado = resultado + termino
                String temp = nuevoTemporal();
                tripletas.add(new Tripleta(indiceTripleta++, "+", resultado, termino, temp));
                resultado = temp;
            } else {
                // resultado = resultado - termino
                String temp = nuevoTemporal();
                tripletas.add(new Tripleta(indiceTripleta++, "-", resultado, termino, temp));
                resultado = temp;
            }
        }
        
        return resultado;
    }
    
    /**
     * Agrega tripletas para la fórmula general con operaciones intermedias
     */
    public String agregarFormulaGeneral(double a, double b, double c) {
        // discriminante = b^2
        String b2 = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "^", String.valueOf(b), "2", b2));
        
        // 4*a
        String cuatroA = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "*", "4", String.valueOf(a), cuatroA));
        
        // 4*a*c
        String cuatroAC = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "*", cuatroA, String.valueOf(c), cuatroAC));
        
        // discriminante = b^2 - 4*a*c
        String discriminante = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "-", b2, cuatroAC, discriminante));
        
        // sqrt(discriminante)
        String sqrtDisc = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "sqrt", discriminante, "-", sqrtDisc));
        
        // -b
        String menosB = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "*", "-1", String.valueOf(b), menosB));
        
        // 2*a
        String dosA = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "*", "2", String.valueOf(a), dosA));
        
        // x1 = (-b + sqrt(discriminante)) / (2*a)
        String numeradorX1 = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "+", menosB, sqrtDisc, numeradorX1));
        
        String x1 = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "/", numeradorX1, dosA, x1));
        
        // x2 = (-b - sqrt(discriminante)) / (2*a)
        String numeradorX2 = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "-", menosB, sqrtDisc, numeradorX2));
        
        String x2 = nuevoTemporal();
        tripletas.add(new Tripleta(indiceTripleta++, "/", numeradorX2, dosA, x2));
        
        // Retornar x1 (o podrías crear una estructura para ambas raíces)
        return x1;
    }
    
    /**
     * Obtiene todas las tripletas
     */
    public List<Tripleta> getTripletas() {
        return tripletas;
    }
    
    /**
     * Limpia todas las tripletas
     */
    public void limpiar() {
        tripletas.clear();
        contadorTemporales = 0;
        indiceTripleta = 0;
    }
}
