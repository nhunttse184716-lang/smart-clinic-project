package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByEmail(String email);

    @Query("SELECT p FROM Patient p WHERE p.email = ?1 OR p.phone = ?2")
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}
