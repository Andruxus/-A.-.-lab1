package tech.reliab.course.latishevai;

import tech.reliab.course.latishevai.bank.entity.Bank;
import tech.reliab.course.latishevai.bank.entity.User;
import tech.reliab.course.latishevai.bank.enums.StatusATM;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.AtmService;
import tech.reliab.course.latishevai.bank.service.BankOfficeService;
import tech.reliab.course.latishevai.bank.service.EmployeeService;
import tech.reliab.course.latishevai.bank.service.impl.*;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String args[]) {
        //Bank
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.create(1, "Сбер");

        //BankOffice
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.create(1,"Восточный","Костюкова 44",StatusOffice.Work,true,
                0,true,true,true,234324.0,233222.0,bankService.getBank());

        //Employee
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.create(1,"Егор","Петров","Петрович",
                LocalDate.of(2000,12,12),bankService.getBank(),bankOfficeService.getBankOffice(),
                "Помощник",true,true,20000.0);

        //Bank ATM
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.create(1,"Восточный",bankService.getBank(),bankOfficeService.getBankOffice(),employeeService.getEmployee(),
                StatusATM.WORKING,true,true,234234.3,12000.0);


        //User
        UserServiceImpl userService = new UserServiceImpl();
        userService.create(1,"Иван","Иванов","Иванович",
                LocalDate.of(2003,1,12),"бариста",34000.0,
                bankService.getBank());

        //Payment Account
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.create(1,userService.getUser(),bankService.getBank(),2000.0);

        //Credit Account
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        creditAccountService.create(1,userService.getUser(),bankService.getBank(),LocalDate.of(2014,2,5),
                LocalDate.of(2018,3,7),300000.0,
                employeeService.getEmployee(),paymentAccountService.getPaymentAccount());

        System.out.println(bankService.getBank());
        System.out.println(bankOfficeService.getBankOffice());
        System.out.println(employeeService.getEmployee());
        System.out.println(atmService.getBankATM());
        System.out.println(userService.getUser());
        System.out.println(creditAccountService.getCreditAccount());
        System.out.println(paymentAccountService.getPaymentAccount());
    }
}
