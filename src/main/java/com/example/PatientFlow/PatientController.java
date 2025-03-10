package com.example.PatientFlow;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController //tells spring that this class is a component of type RestController and capable of handling HTTP requests
@RequestMapping("/patients") //companion to @RestController that indicates which address requests must have to access this controller
public class PatientController {
    private final PatientRepository patientRepository; //is a spring data JPA repository which is automatically managed as a spring bean. When patientController is created, Spring injects an instance into the constructor.

    @Autowired //marks this constructor for dependency injection
    private PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/{requestedId}") //marks a method as a handler method. GET requests that match URI will be handled by this
    private ResponseEntity<Patient> findById(@PathVariable Integer requestedId){
            Optional<Patient> patientOptional = patientRepository.findById(requestedId);

            if(patientOptional.isPresent()) {
                return ResponseEntity.ok(patientOptional.get());
            }else {
                return ResponseEntity.notFound().build();
            }

    }
}
