package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.*;
import tech.reliab.course.latishevai.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.time.Period;

public class CreditAccountServiceImpl implements CreditAccountService {
    private CreditAccount creditAccount = null;
    @Override
    public void create(Integer id, User user, Bank bank,
                       LocalDate start, LocalDate end,
                       double sum,Employee employee,
                       PaymentAccount paymentAccount) {
        this.creditAccount = new CreditAccount(id, user, bank, start, end,
                sum, employee, paymentAccount);
        Period p = Period.between(start,end);
        this.creditAccount.setMonthNumber(p.getMonths()+p.getYears()*12);
        this.creditAccount.setInterestRate(bank.getInterestRate());
        this.creditAccount.setMonthPayment(sum/creditAccount.getMonthNumber()*(1+creditAccount.getInterestRate()/100));
        UserServiceImpl userService = new UserServiceImpl();
        userService.update(user);
        userService.addCreditAccount(this.creditAccount);
    }

    @Override
    public void update(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    @Override
    public void delete() {
        this.creditAccount.setId(null);
        this.creditAccount.setUser(null);
        this.creditAccount.setBank(null);
        this.creditAccount.setStart(null);
        this.creditAccount.setEnd(null);
        this.creditAccount.setSum(0);
        this.creditAccount.setEmployee(null);
        this.creditAccount.setPaymentAccount(null);
        this.creditAccount=null;
    }

    @Override
    public CreditAccount getCreditAccount() {
        return this.creditAccount;
    }
}
