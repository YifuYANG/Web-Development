package app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Phone
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String type;
    @Column
    public String number;
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    public Person user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user)
    {
        this.user = user;
    }
}
