package ru.jolly.ray.domen;

public class Crowd {
    private static final int maxHumans = 100;

    private Human[] humans;
    private String name;

    public Crowd(String name){
        if (name == null){
            this.name = "";
        } else{
            this.name = name;
        }
        this.humans = new Human[0];
    }

    public String[] roar(){
        if (humans == null || humans.length == 0){
            return null;
        }
        String[] roars = new String[(int)Math.round(Math.random() * 12) + 1];
        
        for (int iter = 0; iter < roars.length; iter++){
            roars[iter] = humans[(int)Math.floor(Math.random() * humans.length)].getBatleRoar();
        }

        return roars;
    }

    public int add(Human ... newcomers){
        if (newcomers ==null || humans.length == maxHumans || newcomers.length == 0){
            return 0;
        }

        int quantity = 0;
        CHECKNEW:
        for (int iter = 0; iter < newcomers.length; iter++){
            if (newcomers[iter] == null){
                continue CHECKNEW;
            }
            for (Human human: humans){
                if (human == newcomers[iter]){
                    newcomers[iter] = null;
                    continue CHECKNEW;
                }
            }
            quantity++;
        }

        quantity = humans.length + quantity > maxHumans ? maxHumans - humans.length : quantity;

        Human[] newCrowd = new Human[quantity + humans.length];

        for (int iter = 0; iter < humans.length; iter++){
            newCrowd[iter] = humans[iter];
        }

        int counter = 0;
        int iter = 0;

        while(counter < quantity){
            if (newcomers[iter] != null){
                newCrowd[humans.length + counter] = newcomers[iter];
                counter++;
            }
            iter++;
        }

        humans = newCrowd;
        
        return quantity;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
