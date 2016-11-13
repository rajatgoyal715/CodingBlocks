package com.rajatgoyal.hw3_registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by rajat goyal on 9/1/2016.
 */

public class FormActivity extends AppCompatActivity {
    String name,father,contact,addr,email,course;
    Button show,showList;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        show=(Button)findViewById(R.id.btn_show);
        layout=(RelativeLayout)findViewById(R.id.myLayout);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        father = i.getStringExtra("father");
        contact = i.getStringExtra("contact");
        addr = i.getStringExtra("addr");
        email = i.getStringExtra("email");
        course = i.getStringExtra("course");


        ((TextView)findViewById(R.id.tv_add_val)).setText(addr);
        ((TextView)findViewById(R.id.tv_fat_val)).setText(father);
        ((TextView)findViewById(R.id.tv_contact_val)).setText(contact);
        ((TextView)findViewById(R.id.tv_email_val)).setText(email);
        ((TextView)findViewById(R.id.tv_name_val)).setText(name);
        ((TextView)findViewById(R.id.tv_course_val)).setText(course);



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
            }
        });
    }
}