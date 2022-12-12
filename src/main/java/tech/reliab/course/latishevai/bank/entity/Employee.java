package tech.reliab.course.latishevai.bank.entity;

import java.time.LocalDate;

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
        return "Employee{" +
                "банк: " + bank.getId() + '\n' +
                "банковский офис: " + bankOffice.getId() + '\n' +
                "должность: " + job + '\n' +
                "работает удаленно: " + distantWork + '\n' +
                "выдает кредиты: " + canIssueCredit + '\n' +
                "размер зарплаты: " + salary + '\n' +
                '}';
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Boolean getDistantWork() {
        return distantWork;
    }

    public void setDistantWork(Boolean distantWork) {
        this.distantWork = distantWork;
    }

    public Boolean getCanIssueCredit() {
        return canIssueCredit;
    }

    public void setCanIssueCredit(Boolean canIssueCredit) {
        this.canIssueCredit = canIssueCredit;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
