package ru.vmakarenko.common;

/**
 * Created by VMakarenko on 2/15/15.
 */
public class LoginPassCheckResult {
    private String field;
    private String msg;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public LoginPassCheckResult field(String field) {
        this.field = field;
        return this;
    }

    public LoginPassCheckResult status(String status) {
        this.status = status;
        return this;
    }

    public LoginPassCheckResult msg(String msg) {
        this.msg = msg;
        return this;
    }


}
