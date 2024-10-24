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
    
     /**
     * @return the station
     */
    public String getStation() {
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * @return the nearStations
     */
    public SimpleList getNearStations() {
        return nearStations;
    }

    /**
     * @param nearStations the nearStations to set
     */
    public void setNearStations(SimpleList nearStations) {
        this.nearStations = nearStations;
    }

    /**
     * @return the next
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * @return the hasBranch
     */
    public boolean isHasBranch() {
        return hasBranch;
    }

    /**
     * @param hasBranch the hasBranch to set
     */
    public void setHasBranch(boolean hasBranch) {
        this.hasBranch = hasBranch;
    }

    
    
    
}
