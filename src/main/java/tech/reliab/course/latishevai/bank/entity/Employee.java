package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.time.LocalDate;
@Getter
@Setter
public class Employee extends Person {
    private Bank bank;
    private BankOffice bankOffice;
    private String job;
    private Boolean distantWork;
    private Boolean canIssueCredit;
    private Double salary;

    public Employee(Integer id, String firstName, String lastName, String patronymic, LocalDate birthDay,
                    Bank bank, BankOffice bankOffice, String job, Boolean distantWork,
                    Boolean canIssueCredit, Double salary) {
        super(id, firstName, lastName, patronymic, birthDay);
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.job = job;
        this.distantWork = distantWork;
        this.canIssueCredit = canIssueCredit;
        this.salary = salary;
    }

    @Override
    public String toString() {
        DecimalFormat dF = new DecimalFormat("##.###");
        return "Employee{" +
                "банк: " + bank.getId() + '\n' +
                "банковский офис: " + bankOffice.getId() + '\n' +
                "должность: " + job + '\n' +
                "работает удаленно: " + distantWork + '\n' +
                "выдает кредиты: " + canIssueCredit + '\n' +
                "размер зарплаты: " + dF.format(salary) + '\n' +
                '}';
    }
}
