/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author sebas/aaron/jesus
 */
public class Cola {

    Nodo head;
    Nodo tail;

    public Cola() {
        this.head = this.tail = null;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    public void enqueue(String n) {
        if (this.head == null) {
            this.head = this.tail = new Nodo(n);
        } else {
            this.tail.setNext(new Nodo(n));
            this.tail = this.tail.getNext();
        }
    }

    public Nodo dequeue() {
        if (this.head == null) {
            return null;
        } else {
            Nodo aux = this.head;
            this.head = this.head.getNext();
            return aux;
        }
    }
}

