package com.rajatgoyal.hw5_fragmentstudentlist.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rajatgoyal.hw5_fragmentstudentlist.MainActivity;
import com.rajatgoyal.hw5_fragmentstudentlist.R;
import com.rajatgoyal.hw5_fragmentstudentlist.model.Student;

/**
 * Created by rajat goyal on 9/3/2016.
 */

public class DetailFragment extends Fragment {

    public static DetailFragment newInstance(int index) {

        Bundle args = new Bundle();
        args.putInt("index",index);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail,container,false);
        int index=0;

        try {
            index = getArguments().getInt("index");
        }catch(Exception e){}

        Student stu = MainActivity.students.get(index);
        //Student.getListItems(12).get(index);

        ((TextView) rootView.findViewById(R.id.tv_name_val)).setText(stu.getName());
        ((TextView) rootView.findViewById(R.id.tv_add_val)).setText(stu.getAddress());
        ((TextView) rootView.findViewById(R.id.tv_contact_val)).setText(stu.getContact());
        ((TextView) rootView.findViewById(R.id.tv_course_val)).setText(stu.getCourse());
        ((TextView) rootView.findViewById(R.id.tv_email_val)).setText(stu.getEmail());
        ((TextView) rootView.findViewById(R.id.tv_fat_val)).setText(stu.getFatherName());
        return rootView;
    }

//    public static void change(FragmentManager fragMan,int position) {
//        FragmentTransaction fragTxn = fragMan.beginTransaction();
//        fragTxn.add(R.id.detail,newInstance(position));
//    }
}
