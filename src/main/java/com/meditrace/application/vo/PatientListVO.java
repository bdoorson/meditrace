package com.meditrace.application.vo;

import com.meditrace.application.models.PatientModel;

import java.util.List;

public class PatientListVO {

    private List<PatientModel> patients;
    private boolean isLastPage;

    public List<PatientModel> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientModel> patients) {
        this.patients = patients;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }
}