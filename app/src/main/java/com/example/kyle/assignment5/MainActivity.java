// Kyle Ehlers
// COMP 3710 - 001
// 2-6-19
// Assignment 1

package com.example.kyle.assignment5;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // EditText components:
    private EditText celsiusInput;
    private EditText fahrenheitInput;
    private EditText kmInput;
    private EditText miInput;
    private EditText kgInput;
    private EditText lbInput;
    private EditText literInput;
    private EditText gallonInput;

    // Toggle bools for keeping infinite loop from occuring:
    private boolean tempCheck;
    private boolean distanceCheck;
    private boolean massCheck;
    private boolean volumeCheck;

    // Decimal Format for cleaner conversion viewing:
    private DecimalFormat df;

    // Logfile constant:
    private static final String LOGFILE = "/sdcard/converterLog.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Request permission to write  to external storage:
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        // Finalize decimal format:
        df = new DecimalFormat("#.##");

        // Set toggle bools to false initially:
        tempCheck = false;
        distanceCheck = false;
        massCheck = false;
        volumeCheck = false;


        /*
          * Next several chunks of code each handle the EditText event listeners
          *
          * They update the corresponding EditText to give the converted value,
          * and they log each event to /sdcard/converterLog.txt
          *
          */

        celsiusInput = findViewById(R.id.celsius);
        celsiusInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (tempCheck) {
                    return;
                }

                tempCheck = true;

                try {
                    fahrenheitInput.setText("" + df.format(celsiusToFahrenheit(validateInput(celsiusInput.getText().toString()))));
                    log("Celsius text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(celsiusInput.getText().toString()));
                    log("");

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
                    celsiusInput.setText("" + df.format(fahrenheitToCelsius(validateInput(fahrenheitInput.getText().toString()))));
                    log("Fahrenheit text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(fahrenheitInput.getText().toString()));
                    log("");
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
                    miInput.setText("" + df.format(kmToMi(validateInput(kmInput.getText().toString()))));
                    log("Kilometers text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(kmInput.getText().toString()));
                    log("");
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
                    kmInput.setText("" + df.format(miToKm(validateInput(miInput.getText().toString()))));
                    log("Miles text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(miInput.getText().toString()));
                    log("");
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
                    lbInput.setText("" + df.format(kgToLb(validateInput(kgInput.getText().toString()))));
                    log("Kilograms text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(kgInput.getText().toString()));
                    log("");
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
                    kgInput.setText("" + df.format(lbToKg(validateInput(lbInput.getText().toString()))));
                    log("Pounds text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(lbInput.getText().toString()));
                    log("");
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
                    gallonInput.setText("" + df.format(litersToGallons(validateInput(literInput.getText().toString()))));
                    log("Liters text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(literInput.getText().toString()));
                    log("");
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
                    literInput.setText("" + df.format(gallonsToLiters(validateInput(gallonInput.getText().toString()))));
                    log("Gallons text changed.");
                    log("Timestamp: " + System.currentTimeMillis());
                    log("New value: " + validateInput(gallonInput.getText().toString()));
                    log("");
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

    // Utility methods for unit conversions:
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


    /* Data validation method. Makes sure the input is correct,
    even though it only allows for numberDecimal inputs. */
    public static double validateInput(String input) {
        double d = Double.MAX_VALUE ;
        try {
            d = Double.parseDouble(input);
        } catch (NumberFormatException e) {

            e.printStackTrace();
        }
        return d;
    }

    // Event logging method:
    public void log(String msg) {
        File f = new File(LOGFILE);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(LOGFILE, true));
            buff.append(msg);
            buff.newLine();
            buff.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
