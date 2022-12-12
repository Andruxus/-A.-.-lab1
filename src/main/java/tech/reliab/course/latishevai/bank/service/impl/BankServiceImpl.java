package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.Bank;
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
        this.bank.setCountEmployees(null);
        this.bank.setMoney(null);
        this.bank.setRating(null);
        this.bank.setCountClients(null);
        this.bank.setCountATM(null);
        this.bank.setName(null);
        this.bank.setInterestRate(null);
        this.bank = null;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }
}