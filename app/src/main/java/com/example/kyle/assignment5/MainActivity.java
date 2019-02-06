package com.example.kyle.assignment5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static double celsiusToFahrenheit(double c) {
        return c * 1.8 + 32.0;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32.0) / 1.8;
    }

    public static double kmToMi(double k) {
        return k * 0.62137;
    }

    public static double miToKm(double m) {
        return m / 0.62137;
    }

    public static double kgToLb(double k) {
        return k * 2.2046;
    }

    public static double lbToKg(double l) {
        return l / 2.2046;
    }

    public static double litersToGallons(double l) {
        return l * 0.26417;
    }

    public static double gallonsToLiters(double g) {
        return g / 0.26417;
    }

    public static double validateInput(String input) {
        double d = Double.MAX_VALUE;
        try {
            d = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return d;
    }
}
