# Database Schema Design – Smart Clinic Management System

## Tables

### 1. doctors
| Column | Type | Description |
|--------|------|-------------|
| doctor_id | INT (PK) | Unique ID for doctor |
| name | VARCHAR(100) | Doctor name |
| specialization | VARCHAR(100) | Field of expertise |
| email | VARCHAR(100) | Doctor email |
| password | VARCHAR(100) | Encrypted password |

### 2. patients
| Column | Type | Description |
|--------|------|-------------|
| patient_id | INT (PK) | Unique ID for patient |
| name | VARCHAR(100) | Patient name |
| dob | DATE | Date of birth |
| email | VARCHAR(100) | Patient email |
| password | VARCHAR(100) | Encrypted password |

### 3. appointments
| Column | Type | Description |
|--------|------|-------------|
| appointment_id | INT (PK) | Unique ID for appointment |
| patient_id | INT (FK) | Linked to patients.patient_id |
| doctor_id | INT (FK) | Linked to doctors.doctor_id |
| appointment_date | DATETIME | Scheduled time |
| status | VARCHAR(50) | Pending / Completed / Cancelled |

### 4. prescriptions
| Column | Type | Description |
|--------|------|-------------|
| prescription_id | INT (PK) | Unique ID |
| appointment_id | INT (FK) | Linked to appointments |
| details | TEXT | Medication details |
| created_at | DATETIME | Creation time |
