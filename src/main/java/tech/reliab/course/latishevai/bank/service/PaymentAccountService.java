package tech.reliab.course.latishevai.bank.service;

import tech.reliab.course.latishevai.bank.entity.*;

import java.time.LocalDate;

public interface PaymentAccountService {
    void create(Integer id, User user, Bank bank, double sum);
    void update(PaymentAccount paymentAccount);
    void delete();
    PaymentAccount getPaymentAccount();
}
