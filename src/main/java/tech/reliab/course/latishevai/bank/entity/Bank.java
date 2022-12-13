package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Bank {
    private Integer id;
    private String name;
    private Integer rating;
    private Double money;
    private Double interestRate;
    private ArrayList<BankOffice> bankOffices;
    private ArrayList<Employee> employees;
    private ArrayList<User> users;
    private ArrayList<BankAtm> bankAtms;

    public Bank(Integer id, String name){
        this.id=id;
        this.name=name;
        this.employees = new ArrayList<>();
        this.users = new ArrayList<>();
        this.bankAtms = new ArrayList<>();
        this.bankOffices = new ArrayList<>();
    };
    public void bankInfo(){
        System.out.println("Банковские офисы банка "+ getId());
        for (BankOffice bankOffice : getBankOffices()){
            System.out.println(bankOffice);
        }
        System.out.println("Сотрудники банка "+getId());
        for (Employee employee : getEmployees()){
            System.out.println(employee);
        }
        System.out.println("Банкоматы банка "+ getId());
        for (BankAtm bankAtm : getBankAtms()){
            System.out.println(bankAtm);
        }
        System.out.println("Пользователи банка "+getId());
        for (User user : getUsers()){
            System.out.println(user);
        }
    }
    @Override
    public String toString() {
        return "Bank{" +
                "id: " + id + '\n' +
                "Наименование банка: " + name + '\n' +
                "кол-во офисов: " + getBankOffices().size() + '\n' +
                "кол-во банкоматов: " + getBankAtms().size() + '\n' +
                "кол-во сотрудников: " + getEmployees().size() + '\n' +
                "кол-во клиентов: " + getUsers().size() + '\n' +
                "рейтинг: " + rating + '\n' +
                "денег: " + money + '\n' +
                "ставка: " + interestRate + '\n' +
                '}';

    }
}