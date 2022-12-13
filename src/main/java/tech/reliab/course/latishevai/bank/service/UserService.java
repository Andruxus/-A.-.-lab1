package tech.reliab.course.latishevai.bank.service;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.CreditAccount;
import tech.reliab.course.latishevai.bank.entity.PaymentAccount;
import tech.reliab.course.latishevai.bank.entity.User;

import java.time.LocalDate;

public interface UserService {
    void create(Integer id, String firstName, String lastName,
                String patronymic, LocalDate birthDay, String job, double salary, Bank bank);
    void update(User user);
    void delete();
    User getUser();
    void addPaymentAccount(PaymentAccount paymentAccount);
    void deletePaymentAccount(PaymentAccount paymentAccount);
    PaymentAccount getPaymentAccount(Integer id);
    void addCreditAccount(CreditAccount creditAccount);
    void deleteCreditAccount(CreditAccount creditAccount);
    CreditAccount getCreditAccount(Integer id);
}
