package main;

import quickunion.QuickUnionImpl;

public class MainQuickUnion {
    public static void main(String[] args) {
        int arraySize = 10;
        System.out.println("*****************Quick Union*************************");
        QuickUnionImpl quickUnion = new QuickUnionImpl(arraySize);
        quickUnion.union(0,1);
        quickUnion.union(5,0);
        quickUnion.union(6,5);
        quickUnion.union(2,1);
        quickUnion.union(7,1);
        quickUnion.union(3,8);
        quickUnion.union(9,8);
        quickUnion.union(4,3);
        quickUnion.union(5,9); //Eksempel fra illustrationen
        quickUnion.union(9,7); //Bruges til at tjekke - da 9 og 7 allerede er forbundet gennem træerne
        System.out.println("1 and 5 connected: " + quickUnion.connected(1,5));
        System.out.println("4 and 3 connected: " + quickUnion.connected(4,3));
        System.out.println("5 and 9 connected: " + quickUnion.connected(5,9));
        System.out.println("*****************Quick Union*************************");
    }
}
