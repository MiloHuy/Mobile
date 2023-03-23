package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.lang.Object;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import java.lang.Math;
public class MainActivity extends AppCompatActivity  {

    private TextView result;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnsum,btnMinus,btnclear,btnMultiple,btnDivide,btnEqual;
    private float sum,minus,multiple,divide;
    private float value1,value2;
    private String data;
    private boolean add,Minus,Multiple,Divide;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.calculator);

        add = false;
        Minus = false;
        Multiple = false;
        Divide = false;
        result = (TextView) findViewById(R.id.number_result);
        data = result.getText().toString() + data;
        if (data.equals("0")) {
            result.setText("");
        }
        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn0.getText().toString();
                result.setText(data);
            }
        });
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn1.getText().toString();
                result.setText(String.valueOf(data));
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn2.getText().toString();
                result.setText(String.valueOf(data));
            }
        });

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn3.getText().toString();
                result.setText(String.valueOf(data));
            }
        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn4.getText().toString();
                result.setText(String.valueOf(data));
            }
        });

        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn5.getText().toString();
                result.setText(String.valueOf(data));
            }
        });
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn6.getText().toString();
                result.setText(String.valueOf(data));
            }
        });
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn7.getText().toString();
                result.setText(String.valueOf(data));
            }
        });
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn8.getText().toString();
                result.setText(String.valueOf(data));
            }
        });
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.equals("0")) {
                    result.setText("");
                }
                data = result.getText().toString() + btn9.getText().toString();
                result.setText(String.valueOf(data));
            }
        });

        btnclear = (Button) findViewById(R.id.btnC);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
            }
        });
        btnsum = (Button) findViewById(R.id.btnAdd);
        btnsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Float.parseFloat(String.valueOf(data));
                result.setText("");
                add = true;
            }
        });
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Float.parseFloat(String.valueOf(data));
                result.setText("");
                Minus = true;
            }
        });
        btnMultiple = (Button)findViewById(R.id.btnMultiple);
        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Float.parseFloat(String.valueOf(data));
                result.setText("");
                Multiple = true;
            }
        });
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Float.parseFloat(String.valueOf(data));
                result.setText("");
                Divide = true;
            }
        });
        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(add == true) {
                    value2 = Float.parseFloat(String.valueOf(data));
                    sum = value1 + value2;
                    result.setText(String.valueOf(sum));
                    data = String.valueOf(sum);
                }
                if(Minus == true)
                {
                    value2 = Float.parseFloat(String.valueOf(data));
                    minus = value1 - value2;
                    result.setText(String.valueOf(minus));
                    data = String.valueOf(minus);
                }
                if(Multiple == true)
                {
                    value2 = Float.parseFloat(String.valueOf(data));
                    multiple = value1 * value2;
                    result.setText(String.valueOf(multiple));
                    data = String.valueOf(multiple);
                }
                if(Divide == true)
                {
                    value2 = Float.parseFloat(String.valueOf(data));
                    divide = value1 / value2;
                    result.setText(String.valueOf(divide));
                    data = String.valueOf(divide);
                }
            }
        });


    }
}