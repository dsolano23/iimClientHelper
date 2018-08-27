package com.luda.iimClientHelper.constants;

public enum IimClientStockItemKeysValue {

    DEV_ENVIRONMENT("dev","mqServerDev"),
    PRE_PRODUCT_ENVIRONMENT("preProd","mqServerPre"),
    PRODUCTION_ENVIRONMENT("prod","mqServerProd");


    private final String environment;
    private final String mqServerEnv;



    IimClientStockItemKeysValue(String environment , String mqServerEnv) {
        this.environment = environment;
        this.mqServerEnv = mqServerEnv;
    }

    private String getEnvironment() {
        return environment;
    }

    public String getMqServerEnv() {
        return mqServerEnv;
    }

    public static IimClientStockItemKeysValue getMqServerEnv(String environment) {
        IimClientStockItemKeysValue res = null;
        for (IimClientStockItemKeysValue p : values()) {
            if (p.getEnvironment().equals(environment)) {
                res = p;
            }
        }
        return res;
    }

}
