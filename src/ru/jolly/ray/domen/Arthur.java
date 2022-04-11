package ru.jolly.ray.domen;

public class Arthur extends Human{

    //Скорость измерятеся в Артурометрах/сек
    private double speed = 1;
    private House target;
    private static Arthur arthur;

    public static Arthur createArthur(House target){
        if (target == null){
            return null;
        }
        if (arthur != null){
            arthur.setTarget(target);
            return arthur;
        }

        arthur = new Arthur("Оглядываю всё вокруг, лечу в окно, кста. Ещё подомной какой-то оратор.", target);
        Air.setArthur(arthur);
        
        return arthur;
    }
    
    private Arthur(String batleRoar, House target){
        super(batleRoar);
        this.target = target;
    }

    public String rollDown(){
        if (arthur == null){
            return "Артур не может скользить по воздуху,если его не существует";
        }
        double coor =  Air.rollDown(speed);
        if (coor == 0) {
            return target.showStatus();
        }
        return "Артур успешно сотрудничает с гравитацией и падает на координату " + coor;
        
    }

    public double speedUp(double accelerator){
        speed += accelerator;
        if (speed < 1){
            speed = 1;
        }
        return speed;
    }

    public House getTarget(){
        return target;
    }

    public void setTarget(House target){
        this.target = target;
    }
    
    @Override
    public String toString() {
        return "Артур";
    }
}
