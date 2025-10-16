package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    // ✅ Khóa chính (primary key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Các trường thông tin + validation
    @NotBlank(message = "Doctor name cannot be blank")
    private String name;

    @NotBlank(message = "Specialization cannot be blank")
    private String specialization;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private boolean available;

    // ✅ Quan hệ OneToMany với Appointment
    // Một bác sĩ có thể có nhiều cuộc hẹn
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    // ✅ Constructor mặc định (bắt buộc cho JPA)
    public Doctor() {}

    // ✅ Constructor đầy đủ (tùy chọn)
    public Doctor(String name, String specialization, String email, String password, boolean available) {
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.password = password;
        this.available = available;
    }

    // ✅ Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    // ✅ toString() để dễ debug & log
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                ", available=" + available +
                '}';
    }
}
