package tuan.exam.studentmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tuan.exam.studentmanagement.R;
import tuan.exam.studentmanagement.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder>{

    private final Context context;
    private final ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.students = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.each_student_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.MyViewHolder holder, int position) {
        holder.txtStudentId.setText(String.valueOf(students.get(position).getId()));
        holder.txtStudentName.setText(students.get(position).getName());
        holder.txtStudentDob.setText(students.get(position).getDob());
        holder.txtStudentTown.setText(students.get(position).getTown());
        holder.txtStudentYear.setText(students.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView txtStudentId, txtStudentName, txtStudentDob, txtStudentTown, txtStudentYear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStudentId = itemView.findViewById(R.id.txtStudentId);
            txtStudentName = itemView.findViewById(R.id.txtStudentName);
            txtStudentDob = itemView.findViewById(R.id.txtStudentDob);
            txtStudentTown = itemView.findViewById(R.id.txtStudentTown);
            txtStudentYear = itemView.findViewById(R.id.txtStudentYear);
        }
    }
}
