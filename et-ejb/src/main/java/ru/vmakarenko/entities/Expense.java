package ru.vmakarenko.entities;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Proxy;
import org.hibernate.type.StringClobType;
import ru.vmakarenko.common.AppConsts;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by VMakarenko on 2/3/15.
 */
@XmlRootElement
@Entity
@Table(name = "EXPENSE")
@Proxy(lazy = false)
public class Expense extends DefaultEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_TIME")
    private Date dateTime;

    @Transient
    private String date;
    @Transient
    private String time;

    @Column(name = "DESCRIPTION", length = 40)
    private String description;
    @Column(name = "USER_COMMENT", length = 40)
    private String comment;
    @Column(name = "AMOUNT")
    private int amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;

    @JsonIgnore
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @PostLoad
    public void postLoad() {
        date = new SimpleDateFormat(AppConsts.DATE_FORMAT).format(dateTime);
        time = new SimpleDateFormat(AppConsts.TIME_FORMAT).format(dateTime);
    }

    @PrePersist
    @PreUpdate
    public void prePersist() {
        long timeL = 0L;
        try {
            if (date != null) {
                timeL += new SimpleDateFormat(AppConsts.DATE_FORMAT).parse(date).getTime();
            }
            if (time != null) {
                timeL += new SimpleDateFormat(AppConsts.TIME_FORMAT).parse(time).getTime();
            }
            dateTime = new Date(timeL);
        } catch (ParseException e) {
            // TODO logging
        }

    }
}
