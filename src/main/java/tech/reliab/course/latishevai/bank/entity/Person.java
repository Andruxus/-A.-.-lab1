package tech.reliab.course.latishevai.bank.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String patronymic = null;
    private LocalDate birthDay;

    public Person(Integer id, String firstName, String lastName, String patronymic, LocalDate birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
    }
    public String getFullName(){
        if (patronymic == null){
            return lastName + " " + firstName;
        }
        return lastName + " " + firstName + " " + patronymic;
    }
}
