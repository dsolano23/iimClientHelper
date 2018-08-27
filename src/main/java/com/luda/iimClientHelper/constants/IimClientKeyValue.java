package com.luda.iimClientHelper.constants;

public enum KeyValueImmClient {

    PATH_IMM_CLIENT_PROPERTIES("/src/main/Resources/iimClientProperties/"),
    PATH_PHARMACY_IIM_CLIENT_PROPERTIES("/src/main/Resources/pharmacyIimClientProp/"),
    PHARMACY_ID("pharmacyId"),
    PHARMACY_SW_TYPE("pharmacysw.type"),
    MQ_SERVER_HOST("mq.server.host"),
    MQ_SERVER_PORT("mq.server.port"),
    MQ_SERVER_USER("mq.server.user"),
    MQ_SERVER_PWD("mq.server.password"),
    UNYCOP_STOCK_ITEMS_DAO("pharmacysw.unycop.mdb");

    private final String immClientPropertyKey;

    KeyValueImmClient(String immClientPropertyKey) {
        this.immClientPropertyKey = immClientPropertyKey;
    }

    public String getValue() {
        return this.immClientPropertyKey;
    }

}

