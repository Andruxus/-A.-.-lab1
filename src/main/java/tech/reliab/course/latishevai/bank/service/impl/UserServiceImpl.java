package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.CreditAccount;
import tech.reliab.course.latishevai.bank.entity.PaymentAccount;
import tech.reliab.course.latishevai.bank.entity.User;
import tech.reliab.course.latishevai.bank.service.UserService;

import java.time.LocalDate;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private User user = null;
    @Override
    public void create(Integer id, String firstName, String lastName,
                       String patronymic, LocalDate birthDay, String job, double salary,
                       Bank bank) {
        this.user=new User(id, firstName, lastName, patronymic, birthDay,
                job, salary, bank);
        Random random = new Random();
        user.setSalary(random.nextDouble(0, 10000));
        if (salary>=9000) {
            user.setCreditRating(1000);
        }
        else{
            user.setCreditRating(random.nextDouble((int)Math.floor(salary/10),(int)Math.ceil(salary/10)));
        }
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.update(bank);
        bankService.addUser(this.user);
    }

    @Override
    public void update(User user) {
        this.user=user;
    }

    @Override
    public void delete() {
        this.user.setId(null);
        this.user.setFirstName(null);
        this.user.setLastName(null);
        this.user.setPatronymic(null);
        this.user.setBirthDay(null);
        this.user.setPaymentAccounts(null);
        this.user.setCreditAccounts(null);
        this.user.setBank(null);
        this.user.setJob(null);
        this.user.setSalary(0);
        this.user=null;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void addPaymentAccount(PaymentAccount paymentAccount) {
        this.user.getPaymentAccounts().add(paymentAccount);
        paymentAccount.setUser(this.user);
    }

    @Override
    public void deletePaymentAccount(PaymentAccount paymentAccount) {
        this.user.getPaymentAccounts().remove(paymentAccount);
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.update(paymentAccount);
        paymentAccountService.delete();
    }

    @Override
    public PaymentAccount getPaymentAccount(Integer id) {
        for (PaymentAccount paymentAccount : this.user.getPaymentAccounts()) {
            if (id.equals(paymentAccount.getId()))
                return paymentAccount;
        }
        return null;
    }

    @Override
    public void addCreditAccount(CreditAccount creditAccount) {
        this.user.getCreditAccounts().add(creditAccount);
        creditAccount.setUser(this.user);
    }

    @Override
    public void deleteCreditAccount(CreditAccount creditAccount) {
        this.user.getPaymentAccounts().remove(creditAccount);
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        creditAccountService.update(creditAccount);
        creditAccountService.delete();
    }

    @Override
    public CreditAccount getCreditAccount(Integer id) {
        for (CreditAccount creditAccount : this.user.getCreditAccounts()) {
            if (id.equals(creditAccount.getId()))
                return creditAccount;
        }
        return null;
    }
}
