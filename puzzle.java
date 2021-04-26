import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        int p = result(ar);

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(p);
    }

    public static int result(int[]ar){
        int max=ar[0];
        List <Integer> l = new LinkedList<>();
        for (int i = 0; i < ar.length-1; i++){
            if (ar[i]<ar[i+1]&&ar[i+1]>max){
               max=ar[i+1];
               int min =max; 
                for (int j=i+1;j<ar.length;j++){ 
                                   
                   if (ar[j]<min){
                       min = ar[j];
                   }
               } l.add(max-min);   
           } 
        }
        System.err.println(l);
        Collections.sort(l);
         if (l == null || l.size() == 0) {
             return 0;
         } else return -l.get(l.size() - 1);
    }
}
