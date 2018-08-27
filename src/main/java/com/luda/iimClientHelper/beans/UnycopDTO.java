package com.luda.iimClientHelper.beans;

public class UnycopDTO extends IimClientDTO {

    private String pharmacyStockItemsDAO;

    public UnycopDTO(String pharmacyKey, String pharmacyId, String pharmacySWType, MqServerDTO mqServerDTO, String pharmacyStockItemsDAO) {
        super( pharmacyKey, pharmacyId, pharmacySWType, mqServerDTO);
        this.pharmacyStockItemsDAO = pharmacyStockItemsDAO;
    }

    public String getPharmacyStockItemsDAO() {
        return pharmacyStockItemsDAO;
    }
}
