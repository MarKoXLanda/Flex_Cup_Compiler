/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

/**
 *
 * @author USUARIO
 */
public class FuncionesMatematicas {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
        if (n == 0 || n == 1) return 1;
        
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    
    public static double[] formulaGeneral(double a, double b, double c) {
        if (a == 0) {
            // No es cuadrática, es lineal: bx + c = 0
            if (b == 0) return null; // No hay solución
            return new double[]{-c / b};
        }
        
        // Discriminante: b² - 4ac
        double discriminante = b * b - 4 * a * c;
        
        System.out.println("Discriminante: " + discriminante);
        
        if (discriminante < 0) {
            // No hay raíces reales
            return null;
        } else if (discriminante == 0) {
            // Raíz única
            double x = -b / (2 * a);
            return new double[]{x};
        } else {
            // Dos raíces distintas
            double sqrtDisc = Math.sqrt(discriminante);
            double x1 = (-b + sqrtDisc) / (2 * a);
            double x2 = (-b - sqrtDisc) / (2 * a);
            return new double[]{x1, x2};
        }
    }
    
    
    public static double sinTaylor(double x, int terminos) {
        double resultado = 0.0;
        
        for (int n = 0; n < terminos; n++) {
            // Término n: (-1)^n * x^(2n+1) / (2n+1)!
            int exponente = 2 * n + 1;
            double termino = Math.pow(x, exponente) / factorial(exponente);
            
            // Alternar signos: +, -, +, -, ...
            if (n % 2 == 0) {
                resultado += termino;
            } else {
                resultado -= termino;
            }
        }
        
        return resultado;
    }
    
  
    public static double cosTaylor(double x, int terminos) {
        double resultado = 0.0;
        
        for (int n = 0; n < terminos; n++) {
            // Término n: (-1)^n * x^(2n) / (2n)!
            int exponente = 2 * n;
            double termino = Math.pow(x, exponente) / factorial(exponente);
            
            // Alternar signos: +, -, +, -, ...
            if (n % 2 == 0) {
                resultado += termino;
            } else {
                resultado -= termino;
            }
        }
        
        return resultado;
    }
    
   
    public static double tanTaylor(double x) {
        double sinVal = sinTaylor(x, 10);
        double cosVal = cosTaylor(x, 10);
        
        if (Math.abs(cosVal) < 1e-10) {
            throw new ArithmeticException("tan indefinida (cos(x) ≈ 0)");
        }
        
        return sinVal / cosVal;
    }
}
