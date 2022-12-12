package tech.reliab.course.latishevai.bank.service;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.BankOffice;
import tech.reliab.course.latishevai.bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    void create(Integer id, String firstName, String lastName, String patronymic, LocalDate birthDay,
                Bank bank, BankOffice bankOffice, String job, Boolean distantWork,
                Boolean canIssueCredit, Double salary);
    void update(Employee employee);
    void delete();
    Employee getEmployee();
}
