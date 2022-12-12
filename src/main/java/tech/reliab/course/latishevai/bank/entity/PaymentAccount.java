package tech.reliab.course.latishevai.bank.entity;

public class PaymentAccount {
    Integer id;
    User user;
    Bank bank;
    double sum = 0.0;

    public PaymentAccount(Integer id, User user, Bank bank, double sum) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id: " + id + '\n' +
                "пользователь: " + user.getId() + '\n' +
                "наименование банка: " + bank.getName() + '\n' +
                "сумма: " + sum + '\n' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
