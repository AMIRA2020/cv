package com.example.x.cv.previous_work;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.x.cv.R;

import java.util.List;

public class PreviousWorkAdapter extends RecyclerView.Adapter<PreviousWorkAdapter.ViewHolder>{

    private List<PreviousWork> previousWorkList;

    public void setPreviousWorkList(List<PreviousWork> previousWorkList) {
        this.previousWorkList = previousWorkList;
    }

    @NonNull
    @Override
    public PreviousWorkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.previous_work_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousWorkAdapter.ViewHolder holder, int position) {

        holder.numberTextView.append(String.valueOf(position));
        holder.companyTextView.append(previousWorkList.get(position).getCompany());
        holder.roleTextView.append(previousWorkList.get(position).getRole());
        holder.fromTextView.append(previousWorkList.get(position).getFrom());
        holder.toTextView.append(previousWorkList.get(position).getTo());
    }

    @Override
    public int getItemCount() {
        return previousWorkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView numberTextView;
        private TextView companyTextView;
        private TextView roleTextView;
        private TextView fromTextView;
        private TextView toTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            numberTextView = itemView.findViewById(R.id.previous_work_number_textView);
            companyTextView = itemView.findViewById(R.id.previous_work_company_textView);
            roleTextView = itemView.findViewById(R.id.previous_work_role_textView);
            fromTextView = itemView.findViewById(R.id.previous_work_from_textView);
            toTextView = itemView.findViewById(R.id.previous_work_to_textView);
        }
    }
}
