package com.example.PatientFlow;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //tells spring that this class is a component of type RestController and capable of handling HTTP requests
@RequestMapping("/patients") //companion to @RestController that indicates which address requests must have to access this controller
public class PatientController {

    @GetMapping("/{requestedId}") //marks a method as a handler method. GET requests that match URI will be handled by this
    private ResponseEntity<Patient> findById(){
        Patient patient = new Patient("Linda John", 76, 20);
        return ResponseEntity.ok(patient);
    }
}
