package com.mmj.www.gridlayoutcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button btnPlus,btnMinus,btnMulty,btnDiv;
    TextView textView;
    String num1,num2; Integer result; Double result1;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10};
    int i=0;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("그리드 레이아웃 계산기");
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulty = (Button) findViewById(R.id.btnMulty);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        textView = (TextView)findViewById(R.id.textView);

        for(i=0; i<numBtnIDs.length; i++)
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);

        for(i=0; i<numBtnIDs.length; i++){
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(editText1.isFocused()){
                        imm.hideSoftInputFromWindow(editText1.getWindowToken(),0);
                    num1 = editText1.getText().toString() + numButtons[index].getText().toString();
                    editText1.setText(num1);}
                    else if(editText2.isFocused()){
                        imm.hideSoftInputFromWindow(editText2.getWindowToken(),0);
                        num2 = editText2.getText().toString() + numButtons[index].getText().toString();
                        editText2.setText(num2);}
                    else Toast.makeText(getApplicationContext(), "먼저 입력텍스를 선택하세요", Toast.LENGTH_SHORT).show();
                }
           });
         btnPlus.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View view, MotionEvent motionEvent) {
                 num1 = editText1.getText().toString();
                 num2 = editText2.getText().toString();
                 result = Integer.parseInt(num1) + Integer.parseInt(num2);
                 textView.setText("계산결과: " + result.toString());
                 return false;
             }
         });
//            btnPlus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                 num1 = editText1.getText().toString();
//                 num2 = editText2.getText().toString();
//                 result = Integer.parseInt(num1) + Integer.parseInt(num2);
//                 textView.setText("계산결과: " + result.toString());
//
//                }
//            });
         btnMinus.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = editText1.getText().toString();
                    num2 = editText2.getText().toString();
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                    textView.setText("계산결과: " + result.toString());
                    return false;
                }
            });
            btnMulty.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = editText1.getText().toString();
                    num2 = editText2.getText().toString();
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    textView.setText("계산결과: " + result.toString());
                    return false;
                }
            });
            btnDiv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = editText1.getText().toString();
                    num2 = editText2.getText().toString();
                    result1 = Double.parseDouble(num1)/Double.parseDouble(num2);
                    textView.setText("계산결과: " + result.toString());
                    return false;
                }
            });
        }
    }
}


