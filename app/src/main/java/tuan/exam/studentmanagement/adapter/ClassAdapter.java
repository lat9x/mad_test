package tuan.exam.studentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tuan.exam.studentmanagement.R;
import tuan.exam.studentmanagement.model.Class;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.MyClassViewHolder>{

    private final Context context;
    private final ArrayList<Class> classes;

    public ClassAdapter(Context context, ArrayList<Class> list) {
        this.context = context;
        this.classes = list;
    }

    @NonNull
    @Override
    public ClassAdapter.MyClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.each_class_layout, parent, false);
        return new ClassAdapter.MyClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassAdapter.MyClassViewHolder holder, int position) {
        holder.txtClassId.setText(String.valueOf(classes.get(position).getId()));
        holder.txtClassName.setText(classes.get(position).getName());
        holder.txtClassDesc.setText(classes.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    protected class MyClassViewHolder extends RecyclerView.ViewHolder{

        private final TextView txtClassId, txtClassName, txtClassDesc;

        public MyClassViewHolder(@NonNull View itemView) {
            super(itemView);

            txtClassId = itemView.findViewById(R.id.txtClassId);
            txtClassName = itemView.findViewById(R.id.txtClassName);
            txtClassDesc = itemView.findViewById(R.id.txtClassDesc);
        }
    }
}
