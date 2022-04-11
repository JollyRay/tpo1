package ru.jolly.ray;

import static ru.jolly.ray.function.Arctg.calcul;

import ru.jolly.ray.domen.*;
import ru.jolly.ray.graph.Graph;

public class Main {
    public static void main(String[] args) {
        // debugFirst();
        // debugSecond();
        imitation();
    }

    public static void debugFirst(){
        double value = 0.01;
        try {
            System.out.printf("Моя степень %f, значение: %f\n", value, calcul(value, 1e-6));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void debugSecond(){
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
        Graph graph = Graph.init(matrix);

        System.out.println(graph.showAllRoads(15, -1));
    }


    public static void imitation(){
        /* Появление толпы */
        Human []humans = new Human[]{
            new Human("Малые страдания выводят нас из самих себя, великие же возвращают нас самим себе. Треснувший колокол издает глухой звук: разбейте его на две части — он снова издает чистый звук."),
            new Human("За усердное исполнение своего долга человек вознаграждает себя удовлетворением, которое он испытывает, и не заботится о похвалах, почете и признательности, в которых ему отказывают."),
            new Human("Кто хвастает перед тем, кто его знает, заслуженно поднимает себя на смех."),
            new Human("Если тебе не спастись от смерти, умри, по крайней мере, со славой."),
            new Human("Научное мировоззрение, проникнутое естествознанием и математикой, есть величайшая сила не только настоящего, но и будущего."),
            new Human("Охотнее всего мы говорим о том, чего не знаем. Ибо об этом-то и думаем. Сюда направлена работа мысли, и направлена она может быть только одна."),
            new Human("Одна из примет посредственности ума есть желание постоянно рассказывать."),
        };
        Crowd crowd = new Crowd("Моя первая организованная группировка");
        crowd.add(humans);
        /* Крики */
        for (String roar: crowd.roar()){
            System.out.println(roar);
        }
        System.out.println("---------------------");
        /* Создание артура в этот мир */
        Plarform plarform = new Plarform();
        House goodPlaceToFall = new House(4, plarform);
        Arthur arthur = Arthur.createArthur(goodPlaceToFall);
        /* Артур помещается в воздух */
        Air.setArthur(arthur);
        System.out.println(arthur.roar());
        /* Артур скатывается по воздуху */
        for (int iter = 0; iter < 4; iter++){
            System.out.println(arthur.rollDown());
        }
        /* Артур ускорятеся */
        arthur.speedUp(12);
        System.out.println("---------------------");
        /* На помосте появляется оратор */
        plarform.setSpeaker(new Speaker("Я стою выше"));
        System.out.println(plarform.getSpeaker().apple());
        System.out.println("---------------------");
        /* Артур продолжает скатывается по воздуху */
        for (int iter = 0; iter < 4; iter++){
            System.out.println(arthur.rollDown());
        }
        /* Артур ускорятеся очень сильно*/
        arthur.speedUp(666);
        System.out.println(arthur.rollDown());
        
    }
}