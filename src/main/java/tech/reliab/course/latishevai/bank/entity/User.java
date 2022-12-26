package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
public class User extends Person {
    private String job;
    private double salary;
    private Bank bank;
    private ArrayList<PaymentAccount> paymentAccounts;
    private ArrayList<CreditAccount> creditAccounts;
    private double creditRating;

    public User(Integer id, String firstName, String lastName,
                String patronymic, LocalDate birthDay, String job, double salary, Bank bank) {
        super(id, firstName, lastName, patronymic, birthDay);
        this.job = job;
        this.salary = salary;
        this.bank = bank;
        this.creditAccounts = new ArrayList<>();
        this.paymentAccounts = new ArrayList<>();
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        DecimalFormat dF = new DecimalFormat("##.###");
        return "User{" +
                "id: " + super.getId() + '\n' +
                "ФИО: " + super.getFullName() + '\n' +
                "дата рождения: " + super.getBirthDay() + '\n' +
                "место работы: " + job + '\n' +
                "зарплата: " + dF.format(salary) + '\n' +
                "банк: " + bank.getId() + '\n' +
                "кредитный рейтинг: " + dF.format(creditRating) + '\n' +
                '}';
    }

    public void userInfo() {
        System.out.println("Платежные счета пользователя " + getId());
        for (PaymentAccount paymentAccount : getPaymentAccounts()) {
            System.out.println(paymentAccount);
        }
        System.out.println("Кредитные счета пользователя " + getId());
        for (CreditAccount creditAccount : getCreditAccounts()) {
            System.out.println(creditAccount);
        }
    }
}
