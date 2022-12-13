package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentAccount {
    private Integer id;
    private User user;
    private Bank bank;
    private double sum = 0.0;

    public PaymentAccount(Integer id, User user, Bank bank, double sum) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id: " + id + '\n' +
                "пользователь: " + user.getId() + '\n' +
                "наименование банка: " + bank.getName() + '\n' +
                "сумма: " + sum + '\n' +
                '}';
    }
}
