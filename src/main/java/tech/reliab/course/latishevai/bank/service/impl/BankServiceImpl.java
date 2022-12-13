package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.*;
import tech.reliab.course.latishevai.bank.service.BankService;

import java.util.Random;

public class BankServiceImpl implements BankService {
    private Bank bank = null;

    @Override
    public void create(Integer id, String name) {
        this.bank = new Bank(id, name);
        Random random = new Random();
        this.bank.setRating(random.nextInt(0, 100));
        this.bank.setMoney(random.nextDouble(0, 10000000));
        this.bank.setInterestRate(20.0 - this.bank.getRating() / 5.0);
    }

    @Override
    public void update(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void delete() {
        this.bank.setId(null);
        this.bank.setMoney(null);
        this.bank.setRating(null);
        this.bank.setName(null);
        this.bank.setInterestRate(null);
        this.bank.setEmployees(null);
        this.bank.setBankAtms(null);
        this.bank.setBankOffices(null);
        this.bank.setUsers(null);
        this.bank = null;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public void addBankAtm(BankAtm bankAtm) {
        this.bank.getBankAtms().add(bankAtm);
        bankAtm.setBank(this.bank);
    }

    @Override
    public void deleteBankAtm(BankAtm bankAtm) {
        this.bank.getBankAtms().remove(bankAtm);
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.update(bankAtm);
        atmService.delete();
    }

    @Override
    public BankAtm getBankAtm(Integer id) {
        for (BankAtm bankAtm : this.bank.getBankAtms()) {
            if (id.equals(bankAtm.getId()))
                return bankAtm;
        }
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        this.bank.getEmployees().add(employee);
        employee.setBank(this.bank);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        this.bank.getEmployees().remove(employee);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.update(employee);
        employeeService.delete();
    }

    @Override
    public Employee getEmployee(Integer id) {
        for (Employee employee : this.bank.getEmployees()) {
            if (id.equals(employee.getId()))
                return employee;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        this.bank.getUsers().add(user);
        user.setBank(this.bank);
    }

    @Override
    public void DeleteUser(User user) {
        this.bank.getUsers().remove(user);
        UserServiceImpl userService = new UserServiceImpl();
        userService.update(user);
        userService.delete();
    }

    @Override
    public User getUser(Integer id) {
        for (User user : this.bank.getUsers()) {
            if (id.equals(user.getId()))
                return user;
        }
        return null;
    }

    @Override
    public void addBankOffice(BankOffice bankOffice) {
        this.bank.getBankOffices().add(bankOffice);
        bankOffice.setBank(this.bank);
    }

    @Override
    public void deleteBankOffice(BankOffice bankOffice) {
        this.bank.getBankOffices().remove(bankOffice);
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.update(bankOffice);
        bankOfficeService.delete();
    }

    @Override
    public BankOffice getBankOffice(Integer id) {
        for (BankOffice bankOffice : this.bank.getBankOffices()) {
            if (id.equals(bankOffice.getId()))
                return bankOffice;
        }
        return null;
    }
}