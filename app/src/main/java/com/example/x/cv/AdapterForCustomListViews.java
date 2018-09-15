package com.example.x.cv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterForCustomListViews extends ArrayAdapter<CustomObjectForArrays> {


    public AdapterForCustomListViews(@NonNull Context context, int resource, @NonNull List<CustomObjectForArrays> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.education_item_list, parent, false);
        }
        CustomObjectForArrays current = getItem(position);
        TextView fromDataTextView=listItemView.findViewById(R.id.fromDataTextView);
        fromDataTextView.setText(current.getFromDataTextView());
        TextView toDataTextView=listItemView.findViewById(R.id.toDataTextView);
        toDataTextView.setText(current.getToDataTextView());
        TextView specializationTextView=listItemView.findViewById(R.id.specializationTextView);
        specializationTextView.setText(current.getSpecializationTextView());
        TextView academicDegreeTextView=listItemView.findViewById(R.id.academicDegreeTextView);
        academicDegreeTextView.setText(current.getAcademicDegreeTextView());
        TextView gradeTextView=listItemView.findViewById(R.id.gradeTextView);
        gradeTextView.setText(current.getGradeTextView());
        TextView donorTextView=listItemView.findViewById(R.id.donorTextView);
        donorTextView.setText(current.getDonorTextView());
        ImageView logoForDegree = listItemView.findViewById(R.id.logoForDegree);
        logoForDegree.setImageResource(current.logoForDegree);

        return listItemView;
    }


}
