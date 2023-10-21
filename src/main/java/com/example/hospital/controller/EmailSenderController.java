package com.example.hospital.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hospital.model.NewsLetter;
import com.example.hospital.repository.MessageRepository;
import com.example.hospital.service.EmailSenderService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmailSenderController {
    

    private EmailSenderService emailService;

    public EmailSenderController(EmailSenderService emailService){
        this.emailService =  emailService;
    }


    @PostMapping("/newsletter")
    public ResponseEntity<String> subscribeNewsLetter(@RequestBody NewsLetter email) throws MessagingException {

        if (!emailService.isValidEmail(email.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageRepository.INVALID_EMAIL);
        }

        emailService.newsLetter(email);
        return ResponseEntity.status(HttpStatus.OK).body(MessageRepository.INVALID_EMAIL);
    }
}
