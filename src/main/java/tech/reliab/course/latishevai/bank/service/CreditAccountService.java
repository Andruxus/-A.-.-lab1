package tech.reliab.course.latishevai.bank.service;

import tech.reliab.course.latishevai.bank.entity.*;

import java.time.LocalDate;

public interface CreditAccountService {
    void create(Integer id, User user, Bank bank, LocalDate start,
                LocalDate end, double sum, Employee employee, PaymentAccount paymentAccount);
    void update(CreditAccount creditAccount);
    void delete();
    CreditAccount getCreditAccount();
}
