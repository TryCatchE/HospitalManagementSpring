package com.example.hospital.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;

@Service
public class DoctorService {

    private DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public void save(Doctor doc) {
        repository.save(doc);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Doctor> getAll() {
        return repository.findAll();
    }

    public Optional<Doctor> getById(Integer id) {
        return repository.findById(id);
    }

    public Boolean existById(Integer id) {
        return repository.findById(id) != null;
    }

    public Doctor updateDoc(Doctor doc, Integer id) {
        Optional<Doctor> existingDoctor = repository.findById(id);

        if (!existingDoctor.isPresent()) {
            return doc;
        }

        Doctor updatedDoctor = existingDoctor.get();
        updatedDoctor.setName(doc.getName());
        updatedDoctor.setSurname(doc.getSurname());
        updatedDoctor.setEmail(doc.getEmail());
        updatedDoctor.setPassword(doc.getPassword());
        updatedDoctor.setSpecialization(doc.getSpecialization());

        return repository.save(updatedDoctor);
    }

}
