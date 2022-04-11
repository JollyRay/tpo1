package ru.jolly.ray.graph;

import java.util.Arrays;

public class Node {
    
    private final int number;
    private Node[] roads;
    private int lastIndex;

    protected Node(int number, int size){
        this.number = number;
        this.roads = new Node[size];
        this.lastIndex = 0;
    }

    protected void addRoad(Node way){
        for (Node node: roads){
            if (node == way){
                return;
            }
        }
        if (lastIndex < roads.length){
            roads[lastIndex++] = way;
        } else {
            roads = Arrays.copyOf(roads, lastIndex + 1);
            roads[lastIndex++] = way;
        }
    }

    protected Node[] getRoads(){
        return this.roads;
    }

    protected int getNumber(){
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
