package com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // GET: /api/doctors/available?specialization=Cardiology
    @GetMapping("/available")
    public ResponseEntity<?> getAvailableDoctors(
            @RequestParam(required = false) String specialization,
            @RequestHeader("Authorization") String token) {

        // Token validation (mock)
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid or missing token");
        }

        List<Doctor> doctors = doctorService.findAvailableDoctors(specialization);
        return ResponseEntity.ok(doctors);
    }
}
