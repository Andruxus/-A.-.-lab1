package tech.reliab.course.latishevai.bank.entity;

import tech.reliab.course.latishevai.bank.enums.StatusOffice;

public class BankOffice {
    private Integer id;
    private String name;
    private String address;
    private StatusOffice status;
    private Boolean maySetATM;
    private Integer countATM;
    private Boolean mayApplyLoan;
    private Boolean mayWithdrawMoney;
    private Boolean mayDepositMoney;
    private Double money;
    private Double rentCost;
    private Bank bank;

    public BankOffice(Integer id, String name, String address,
                      StatusOffice status, Boolean maySetATM, Integer countATM,
                      Boolean mayApplyLoan, Boolean mayWithdrawMoney, Boolean mayDepositMoney,
                      Double money, Double rentCost, Bank bank) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.maySetATM = maySetATM;
        this.countATM = countATM;
        this.mayApplyLoan = mayApplyLoan;
        this.mayWithdrawMoney = mayWithdrawMoney;
        this.mayDepositMoney = mayDepositMoney;
        this.money = money;
        this.rentCost = rentCost;
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id: " + id + '\n' +
                "наименование: " + name + '\n' +
                "адрес: " + address + '\n' +
                "статус: " + status + '\n' +
                "можно разместить банкомат: " + maySetATM + '\n' +
                "кол-во банкоматов: " + countATM + '\n' +
                "оформляет кредит: " + mayApplyLoan + '\n' +
                "работает на прием денег: " + mayWithdrawMoney + '\n' +
                "работает на выдачу денег: " + mayDepositMoney + '\n' +
                "денег: " + money + '\n' +
                "аренда: " + rentCost + '\n' +
                "банк: " + bank.getId() + '\n' +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StatusOffice getStatus() {
        return status;
    }

    public void setStatus(StatusOffice status) {
        this.status = status;
    }

    public Boolean getMaySetATM() {
        return maySetATM;
    }

    public void setMaySetATM(Boolean maySetATM) {
        this.maySetATM = maySetATM;
    }

    public Integer getCountATM() {
        return countATM;
    }

    public void setCountATM(Integer countATM) {
        this.countATM = countATM;
    }

    public Boolean getMayApplyLoan() {
        return mayApplyLoan;
    }

    public void setMayApplyLoan(Boolean mayApplyLoan) {
        this.mayApplyLoan = mayApplyLoan;
    }

    public Boolean getMayWithdrawMoney() {
        return mayWithdrawMoney;
    }

    public void setMayWithdrawMoney(Boolean mayWithdrawMoney) {
        this.mayWithdrawMoney = mayWithdrawMoney;
    }

    public Boolean getMayDepositMoney() {
        return mayDepositMoney;
    }

    public void setMayDepositMoney(Boolean mayDepositMoney) {
        this.mayDepositMoney = mayDepositMoney;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
