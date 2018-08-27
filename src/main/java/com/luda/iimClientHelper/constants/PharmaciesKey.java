package com.luda.webDriverTest.utilsType.constans.immClient;

public enum PharmaciesKey {

    PHARMACY_01("pharmacy01"),
    PHARMACY_02("pharmacy02"),
    PHARMACY_03("pharmacy03"),
    PHARMACY_04("pharmacy04"),;

    private final String pharmaciesKey;

    PharmaciesKey(String pharmaciesKey) {
        this.pharmaciesKey = pharmaciesKey;
    }

    public String getValue() {
        return this.pharmaciesKey;
    }
}
