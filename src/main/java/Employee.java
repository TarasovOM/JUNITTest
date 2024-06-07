import java.util.ArrayList;
import java.util.List;

import static java.lang.StringTemplate.STR;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String country;
    private int age;

    public Employee() {
        // Пустой конструктор
    }

    public Employee(long id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    public Employee(Object id) {
    }

    @Override
    public String toString() {
        return STR."Employee{id= '\{this.id}', Name: '\{this.firstName}', lastName: '\{this.lastName}' country: '\{this.country}', age: '\{this.age}'}";
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = String.valueOf(lastName);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
