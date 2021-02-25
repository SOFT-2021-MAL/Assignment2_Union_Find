package main;

import weightedunion.WeightedQuickUnionImpl;

public class MainWeightedQuickUnion {
    public static void main(String[] args) {
        int arraySize = 10;
        System.out.println("*****************Weighted Quick Union****************");
        WeightedQuickUnionImpl weightedQuickUnion = new WeightedQuickUnionImpl(arraySize);
        weightedQuickUnion.union(0,1);
        weightedQuickUnion.union(5,0);
        weightedQuickUnion.union(6,5);
        weightedQuickUnion.union(2,1);
        weightedQuickUnion.union(7,1);
        weightedQuickUnion.union(3,8);
        weightedQuickUnion.union(9,8);
        weightedQuickUnion.union(4,3);
        weightedQuickUnion.union(5,9); //Eksempel fra illustrationen
        weightedQuickUnion.union(9,7); //Bruges til at tjekke - da 9 og 7 allerede er forbundet gennem træerne
        System.out.println("1 and 5 connected: " + weightedQuickUnion.connected(1,5));
        System.out.println("4 and 3 connected: " + weightedQuickUnion.connected(4,3));
        System.out.println("5 and 9 connected: " + weightedQuickUnion.connected(5,9));
        System.out.println("*****************Weighted Quick Union****************");
    }
}
