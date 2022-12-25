package tech.reliab.course.latishevai;

import tech.reliab.course.latishevai.bank.entity.*;
import tech.reliab.course.latishevai.bank.enums.StatusATM;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.*;
import tech.reliab.course.latishevai.bank.service.exceptions.*;
import tech.reliab.course.latishevai.bank.service.impl.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<BankService> banksWithMoney(ArrayList<BankService> banks, Double loanSum) {
        ArrayList<BankService> banksWithMoney = new ArrayList<>();
        ArrayList<Double> criteria = new ArrayList<>();
        for (BankService bank : banks) {
            if (bank.getBank().getMoney() >= loanSum) {
                banksWithMoney.add(bank);
            }
        }
        return banksWithMoney;
    }
    public static void main(String args[]) throws UserAnotherBankException, BadUserRatingException, CreditException, PayAccAnotherUserException, CreditAccAnotherUserException {
        ArrayList<BankService> banks = new ArrayList<>();
        //Инициализация 5 банков
        for (int i = 1; i <= 5; i++) {
            BankServiceImpl bank = new BankServiceImpl();
            bank.create(i, "first" + i);
            banks.add(bank);
        }
        // Инициализация банковских офисов,сотрудников для каждого банка
        for (BankService bankService : banks) {
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
        for (BankService bankService : banks) {
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



        System.out.println("Клиент");
        User workUser = banks.get(1).getUser(1);
        System.out.println(workUser);
        System.out.println("\nПопытка получения нового кредита");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму кредита: ");
        double loanSum = input.nextDouble();
        System.out.println("Введите количество месяцев: ");
        int countMonth = input.nextInt();
        ArrayList<BankService> banksWithMoney = banksWithMoney(banks, loanSum);
        System.out.println("\nПредложенные банки:");
        for (int i = 0; i < banksWithMoney.size(); i++) {
            if (i != 0) {
                System.out.printf("\nБанк №%d%n", i+1);
            }
            else {
                System.out.printf("Банк №%d%n", i+1);
            }
            System.out.println(banksWithMoney.get(i).getBank());
        }
        System.out.println("\nВыберите из предложенных банков: ");
        int bankID = input.nextInt();
        BankService workBank = banksWithMoney.get(bankID );

        System.out.println("\nПредложенные банковские офисы:");
        for (int i = 0; i < workBank.getBank().getBankOffices().size(); i++) {
            if (i != 0) {
                System.out.printf("\nОфис №%d%n", i+1);
            }
            else {
                System.out.printf("Офис №%d%n", i+1);
            }
            System.out.println(workBank.getBank().getBankOffices().get(i));
        }
        System.out.println("\nВыберите из предложенных офисов: ");
        int officeID = input.nextInt();
        BankOffice workOffice = workBank.getBank().getBankOffices().get(officeID);
        System.out.println(workOffice.getEmployees());
        for (int i = 0; i < workOffice.getEmployees().size(); i++) {
                System.out.printf("\nСотрудник №%d%n", i+1);
                System.out.printf("Сотрудник №%d%n", i+1);
            System.out.printf("id %d%n", workOffice.getEmployees().get(i).getId());
            System.out.printf("Имя %s", workOffice.getEmployees().get(i).getFirstName());
            if (workOffice.getEmployees().get(i).getCanIssueCredit()) {
                System.out.println("\nМожет выдавать кредиты");
            }
            else {
                System.out.println("\nНе может выдавать кредиты");
            }
        }
        System.out.println("\nВыберите из предложенных сотрудников: ");
        int employeeID = input.nextInt();
        Employee workEmployee = workOffice.getEmployees().get(employeeID-1);
        //Берём кредит
        PaymentAccountServiceImpl payAcc = new PaymentAccountServiceImpl();
        CreditAccountServiceImpl creditAcc = new CreditAccountServiceImpl();
        UserService userService = new UserServiceImpl();
        userService.update(workUser);
        userService.issueLoanBankService(workBank, workOffice, workEmployee, workOffice.getBankAtms().get(0), loanSum,
                LocalDate.of(2022, 11, 11), countMonth, payAcc, creditAcc);
        System.out.println("Кредит успешно оформлен.");
        int size = userService.getUser().getCreditAccounts().size();
        System.out.println(userService.getUser().getCreditAccounts().get(size - 1));
    }
}
