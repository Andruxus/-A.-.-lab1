package tech.reliab.course.latishevai.bank.entity;

import java.time.LocalDate;

public class CreditAccount {
    Integer id;
    User user;
    Bank bank;
    LocalDate start;
    LocalDate end;
    int monthNumber;
    double sum;
    double monthPayment;
    double interestRate;
    Employee employee;
    PaymentAccount paymentAccount;

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
        return "CreditAccount{" +
                "id: " + id + '\n' +
                "пользователь: " + user.getId() + '\n' +
                "имя банка: " + bank.getName() + '\n' +
                "начало кредита: " + start + '\n' +
                "конец кредита: " + end + '\n' +
                "кол-во месяцев кредита: " + monthNumber + '\n' +
                "сумма кредита: " + sum + '\n' +
                "ежемесячный платеж: " + monthPayment + '\n' +
                "процентная ставка: " + interestRate + '\n' +
                "сотрудник: " + employee.getId() + '\n' +
                "платежный счет: " + paymentAccount.getId() + '\n' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bank.getName();
    }

    public void setBankName(Bank bank) {
        this.bank = bank;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(double monthPayment) {
        this.monthPayment = monthPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
}
