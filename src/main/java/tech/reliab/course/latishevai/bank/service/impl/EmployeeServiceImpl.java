package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.BankOffice;
import tech.reliab.course.latishevai.bank.entity.Employee;
import tech.reliab.course.latishevai.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee = null;
    @Override
    public void create(Integer id, String firstName, String lastName, String patronymic,
                       LocalDate birthDay, Bank bank, BankOffice bankOffice, String job, Boolean distantWork,
                       Boolean canIssueCredit, Double salary) {
        this.employee=new Employee(id, firstName, lastName, patronymic, birthDay,
                bank, bankOffice, job, distantWork, canIssueCredit, salary);
        bank.setCountEmployees(bank.getCountEmployees()+1);
    }

    @Override
    public void update(Employee employee) {
        this.employee=employee;
    }

    @Override
    public void delete() {
        employee.setId(null);
        employee.setFirstName(null);
        employee.setLastName(null);
        employee.setPatronymic(null);
        employee.setBirthDay(null);
        employee.getBank().setCountEmployees(employee.getBank().getCountEmployees()-1);
        employee.setBank(null);
        employee.setBankOffice(null);
        employee.setJob(null);
        employee.setDistantWork(null);
        employee.setCanIssueCredit(null);
        employee.setSalary(null);
        this.employee=null;
    }

    @Override
    public Employee getEmployee() {
        return employee;
    }
}
