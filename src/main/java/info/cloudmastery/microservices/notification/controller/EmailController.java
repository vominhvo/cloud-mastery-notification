package info.cloudmastery.microservices.notification.controller;

import info.cloudmastery.microservices.notification.dto.ResponseData;
import info.cloudmastery.microservices.notification.dto.response.EmailResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @PostMapping
    public ResponseData<EmailResponse> sendEmail() {
        return ResponseData.of(new EmailResponse());
    }

    @GetMapping
    public ResponseData<String> ping() {
        return ResponseData.of("OK!");
    }
}
