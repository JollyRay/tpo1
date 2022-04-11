package ru.jolly.ray.function;

public class Arctg {
    private Arctg(){}

    private static final double acc = 1E-7;

    public static double calcul(double x, double maxAccuracy) throws IllegalArgumentException{
        if (Double.isNaN(maxAccuracy)){
            throw new IllegalArgumentException("your accuracy is NaN");
        }
        if (Math.abs(maxAccuracy) < acc){
            throw new IllegalArgumentException("your accuracy too small. your = " + maxAccuracy);
        }
        if (Double.isNaN(x)){
            return Double.NaN;
        }
        
        return calculAfterCheck(x, maxAccuracy);
    }

    private static double calculAfterCheck(double x, double maxAccuracy) throws IllegalArgumentException{
        if (Math.abs(x) > 1) {
            return (x > 0 ? 1 : -1) * Math.PI/2 - calculAfterCheck(1/x, maxAccuracy);
        } else {
            int repeats = getLength(x, maxAccuracy);
            double result = 0.0d;
            for (int iter = 0; iter < repeats; iter++) {
                result += (iter % 2 != 0 ? -1 : 1) * Math.pow(x, 2 * iter + 1) / (2 * iter + 1);
            }
            return result;
        }
    }

    private static int getLength(double x, double maxAccuracy) {
        int min = 0;
        int max = Integer.MAX_VALUE;
        int n = 0;
        while (min < max) {
            n = min/2 + max/2;
            double probe = Math.pow(x, 2 * n + 1) / (2 * n + 1);
            if (Math.abs(probe) > Math.abs(maxAccuracy))
                min = n + 1;
            else
                max = n;
        }

        return n == 0 ? 1 : n;
    }
}
