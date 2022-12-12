package tech.reliab.course.latishevai.bank.service;

import tech.reliab.course.latishevai.bank.entity.Bank;

public interface BankService {
    void create(Integer id, String name);

    void update(Bank bank);

    void delete();
    Bank getBank();

}
