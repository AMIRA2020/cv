package com.example.x.cv;

import android.widget.ImageView;
import android.widget.TextView;

public class CustomObjectForArrays {

    private String fromDataTextView,toDataTextView,specializationTextView,academicDegreeTextView,gradeTextView,donorTextView;
    int logoForDegree;

    public CustomObjectForArrays(String fromDataTextView, String toDataTextView, String specializationTextView,
                                 String academicDegreeTextView, String gradeTextView, String donorTextView,
                                 int logoForDegree) {
        this.fromDataTextView = fromDataTextView;
        this.toDataTextView = toDataTextView;
        this.specializationTextView = specializationTextView;
        this.academicDegreeTextView = academicDegreeTextView;
        this.gradeTextView = gradeTextView;
        this.donorTextView = donorTextView;
        this.logoForDegree = logoForDegree;
    }
    public String getFromDataTextView() {
        return fromDataTextView;
    }

    public void setFromDataTextView(String fromDataTextView) {
        this.fromDataTextView = fromDataTextView;
    }

    public String getToDataTextView() {
        return toDataTextView;
    }

    public void setToDataTextView(String toDataTextView) {
        this.toDataTextView = toDataTextView;
    }

    public String getSpecializationTextView() {
        return specializationTextView;
    }

    public void setSpecializationTextView(String specializationTextView) {
        this.specializationTextView = specializationTextView;
    }

    public String getAcademicDegreeTextView() {
        return academicDegreeTextView;
    }

    public void setAcademicDegreeTextView(String academicDegreeTextView) {
        this.academicDegreeTextView = academicDegreeTextView;
    }

    public String getGradeTextView() {
        return gradeTextView;
    }

    public void setGradeTextView(String gradeTextView) {
        this.gradeTextView = gradeTextView;
    }

    public String getDonorTextView() {
        return donorTextView;
    }

    public void setDonorTextView(String donorTextView) {
        this.donorTextView = donorTextView;
    }

    public int getLogoForDegree() {
        return logoForDegree;
    }

    public void setLogoForDegree(int logoForDegree) {
        this.logoForDegree = logoForDegree;
    }


}
