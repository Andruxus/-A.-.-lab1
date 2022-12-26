package tech.reliab.course.latishevai;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tech.reliab.course.latishevai.bank.entity.*;
import tech.reliab.course.latishevai.bank.enums.StatusATM;
import tech.reliab.course.latishevai.bank.enums.StatusOffice;
import tech.reliab.course.latishevai.bank.service.*;
import tech.reliab.course.latishevai.bank.service.exceptions.*;
import tech.reliab.course.latishevai.bank.service.impl.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;
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

    static void createJsonFromUsersBank(Bank bank){
        JSONObject json = new JSONObject();
        JSONArray ar = new JSONArray();
        DecimalFormat dF = new DecimalFormat("##.###");
        for (User user : bank.getUsers()){
            for (PaymentAccount paymentAccount: user.getPaymentAccounts()) {
                JSONObject jsonPayment = new JSONObject();
                jsonPayment.put("id", paymentAccount.getId().intValue());
                jsonPayment.put("user", paymentAccount.getUser().getId());
                jsonPayment.put("Bank", paymentAccount.getBank().getId());
                jsonPayment.put("sum", dF.format(paymentAccount.getSum()));
                jsonPayment.put("type", "paymentAccount");
                ar.put(jsonPayment);
            }
            for(CreditAccount creditAccount : user.getCreditAccounts()){
                JSONObject jsonCredit = new JSONObject();
                jsonCredit.put("id",creditAccount.getId());
                jsonCredit.put("user",creditAccount.getUser().getId());
                jsonCredit.put("bank",creditAccount.getBank().getId());
                jsonCredit.put("start",creditAccount.getStart());
                jsonCredit.put("end",creditAccount.getEnd());
                jsonCredit.put("monthNumber",creditAccount.getMonthNumber());
                jsonCredit.put("sum", dF.format(creditAccount.getSum()));
                jsonCredit.put("monthPayment", dF.format(creditAccount.getMonthPayment()));
                jsonCredit.put("interestRate", dF.format(creditAccount.getInterestRate()));
                jsonCredit.put("employee",creditAccount.getEmployee().getId());
                jsonCredit.put("type", "paymentAccount");
                ar.put(jsonCredit);
            }
            json.put("acc",ar);
        }
        try (PrintWriter out = new PrintWriter(new FileWriter("D:\\file.json"))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json.toString());
    }

    static void updatePaymentAcc(PaymentAccount paymentAccount,String json, User user) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;
        paymentAccount.setId((Integer) jsonObj.get("id"));
        paymentAccount.setSum((Double) jsonObj.get("sum"));
        paymentAccount.setBank(user.getBank());
    }
    static void updateCreditAcc(CreditAccount creditAccount, String json, User user) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;
        creditAccount.setId((Integer) jsonObj.get("id"));
        creditAccount.setStart((LocalDate) jsonObj.get("start"));
        creditAccount.setSum((Double) jsonObj.get("sum"));
        creditAccount.setEnd((LocalDate) jsonObj.get("end"));
        creditAccount.setInterestRate((Double) jsonObj.get("interestRate"));
        creditAccount.setMonthPayment((Double) jsonObj.get("monthPayment"));
        creditAccount.setMonthNumber((Integer) jsonObj.get("monthNumber"));
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
                        LocalDate.of(1999, 12, 12), "rab", 3232.3, banks.get(new Random().nextInt(0,3)).getBank());
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
        createJsonFromUsersBank(banks.get(1).getBank());
    }
}
