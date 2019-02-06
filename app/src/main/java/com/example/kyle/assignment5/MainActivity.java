// Kyle Ehlers
// COMP 3710 - 001
// 2-5-19
// Assignment 1
// TODO: Add decimal formatting
// TODO: Add log for each text change
// TODO: Add log for exceptions

package com.example.kyle.assignment5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText celsiusInput;
    EditText fahrenheitInput;
    EditText kmInput;
    EditText miInput;
    EditText kgInput;
    EditText lbInput;
    EditText literInput;
    EditText gallonInput;

    boolean tempCheck;
    boolean distanceCheck;
    boolean massCheck;
    boolean volumeCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempCheck = false;
        distanceCheck = false;
        massCheck = false;
        volumeCheck = false;

        celsiusInput = findViewById(R.id.celsius);
        celsiusInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (tempCheck) {
                    return;
                }

                tempCheck = true;

                try {
                    fahrenheitInput.setText("" + celsiusToFahrenheit(validateInput(celsiusInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    tempCheck = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        fahrenheitInput = findViewById(R.id.fahrenheit);
        fahrenheitInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (tempCheck) {
                    return;
                }

                tempCheck = true;

                try {
                    celsiusInput.setText("" + fahrenheitToCelsius(validateInput(fahrenheitInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    tempCheck = false;
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        kmInput = findViewById(R.id.km);
        kmInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (distanceCheck) {
                    return;
                }

                distanceCheck = true;

                try {
                    miInput.setText("" + kmToMi(validateInput(kmInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    distanceCheck = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        miInput = findViewById(R.id.mi);
        miInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (distanceCheck) {
                    return;
                }

                distanceCheck = true;

                try {
                    kmInput.setText("" + miToKm(validateInput(miInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    distanceCheck = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        kgInput = findViewById(R.id.kg);
        kgInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (massCheck) {
                    return;
                }

                massCheck = true;

                try {
                    lbInput.setText("" + kgToLb(validateInput(kgInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    massCheck = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        lbInput = findViewById(R.id.lb);
        lbInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (massCheck) {
                    return;
                }

                massCheck = true;

                try {
                    kgInput.setText("" + lbToKg(validateInput(lbInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    massCheck = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        literInput = findViewById(R.id.liters);
        literInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (volumeCheck) {
                    return;
                }

                volumeCheck = true;

                try {
                    gallonInput.setText("" + litersToGallons(validateInput(literInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    volumeCheck = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        gallonInput = findViewById(R.id.gallons);
        gallonInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (volumeCheck) {
                    return;
                }

                volumeCheck = true;

                try {
                    literInput.setText("" + gallonsToLiters(validateInput(gallonInput.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    volumeCheck = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

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
