package com.example.hospital.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Appointment;
import com.example.hospital.repository.AppointmentRepository;

@Service
public class AppointmentService {


    private AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public void save(Appointment Appointment){
        repository.save(Appointment);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Optional<Appointment> getById(Integer id) {
        return repository.findById(id);
    }

    public Boolean existById(Integer id) {
        return repository.findById(id) != null;
    }

    public Appointment updateAppointment(Appointment appointment, Integer id) {
        Optional<Appointment> existingAppointment = repository.findById(id);

        if (!existingAppointment.isPresent()) {
            return appointment;
        }

        Appointment updatedAppointment = existingAppointment.get();
        // updatedAppointment.setDoctor(appointment.getDoctor());
        updatedAppointment.setDate(appointment.getDate());
        updatedAppointment.setTime(appointment.getTime());

        return repository.save(updatedAppointment);
    }

    
    public List<Appointment> getAllDoctorAppointmentsById(Long id){
        return repository.findAllByDoctorId(id);
    }

    public List<Appointment> getAllPatientAppointmentsById(Long id){
        return repository.findAllByPatientId(id);
    }
}
