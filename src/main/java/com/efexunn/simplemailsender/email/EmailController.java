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

    @PostMapping("/send-template-mail")
    public ResponseEntity<String> sendTemplateMail(@RequestBody MailRequest mailRequest) throws MessagingException {
        emailService.sendTemplateEmail(
                mailRequest.getEmailAddress(),
                SIMPLE_TEMPLATE,
                mailRequest.getMessage(),
                mailRequest.getSubject()
        );

        return ResponseEntity.ok("Template mail sent succesfully. If you are using 'dev' profile, you can check localhost:1080");
    }

    @PostMapping("/send-text-mail")
    public ResponseEntity<String> sendTextMail(@RequestBody MailRequest mailRequest) throws MessagingException {
        emailService.sendTextEmail(
                mailRequest.getEmailAddress(),
                mailRequest.getSubject(),
                mailRequest.getMessage()
        );

        return ResponseEntity.ok("Text mail sent succesfully. If you are using 'dev' profile, you can check localhost:1080");

    }

}
