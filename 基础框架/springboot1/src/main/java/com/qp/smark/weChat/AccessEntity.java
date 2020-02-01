package com.qp.smark.weChat;

public class AccessEntity {

    public String access_token;

    public String time;

    public String expires_in;

    public String ticket;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "AccessEntity{" +
                "access_token='" + access_token + '\'' +
                ", time='" + time + '\'' +
                ", expires_in='" + expires_in + '\'' +
                '}';
    }
}
