package tech.reliab.course.latishevai.bank.entity;

import tech.reliab.course.latishevai.bank.enums.StatusATM;

import java.util.Formatter;

public class BankAtm{
    private Integer id;
    private String name;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private StatusATM status;
    private boolean workIssuanceMoney;
    private boolean workDepositMoney;
    private Double money;
    private Double maintenanceCost;

    public BankAtm(Integer id, String name, Bank bank, BankOffice bankOffice,
                   Employee employee, StatusATM status, boolean workDepositMoney, boolean workIssuanceMoney,
                   Double money, Double maintenanceCost){
        this.id = id;
        this.name = name;
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.employee = employee;
        this.status = status;
        this.workIssuanceMoney = workIssuanceMoney;
        this.workDepositMoney = workDepositMoney;
        this.money = money;
        this.maintenanceCost = maintenanceCost;
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id: " + id + '\n' +
                "имя банкомата: " + name + '\n' +
                "адрес: " + bankOffice.getAddress() + '\n' +
                "банковский офис: " + bankOffice.getId() +  '\n' +
                "сотрудник: " + employee.getId() + '\n' +
                "статус: " + status + '\n' +
                "работает на выдачу: " + workIssuanceMoney + '\n' +
                "можно внести деньги: " + workDepositMoney + '\n' +
                "денег: " + money + '\n' +
                "обслуживание: " + maintenanceCost + '\n' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StatusATM getStatus() {
        return status;
    }

    public void setStatus(StatusATM status) {
        this.status = status;
    }

    public boolean isWorkIssuanceMoney() {
        return workIssuanceMoney;
    }

    public void setWorkIssuanceMoney(boolean workIssuanceMoney) {
        this.workIssuanceMoney = workIssuanceMoney;
    }

    public boolean isWorkDepositMoney() {
        return workDepositMoney;
    }

    public void setWorkDepositMoney(boolean workDepositMoney) {
        this.workDepositMoney = workDepositMoney;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
}
