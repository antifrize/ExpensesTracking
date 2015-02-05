package ru.vmakarenko.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VMakarenko on 2/3/15.
 */
@Entity
@Table(name="USER")
public class User extends DefaultEntity {
    @Column(name="USER")
    private String user;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="EMAIL")
    private String eMail;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
