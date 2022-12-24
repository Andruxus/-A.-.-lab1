package tech.reliab.course.latishevai;

import tech.reliab.course.latishevai.bank.entity.*;
import tech.reliab.course.latishevai.bank.enums.StatusATM;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.AtmService;
import tech.reliab.course.latishevai.bank.service.BankOfficeService;
import tech.reliab.course.latishevai.bank.service.BankService;
import tech.reliab.course.latishevai.bank.service.EmployeeService;
import tech.reliab.course.latishevai.bank.service.impl.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<BankServiceImpl> banks = new ArrayList<>();
        //Инициализация 5 банков
        for (int i = 1; i <= 5; i++) {
            BankServiceImpl bank = new BankServiceImpl();
            bank.create(i, "first" + i);
            banks.add(bank);
        }
        // Инициализация банковских офисов,сотрудников для каждого банка
        for (BankServiceImpl bankService : banks) {
            for (int i = 1; i <= 3; i++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(i, "firstOffice" + i, "345", StatusOffice.Work,
                        true, true, true, true,
                        32423432.0, 12321.0, bankService.getBank());

                for (int k = 1; k <= 5; k++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(k, "Petr", "Petrov", "Petrovich",
                            LocalDate.of(2000, 1, 1), bankService.getBank(), bankOfficeService.getBankOffice(),
                            "helper", true, true, 20000.0);
                }
            }
            // Инициализация банкоматов для каждого банка
            for (int k = 1; k <= 3; k++) {
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(k, "atmFirst", bankService.getBank(), bankService.getBankOffice(k),
                        bankService.getEmployee(k), StatusATM.WORKING, true, true, 23131.0, 3232.0);
            }
        }
        // Инициализация клиентов банков и их платежных и кредитных счетов
        for (BankServiceImpl bankService : banks) {
            for (int i = 1; i <= 5; i++) {
                UserServiceImpl user = new UserServiceImpl();
                user.create(1, "Petrov", "Petrov", "Petrov",
                        LocalDate.of(1999, 12, 12), "rab", 3232.3, banks.get(1).getBank());
                for (int k = 2; k <= 2; k++) {
                    PaymentAccountServiceImpl paymentAccountUserFirstBank1 = new PaymentAccountServiceImpl();
                    paymentAccountUserFirstBank1.create(1, user.getUser(), bankService.getBank(), 2324.0);
                    CreditAccountServiceImpl creditAccountUserFirstBank1 = new CreditAccountServiceImpl();
                    creditAccountUserFirstBank1.create(1, user.getUser(), bankService.getBank(),
                            LocalDate.of(2010, 1, 1), LocalDate.of(2014, 4, 6),
                            3232.0, banks.get(1).getEmployee(1), paymentAccountUserFirstBank1.getPaymentAccount());
                }
            }
        }
        //Вывод информации о банках и их клиентах
        for (BankServiceImpl bankService : banks) {
            bankService.getBank().bankInfo();
            for (User user : bankService.getBank().getUsers()) {
                user.userInfo();
            }
        }
    }
}
