package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;

import java.util.ArrayList;

@Getter
@Setter
public class BankOffice {
    private Integer id;
    private String name;
    private String address;
    private StatusOffice status;
    private Boolean maySetATM;
    private Boolean mayApplyLoan;
    private Boolean mayWithdrawMoney;
    private Boolean mayDepositMoney;
    private Double money;
    private Double rentCost;
    private Bank bank;
    private ArrayList<BankAtm> bankAtms;
    private ArrayList<Employee> employees;

    public BankOffice(Integer id, String name, String address,
                      StatusOffice status, Boolean maySetATM,
                      Boolean mayApplyLoan, Boolean mayWithdrawMoney, Boolean mayDepositMoney,
                      Double money, Double rentCost, Bank bank) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.maySetATM = maySetATM;
        this.mayApplyLoan = mayApplyLoan;
        this.mayWithdrawMoney = mayWithdrawMoney;
        this.mayDepositMoney = mayDepositMoney;
        this.money = money;
        this.rentCost = rentCost;
        this.bank = bank;
        this.bankAtms = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id: " + id + '\n' +
                "наименование: " + name + '\n' +
                "адрес: " + address + '\n' +
                "статус: " + status + '\n' +
                "можно разместить банкомат: " + maySetATM + '\n' +
                "кол-во банкоматов: " + getBankAtms().size() + '\n' +
                "оформляет кредит: " + mayApplyLoan + '\n' +
                "работает на прием денег: " + mayWithdrawMoney + '\n' +
                "работает на выдачу денег: " + mayDepositMoney + '\n' +
                "денег: " + money + '\n' +
                "аренда: " + rentCost + '\n' +
                "банк: " + bank.getId() + '\n' +
                '}';
    }
}
