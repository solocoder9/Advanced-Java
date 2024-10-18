package com.demo.DemoApp;

import java.util.Date;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) // Enable caching for this entity
public class Employee {

    @Id
    @Column(name = "empid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;
    
    @Column(name = "ename", length = 50)
    private String eName;
    
    @Column(name = "sal")
    private double salary;
    
    @Column(name = "deptno", length = 2)
    private int deptNo;
    
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    public Employee() {
        super();
    }

    public Employee(int empID, String eName, double salary, int deptNo, Date hireDate) {
        super();
        this.empID = empID;
        this.eName = eName;
        this.salary = salary;
        this.deptNo = deptNo;
        this.hireDate = hireDate;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "empid: " + empID +
               ", ename: " + eName +
               ", sal: " + salary +
               ", deptno: " + deptNo +
               ", hire_date: " + hireDate;
    }
}
