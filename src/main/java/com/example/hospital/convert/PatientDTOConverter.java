package com.example.hospital.convert;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.hospital.dto.PatientDTO;
import com.example.hospital.model.Patient;

@Component
public class PatientDTOConverter {

    private final ModelMapper modelMapper;

    public PatientDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    

    public PatientDTO convertPatientToPatientDTO(Patient patient){

        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
        return patientDTO;
    }


    public Patient convertPatientDTOToPatient(PatientDTO patientDTO){


        Patient  patient  = modelMapper.map(patientDTO, Patient.class);

        return patient;
    }

}
