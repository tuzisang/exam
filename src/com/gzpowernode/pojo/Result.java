package com.gzpowernode.pojo;

/**
 * @author tzsang
 * @create 2022-04-22 12:45
 */
public class Result {
    private int state;
    private String message;

    public Result() {
    }

    public Result(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state=" + state +
                ", message='" + message + '\'' +
                '}';
    }
}
