package logica;
import java.util.ArrayList;

/**
 * Clase generica que representa un deposito de almacenamiento de objetos.
 * Utiliza una estructura de datos ArrayList para gestionar los elementos.
 * Implementa operaciones FIFO (First In, First Out).
 * 
 * @param <T> el tipo de objetos almacenados en el deposito
 * @author Tarea DOO
 * @version 1.0
 */
public class Deposito<T>{
    private ArrayList<T> elementos;
    /**
     * Constructor que inicializa un deposito vacio.
     */
    public Deposito(){

        elementos=new ArrayList<T>();
    }
    
    /**
     * Añade un objeto al deposito.
     * 
     * @param objeto el objeto a añadir
     */
    public void add(T objeto){
        elementos.add(objeto);
    }
    
    /**
     * Obtiene y extrae el primer objeto del deposito (FIFO).
     * 
     * @return el primer objeto del deposito o null si esta vacio
     */
    public T get(){
        if(elementos.size()>0){
            return elementos.remove(0);
        }
        else{
            return null;
        }
    }
}