package tuan.exam.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import tuan.exam.studentmanagement.adapter.StudentAdapter;
import tuan.exam.studentmanagement.model.Student;

public class StudentActivity extends AppCompatActivity {

    RecyclerView rvAllStudents;
    FloatingActionButton btnToAddStudent;

    private ArrayList<Student> students;
    private StudentAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        rvAllStudents = findViewById(R.id.rvAllStudents);
        btnToAddStudent = findViewById(R.id.btnToAddStudent);

        students = new ArrayList<>();

        btnToAddStudent.setOnClickListener(v -> {
            startActivity(new Intent(this, AddStudentActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        students.clear();
        getAllStudents();

        rvAllStudents.setHasFixedSize(true);

        rvAllStudents.setLayoutManager(new LinearLayoutManager(StudentActivity.this));

        myAdapter = new StudentAdapter(StudentActivity.this, students);
        rvAllStudents.setAdapter(myAdapter);
    }

    private void getAllStudents() {
        DB db = new DB(this);
        Cursor cursor = db.readAllStudents();

        if (cursor == null) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            return;
        }

        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String dob = cursor.getString(2);
            String town = cursor.getString(3);
            String year = cursor.getString(4);

            Student student = new Student(id, name, dob, town, year);
            students.add(student);
        }
    }
}