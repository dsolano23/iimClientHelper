package com.luda.iimClientHelper.beans;

public class IimClientDTO {

    private String pharmacyKey;
    private String pharmacyId;
    private String pharmacySWType;
    private MqServerDTO mqServerDTO;


    public IimClientDTO(String pharmacyKey, String pharmacyId, String pharmacySWType, MqServerDTO mqServerDTO) {
        this.pharmacyKey = pharmacyKey;
        this.pharmacyId = pharmacyId;
        this.pharmacySWType = pharmacySWType;
        this.mqServerDTO = mqServerDTO;
    }

    public String getPharmacyKey() {
        return pharmacyKey;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public String getPharmacySWType() {
        return pharmacySWType;
    }

    public MqServerDTO getMqServerDTO() {
        return mqServerDTO;
    }
}
