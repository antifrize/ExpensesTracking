package ru.vmakarenko.common;

/**
 * Created by VMakarenko on 2/15/15.
 */
public class RestResult {
    private String status;

    public RestResult(){}
    private RestResult(String status) {
        this.status = status;
    }

    public static RestResult getOk(){
        return new RestResult(AppConsts.RESPONSE_OK);
    }

    public static RestResult getBad(){
        return new RestResult(AppConsts.RESPONSE_ERROR);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
