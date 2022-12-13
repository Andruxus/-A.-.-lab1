package tech.reliab.course.latishevai.bank.service;

import tech.reliab.course.latishevai.bank.entity.*;

public interface BankService {
    void create(Integer id, String name);
    void update(Bank bank);
    void delete();
    Bank getBank();
    void addBankAtm(BankAtm bankAtm);
    void deleteBankAtm(BankAtm bankAtm);
    BankAtm getBankAtm(Integer id);
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    Employee getEmployee(Integer id);
    void addUser(User user);
    void DeleteUser(User user);
    User getUser(Integer id);
    void addBankOffice(BankOffice bankOffice);
    void deleteBankOffice(BankOffice bankOffice);
    BankOffice getBankOffice(Integer id);


}
