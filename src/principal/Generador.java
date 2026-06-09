/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author SkullCandy
 */
public class Generador {
    
    public static void main(String[] args) throws Exception {
        String ruta1 = "Lexer.flex"; // Ruta al archivo flex
        String ruta2 = "Sintax.cup"; // Ruta al archivo cup
        String[] rutaS = {"-parser", "Sintax", ruta2};
        
        generar(ruta1, rutaS);
    }
    
    public static void generar(String ruta1, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        jflex.Main.generate(new String[]{ ruta1 }); // Genera el Lexer.java
        java_cup.Main.main(rutaS); // Genera el Sintax.java y sym.java
        
        // Mover archivos generados a la carpeta src/codigo
        // NOTA: Ajusta estas rutas según la ubicación exacta de tu proyecto en tu disco
        Path rutaSym = Paths.get("C:\\Users\\SkullCandy\\Documents\\NetBeansProjects\\CompiladorConFlexCup\\sym.java");
        Path rutaSin = Paths.get("C:\\Users\\SkullCandy\\Documents\\NetBeansProjects\\CompiladorConFlexCup\\Sintax.java");
        Path rutaLex = Paths.get("C:\\Users\\SkullCandy\\Documents\\NetBeansProjects\\CompiladorConFlexCup\\Lexer.java"); // Lexer se genera en raiz usualmente

        // Aquí deberías agregar la lógica para moverlos a src/codigo manualmente o por código
        // Por simplicidad, al ejecutar esto, los archivos aparecerán en la raíz del proyecto.
        // ARRASTRALOS MANUALMENTE DENTRO DEL PAQUETE 'codigo' en NetBeans.
    }
    
}
