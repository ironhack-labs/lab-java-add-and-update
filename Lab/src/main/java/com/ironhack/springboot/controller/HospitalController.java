package com.ironhack.springboot.controller;

import com.ironhack.springboot.enums.EmployeeStatus;
import com.ironhack.springboot.model.Employee;
import com.ironhack.springboot.model.Patient;
import com.ironhack.springboot.service.EmployeeService;
import com.ironhack.springboot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Hospital")
@RequiredArgsConstructor
public class HospitalController {

//    Get all patients with a doctor whose status is OFF: Create a route to get all patients with a doctor whose status is OFF.

    private final EmployeeService employeeService;
    private final PatientService patientService;
//
//    Add new patient: Create a route to add a new patient.
//    Add new doctor: Create a route to add a new doctor.
//    Change doctor status: Create a route to change a doctor's status.
//    Update doctor's department: Create a route to update a doctor's department.
//    Update patient information: Create a route to update patient information (the user should be able to update any patient information through this route).

    //Add new patient: Create a route to add a new patient.
    @PostMapping("/Patients/add/{patientId}/{name}/{dateOfBirth}/{admittingDoctorId}")
    public void addPatient(@PathVariable("patientId") Long patientId, @PathVariable("name") String name, @PathVariable("dateOfBirth") Date dateOfBirth, @PathVariable("admittingDoctorId") Employee admittingDoctorId) {
        patientService.addPatient(patientId, name, dateOfBirth, admittingDoctorId);
    }

    //Add new doctor: Create a route to add a new doctor.
    @PostMapping("/Employees/add/{employeeId}/{department}/{name}/{status}")
    public void addEmployee(@PathVariable("employeeId") Long employeeId, @PathVariable("department") String department, @PathVariable("name") String name, @PathVariable("status") EmployeeStatus status) {
        employeeService.addEmployee(employeeId, department, name, status);
    }

    //Change doctor status: Create a route to change a doctor's status.
    @PutMapping("/Employees/status/{employeeId}/{status}")
    public void changeEmployeeStatus(@PathVariable("employeeId") Long employeeId, @PathVariable("status") EmployeeStatus status) {
        employeeService.changeEmployeeStatus(employeeId, status);
    }

    //Update doctor's department: Create a route to update a doctor's department.
    @PutMapping("/Employees/department/{employeeId}/{department}")
    public void updateEmployeeDepartment(@PathVariable("employeeId") Long employeeId, @PathVariable("department") String department) {
        employeeService.updateEmployeeDepartment(employeeId, department);
    }

    //Update patient information: Create a route to update patient information (the user should be able to update any patient information through this route).
    @PutMapping("/Patients/update/{patientId}/{name}/{dateOfBirth}/{admittingDoctorId}")
    public void updatePatient(@PathVariable("patientId") Long patientId, @PathVariable("name") String name, @PathVariable("dateOfBirth") Date dateOfBirth, @PathVariable("admittingDoctorId") Employee admittingDoctorId) {
        patientService.updatePatient(patientId, name, dateOfBirth, admittingDoctorId);
    }




}
