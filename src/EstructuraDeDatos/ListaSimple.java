/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author jesus 
 */
public class ListaSimple {

    private Nodo first;
    private Nodo last;
    private int size;

    public ListaSimple() {
        this.first = null;
        this.last = null;
        this.size = 0;

    }

    public void insert(String station) {
        Nodo newNode = new Nodo(station);
        if (this.getFirst() == null) {
            this.setFirst(this.last = newNode);
        } else {
            this.getLast().setNext(newNode);
            this.setLast(this.getLast().getNext());
        }
        this.setSize(this.getSize() + 1);
    }

    public Nodo search(String station) {
        station = station.toLowerCase();
        String name[] = station.split("_");
        if (this.getFirst() == null) {
            return null;
        } else {
            Nodo aux = this.getFirst();
            if (name.length <= 1) {
                while (aux != null && !aux.getStation().toLowerCase().equals(station)) {
                    aux = aux.getNext();
                }
                return aux;
            } else {
                while (aux != null && !aux.getStation().toLowerCase().contains(name[0])) {
                    aux = aux.getNext();
                }
                return aux;
            }
        }
    }

    public String print() {
        if (this.getFirst() == null) {
            return "NO HAY ESTACIONES CERCANAS";
        } else {
            Nodo aux = this.getFirst();
            String print = "";
            while (aux != null) {
                if (!aux.getStation().equals("")) {
                    print += aux.getStation() + ", ";
                }
                aux = aux.getNext();
            }
            return print;
        }
    }

    /**
     * @return the first
     */
    public Nodo getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Nodo first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public Nodo getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Nodo last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
