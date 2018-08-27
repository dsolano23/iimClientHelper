package com.luda.iimClientHelper.beans;

public class MqServerDTO {

    private String mqServerHost;
    private String mqServerPort;
    private String mqServerUser;
    private String mqServerPWD;

    public MqServerDTO( String mqServerHost, String mqServerPort, String mqServerUser, String mqServerPWD) {

        this.mqServerHost = mqServerHost;
        this.mqServerPort = mqServerPort;
        this.mqServerUser = mqServerUser;
        this.mqServerPWD = mqServerPWD;
    }

    public String getMqServerHost() {
        return mqServerHost;
    }

    public String getMqServerPort() {
        return mqServerPort;
    }

    public String getMqServerUser() {
        return mqServerUser;
    }

    public String getMqServerPWD() {
        return mqServerPWD;
    }
}
