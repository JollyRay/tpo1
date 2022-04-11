package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Timeout;

import ru.jolly.ray.graph.Graph;

public class GrachTest {
    static Graph graph;

    @BeforeClass
    public static void setting() {
        boolean[][] matrix = {
            {false, true, true, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false},
            {false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, true, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false},
            {false, false, true, false, false, true, false, false, false, true, true, false, false, false, false, false, false, false},
            {true, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false},
            {false, false, false, false, true, false, false, true, false, false, false, true, true, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, true},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        };
        graph = Graph.init(matrix);
    }

    @Test
    @Timeout(value = 2)
    public void bypassTest1(){
        Assert.assertTrue(graph.showAllRoads(15, 11).contains("-> 15 -> 11"));
    }
    @Test
    @Timeout(value = 2)
    public void bypassTest2(){
        String result = graph.showAllRoads(13, 11);
        Assert.assertTrue(result.contains("-> 13 -> 10 -> 9 -> 8 -> 12 -> 11"));
        Assert.assertTrue(result.contains("-> 13 -> 10 -> 9 -> 8 -> 11"));
        Assert.assertTrue(result.split("\n").length == 2);
    }
    @Test
    @Timeout(value = 2)
    public void bypassTest3(){
        String result = graph.showAllRoads(13, 3);
        Assert.assertTrue(result.contains("-> 13 -> 10 -> 9 -> 8 -> 4 -> 7 -> 0 -> 2 -> 3"));
        Assert.assertTrue(result.contains("-> 13 -> 10 -> 9 -> 8 -> 7 -> 0 -> 2 -> 3"));
        Assert.assertTrue(result.split("\n").length == 2);
    }
    @Test
    @Timeout(value = 2)
    public void bypassTest4(){
        Assert.assertTrue(graph.showAllRoads(16, 3).equals("Неудалось установить маршрут."));
    }
    @Test
    @Timeout(value = 2)
    public void uncorrectStartTest1(){
        Assert.assertTrue(graph.showAllRoads(-1, 3).equals("Неудалось установить маршрут."));
    }
    @Test
    @Timeout(value = 2)
    public void uncorrectStartTest2(){
        Assert.assertTrue(graph.showAllRoads(99999, 3).equals("Неудалось установить маршрут."));
    }
    @Test
    @Timeout(value = 2)
    public void uncorrectEndTest1(){
        String result = graph.showAllRoads(15, -1);
        Assert.assertTrue(result.contains("-> 15 -> 16"));
        Assert.assertTrue(result.contains("-> 15 -> 17"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 1 -> 5 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 1 -> 5 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 2 -> 1 -> 4 "));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 2 -> 3"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 2 -> 1 -> 5 -> 9 "));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 2 -> 6 -> 5 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 2 -> 6 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 2 -> 6 -> 10 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 14"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 4 -> 1 -> 5 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 14"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 0 -> 1 -> 5 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 0 -> 2 -> 1 -> 5 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 0 -> 2 -> 3"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 0 -> 2 -> 6 -> 5 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 0 -> 2 -> 6 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 0 -> 2 -> 6 -> 10 -> 9"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 0 -> 14"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 4 -> 7 -> 14"));
        Assert.assertTrue(result.contains("-> 15 -> 11 -> 12 -> 8 -> 7 -> 0 -> 1 -> 4"));
        Assert.assertTrue(result.split("\n").length == 22);
    }
    @Test
    @Timeout(value = 2)
    public void uncorrectEndTest2(){
        Assert.assertTrue(graph.showAllRoads(14, -1).equals("Неудалось установить маршрут."));
    }
}
