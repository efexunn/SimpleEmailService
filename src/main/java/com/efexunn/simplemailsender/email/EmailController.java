package com.efexunn.simplemailsender.email;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.efexunn.simplemailsender.email.EmailTemplateName.SIMPLE_TEMPLATE;

@RestController
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send-mail")
    public ResponseEntity<String> sendMail(@RequestBody MailRequest mailRequest) throws MessagingException {
        emailService.sendEmail(
                mailRequest.getEmailAddress(),
                SIMPLE_TEMPLATE,
                mailRequest.getMessage(),
                mailRequest.getSubject()
        );

        return ResponseEntity.ok("Sending mail started check maildev on localhost:1080");
    }

}
