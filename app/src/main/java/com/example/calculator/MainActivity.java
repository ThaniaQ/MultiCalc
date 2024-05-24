package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;

    TextView screen;
    Button button_0;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_squared;
    Button button_del;
    Button button_ac;
    Button button_minus;
    Button button_plus;
    Button button_divide;
    Button button_equal;
    Button button_multiply;

    Button button_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);

        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);

        button_squared = (Button) findViewById(R.id.button_squared);
        button_ac = (Button) findViewById(R.id.button_ac);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_divide = (Button) findViewById(R.id.button_divide);
        button_equal = (Button) findViewById(R.id.button_equal);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_dot = (Button) findViewById(R.id.button_dot);
        button_del = (Button) findViewById(R.id.button_del);

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(button_0);
        nums.add(button_1);
        nums.add(button_2);
        nums.add(button_3);
        nums.add(button_4);
        nums.add(button_5);
        nums.add(button_6);
        nums.add(button_7);
        nums.add(button_8);
        nums.add(button_9);


        for (Button b : nums) {
            b.setOnClickListener(View -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(button_divide);
        opers.add(button_multiply);
        opers.add(button_plus);
        opers.add(button_minus);
        for (Button b : opers) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        button_del.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        button_dot.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".");
            }
        });

        button_ac.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");
        });

        button_equal.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = firstNum / secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                default:
                    result = firstNum + secondNum;
            }
            screen.setText(String.valueOf(result));
            firstNum = result;
        });
    }
}