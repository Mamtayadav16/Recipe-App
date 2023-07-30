package com.example.apprecipe.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apprecipe.R;
import com.example.apprecipe.models.InstructionsResponse;

import java.util.List;

import retrofit2.Call;

public class InstructionsAdapter extends RecyclerView.Adapter<InstructionsViewHolder>{
    List<InstructionsResponse> list;
    Context context;

    public InstructionsAdapter(Context context,List<InstructionsResponse> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public InstructionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull InstructionsViewHolder holder, int position) {
        holder.textView_instructions_name.setText(list.get(position).name);
        holder.recycler_instructions_steps.setHasFixedSize(true);

        holder.recycler_instructions_steps.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        instructionStepAdapter instructionStepAdapter= new instructionStepAdapter(context,list.get(position).steps);
        holder.recycler_instructions_steps.setAdapter(instructionStepAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class InstructionsViewHolder  extends RecyclerView.ViewHolder{

    TextView textView_instructions_name;
    RecyclerView recycler_instructions_steps;
    public InstructionsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_instructions_name = itemView.findViewById(R.id.textView_instructions_name);
        recycler_instructions_steps=itemView.findViewById(R.id.recycler_instructions_steps);
    }
}