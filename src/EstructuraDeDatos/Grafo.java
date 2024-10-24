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
    
    public void newEdge(String a, String b){
        Nodo estA = this.searchStation(a);
        Nodo estB = this.searchStation(b);
        
        if(estA != estB && estA != null && estB != null){
            estA.getNearStations().insert(b);
            estB.getNeatStations().insert(a);
        }
    }
    
    public void auxDFS(int v, boolean[] visitados, int contador){
        visitados[v] = true;
        System.out.println(v);
        if(contador != getT()){
            for (int=0; i < this.getMax_vertex(); i++){
                if((v !=i)&&(!visitados[i])&&this.getStations()[i].getNearStations().search(this.getStations()[v].getStation()) !=null){
                    auxDFS(i, visitados, contador + 1);
                    
                }
            }
        }
    }
    
    public void dfs(){
        boolean visitados[] = new boolean[this.getMax_vertex()];
        
        for (int i=0; i < this.getMax_vertex(); i++){
            visitados[i] = false;
        }
        for (int i=0; i<this.getMax_vertex(); i++){
            if(!visitados[i]){
                auxDFS(i, visitados, contador:0);
            }
        }
    }
    
    /**
     * @return the max_vertex
     */
    public int getMax_vertex(){
        return max_vertex;
    }
    
    /**
     * @param max_vertex the max_vertex to set
     */
    public void setMax_vertex(int max_vertex){
        this.max_vertex = max_vertex;
    }
    
    /**
     * @return the number_vertex to set
     */
    public int getNumber_vertex(){
        return number_vertex;
    }
    
    /**
     * @param number_vertex the number_vertex to set
     */
    public void setNumber_vertex(int number_vertex){
        this.number_vertex = number_vertex;
    }
    
    /**
     * @return the stations
     */
    public Nodo[] getStations(){
        return stations;
    }
    
    /**
     * @param stations the station to set
     */
    public void setStations(Nodo[] stations){
        this.stations = stations;
    }
    /**
     * @return the t
     */
    public int getT(){
        return t;
    }
    
    /**
     * @param t the t to set
     */
    public void setT(int t){
        this.t = t;
    }
}
    