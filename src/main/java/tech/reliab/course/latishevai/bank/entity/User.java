package tech.reliab.course.latishevai.bank.entity;

import java.time.LocalDate;

public class User extends Person{
    String job;
    double salary;
    Bank bank;
    CreditAccount creditAccount;
    PaymentAccount paymentAccount;
    double creditRating;

    public User(Integer id, String firstName, String lastName,
                String patronymic, LocalDate birthDay, String job, double salary, Bank bank) {
        super(id, firstName, lastName, patronymic, birthDay);
        this.job = job;
        this.salary = salary;
        this.bank = bank;
        this.creditAccount = null;
        this.paymentAccount = null;
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id: " + super.getId() + '\n' +
                "ФИО: " + super.getFullName() + '\n' +
                "дата рождения: " + super.getBirthDay() + '\n' +
                "место работы: " + job + '\n' +
                "зарплата: " + salary + '\n' +
                "банк: " + bank.getId() + '\n' +
                "кредитный счет: " + creditAccount.getId() + '\n' +
                "платежный счет: " + paymentAccount.getId() + '\n' +
                "кредитный рейтинг: " + creditRating + '\n' +
                '}';
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(double creditRating) {
        this.creditRating = creditRating;
    }
}
