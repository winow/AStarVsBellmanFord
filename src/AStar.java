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


/*
import java.io.*;*/

public class AStar {

    /**
     * @param args the command line arguments
     */
    
    public static void AStar(Node awal, Node akhir){
        //explored adalah HashSet yang akan diisikan dengan Node yang di instansiasi, awalnya explored bernilai null
        Set<Node> explored = new HashSet<Node>();
    
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, (Node i, Node j) ->{
            if(i.f >j.f){
                return 1; //ada di paling belakang
            }else if(i.f<j.f){
                return -1; //ada di paling depan, kemungkinan di explored duluan
            }else{
                return 0; // ada di tengah
            }
        }
        ); 
        
        /*System.out.println("Perhitungan Cost: ");*/
        
        awal.g=0;  //node awal, costnya di set 0
        queue.add(awal); //memasukkan node awal kedalam queue
        /*
        System.out.println("[QUEUE]   " + queue);
        System.out.println("[EXPLORED] " + explored);
        System.out.println("");*/

        boolean found = false;
        //loop ketika queue tidak sama dengan null dan node belum sampai di node tujuan
        while((!queue.isEmpty())&&(!false)){
            Node current = queue.poll(); //poll untuk menghapus, tetapi nilainya di return
            
            explored.add(current); // node yang punya f paling kecil dihapus dari current dan dimasukkan ke explored
            /*System.out.println("[QUEUE]   " + queue);
            System.out.println("[EXPLORED] " + explored);*/
            
            if(current.node.equals(akhir.node)){ //looping selesai jika ketemu node tujuan
                found = true;/*
                System.out.println("--- SELESAI ---");
                System.out.println("");*/
            }
            
            //cek semua anak dari parrent
            for(Edge e : current.jarak){
                Node child = e.target;
                double cost = e.cost;
                double temp_g_nilai = current.g + cost;
                double temp_f_nilai = temp_g_nilai + child.h;
                /*System.out.println("\t[QUEUE]\t" + child + " " + temp_f_nilai);*/
                
                //jika nilai f node child lebih besar, akan continue ke node lain 
                if((explored.contains(child))&&(temp_f_nilai >= child.f)){
         
                
                }
                //jika nilai f node child lebih kecil dan node child belum ada di dalam queue
                else if((!queue.contains(child)) || (temp_f_nilai < child.f)){
                    child.parent = current;
                    child.g = temp_g_nilai;
                    child.f = temp_f_nilai;
                    
                    if(queue.contains(child)){
                        queue.remove(child); //hapus, tapi nilainya tidak di return
                    }
                    
                    queue.add(child);
                }
            }
        }
        System.out.println("TOTAL COST : " + akhir.f);
    }
        
    public static List<Node> printPath(Node target){
        //path bertipe list Node sesuai dengan yang bisa direturn oleh fungsi ini
        List<Node> path = new ArrayList<>();
        
        for(Node node=target; node != null; node = node.parent){
            path.add(node);
        }
        
        Collections.reverse(path); //reverse agar returnnya dimulai dari node awal - node akhir
        
        return path;
    }  
}
