package test;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.Assert;

import ru.jolly.ray.function.*;

public class FuncTest {
    @Test
    @Timeout(value = 2)
    public void startTest1(){
        Assert.assertEquals(0.009999, Arctg.calcul(0.01, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void midleTest1(){
        Assert.assertEquals(0.463647, Arctg.calcul(0.5, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void midleTest2(){
        Assert.assertEquals(0.540419, Arctg.calcul(0.6, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void endTest1(){
        Assert.assertEquals(0.780373, Arctg.calcul(0.99, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void endTest2(){
        Assert.assertEquals(0.832981, Arctg.calcul(1.1, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void farTest1(){
        Assert.assertEquals(0.982793, Arctg.calcul(1.5, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void farTest2(){
        Assert.assertEquals(1.471127, Arctg.calcul(10, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void farTest3(){
        Assert.assertEquals(Math.PI/2, Arctg.calcul(Double.POSITIVE_INFINITY, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void startNegTest1(){
        Assert.assertEquals(-0.009999, Arctg.calcul(-0.01, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void midleNegTest1(){
        Assert.assertEquals(-0.463647, Arctg.calcul(-0.5, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void farNegTest1(){
        Assert.assertEquals(-1.471127, Arctg.calcul(-10, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void NaNvalueTest1(){
        Assert.assertEquals(Double.NaN, Arctg.calcul(Double.NaN, 1E-5), 1E-5);
    }
    @Test
    @Timeout(value = 2)
    public void NaNvalueTest2(){
        IllegalArgumentException exception = Assert.assertThrows(IllegalArgumentException.class, () -> Arctg.calcul(1, Double.NaN));
        Assert.assertTrue(exception.getMessage().contains("your accuracy is NaN"));
    }
    @Test
    @Timeout(value = 2)
    public void smallValueTest1(){
        IllegalArgumentException exception = Assert.assertThrows(IllegalArgumentException.class, () -> Arctg.calcul(1, 1e-20));
        Assert.assertTrue(exception.getMessage().contains("your accuracy too small"));
    }

}
