package ru.jolly.ray.domen;

public class Human {
    private static final String baseCrowdName = "Я тут за Васькой пошёл, а кто главынй знать не знаю, царь-батюшка!";
    private static final String baseBatleRoar = "A-a-a-a-a-a-a-a";

    private Crowd crowd;
    private String balteRoar;

    public Human(String batleRoar){
        this.balteRoar = batleRoar;
    }

    public String roar(){
        if (balteRoar == null){
            return baseBatleRoar;
        }
        return balteRoar;
    }

    public boolean join(Crowd crowd){
        if (crowd == null){
            return false;
        } 
        int inc = crowd.add(this);
        if (inc == 0){
            return false;
        }
        this.crowd = crowd;
        return true;
    }
    

    public String getCrowdName(){
        if (crowd == null){
            return baseCrowdName;
        }
        return crowd.getName();
    }

    public String getBatleRoar(){
        if (balteRoar == null){
            return "A-a-a-a-a-a-a-a";
        }
        return balteRoar;
    }

    @Override
    public String toString() {
        return "Неизвестный";
    }
}
