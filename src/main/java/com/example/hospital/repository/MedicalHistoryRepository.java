package com.example.hospital.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hospital.model.MedicalHistory;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer>{
    List<MedicalHistory> findAllByDoctorId(Long id);
    List<MedicalHistory> findAllByPatientId(Long id);
}
