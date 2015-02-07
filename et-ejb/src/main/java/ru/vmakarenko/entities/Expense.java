package ru.vmakarenko.entities;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by VMakarenko on 2/3/15.
 */
@XmlRootElement
@Entity
@Table(name="EXPENSE")
@Proxy(lazy = false)
public class Expense extends DefaultEntity{
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE_TIME")
    private Date dateTime;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="USER_COMMENT")
    private String comment;
    @Column(name="AMOUNT")
    private int amount;
    // TODO why eager?
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    @JsonIgnore
    private User user;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
