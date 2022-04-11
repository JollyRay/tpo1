package ru.jolly.ray.domen;

public class Speaker extends Human{
    public Speaker(String batleRoar){
        super(batleRoar);
    }

    public String apple(){
        StringBuilder sb = new StringBuilder();
        sb.append(getBatleRoar()).append(", Сэр.");
        return sb.toString();
    }
}
