package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.latishevai.bank.enums.StatusATM;

import java.text.DecimalFormat;

@Getter
@Setter
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
        DecimalFormat dF = new DecimalFormat("##.###");
        return "BankAtm{" +
                "id: " + id + '\n' +
                "имя банкомата: " + name + '\n' +
                "адрес: " + bankOffice.getAddress() + '\n' +
                "банковский офис: " + bankOffice.getId() +  '\n' +
                "сотрудник: " + employee.getId() + '\n' +
                "статус: " + status + '\n' +
                "работает на выдачу: " + workIssuanceMoney + '\n' +
                "можно внести деньги: " + workDepositMoney + '\n' +
                "денег: " + dF.format(money) + '\n' +
                "обслуживание: " + maintenanceCost + '\n' +
                '}';
    }
}
