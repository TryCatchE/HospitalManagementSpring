package com.example.hospital.schedule;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.hospital.model.Doctor;
import com.example.hospital.service.DoctorService;

@Component
@Profile("test")
public class ReportTask {

    private  DoctorService service;
    
    @Scheduled(fixedRate = 5000)
    public void task(){
        
        if (service != null) {
            List<Doctor> doctors = service.getAll();
            int numberOfDoctors = doctors.size();
            System.out.println("Number of users: " + numberOfDoctors);
        } else {
            System.out.println("DoctorService is not initialized.");
        }
    
    }
}