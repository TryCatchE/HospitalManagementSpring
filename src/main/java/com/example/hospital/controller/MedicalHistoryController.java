package com.example.hospital.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hospital.exception.ApiRequestException;
import com.example.hospital.model.MedicalHistory;
import com.example.hospital.repository.HttpStatusCodes;
import com.example.hospital.repository.MessageRepository;
import com.example.hospital.service.MedicalHistoryService;


@RestController()
@RequestMapping("/api")
@CrossOrigin
public class MedicalHistoryController {


    private final MedicalHistoryService service;

    public MedicalHistoryController(MedicalHistoryService service) {
        this.service = service;
    }

    @GetMapping("/medical/{id}/{value}")
    public List<MedicalHistory> getAllById(@PathVariable Long id, @PathVariable String role){
        return service.getAllMedicalHistory(id,role);

    }

    @PutMapping("/medical/{id}")
    public void  updateMedicalHistory(@RequestBody MedicalHistory medicalHistory, @PathVariable Integer id) {

        if(!service.existById(id)){
            throw new ApiRequestException(MessageRepository.MEDICAL_HISTORY_NOT_FOUND,HttpStatusCodes.NOT_FOUND);
        }
        service.updateMedical(id,medicalHistory);

    }    
}
