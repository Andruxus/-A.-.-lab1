package tech.reliab.course.latishevai.bank.entity;

public class Bank {
    private Integer id;
    private String name;
    private Integer countOffice;
    private Integer countATM;
    private Integer countEmployees;
    private Integer countClients;
    private Integer rating;
    private Double money;
    private Double interestRate;

    public Bank(Integer id, String name){
        this.id=id;
        this.name=name;
        this.countClients=0;
        this.countEmployees=0;
        this.countATM=0;
        this.countOffice=0;
    };

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

    public Integer getCountOffice() {
        return countOffice;
    }

    public void setCountOffice(Integer countOffice) {
        this.countOffice = countOffice;
    }

    public Integer getCountATM() {
        return countATM;
    }

    public void setCountATM(Integer countATM) {
        this.countATM = countATM;
    }

    public Integer getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(Integer countEmployees) {
        this.countEmployees = countEmployees;
    }

    public Integer getCountClients() {
        return countClients;
    }

    public void setCountClients(Integer countClients) {
        this.countClients = countClients;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id: " + id + '\n' +
                "Наименование банка: " + name + '\n' +
                "кол-во офисов: " + countOffice + '\n' +
                "кол-во банкоматов: " + countATM + '\n' +
                "кол-во сотрудников: " + countEmployees + '\n' +
                "кол-во клиентов: " + countClients + '\n' +
                "рейтинг: " + rating + '\n' +
                "денег: " + money + '\n' +
                "ставка: " + interestRate + '\n' +
                '}';
    }
}