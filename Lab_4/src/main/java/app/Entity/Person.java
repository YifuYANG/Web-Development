package app.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String firstname;
    @Column
    public String surname;

    @OneToMany (mappedBy = "user",fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
    public List<Phone> number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Phone> getNumber() {
        return number;
    }

    public void setNumber(Phone phone)
    {
        number.add(phone);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }
}
