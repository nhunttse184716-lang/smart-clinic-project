package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAvailableDoctors(String specialization) {
        if (specialization != null) {
            return doctorRepository.findBySpecialization(specialization);
        }
        return doctorRepository.findAll();
    }
}
