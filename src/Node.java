/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author winow
 */
import java.util.*;

public class Node {
    
    public final String node; //untk nama node
    public double g; //jarak dari node asal ke node yang di eksekusi
    public final double h; //nilai heuristik dari node
    public double f; //untuk variabel rumus f = g + h
    public Edge[] jarak; //untuk penghubung antar node
    public Node parent;

    Node(String node, double h) {
        this.node = node;
        this.h = h;
    }  
  
    @Override //karena agar tidak mengoutputkan Node@address
    public String toString() {
        return node;
    }
    
    
}
