package com.rajatgoyal.hw5_fragmentstudentlist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rajatgoyal.hw5_fragmentstudentlist.MainActivity;
import com.rajatgoyal.hw5_fragmentstudentlist.R;
import com.rajatgoyal.hw5_fragmentstudentlist.adapter.StudentListAdapter;
import com.rajatgoyal.hw5_fragmentstudentlist.model.Student;

import java.util.ArrayList;

/**
 * Created by rajat goyal on 9/3/2016.
 */

public class ListFragment extends Fragment {
    ArrayList<Student> students;
    ListView list;
    StudentListAdapter adapter;
    FragmentManager fragMan;

//    public static ListFragment newInstance() {
//
//        Bundle args = new Bundle();
//
//        ListFragment fragment = new ListFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

//        ArrayList a = new ArrayList();
//        ArrayList b = a;

        fragMan = getFragmentManager();
//        students = Student.getListItems(120);
        students = MainActivity.students;

        list = (ListView)rootView.findViewById(R.id.student_list);
//        ArrayAdapter<Student> adapter = new ArrayAdapter<>(
//                getContext(),android.R.layout.simple_list_item_1,android.R.id.text1,students
//        );
//        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(
//                this,android.R.layout.simple_list_item_1,android.R.id.text1,students
//        );
        adapter = new StudentListAdapter(getActivity(),students);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.clicked(fragMan,position);
//                FragmentTransaction fragTxn = fragMan.beginTransaction();
//                fragTxn.add(R.layout.fragment_detail,DetailFragment.newInstance(position));
                Toast.makeText(getContext(),"Clicked "+new StudentListAdapter(getActivity(),students).getItem(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
//+new StudentListAdapter(students).getItem(position).getName()