package tuan.exam.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

import tuan.exam.studentmanagement.adapter.StudentAdapter;
import tuan.exam.studentmanagement.model.Student;

public class StatActivity extends AppCompatActivity {

    RecyclerView rvStat;

    ArrayList<Student> students;
    StudentAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        rvStat = findViewById(R.id.rvStat);

        students = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        students.clear();
        getStudents();

        rvStat.setHasFixedSize(true);

        rvStat.setLayoutManager(new LinearLayoutManager(StatActivity.this));

        myAdapter = new StudentAdapter(StatActivity.this, students);
        rvStat.setAdapter(myAdapter);
    }

    private void getStudents() {
        DB db = new DB(this);
        Cursor cursor = db.readStat();

        while (cursor.moveToNext()) {
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