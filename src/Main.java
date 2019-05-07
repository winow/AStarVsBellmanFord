

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author winow
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("-- MENCARI RUTE TERPENDEK DENGAN ALGORIMA ASTAR --");
        System.out.println("");
        //instansiasi objek node dengan constructor yg ada dikelas Node, dan mempunyai parameter nama node dan nilai heuristiknya
        Node k1 = new Node("A",0);
        Node k2 = new Node("B",3);
        Node k3 = new Node("C",10);
        Node k4 = new Node("D",5);
        Node k5 = new Node("E",2);
        Node k6 = new Node("F",7);
        Node k7 = new Node("G",5);
        Node k8 = new Node("H",9);
        Node k9 = new Node("I",8);
        
        //instansiasi cost yang menghubungkan antara 2 node yang ada dalam class Edge
        k1.jarak=new Edge[]{
            new Edge(k2,1),
            new Edge(k4,1)
        };
        k2.jarak=new Edge[]{
            new Edge(k3,2)
        };
        k3.jarak=new Edge[]{
            new Edge(k4,3),
            new Edge(k5,7)
        };
        k4.jarak=new Edge[]{
            new Edge(k2,8),
            new Edge(k6,4)
        };
        k5.jarak=new Edge[]{
            new Edge(k4,5),
            new Edge(k7,1),
            new Edge(k8,10)
        };
        k6.jarak=new Edge[]{
            new Edge(k9,9),
            new Edge(k5,3)
        };
        k7.jarak=new Edge[]{
            new Edge(k8,8)
        };
        k8.jarak=new Edge[]{
            new Edge(k6,8),
            new Edge(k9,14)
        };
        k9.jarak=new Edge[]{
            new Edge(k1,3),
            new Edge(k4,5)
        };
        
        System.out.println("Dengan Algoritma AStar  :");
         
        long start = System.nanoTime();
        
        AStar.AStar(k1,k9);
        
        List<Node> jalur = AStar.printPath(k9);
        
        System.out.println("Solusi: " + jalur);
        
        long end = System.nanoTime();
        
        long Time = end - start;
        
        System.out.println("Waktu Eksekusi : " + Time + " ns ");
        
        System.out.println("");
        System.out.println("Dengan Algoritma Bellman Ford   :");
        
    } 
    
}
