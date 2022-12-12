package tech.reliab.course.latishevai.bank.service;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.BankAtm;
import tech.reliab.course.latishevai.bank.entity.BankOffice;
import tech.reliab.course.latishevai.bank.entity.Employee;
import tech.reliab.course.latishevai.bank.enums.StatusATM;

public interface AtmService {
    void create(Integer id, String name, Bank bank, BankOffice bankOffice,
                Employee employee, StatusATM status, boolean workDepositMoney, boolean workIssuanceMoney,
                Double money, Double maintenanceCost);
    void update(BankAtm bankATM);
    void delete();
    BankAtm getBankATM();
}
