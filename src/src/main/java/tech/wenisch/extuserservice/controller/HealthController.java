package tech.wenisch.extuserservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        // Return a custom HTTP status code
        return new ResponseEntity<>("Application is running!", HttpStatus.OK);
    }
}
