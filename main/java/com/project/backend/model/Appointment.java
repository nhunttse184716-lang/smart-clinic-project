package com.project.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * ✅ Entity: Appointment
 * Đại diện cho lịch hẹn giữa bác sĩ và bệnh nhân trong hệ thống.
 */
@Entity
@Table(name = "appointments")
public class Appointment {

    // ✅ Khóa chính (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Mối quan hệ N-1 với Doctor
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    @NotNull(message = "Doctor must not be null")
    private Doctor doctor;

    // ✅ Mối quan hệ N-1 với Patient
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @NotNull(message = "Patient must not be null")
    private Patient patient;

    // ✅ Thời gian hẹn (phải là thời gian tương lai)
    @Column(name = "appointment_time", nullable = false)
    @NotNull(message = "Appointment time cannot be null")
    @Future(message = "Appointment time must be in the future")
    private LocalDateTime appointmentTime;

    // ✅ Ghi chú thêm cho lịch hẹn
    @Column(length = 500)
    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;

    // ✅ Constructor mặc định (bắt buộc cho JPA)
    public Appointment() {
    }

    // ✅ Constructor đầy đủ (tùy chọn)
    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentTime, String notes) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.notes = notes;
    }

    // ✅ Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // ✅ Phương thức toString - dùng cho logging/debug
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorId=" + (doctor != null ? doctor.getId() : null) +
                ", patientId=" + (patient != null ? patient.getId() : null) +
          ", appointmentTime=" + appointmentTime +
                ", notes='" + notes + '\'' +
                '}';
    }

    // ✅ equals() và hashCode() để hỗ trợ so sánh entity an toàn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
