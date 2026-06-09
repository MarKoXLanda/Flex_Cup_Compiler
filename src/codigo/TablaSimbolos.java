/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.util.HashMap;

/**
 *
 * @author SkullCandy
 */
public class TablaSimbolos {
    
    public HashMap<String, Simbolo> t;


    public TablaSimbolos(){
        t = new HashMap<>();
    }

    public Simbolo insertar(String nombre, String tipo){
        Simbolo s = new Simbolo(nombre, tipo, null);
        t.put(nombre, s);
        return s;
    }

    public Simbolo buscar(String nombre){
        return (Simbolo)(t.get(nombre));
    }

    public void imprimir(){
        for (Simbolo s : t.values()) {
            System.out.println(s.nombre + " (" + s.tipo + "): " + s.valor);
        }
    }
}
