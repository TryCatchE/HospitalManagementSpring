package com.example.hospital.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.hospital.exception.ApiRequestException;
import com.example.hospital.model.Doctor;
import com.example.hospital.repository.HttpStatusCodes;
import com.example.hospital.repository.MessageRepository;
import com.example.hospital.service.DoctorService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DoctorController {

    private DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return service.getAll();
    }

    @GetMapping("/doctor/{id}")
    public Doctor getSingleDoctor(@PathVariable Integer id) {
        return service.getById(id).orElseThrow(
                () -> new ApiRequestException(MessageRepository.DOCTOR_NOT_FOUND, HttpStatusCodes.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/doctor")
    public ResponseEntity<String> createDoc(@RequestBody Doctor doc) {
        service.save(doc);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doctor created successfully");
    }

    @DeleteMapping("/doctor/{id}")
    public void deleteDoc(@PathVariable Integer id) {
        if (!service.existById(id)) {
            throw new ApiRequestException(MessageRepository.DOCTOR_NOT_FOUND, HttpStatusCodes.NOT_FOUND);
        }
        service.delete(id);
    }

    @PutMapping("/doctor/{id}")
    public void update(@RequestBody Doctor doctor, @PathVariable Integer id) {

        if (!service.existById(id)) {
            throw new ApiRequestException(MessageRepository.DOCTOR_NOT_FOUND, HttpStatusCodes.NOT_FOUND);
        }
        service.updateDoc(doctor, id);
    }

}
