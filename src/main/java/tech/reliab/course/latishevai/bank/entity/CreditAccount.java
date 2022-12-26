package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.time.LocalDate;
@Getter
@Setter
public class CreditAccount {
    private Integer id;
    private User user;
    private Bank bank;
    private LocalDate start;
    private LocalDate end;
    private int monthNumber;
    private double sum;
    private double monthPayment;
    private double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(Integer id, User user, Bank bank, LocalDate start,
                         LocalDate end, double sum,
                         Employee employee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        DecimalFormat dF = new DecimalFormat("##.###");
        return "CreditAccount{" +
                "id: " + id + '\n' +
                "пользователь: " + user.getId() + '\n' +
                "имя банка: " + bank.getName() + '\n' +
                "начало кредита: " + start + '\n' +
                "конец кредита: " + end + '\n' +
                "кол-во месяцев кредита: " + monthNumber + '\n' +
                "сумма кредита: " + dF.format(sum) + '\n' +
                "ежемесячный платеж: " + dF.format(monthPayment) + '\n' +
                "процентная ставка: " + dF.format(interestRate) + '\n' +
                "сотрудник: " + employee.getId() + '\n' +
                "платежный счет: " + paymentAccount.getId() + '\n' +
                '}';
    }
}
