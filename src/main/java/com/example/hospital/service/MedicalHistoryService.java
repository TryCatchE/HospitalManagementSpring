package com.example.hospital.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hospital.model.MedicalHistory;
import com.example.hospital.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {
    

    private  final MedicalHistoryRepository repository;

    public MedicalHistoryService(MedicalHistoryRepository repository){
        this.repository = repository;
    }

    public Boolean existById(Integer id) {
        return repository.findById(id) != null;
    }

    public List<MedicalHistory> getAllMedicalHistory(Long id, String role){

        // refactor this
        if(role != "doc"){
            repository.findAllByPatientId(id);
        }

        return repository.findAllByDoctorId(id);
    } 

    public MedicalHistory updateMedical(Integer id, MedicalHistory medicalHistory){

        Optional<MedicalHistory> medicalHistoryExists =  repository.findById(id);

        if(!medicalHistoryExists.isPresent()){
           return  medicalHistory;
        }

        MedicalHistory updatedMedicalHistory = medicalHistoryExists.get();
        updatedMedicalHistory.setMedicalHistory(medicalHistory.getMedicalHistory());

        return repository.save(updatedMedicalHistory);
        
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }


}
