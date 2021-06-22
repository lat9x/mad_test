package tuan.exam.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import tuan.exam.studentmanagement.model.Class;

public class AddClassActivity extends AppCompatActivity {

    EditText edtClassName, edtClassDesc;
    Button btnAddClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        edtClassName = findViewById(R.id.edtClassName);
        edtClassDesc = findViewById(R.id.edtClassDesc);
        btnAddClass = findViewById(R.id.btnAddClass);

        btnAddClass.setOnClickListener(v -> {
            String name = edtClassName.getText().toString();
            String desc = edtClassDesc.getText().toString();

            Class newClass = new Class(name, desc);

            DB db = new DB(this);
            db.addClass(newClass);

            edtClassName.setText("");
            edtClassDesc.setText("");
        });
    }
}