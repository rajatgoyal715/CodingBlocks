package com.rajatgoyal.hw1_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView exp,result;
    String str="";
    int num=0,prev=0,res=0;
    boolean operator=false;
    String op="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exp = (TextView)findViewById(R.id.tv_exp);
        result = (TextView)findViewById(R.id.tv_result);
    }

    public void btn_clear(View v){
        str="";
        exp.setText(str);
        num=0;
        prev=0;
    }

    public void insert(String s){
        str+=s;
        exp.setText(str);
    }

    public void btn_equal(View v){
        switch(op){
            case "+":
                res=prev+num;
                break;
            case "-":
                res=prev-num;
                break;
            case "*":
                res=prev*num;
                break;
            case "/":
                res=prev/num;
                break;
            case "%":
                res=prev%num;
                break;
            default:
                res=num;
                break;
        }
        result.setText(res+"");
        btn_clear(v);
        num=0;
        prev=0;
        res=0;
    }
    public void click0(View v){
        if(num!=0){
            insert("0");
            num=num*10;
        }
        operator=false;
    }
    public void click1(View v){
        num=num*10+1;
        insert("1");
        operator=false;
    }
    public void click2(View v){
        num=num*10+2;
        insert("2");
        operator=false;
    }
    public void click3(View v){
        num=num*10+3;
        insert("3");
        operator=false;
    }
    public void click4(View v){
        num=num*10+4;
        insert("4");
        operator=false;
    }
    public void click5(View v){
        num=num*10+5;
        insert("5");
        operator=false;
    }
    public void click6(View v){
        num=num*10+6;
        insert("6");
        operator=false;
    }
    public void click7(View v){
        num=num*10+7;
        insert("7");
        operator=false;
    }
    public void click8(View v){
        num=num*10+8;
        insert("8");
        operator=false;
    }
    public void click9(View v){
        num=num*10+9;
        insert("9");
        operator=false;
    }
    public void click_mul(View v){
        if (num!=0&&!operator){
            insert("*");
            operator = true;
            op="*";
            prev=num;
            num=0;
        }
    }
    public void click_add(View v){
        if (num!=0&&!operator){
            insert("+");
            operator = true;
            op="+";
            prev=num;
            num=0;
        }
    }
    public void click_div(View v){
        if (num!=0&&!operator){
            insert("/");
            operator = true;
            op="/";
            prev=num;
            num=0;
        }
    }
    public void click_sub(View v) {
        if (num!=0&&!operator){
            insert("-");
            operator = true;
            op="-";
            prev=num;
            num=0;
        }
    }
    public void click_mod(View v){
        if(num!=0&&!operator){
            insert("%");
            operator=true;
            op="%";
            prev=num;
            num=0;
        }
    }
    public void click_dot(View v){

    }
    public void click_sign(View v){
        if(num!=0&&!operator){
        }
        else{
        }
    }
    public void backspace(View v){
        try {
            str = str.substring(0, str.length() - 1);
        }catch(Exception e){}
        exp.setText(str);
        if(operator){
            operator=false;
        }
        else{
            num/=10;
        }
    }
}
