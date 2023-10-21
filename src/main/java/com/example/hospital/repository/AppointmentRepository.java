package com.example.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
    List<Appointment> findAllByDoctorId(Long id);
    List<Appointment> findAllByPatientId(Long id);
}
