package com.example.hospital.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository repository;

    public PatientService(PatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> getAll() {
        return repository.findAll();
    }

    public void save(Patient patient) {
        repository.save(patient);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Optional<Patient> getById(long id) {
        return repository.findById(id);
    }

    public Boolean existById(long id) {
        return repository.findById(id) != null;
    }

    public Patient updatePatient(Patient patient, long id) {
        Optional<Patient> existingPatient = repository.findById(id);

        if (!existingPatient.isPresent()) {
            return patient;
        }

        Patient updatedPatient = existingPatient.get();
        updatedPatient.setName(patient.getName());
        updatedPatient.setSurname(patient.getSurname());
        updatedPatient.setEmail(patient.getEmail());
        updatedPatient.setPassword(patient.getPassword());

        return repository.save(updatedPatient);

    }

}
