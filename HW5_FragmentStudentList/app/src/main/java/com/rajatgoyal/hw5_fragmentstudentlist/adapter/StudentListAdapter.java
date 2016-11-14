package com.rajatgoyal.hw5_fragmentstudentlist.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rajatgoyal.hw5_fragmentstudentlist.R;
import com.rajatgoyal.hw5_fragmentstudentlist.model.Student;

import java.util.ArrayList;

/**
 * Created by rajat goyal on 9/4/2016.
 */

public class StudentListAdapter extends BaseAdapter{
    ArrayList<Student> students;
    LayoutInflater li;

    public StudentListAdapter(Context context, ArrayList<Student> students){
        this.students = students;
        li = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView = li.inflate(R.layout.list_item,null,false);
        Student stu = getItem(i);
        ((TextView)convertView.findViewById(R.id.stu_name)).setText(stu.getName());

        return convertView;
    }
}
