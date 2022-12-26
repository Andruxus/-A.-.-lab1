package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.*;
import tech.reliab.course.latishevai.bank.enums.StatusATM;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.*;
import tech.reliab.course.latishevai.bank.service.exceptions.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private User user = null;

    @Override
    public void create(Integer id, String firstName, String lastName,
                       String patronymic, LocalDate birthDay, String job, double salary,
                       Bank bank) {
        this.user = new User(id, firstName, lastName, patronymic, birthDay,
                job, salary, bank);
        Random random = new Random();
        user.setSalary(random.nextDouble(0, 10000));
        if (salary >= 9000) {
            user.setCreditRating(1000);
        } else {
            user.setCreditRating(random.nextDouble((int) Math.floor(salary / 10), (int) Math.ceil(salary / 10)));
        }
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.update(bank);
        bankService.addUser(this.user);
    }

    @Override
    public void update(User user) {
        this.user = user;
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
        this.user = null;
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

    @Override
    public void issueLoanBankService(BankService bank, BankOffice bankOffice, Employee employee,
                                     BankAtm bankATM, Double sumCredit, LocalDate startDate,
                                     Integer countMonths, PaymentAccountService paymentAccount,
                                     CreditAccountService creditAccount) throws CreditException, BadUserRatingException{
        if (this.user.getCreditRating() / 10 < bank.getBank().getRating()) {
            throw new BadUserRatingException(bank.getBank().getRating(),
                    this.user.getCreditRating() / 10);
        }
        if (bankOffice.getStatus() != StatusOffice.Work)
            throw new CreditException("Выбранный офис не работает");
        if (bankOffice.getMoney() < sumCredit)
            throw new CreditException("В выбранном офисе недостаточно денег");
        if (bankATM.getStatus() != StatusATM.WORKING)
            throw new CreditException("Банкомат, в выбранном офисе, не работает");
        if (bankATM.getMoney() < sumCredit)
            throw new CreditException("В выбранном банкомате недостаточно денег");
        if (!employee.getCanIssueCredit())
            throw new CreditException("Выбранный сотрудник не может выдавать кредиты");

        if (!bank.getBank().getUsers().contains(this.user)) {
            paymentAccount.create(100, this.user, bank.getBank(), sumCredit);
            this.addPaymentAccount(paymentAccount.getPaymentAccount());
            bank.addUser(this.user);
        } else {
            for (int i = 0; i < this.user.getPaymentAccounts().size(); i++) {
                if (Objects.equals(this.user.getPaymentAccounts().get(i).getBank().getId(), bank.getBank().getId())) {
                    paymentAccount.update(this.user.getPaymentAccounts().get(i));
                } else {
                    paymentAccount.update(null);
                }
            }
        }
        creditAccount.create(100, this.user, bank.getBank(), startDate, startDate.plusMonths(countMonths),
                sumCredit, employee, paymentAccount.getPaymentAccount());
        this.addCreditAccount(creditAccount.getCreditAccount());
    }
}

