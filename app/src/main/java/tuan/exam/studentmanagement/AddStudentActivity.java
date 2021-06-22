package tuan.exam.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import tuan.exam.studentmanagement.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    EditText edtStudentName,edtStudentDob, edtStudentTown, edtStudentYear;
    Button btnAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edtStudentName = findViewById(R.id.edtStudentName);
        edtStudentDob = findViewById(R.id.edtStudentDob);
        edtStudentTown = findViewById(R.id.edtStudentTown);
        edtStudentYear = findViewById(R.id.edtStudentYear);
        btnAddStudent = findViewById(R.id.btnAddStudent);

        btnAddStudent.setOnClickListener(v -> {
            String name = edtStudentName.getText().toString();
            String dob = edtStudentDob.getText().toString();
            String town = edtStudentTown.getText().toString();
            String year = edtStudentYear.getText().toString();

            Student newStudent = new Student(name, dob, town, year);
            DB db = new DB(this);
            db.addStudent(newStudent);
            setEmpty();
        });
    }

    private void setEmpty() {
        edtStudentName.setText("");
        edtStudentDob.setText("");
        edtStudentTown.setText("");
        edtStudentYear.setText("");
    }
}