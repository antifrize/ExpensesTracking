package ru.vmakarenko.entities;

import ru.vmakarenko.entities.User;

import java.util.Date;

/**
 * Created by VMakarenko on 2/4/15.
 */
public class ExpensesFilter {
    private Integer amountMin;
    private Integer amountMax;
    private String dateFrom;
    private String dateTo;
    private String description;
    private String comment;
    private User user;


    public Integer getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(Integer amountMin) {
        this.amountMin = amountMin;
    }

    public Integer getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(Integer amountMax) {
        this.amountMax = amountMax;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
