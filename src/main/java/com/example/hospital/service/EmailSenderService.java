package com.example.hospital.service;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.example.hospital.model.NewsLetter;
import com.example.hospital.repository.NewsLetterRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

// https://www.youtube.com/watch?v=KTBWCJPKiqk&ab_channel=KrisFoster

@Service
public class EmailSenderService {

    @Value("${myEmail}")
    private String myEmail;

    @Value("${subjectNewsLetter}")
    private String subjectNewsLetter;

    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;
    private NewsLetterRepository newsLetterRepo;

    public EmailSenderService(JavaMailSender mailSender, TemplateEngine templateEngine,NewsLetterRepository newsLetterRepo) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.newsLetterRepo = newsLetterRepo;
    }

    public boolean isValidEmail(String email) {

        if (!StringUtils.hasText(email)) {
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public void newsLetter(NewsLetter newsLetterBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());

        newsLetterRepo.save(newsLetterBody);

        String name = "testtt";

        Context context = new Context();
        context.setVariable("name", name);
        helper.setFrom(myEmail);
        helper.setTo(newsLetterBody.getEmail());
        helper.setSubject(subjectNewsLetter);

        String html = templateEngine.process("newsLetter", context);
        helper.setText(html, true);

        mailSender.send(message);

    }
}
