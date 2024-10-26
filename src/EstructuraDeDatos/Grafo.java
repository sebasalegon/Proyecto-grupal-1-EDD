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

    public Grafo() {
        max_vertex = 120;
        number_vertex = 0;
        this.stations = new Nodo[max_vertex];
        for (int i = 0; i < max_vertex; i++) {
            this.stations[i] = new Nodo("");
        }
        t = 3;
    }

    public void insertStation(String station) {
        for (int i = 0; i < getMax_vertex(); i++) {
            if (this.getStations()[i].getStation().equals("")) {
                this.getStations()[i].setStation(station);
                break;
            }
        }
    }

    public void setBranch(String station) {
        this.searchStation(station).setHasBranch(true);
    }

    public Nodo searchStation(String station) {
        station = station.toLowerCase();
        String name[] = station.split("_");
        if (name.length <= 1) {
            for (int i = 0; i < getMax_vertex(); i++) {
                if (this.getStations()[i].getStation().toLowerCase().equals(station)) {
                    return this.getStations()[i];
                }
            }
        } else {
            for (int i = 0; i < getMax_vertex(); i++) {
                if (this.getStations()[i].getStation().toLowerCase().contains(name[0])) {
                    return this.getStations()[i];
                }
            }
        }
        return null;
    }

    public void newEdge(String a, String b) {
        Nodo estA = this.searchStation(a);
        Nodo estB = this.searchStation(b);

        if (estA != estB && estA != null && estB != null) {
            estA.getNearStations().insert(b);
            estB.getNearStations().insert(a);
        }
    }

    public ListaSimple auxDFS(int v, boolean[] visitados, int contador, ListaSimple stationsReached) {
        visitados[v] = true;
//        System.out.println(v);
        stationsReached.insert(this.stations[v].getStation());
        if (contador != getT()) {
            for (int i = 0; i < this.getMax_vertex(); i++) {
                if ((v != i) && (!visitados[i]) && this.getStations()[i].getNearStations().search(this.getStations()[v].getStation()) != null) {
                    stationsReached = auxDFS(i, visitados, contador + 1, stationsReached);
                }
            }
        }
        return stationsReached;
    }

    public ListaSimple dfs(String stationName) {
        boolean visitados[] = new boolean[this.getMax_vertex()];
        ListaSimple stationsReached = new ListaSimple();
        for (int i = 0; i < this.getMax_vertex(); i++) {
            visitados[i] = false;
        }
        int index = -1;
        for (int i = 0; i < this.getMax_vertex(); i++) {
            if (this.stations[i].getStation().equals(stationName)) {
                index = i;
            }
        }
        return auxDFS(index, visitados, 0, stationsReached);

    }

    public boolean hasEdge(int index1, int index2) {
        return this.stations[index1].getNearStations().search(this.stations[index2].getStation()) != null;
    }

    public ListaSimple bfs(String stationName) {
        Cola queue = new Cola();

        ListaSimple path = new ListaSimple();
        boolean visited[] = new boolean[this.max_vertex];
        int v; // vértice actual

        // Se inicializa el vector visitados [] a false
        for (int i = 0; i < this.max_vertex; i++) {
            visited[i] = false;
        }

        // El recorrido en amplitud se inicia en cada vértice no visitado
        int p = -1;
        String name[] = stationName.toLowerCase().split("_");

        for (int i = 0; i < this.max_vertex; i++) {
            if (this.stations[i].getStation().toLowerCase().equals(stationName.toLowerCase())) {
                queue.enqueue(this.stations[i].getStation());
                visited[i] = true;
                p = i;
            }
        }

        int level = 0; // Nivel actual
        int levelNodes = 1; // Nodos en el nivel actual
        int nextLevelNodes = 0; // Nodos en el siguiente nivel

        while (queue.head != null && level < t + 1) {
            String actualNode = queue.dequeue().getStation(); // Desencolar y tratar el vértice
            v = -1;
            for (int j = 0; j < this.max_vertex; j++) {
                if (this.stations[j].getStation().toLowerCase().equals(actualNode.toLowerCase())) {
                    v = j;
                }
            }
            path.insert(this.stations[v].getStation());

            // Encolar los nodos adyacentes a v
            for (int j = 0; j < this.max_vertex; j++) {
                if ((v != j) && this.hasEdge(v, j) && (!visited[j])) {
                    queue.enqueue(this.stations[j].getStation());
                    visited[j] = true;
                    nextLevelNodes++;
                }
            }

            levelNodes--; // Reducir el contador de nodos en el nivel actual

            // Si hemos procesado todos los nodos en el nivel actual
            if (levelNodes == 0) {
                level++; // Aumentar el nivel
                levelNodes = nextLevelNodes; // Actualizar nodosEnNivel
                nextLevelNodes = 0; // Reiniciar para el siguiente nivel
            }
        }
        return path;
    }

    public ListaSimple uncoveredStations() {
        ListaSimple coveredStations = new ListaSimple();
        for (int i = 0; i < this.max_vertex; i++) {
            if (!this.stations[i].getStation().equals("") && this.stations[i].isHasBranch()) {
                ListaSimple visitados = this.dfs(this.stations[i].getStation());
                Nodo aux = visitados.getFirst();
                while (aux != null) {
                    coveredStations.insert(aux.getStation());
                    aux = aux.getNext();
                }
            }
        }

        ListaSimple uncovered = new ListaSimple();
        for (int i = 0; i < this.max_vertex; i++) {
            if (!this.stations[i].getStation().equals("") && coveredStations.search(this.stations[i].getStation()) == null) {
                uncovered.insert(this.stations[i].getStation());
            }
        }
        return uncovered;
    }

    public String[] suggestBranches() {
        ListaSimple uncovered = this.uncoveredStations();
        String[] suggestedNodes = new String[uncovered.getSize()];
        int i = 0;
        while (uncovered.getFirst() != null) {
            this.searchStation(uncovered.getFirst().getStation()).setHasBranch(true);
            suggestedNodes[i] = uncovered.getFirst().getStation();
            i++;
            uncovered = this.uncoveredStations();
        }

        for (String suggest : suggestedNodes) {
            if (suggest != null) {
                this.searchStation(suggest).setHasBranch(false);
            }
        }
        return suggestedNodes;

    }

    public void show() {
        for (int i = 0; i < this.max_vertex; i++) {
            if (!this.stations[i].getStation().equals("")) {
                System.out.println(this.stations[i].getStation() + " --->  " + this.stations[i].getNearStations().print() );
            }
        }
    }

    /**
     * @return the max_vertex
     */
    public int getMax_vertex() {
        return max_vertex;
    }

    /**
     * @param max_vertex the max_vertex to set
     */
    public void setMax_vertex(int max_vertex) {
        this.max_vertex = max_vertex;
    }

    /**
     * @return the number_vertex
     */
    public int getNumber_vertex() {
        return number_vertex;
    }

    /**
     * @param number_vertex the number_vertex to set
     */
    public void setNumber_vertex(int number_vertex) {
        this.number_vertex = number_vertex;
    }

    /**
     * @return the stations
     */
    public Nodo[] getStations() {
        return stations;
    }

    /**
     * @param stations the stations to set
     */
    public void setStations(Nodo[] stations) {
        this.stations = stations;
    }

    /**
     * @return the t
     */
    public int getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(int t) {
        this.t = t;
    }
}
