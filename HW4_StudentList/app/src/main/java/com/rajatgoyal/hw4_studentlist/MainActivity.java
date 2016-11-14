package com.rajatgoyal.hw4_studentlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    String name,addr,father,contact,email,course;
    RadioGroup radioGroup;
    Button register;
    static int count=0;

    public static final String TAG="rajat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button)findViewById(R.id.btn_register);

        radioGroup = (RadioGroup)findViewById(R.id.myRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                course = ((RadioButton)group.findViewById(checkedId)).getText().toString();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=((EditText)findViewById(R.id.et_name)).getText().toString();
                addr=((EditText)findViewById(R.id.et_addr)).getText().toString();
                father=((EditText)findViewById(R.id.et_father)).getText().toString();
                contact=((EditText)findViewById(R.id.et_contact)).getText().toString();
                email=((EditText)findViewById(R.id.et_email)).getText().toString();


                Intent i = new Intent(getApplicationContext(),FormActivity.class);
                i.putExtra("id",count);
                i.putExtra("name",name);
                i.putExtra("father",father);
                i.putExtra("addr",addr);
                i.putExtra("contact",contact);
                i.putExtra("email",email);
                i.putExtra("course",course);
                startActivity(i);

                count++;
            }
        });
    }

    //    RadioButton btn;
    public void changed(View v){
//        Log.d(TAG, "changed");
//        btn = (RadioButton)v;
//        btn.toggle();
//        if(btn.isEnabled()){
//            Log.d(TAG, "changed");
//            btn.setChecked(false);
//        }
//        else{
//            Log.d(TAG, "unchanged");
//            btn.setChecked(true);
//        }
//        if(btn.isChecked()){
//            Log.d(TAG, "unchecked");
//            btn.setChecked(false);
//        }
//        else{
//            Log.d(TAG, "checked");
//            btn.setChecked(true);
//            course = btn.getText().toString();
//        }
    }
}
