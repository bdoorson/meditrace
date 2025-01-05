package com.meditrace.application.service;

import com.meditrace.application.models.PatientModel;
import com.meditrace.application.query.FilterPatientsQuery;
import com.meditrace.application.vo.PatientListVO;
import com.meditrace.application.vo.PatientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private FilterPatientsQuery filterPatientsQuery;

    public List<PatientModel> getPatients() {
        return List.of(
                new PatientModel(59, "Eve", "Iron", "eve.iron@gmail.com"),
                new PatientModel(65, "Jane", "Doe", "jdoe@outlook.com"));
    }

    public PatientListVO filter(int pageNumber, int pageSize, PatientVO patientVO) {
        return filterPatientsQuery.execute(pageNumber, pageSize, patientVO);
    }
}