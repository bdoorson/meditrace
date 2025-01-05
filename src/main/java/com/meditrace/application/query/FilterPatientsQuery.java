package com.meditrace.application.query;

import com.meditrace.application.models.PatientModel;
import com.meditrace.application.vo.PatientListVO;
import com.meditrace.application.vo.PatientVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterPatientsQuery {

    private final List<PatientModel> x = List.of(
            new PatientModel(59, "Eve", "Iron", ""),
            new PatientModel(60, "John", "Doe", ""),
            new PatientModel(61, "Jane", "Doe", ""),
            new PatientModel(62, "John", "Doe", ""),
            new PatientModel(63, "Jane", "Doe", ""),
            new PatientModel(64, "John", "Doe", ""),
            new PatientModel(65, "Jane", "Doe", ""));

    public PatientListVO execute(int pageNumber, int pageSize, PatientVO patientVO) {
        int startPosition = (pageNumber - 1) * pageSize;

        List<PatientModel> list = x.stream().filter(e -> e.getFirstName().equals(patientVO.getFirstName())).toList();

        PatientListVO patientListVO = new PatientListVO();
        patientListVO.setPatients(list);
        return patientListVO;
    }
}