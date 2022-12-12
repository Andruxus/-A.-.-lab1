package tech.reliab.course.latishevai.bank.service.impl;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.PaymentAccount;
import tech.reliab.course.latishevai.bank.entity.User;
import tech.reliab.course.latishevai.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private PaymentAccount paymentAccount = null;

    @Override
    public void create(Integer id, User user, Bank bank, double sum) {
        this.paymentAccount = new PaymentAccount(id, user, bank, sum);
        user.setPaymentAccount(this.paymentAccount);
    }

    @Override
    public void update(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public void delete() {
        this.paymentAccount.setBank(null);
        this.paymentAccount.getUser().setPaymentAccount(null);
        this.paymentAccount.setUser(null);
        this.paymentAccount.setBank(null);
        this.paymentAccount.setSum(0);
        this.paymentAccount = null;
    }

    @Override
    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }
}
