/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author sebas
 */
public class Grafo {
    private int max_vertex;
    private int number_vertex;
    private Nodo[] stations;
    private int t;
    
    public Grafo(){
        max_vertex = 120;
        number_vertex = 0;
        this.stations = new Nodo[max_vertex];
        for (int i=0; i < max_vertex; i++){
            this.stations[i] = new Nodo(n:"");
        }
        t=3;
        
    }
    
    public void insertStation(String station){
        for (int i = 0; i < getMax_vertex(); i++){
            if (this..getstations()[i].getStation().equals(anObject:"")){
                this.getStations()[i].setStation(station);
                break;
            }
        }
    }
    
    public void setBranch(String station){
        this.searchStation(station).setHasBranch(hasBranch:true);
    }
    
    public Nodo searchStation(String station){
        for(int i=0; i < getMax_vertex(); i++){
            if (this.getStations()[i].getStation().equals(station)){
                return this.getStations()[i];
            }
        }
        return null;
    }
    
}
    