package Week4Lab2.Lab4._4.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    private Integer patientId;
    private String name;
    private Date dateOfBirth;

@ManyToOne
@JoinColumn(name = "admitted_by")
private Employee admittedBy;

    public Patient() {
    }

    public Patient(Integer patientId, String name, Date dateOfBirth, Employee admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", admittedBy=" + admittedBy +
                '}';
    }

}



