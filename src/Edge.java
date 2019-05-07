/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author winow
 */
public class Edge {
    public final double cost; //nilai panjang edge
    public final Node target; //node tujuan 

    Edge(Node target, double cost) {
        this.target = target;
        this.cost = cost;
    }
}
