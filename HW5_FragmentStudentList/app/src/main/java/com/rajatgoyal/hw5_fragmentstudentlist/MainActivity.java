package com.rajatgoyal.hw5_fragmentstudentlist;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rajatgoyal.hw5_fragmentstudentlist.fragments.DetailFragment;
import com.rajatgoyal.hw5_fragmentstudentlist.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final ArrayList<Student> students = Student.getListItems(120);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        students = Student.getListItems(120);

        clicked(getSupportFragmentManager(),0);
    }

    public static void clicked(FragmentManager fragMan,int position){
//        DetailFragment.change(fragMan,position);
//        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
        FragmentTransaction fragTxn = fragMan.beginTransaction();
        fragTxn.add(R.id.detail_container,DetailFragment.newInstance(position));
        fragTxn.commit();
    }
}
