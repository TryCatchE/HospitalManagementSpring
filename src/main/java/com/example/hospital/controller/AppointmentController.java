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
import org.springframework.web.bind.annotation.RestController;
import com.example.hospital.exception.ApiRequestException;
import com.example.hospital.model.Appointment;
import com.example.hospital.repository.HttpStatusCodes;
import com.example.hospital.repository.MessageRepository;
import com.example.hospital.service.AppointmentService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AppointmentController {

    private AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/doc-appointments/{id}")
    public List<Appointment> getAllAppointmentsByDoctorId(@PathVariable Long id){
        return service.getAllDoctorAppointmentsById(id);
    }

    @GetMapping("/patient-appointments/{id}")
    public List<Appointment> getAllAppointmentsByPatientId(@PathVariable Long id){
        return service.getAllPatientAppointmentsById(id);
    }

    @PostMapping("/appointment")
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment){
        service.save(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(MessageRepository.APPOINTMENT_SUCCESS);
    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@PathVariable Integer id){
        
        if(!service.existById(id)){
            throw new ApiRequestException(MessageRepository.APPOINTMENT_NOT_FOUND,HttpStatusCodes.NOT_FOUND);
        }
        service.delete(id);
    }

    @PutMapping("/appointment/{id}")
    public void  update(@RequestBody Appointment appointment, @PathVariable Integer id){

        if(!service.existById(id)){
            throw new ApiRequestException(MessageRepository.APPOINTMENT_NOT_FOUND,HttpStatusCodes.NOT_FOUND);
        }
        service.updateAppointment(appointment, id);
    }
    
}
