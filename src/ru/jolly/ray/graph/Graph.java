package ru.jolly.ray.graph;

import java.util.LinkedList;

public class Graph {
    private Node []points;
    private static final String errorMessage = "Неудалось установить маршрут.";
    private static final int maxSize = 20;

    public static Graph init(boolean [][]matrix){
        final int len = matrix.length;
        if (len == 0){
            return null;
        }
        for (int iter = 0; iter < len; iter++){
            if (matrix[iter].length != len){
                return null;
            }
        }
        return new Graph(matrix, len);
    }

    public static Graph init(int size){
        if (size < 1 || size > maxSize){
            return null;
        }
        return new Graph(new boolean[size][size], size);
    }

    private Graph(boolean [][]matrix, int len){
        this.points = new Node[len];

        for (int iter = 0; iter < len; iter++){
            int quantity = 0;
            for (int jtor = 0; jtor < len; jtor++){
                if (matrix[iter][jtor]){
                    quantity++;
                }
            }
            points[iter] = new Node(iter, quantity);
        }

        for (int iter = 0; iter < len; iter++){
            for (int jtor = 0; jtor < len; jtor++){
                if (matrix[iter][jtor]){
                    points[iter].addRoad(points[jtor]);;
                }
            }
        }
    }

    public void addRoad(int from, int in){
        if (from > -1 && from < points.length && in > -1 && in < points.length)
            points[from].addRoad(points[in]);
    }

    public String showAllRoads(int from, int in){
        if (from <0 || from > points.length){
            return errorMessage;
        }
        LinkedList<LinkedList<Node>> roadsMap;
        LinkedList<Node> start = new LinkedList<Node>();
        start.add(points[from]);
        if (in < 0 || in >= points.length){
            roadsMap = search(start, null);
        } else {
            roadsMap = search(start, points[in]);
        }

        if (roadsMap.size() == 0 || roadsMap.size() == 1 && roadsMap.getFirst().size() == 1){
            return errorMessage;
        }
        
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Node> road : roadsMap) {
            for (Node node : road) {
                sb.append("-> ").append(node).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private LinkedList<LinkedList<Node>> search(LinkedList<Node> line, Node request){
        LinkedList<LinkedList<Node>> answer = new LinkedList<LinkedList<Node>>();
        if (request != null && request.equals(line.getLast())){
            answer.add(line);
            return answer;
        }
        Node []wayFromLastPoint = line.getLast().getRoads();
        int counter = 0;
        for (int iter = 0; iter < wayFromLastPoint.length; iter++){
            if (line.contains(wayFromLastPoint[iter])){
                counter++;
            } else {
                LinkedList<Node> newBranch = new LinkedList<Node>(line);
                newBranch.add(wayFromLastPoint[iter]);
                for (LinkedList<Node> road: search(newBranch, request)){
                    answer.add(road);
                }
            }
        }

        if (counter == wayFromLastPoint.length && request == null)
            answer.add(line);

        return answer;
    }
}
