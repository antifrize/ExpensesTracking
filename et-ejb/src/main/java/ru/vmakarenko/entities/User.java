package ru.vmakarenko.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by VMakarenko on 2/3/15.
 */
@Entity
@Table(name="ET_USER")
@Proxy(lazy = false)
public class User extends DefaultEntity {
    @Column(name="USERNAME")
    @NotNull
    private String username;
    @Column(name="PASSWORD")
    @NotNull
    private String password;
    @Transient
    private String password2;
    @Column(name="EMAIL")
    private String eMail;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
