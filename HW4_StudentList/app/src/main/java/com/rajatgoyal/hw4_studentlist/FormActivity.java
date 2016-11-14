package com.rajatgoyal.hw4_studentlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rajatgoyal.hw4_studentlist.model.Student;

import java.util.ArrayList;

/**
 * Created by rajat goyal on 9/2/2016.
 */

public class FormActivity extends AppCompatActivity {
    int id;
    String name,father,contact,addr,email,course;
    Button show,showList;
    RelativeLayout layout;
    static ArrayList<Student> students = Student.getStudents();
    RecyclerView studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        showList= (Button)findViewById(R.id.btn_show_list);
        studentList = (RecyclerView)findViewById(R.id.rv_student_list);

        Intent i = getIntent();
        id = i.getIntExtra("id", 0);
        name = i.getStringExtra("name");
        father = i.getStringExtra("father");
        contact = i.getStringExtra("contact");
        addr = i.getStringExtra("addr");
        email = i.getStringExtra("email");
        course = i.getStringExtra("course");

        Student stu = new Student(id,addr,name,father,email,course,contact);
        students.add(stu);

        showList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                StudentListAdapter slAdapter = new StudentListAdapter();
                LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
                studentList.setLayoutManager(lm);
                studentList.setAdapter(slAdapter);
            }
        });
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public StudentViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAddr = (TextView) itemView.findViewById(R.id.tv_addr);
            tvFatherName = (TextView) itemView.findViewById(R.id.tv_fat_name);
            tvCourse = (TextView) itemView.findViewById(R.id.tv_course);
            tvContact = (TextView) itemView.findViewById(R.id.tv_contact);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
        }
        View rootView;
        TextView tvName;
        TextView tvFatherName;
        TextView tvCourse;
        TextView tvContact;
        TextView tvAddr;
        TextView tvEmail;
    }

    public class StudentListAdapter extends RecyclerView.Adapter<StudentViewHolder>{

        @Override
        public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = getLayoutInflater();
            View convertView = null;

            switch (viewType) {
                case 0:
                    convertView = li.inflate(R.layout.list_student1, parent, false);
                    break;
                case 1:
                    convertView = li.inflate(R.layout.list_student2, parent, false);
                    break;
            }


            StudentViewHolder studentViewHolder = new StudentViewHolder(convertView);

            return studentViewHolder;
        }

        @Override
        public int getItemViewType(int position) {
            return (position%2);
        }

        @Override
        public void onBindViewHolder(StudentViewHolder studentViewHolder, final int position) {
            Student stu = students.get(position);
            studentViewHolder.tvName.setText(stu.getName());
            studentViewHolder.tvAddr.setText(stu.getAddress());

            studentViewHolder.tvFatherName.setText(String.valueOf(stu.getFatherName()));
            studentViewHolder.tvContact.setText(String.valueOf(stu.getContact()));
            studentViewHolder.tvEmail.setText(String.valueOf(stu.getEmail()));
            studentViewHolder.tvCourse.setText(String.valueOf(stu.getCourse()));
//            studentViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(ListActivity.this, "Clicked on " + position, Toast.LENGTH_SHORT).show();
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return students.size();
        }
    }
}
