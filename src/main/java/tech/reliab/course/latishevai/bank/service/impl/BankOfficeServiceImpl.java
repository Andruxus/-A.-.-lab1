package tech.reliab.course.latishevai.bank.service.impl;


import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.BankAtm;
import tech.reliab.course.latishevai.bank.entity.BankOffice;
import tech.reliab.course.latishevai.bank.entity.Employee;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice = null;

    @Override
    public void create(Integer id, String name, String address,
                       StatusOffice status, Boolean maySetATM,
                       Boolean mayApplyLoan, Boolean mayWithdrawMoney, Boolean mayDepositMoney,
                       Double money, Double rentCost, Bank bank) {
        this.bankOffice = new BankOffice(id, name, address, status,
                maySetATM, mayApplyLoan, mayWithdrawMoney, mayDepositMoney,
                money, rentCost, bank);
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.update(bank);
        bankService.addBankOffice(bankOffice);
    }

    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    @Override
    public void delete() {
        this.bankOffice.setBank(null);
        this.bankOffice.setAddress(null);
        this.bankOffice.setId(null);
        this.bankOffice.setName(null);
        this.bankOffice.setStatus(null);
        this.bankOffice.setMayApplyLoan(null);
        this.bankOffice.setMayDepositMoney(null);
        this.bankOffice.setMaySetATM(null);
        this.bankOffice.setMayWithdrawMoney(null);
        this.bankOffice.setMoney(null);
        this.bankOffice.setRentCost(null);
        this.bankOffice.setBankAtms(null);
        this.bankOffice = null;
    }

    @Override
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }
    @Override
    public void addBankAtm(BankAtm bankAtm) {
        this.bankOffice.getBankAtms().add(bankAtm);
        bankAtm.setBankOffice(this.bankOffice);
    }

    @Override
    public void deleteBankAtm(BankAtm bankAtm) {
        this.bankOffice.getBankAtms().remove(bankAtm);
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.update(bankAtm);
        atmService.delete();
    }

    @Override
    public BankAtm getBankAtm(Integer id) {
        for (BankAtm bankAtm : this.bankOffice.getBankAtms()) {
            if (id.equals(bankAtm.getId()))
                return bankAtm;
        }
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        this.bankOffice.getEmployees().add(employee);
        employee.setBankOffice(this.bankOffice);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        this.bankOffice.getEmployees().remove(employee);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.update(employee);
        employeeService.delete();
    }

    @Override
    public Employee getEmployee(Integer id) {
        for (Employee employee : this.bankOffice.getEmployees()) {
            if (id.equals(employee.getId()))
                return employee;
        }
        return null;
    }
}
