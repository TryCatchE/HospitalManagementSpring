package com.example.hospital.controller;

import java.util.List;
import java.util.stream.Collectors;
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
import com.example.hospital.convert.PatientDTOConverter;
import com.example.hospital.dto.PatientDTO;
import com.example.hospital.exception.ApiRequestException;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.HttpStatusCodes;
import com.example.hospital.repository.MessageRepository;
import com.example.hospital.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

    private PatientService service;
    private PatientDTOConverter userConverter;

    public PatientController(PatientService service, PatientDTOConverter userConverter) {
        this.service = service;
        this.userConverter = userConverter;
    }

    @GetMapping("/patients")
    public List<PatientDTO> getAllPatients() {
        return service.getAll().stream().map(patient -> userConverter.convertPatientToPatientDTO(patient)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/patient")
    public ResponseEntity<String> createDoc(@RequestBody Patient patient) {
        service.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient created successfully");
    }

    @GetMapping("/patient/{id}")
    public Patient getSpecificPatient(@PathVariable Integer id) {
        // return service.getById(id);
        return service.getById(id).orElseThrow(
                () -> new ApiRequestException(MessageRepository.PATIENT_NOT_FOUND, HttpStatusCodes.NOT_FOUND));
    }

    @PutMapping("/patient/{id}")
    public void update(@RequestBody Patient patient, @PathVariable Integer id) {

        if (!service.existById(id)) {
            throw new ApiRequestException(MessageRepository.PATIENT_NOT_FOUND, HttpStatusCodes.NOT_FOUND);
        }
        service.updatePatient(patient, id);
    }

    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Integer id) {
        if (!service.existById(id)) {
            throw new ApiRequestException(MessageRepository.PATIENT_NOT_FOUND, HttpStatusCodes.NOT_FOUND);
        }
        service.delete(id);
    }

}
