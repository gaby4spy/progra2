package TP2.punto10;

public class Conversor {


    public static double  aFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public  static  double aCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9.0;
    }
}
