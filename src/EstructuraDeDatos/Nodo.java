/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author aaron
 */
public class Nodo {
    
    private String station;
    private Simplelist nearStation;
    private Nodo next;
    private boolean hasBranch;
    
    public Nodo(String n){
        this.station = n;
        this.next = null;
        this.nearStations = new SimpleList;
        this.hasBranch = false;
    }
    
    
}
