package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.BankAtm;
import tech.reliab.course.latishevai.bank.entity.BankOffice;
import tech.reliab.course.latishevai.bank.entity.Employee;
import tech.reliab.course.latishevai.bank.enums.StatusATM;
import tech.reliab.course.latishevai.bank.service.AtmService;

public class AtmServiceImpl implements AtmService {
    private BankAtm bankAtm = null;
    @Override
    public void create(Integer id, String name, Bank bank,
                       BankOffice bankOffice, Employee employee, StatusATM status,
                       boolean workDepositMoney, boolean workIssuanceMoney,
                       Double money, Double maintenanceCost) {
        this.bankAtm = new BankAtm(id,name,bank,bankOffice,employee,status,
                workDepositMoney,workIssuanceMoney,money,maintenanceCost);
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.update(bank);
        bankService.addBankAtm(this.bankAtm);
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.update(bankOffice);
        bankOfficeService.addBankAtm(this.bankAtm);
    }

    @Override
    public void update(BankAtm bankATM) {
        this.bankAtm = bankATM;
    }

    @Override
    public void delete() {
        this.bankAtm.setBank(null);
        this.bankAtm.setBankOffice(null);
        this.bankAtm.setEmployee(null);
        this.bankAtm.setId(null);
        this.bankAtm.setName(null);
        this.bankAtm.setMaintenanceCost(null);
        this.bankAtm.setMoney(null);
        this.bankAtm.setStatus(null);
        this.bankAtm.setWorkDepositMoney(false);
        this.bankAtm.setWorkIssuanceMoney(false);
        this.bankAtm = null;
    }

    @Override
    public BankAtm getBankATM() {
        return this.bankAtm;
    }
}
