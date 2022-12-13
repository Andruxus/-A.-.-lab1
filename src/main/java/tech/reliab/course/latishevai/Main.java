package tech.reliab.course.latishevai;

import tech.reliab.course.latishevai.bank.entity.*;
import tech.reliab.course.latishevai.bank.enums.StatusATM;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.AtmService;
import tech.reliab.course.latishevai.bank.service.BankOfficeService;
import tech.reliab.course.latishevai.bank.service.EmployeeService;
import tech.reliab.course.latishevai.bank.service.impl.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        //Bank
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.create(1, "Сбер");

        //BankOffice
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.create(1, "Восточный", "Костюкова 44", StatusOffice.Work, true,
                true, true, true, 234324.0, 233222.0, bankService.getBank());

        //Employee
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.create(1, "Егор", "Петров", "Петрович",
                LocalDate.of(2000, 12, 12), bankService.getBank(), bankOfficeService.getBankOffice(),
                "Помощник", true, true, 20000.0);

        //Bank ATM
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.create(1, "Восточный", bankService.getBank(), bankOfficeService.getBankOffice(), employeeService.getEmployee(),
                StatusATM.WORKING, true, true, 234234.3, 12000.0);


        //User
        UserServiceImpl userService = new UserServiceImpl();
        userService.create(1, "Иван", "Иванов", "Иванович",
                LocalDate.of(2003, 1, 12), "бариста", 34000.0,
                bankService.getBank());

        //Payment Account
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.create(1, userService.getUser(), bankService.getBank(), 2000.0);

        //Credit Account
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        creditAccountService.create(1, userService.getUser(), bankService.getBank(), LocalDate.of(2014, 2, 5),
                LocalDate.of(2018, 3, 7), 300000.0,
                employeeService.getEmployee(), paymentAccountService.getPaymentAccount());

        ArrayList<BankServiceImpl> banks = new ArrayList<>();
        BankServiceImpl firstBank = new BankServiceImpl();
        firstBank.create(1, "first");

        //Банковские офисы для первого банка

        BankOfficeServiceImpl bankOfficeFirst = new BankOfficeServiceImpl();
        bankOfficeFirst.create(1, "firstOffice", "345", StatusOffice.Work,
                true, true, true, true,
                32423432.0, 12321.0, firstBank.getBank());


        BankOfficeServiceImpl bankOfficeSecond = new BankOfficeServiceImpl();
        bankOfficeSecond.create(2, "secondOffice", "345", StatusOffice.Work,
                true, true, true, true,
                32423432.0, 12321.0, firstBank.getBank());

        BankOfficeServiceImpl bankOfficeThird = new BankOfficeServiceImpl();
        bankOfficeThird.create(3, "thirdOffice", "345", StatusOffice.Work,
                true, true, true, true,
                32423432.0, 12321.0, firstBank.getBank());

        //Сотрудники первого бака
        EmployeeServiceImpl emplFirst = new EmployeeServiceImpl();
        emplFirst.create(1, "Petr", "Petrov", "Petrovich",
                LocalDate.of(2000, 1, 1), firstBank.getBank(), bankOfficeFirst.getBankOffice(),
                "helper", true, true, 20000.0);
        EmployeeServiceImpl emplSecond = new EmployeeServiceImpl();
        emplSecond.create(2, "Petr", "Petrov", "Petrovich",
                LocalDate.of(2000, 1, 1), firstBank.getBank(), bankOfficeFirst.getBankOffice(),
                "helper", true, true, 20000.0);
        EmployeeServiceImpl emplThird = new EmployeeServiceImpl();
        emplThird.create(3, "Petr", "Petrov", "Petrovich",
                LocalDate.of(2000, 1, 1), firstBank.getBank(), bankOfficeFirst.getBankOffice(),
                "helper", true, true, 20000.0);

        //Банкоматы первого банка
        AtmServiceImpl atmFrist = new AtmServiceImpl();
        atmFrist.create(1, "atmFirst", firstBank.getBank(), bankOfficeFirst.getBankOffice(),
                emplFirst.getEmployee(), StatusATM.WORKING, true, true, 23131.0, 3232.0);
        AtmServiceImpl atmSecond = new AtmServiceImpl();
        atmSecond.create(2, "atmSecond", firstBank.getBank(), bankOfficeFirst.getBankOffice(),
                emplFirst.getEmployee(), StatusATM.WORKING, true, true, 23131.0, 3232.0);
        AtmServiceImpl atmThird = new AtmServiceImpl();
        atmThird.create(3, "atmThird", firstBank.getBank(), bankOfficeFirst.getBankOffice(),
                emplFirst.getEmployee(), StatusATM.WORKING, true, true, 23131.0, 3232.0);

        BankServiceImpl secondBank = new BankServiceImpl();
        secondBank.create(2, "second");

        //Пользователи первого банка
        UserServiceImpl userFirstBank1 = new UserServiceImpl();
        userFirstBank1.create(1,"Petrov","Petrov","Petrov",
                LocalDate.of(1999,12,12),"rab",3232.3,firstBank.getBank());
        UserServiceImpl userFirstBank2 = new UserServiceImpl();
        userFirstBank2.create(2,"Petrov","Petrov","Petrov",
                LocalDate.of(1999,12,12),"rab",3232.3,firstBank.getBank());
        UserServiceImpl userFirstBank3 = new UserServiceImpl();
        userFirstBank3.create(3,"Petrov","Petrov","Petrov",
                LocalDate.of(1999,12,12),"rab",3232.3,firstBank.getBank());

        //Банковские и кредитные счета пользователей

        PaymentAccountServiceImpl paymentAccountUserFirstBank1 = new PaymentAccountServiceImpl();
        paymentAccountUserFirstBank1.create(1,userFirstBank1.getUser(),firstBank.getBank(),2324.0);
        CreditAccountServiceImpl creditAccountUserFirstBank1 = new CreditAccountServiceImpl();
        creditAccountUserFirstBank1.create(1,userFirstBank1.getUser(),firstBank.getBank(),
                LocalDate.of(2010,1,1),LocalDate.of(2014,4,6),
                3232.0,emplFirst.getEmployee(),paymentAccountUserFirstBank1.getPaymentAccount());

        PaymentAccountServiceImpl paymentAccountUserFirstBank2 = new PaymentAccountServiceImpl();
        paymentAccountUserFirstBank2.create(2,userFirstBank2.getUser(),firstBank.getBank(),2324.0);
        CreditAccountServiceImpl creditAccountUserFirstBank2 = new CreditAccountServiceImpl();
        creditAccountUserFirstBank2.create(2,userFirstBank2.getUser(),firstBank.getBank(),
                LocalDate.of(2010,1,1),LocalDate.of(2014,4,6),
                3232.0,emplFirst.getEmployee(),paymentAccountUserFirstBank2.getPaymentAccount());

        PaymentAccountServiceImpl paymentAccountUserFirstBank3 = new PaymentAccountServiceImpl();
        paymentAccountUserFirstBank3.create(3,userFirstBank3.getUser(),firstBank.getBank(),2324.0);
        CreditAccountServiceImpl creditAccountUserFirstBank3 = new CreditAccountServiceImpl();
        creditAccountUserFirstBank3.create(3,userFirstBank3.getUser(),firstBank.getBank(),
                LocalDate.of(2010,1,1),LocalDate.of(2014,4,6),
                3232.0,emplFirst.getEmployee(),paymentAccountUserFirstBank3.getPaymentAccount());

        //Банковские офисы для второго банка

        BankOfficeServiceImpl secondBankOffice1 = new BankOfficeServiceImpl();
        secondBankOffice1.create(1, "secondBankOffice1", "345", StatusOffice.Work,
                true, true, true, true,
                32423432.0, 12321.0, secondBank.getBank());

        BankOfficeServiceImpl secondBankOffice2 = new BankOfficeServiceImpl();
        secondBankOffice2.create(2, "secondBankOffice2", "345", StatusOffice.Work,
                true, true, true, true,
                32423432.0, 12321.0, secondBank.getBank());

        BankOfficeServiceImpl thirdBankOffice2 = new BankOfficeServiceImpl();
        thirdBankOffice2.create(3, "thirdBankOffice2", "345", StatusOffice.Work,
                true, true, true, true,
                32423432.0, 12321.0, secondBank.getBank());

        //Сотрудники второго бака
        EmployeeServiceImpl emplFirstSecondBank = new EmployeeServiceImpl();
        emplFirstSecondBank.create(1, "Petr", "Petrov", "Petrovich",
                LocalDate.of(2000, 1, 1), secondBank.getBank(), secondBankOffice1.getBankOffice(),
                "helper", true, true, 20000.0);
        EmployeeServiceImpl emplSecondSecondBank = new EmployeeServiceImpl();
        emplSecondSecondBank.create(2, "Petr", "Petrov", "Petrovich",
                LocalDate.of(2000, 1, 1), secondBank.getBank(), secondBankOffice1.getBankOffice(),
                "helper", true, true, 20000.0);
        EmployeeServiceImpl emplThirdSecondBank = new EmployeeServiceImpl();
        emplThirdSecondBank.create(3, "Petr", "Petrov", "Petrovich",
                LocalDate.of(2000, 1, 1), secondBank.getBank(), secondBankOffice1.getBankOffice(),
                "helper", true, true, 20000.0);

        //Банкоматы второго банка
        AtmServiceImpl atmFristSecondBank = new AtmServiceImpl();
        atmFristSecondBank.create(1, "atmFristSecondBank", secondBank.getBank(), secondBankOffice1.getBankOffice(),
                emplFirstSecondBank.getEmployee(), StatusATM.WORKING, true, true, 23131.0, 3232.0);
        AtmServiceImpl atmSecondSecondBank = new AtmServiceImpl();
        atmSecondSecondBank.create(2, "atmSecondSecondBank", secondBank.getBank(), secondBankOffice1.getBankOffice(),
                emplFirstSecondBank.getEmployee(), StatusATM.WORKING, true, true, 23131.0, 3232.0);
        AtmServiceImpl atmThirdSecondBank = new AtmServiceImpl();
        atmThirdSecondBank.create(3, "atmThird", secondBank.getBank(), secondBankOffice1.getBankOffice(),
                emplFirstSecondBank.getEmployee(), StatusATM.WORKING, true, true, 23131.0, 3232.0);


        //Пользователи второго банка
        UserServiceImpl userSecondBank1 = new UserServiceImpl();
        userSecondBank1.create(1,"Petrov","Petrov","Petrov",
                LocalDate.of(1999,12,12),"rab",3232.3,secondBank.getBank());
        UserServiceImpl userSecondBank2 = new UserServiceImpl();
        userSecondBank2.create(2,"Petrov","Petrov","Petrov",
                LocalDate.of(1999,12,12),"rab",3232.3,secondBank.getBank());
        UserServiceImpl userSecondBank3 = new UserServiceImpl();
        userSecondBank3.create(3,"Petrov","Petrov","Petrov",
                LocalDate.of(1999,12,12),"rab",3232.3,secondBank.getBank());


        //Банковские и кредитные счета пользователей

        PaymentAccountServiceImpl paymentAccountUserSecondBank1 = new PaymentAccountServiceImpl();
        paymentAccountUserSecondBank1.create(1,userSecondBank1.getUser(),secondBank.getBank(),2324.0);
        CreditAccountServiceImpl creditAccountUserSecondBank1 = new CreditAccountServiceImpl();
        creditAccountUserSecondBank1.create(1,userSecondBank1.getUser(),firstBank.getBank(),
                LocalDate.of(2010,1,1),LocalDate.of(2014,4,6),
                3232.0,emplSecond.getEmployee(),paymentAccountUserSecondBank1.getPaymentAccount());

        PaymentAccountServiceImpl paymentAccountUserSecondBank2 = new PaymentAccountServiceImpl();
        paymentAccountUserSecondBank2.create(2,userSecondBank2.getUser(),secondBank.getBank(),2324.0);
        CreditAccountServiceImpl creditAccountUserSecondBank2 = new CreditAccountServiceImpl();
        creditAccountUserSecondBank2.create(2,userSecondBank2.getUser(),secondBank.getBank(),
                LocalDate.of(2010,1,1),LocalDate.of(2014,4,6),
                3232.0,emplSecond.getEmployee(),paymentAccountUserSecondBank2.getPaymentAccount());

        PaymentAccountServiceImpl paymentAccountUserSecondBank3 = new PaymentAccountServiceImpl();
        paymentAccountUserSecondBank3.create(3,userSecondBank3.getUser(),secondBank.getBank(),2324.0);
        CreditAccountServiceImpl creditAccountUserSecondBank3 = new CreditAccountServiceImpl();
        creditAccountUserSecondBank3.create(3,userSecondBank3.getUser(),secondBank.getBank(),
                LocalDate.of(2010,1,1),LocalDate.of(2014,4,6),
                3232.0,emplSecond.getEmployee(),paymentAccountUserSecondBank3.getPaymentAccount());

        firstBank.getBank().bankInfo();
        for (User user : firstBank.getBank().getUsers()){
            user.userInfo();
        }
        secondBank.getBank().bankInfo();
        for (User user : secondBank.getBank().getUsers()){
            user.userInfo();
        }
    }
}
