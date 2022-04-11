package ru.jolly.ray.domen;

public class Air {
    private Air(){}

    private static Arthur arthur;
    private static double coordinate = 92;

    protected static double rollDown(double speed){
        if (arthur == null){
            return coordinate;
        }
        if (coordinate < speed){
            coordinate = 0;
            arthur.getTarget().smash(arthur);
            arthur = null;
            return 0;
        } 

        coordinate -= speed;
        return coordinate;
    }

    public static Arthur getArthur(){
        return arthur;
    }
    public static void setArthur(Arthur a){
        arthur = a;
    }
    public static double getCoordinate(){
        return coordinate;
    }
    public static void setCoordinate(double c){
        coordinate = c;
    }
}
