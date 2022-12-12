package tech.reliab.course.latishevai.bank.service.impl;


import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.BankOffice;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice = null;

    @Override
    public void create(Integer id, String name, String address,
                       StatusOffice status, Boolean maySetATM, Integer countATM,
                       Boolean mayApplyLoan, Boolean mayWithdrawMoney, Boolean mayDepositMoney,
                       Double money, Double rentCost, Bank bank) {
        this.bankOffice = new BankOffice(id, name, address, status,
                maySetATM, countATM, mayApplyLoan, mayWithdrawMoney, mayDepositMoney,
                money, rentCost, bank);
        bank.setCountOffice(bank.getCountOffice() + 1);
    }

    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    @Override
    public void delete() {
        this.bankOffice.getBank().setCountOffice(this.bankOffice.getBank().getCountOffice()-1);
        this.bankOffice.setBank(null);
        this.bankOffice.setCountATM(0);
        this.bankOffice.setAddress(null);
        this.bankOffice.setId(null);
        this.bankOffice.setName(null);
        this.bankOffice.setStatus(null);
        this.bankOffice.setMayApplyLoan(null);
        this.bankOffice.setMayDepositMoney(null);
        this.bankOffice.setMaySetATM(null);
        this.bankOffice.setMayWithdrawMoney(null);
        this.bankOffice.setMoney(null);
        this.bankOffice.setRentCost(null);
        this.bankOffice = null;
    }

    @Override
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }
}
