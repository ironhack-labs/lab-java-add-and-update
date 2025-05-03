package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")

    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "employee_id")
        private long employeeId;

        private String department;
        private String name;
        private String status;


        public Employee() {}

        public Employee(long employeeId, String department, String name, String status) {
            this.employeeId = employeeId;
            this.department = department;
            this.name = name;
            this.status = status;
        }

        public long getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(long employeeId) {
            this.employeeId = employeeId;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", department='" + department + '\'' +
                    ", name='" + name + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }


}
