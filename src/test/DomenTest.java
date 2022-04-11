package test;

import org.junit.Assert;
import org.junit.Test;

import ru.jolly.ray.domen.*;

public class DomenTest {
    @Test
    public void crowdTest1(){
        Crowd crowd = new Crowd(null);
        Assert.assertEquals(crowd.getName(), "");
    }
    @Test
    public void crowdTest2(){
        Crowd crowd = new Crowd(null);
        Assert.assertEquals(crowd.add(null), 0);
    }
    @Test
    public void crowdTest3(){
        Crowd crowd = new Crowd(null);
        Human []humans = new Human[]{
            new Human("Крик"),
        };
        
        Assert.assertEquals(crowd.add(humans), 1);
    }
    @Test
    public void crowdTest4(){
        Crowd crowd = new Crowd(null);
        Human []humans = new Human[]{
            new Human("Крик"),
        };
        crowd.add(humans);
        Assert.assertEquals(crowd.add(humans), 0);
    }
    @Test
    public void crowdTest5(){
        Crowd crowd = new Crowd(null);
        Human []humans = new Human[]{
            new Human("Крик"),
            new Human("Крик"),
            new Human("Крик"),
            new Human("Крик"),
        };
        
        Assert.assertEquals(crowd.add(humans), 4);
    }
    @Test
    public void crowdTest6(){
        Crowd crowd = new Crowd(null);
        Human []humans = new Human[]{
            new Human("Крик"),
            new Human("Крик"),
            null,
            new Human("Крик"),
        };
        
        Assert.assertEquals(crowd.add(humans), 3);
    }
    @Test
    public void crowdTest7(){
        Crowd crowd = new Crowd("");
        Assert.assertNull(crowd.roar());
    }
    @Test
    public void crowdTest8(){
        Crowd crowd = new Crowd("");
        Human []humans = new Human[]{new Human("Крик")};
        crowd.add(humans);
        Assert.assertNotNull(crowd.roar());
    }

    @Test
    public void humanTest1(){
        Human h = new Human(null);
        Assert.assertEquals(h.getBatleRoar(), "A-a-a-a-a-a-a-a");
    }
    @Test
    public void humanTest2(){
        Human h = new Human("Rdsadasdsa");
        Assert.assertEquals(h.getBatleRoar(), "Rdsadasdsa");
    }
    @Test
    public void humanTest3(){
        Human h = new Human("Rdsadasdsa");
        Assert.assertFalse(h.join(null));
    }
    @Test
    public void humanTest4(){
        Human h = new Human("Rdsadasdsa");
        Crowd crowd = new Crowd("Name");
        Assert.assertTrue(h.join(crowd));
        Assert.assertEquals(h.getCrowdName(), "Name");
    }
    @Test
    public void humanTest5(){
        Human h = new Human("Rdsadasdsa");
        Crowd crowd = new Crowd("Name");
        h.join(crowd);
        Assert.assertFalse(h.join(crowd));
    }
    @Test
    public void humanTest6(){
        Human h = new Human("Rdsadasdsa");
        Assert.assertEquals(h.getCrowdName(), "Я тут за Васькой пошёл, а кто главынй знать не знаю, царь-батюшка!");
    }
    
    @Test
    public void arthurTest1(){
        Assert.assertNull(Arthur.createArthur(null));;
    }
    @Test
    public void arthurTest2(){
        House h2 = new House(4, new Plarform());
        Arthur a = Arthur.createArthur(new House(4, new Plarform()));
        Arthur.createArthur(h2);
        Assert.assertEquals(a.getTarget(), h2);
    }
    @Test
    public void arthurTest3(){
        Arthur a = Arthur.createArthur(new House(4, new Plarform()));
        Assert.assertEquals(a.speedUp(12), 13, 1e-20);
    }
    @Test
    public void arthurTest4(){
        Arthur a = Arthur.createArthur(new House(4, new Plarform()));
        Assert.assertEquals(a.speedUp(-12), 1, 1e-20);
    }
    @Test
    public void arthurTest5(){
        Arthur a = Arthur.createArthur(new House(4, new Plarform()));
        Assert.assertEquals(a.rollDown(), "Артур успешно сотрудничает с гравитацией и падает на координату 91.0");
    }
    @Test
    public void arthurTest6(){
        Arthur a = Arthur.createArthur(new House(4, new Plarform()));
        a.speedUp(666);
        Assert.assertTrue(a.rollDown().contains("Я величественный двухэтажный дом, так в меня входят разные вещи. Давайте послушает, что они нам скажут.\n" +
        "------------------------------\n" + 
        "Помост: Помост грустно стоит в одиночестве и завидует эшафтоу, у которого всегда аншлак."));
    }
    @Test
    public void arthurTest7(){
        Plarform p = new Plarform();
        p.setSpeaker(new Speaker("Да"));
        Arthur a = Arthur.createArthur(new House(4, p));
        a.speedUp(666);
        Assert.assertTrue(a.rollDown().contains("Я величественный двухэтажный дом, так в меня входят разные вещи. Давайте послушает, что они нам скажут.\n" +
        "------------------------------\n" + 
        "Помост: Помост занят спикером"));
    }
    @Test
    public void speakerTest1(){
        Speaker s = new Speaker(null);
        Assert.assertEquals(s.apple(), "A-a-a-a-a-a-a-a, Сэр.");
    }

}
