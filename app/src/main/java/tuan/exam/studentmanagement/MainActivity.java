package tuan.exam.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnToStudentPage, btnClassPage, btnStudentClassPage, btnStudentStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToStudentPage = findViewById(R.id.btnToStudentPage);
        btnClassPage = findViewById(R.id.btnClassPage);
        btnStudentClassPage = findViewById(R.id.btnStudentClassPage);
        btnStudentStat = findViewById(R.id.btnStudentStat);


        btnToStudentPage.setOnClickListener(v -> startActivity(new Intent(this, StudentActivity.class)));
        btnClassPage.setOnClickListener(v -> startActivity(new Intent(this, ClassActivity.class)));
        btnStudentClassPage.setOnClickListener(v -> startActivity(new Intent(this, StudentClassActivity.class)));
        btnStudentStat.setOnClickListener(v -> startActivity(new Intent(this, StatActivity.class)));
    }
}