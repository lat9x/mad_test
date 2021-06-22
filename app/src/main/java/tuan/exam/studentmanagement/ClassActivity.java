package tuan.exam.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import tuan.exam.studentmanagement.adapter.ClassAdapter;
import tuan.exam.studentmanagement.model.Class;

public class ClassActivity extends AppCompatActivity {

    RecyclerView rvAllClasses;
    FloatingActionButton btnToAddClass;

    ClassAdapter myAdapter;
    ArrayList<Class> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        rvAllClasses = findViewById(R.id.rvAllClasses);
        btnToAddClass = findViewById(R.id.btnToAddClass);

        classes = new ArrayList<>();

        btnToAddClass.setOnClickListener(v -> {
            startActivity(new Intent(this, AddClassActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        classes.clear();
        getAllClasses();

        rvAllClasses.setHasFixedSize(true);

        rvAllClasses.setLayoutManager(new LinearLayoutManager(ClassActivity.this));

        myAdapter = new ClassAdapter(this, classes);
        rvAllClasses.setAdapter(myAdapter);
    }

    private void getAllClasses() {
        DB db = new DB(this);
        Cursor cursor = db.readAllClasses();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String desc = cursor.getString(2);

            Class newClass = new Class(id, name, desc);
            classes.add(newClass);
        }
    }
}