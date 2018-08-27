package com.luda.iimClientHelper.manager;

import com.luda.iimClientHelper.beans.IimClientDTO;
import com.luda.iimClientHelper.beans.MqServerDTO;
import com.luda.iimClientHelper.beans.UnycopDTO;
import com.luda.iimClientHelper.constants.KeyValueImmClient;
import com.luda.iimClientHelper.constants.PharmaciesKey;
import com.luda.iimClientHelper.exception.NotFoundResourceException;


import java.io.*;
import java.util.Hashtable;
import java.util.Properties;

public class IimClientManagement {


    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(IimClientManagement.class);
    private static String immClientAbsolutePath = new File(".").getAbsolutePath();

    private static Hashtable<String, Properties> propertiesList = new Hashtable<String, Properties>();

    public static void setUnycopImmClient(UnycopDTO immClientDTO) throws NotFoundResourceException {
        Properties virtualProperties = new Properties();
        InputStream input = null;
        OutputStream output;
        String projectPath = KeyValueImmClient.PATH_IMM_CLIENT_PROPERTIES.getValue();

        String immClientProperties = immClientAbsolutePath + projectPath + immClientDTO.getPharmacyKey() + ".properties";
        LOGGER.debug(" \n\n\n\nimmClientProperties : " + immClientProperties );
        try {

            boolean exist = new File(immClientProperties).exists();
            if (exist) {
                input = new FileInputStream(immClientProperties);
                // load a properties file
                virtualProperties.load(input);

                input.close();

                LOGGER.debug(" \n\n\n\nvirtualProperties : " + virtualProperties.get(KeyValueImmClient.UNYCOP_STOCK_ITEMS_DAO.getValue()) );
                virtualProperties.replace(KeyValueImmClient.PHARMACY_ID.getValue(), immClientDTO.getPharmacyId());
                virtualProperties.replace(KeyValueImmClient.PHARMACY_SW_TYPE.getValue(), immClientDTO.getPharmacyId());
                virtualProperties.replace(KeyValueImmClient.MQ_SERVER_HOST.getValue(), immClientDTO.getMqServerDTO().getMqServerHost());
                virtualProperties.replace(KeyValueImmClient.MQ_SERVER_PORT.getValue(), immClientDTO.getMqServerDTO().getMqServerPort());
                virtualProperties.replace(KeyValueImmClient.MQ_SERVER_USER.getValue(), immClientDTO.getMqServerDTO().getMqServerUser());
                virtualProperties.replace(KeyValueImmClient.MQ_SERVER_PWD.getValue(), immClientDTO.getMqServerDTO().getMqServerPWD());
                virtualProperties.replace(KeyValueImmClient.UNYCOP_STOCK_ITEMS_DAO.getValue(), immClientDTO.getPharmacyStockItemsDAO());
                LOGGER.debug(" \n\n\n\nvirtualProperties : " + immClientDTO.getPharmacyStockItemsDAO() );

                output = new FileOutputStream(immClientProperties);
                virtualProperties.store(output,null);
                LOGGER.debug(" \n\n\n\nvirtualProperties : " + virtualProperties.get(KeyValueImmClient.UNYCOP_STOCK_ITEMS_DAO.getValue()) );


            } else {
                throw new NotFoundResourceException("The file " + immClientProperties + " does not exists");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new NotFoundResourceException(String.format("%s %s", "Error on access to" + immClientProperties + " does not exists ", ex.getMessage()));
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Properties loadImmClientProperties(String pharmacyKey) throws NotFoundResourceException {
        Properties virtualProperties = new Properties();
        InputStream input = null;
        String projectPath = KeyValueImmClient.PATH_IMM_CLIENT_PROPERTIES.getValue();

        String immClientProperties = immClientAbsolutePath + projectPath + pharmacyKey + ".properties";
        try {

            boolean exist = new File(immClientProperties).exists();
            if (exist) {
                input = new FileInputStream(immClientProperties);
                // load a properties file
                virtualProperties.load(input);

            } else {
                throw new NotFoundResourceException("The file " + immClientProperties + " does not exists");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new NotFoundResourceException(String.format("%s %s", "Error on access to" + immClientProperties + " does not exists ", ex.getMessage()));
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return virtualProperties;
    }

    public static IimClientDTO getImmClientDTO(String pharmacyKey) throws NotFoundResourceException {
        Properties virtualProperties = new Properties();
        if (pharmacyKey.equalsIgnoreCase(PharmaciesKey.PHARMACY_01.getValue())) {
            if (getPropertiesList().get(pharmacyKey) == null) {
                Properties immClientArapiles;
                String fileName = PharmaciesKey.PHARMACY_01.getValue();
                immClientArapiles = loadImmClientProperties(fileName);
                getPropertiesList().put(pharmacyKey, immClientArapiles);
            }
        }
        String pharmacyId = getPropertiesList().get(pharmacyKey).getProperty(KeyValueImmClient.PHARMACY_ID.getValue());
        String pharmacySWType = getPropertiesList().get(pharmacyKey).getProperty(KeyValueImmClient.PHARMACY_SW_TYPE.getValue());
        String mqServerHost = getPropertiesList().get(pharmacyKey).getProperty(KeyValueImmClient.MQ_SERVER_HOST.getValue());
        String mqServerPort = getPropertiesList().get(pharmacyKey).getProperty(KeyValueImmClient.MQ_SERVER_PORT.getValue());
        String mqServerUser = getPropertiesList().get(pharmacyKey).getProperty(KeyValueImmClient.MQ_SERVER_USER.getValue());
        String mqServerPwd =  getPropertiesList().get(pharmacyKey).getProperty(KeyValueImmClient.MQ_SERVER_PWD.getValue());
        MqServerDTO mqServerDTO = new MqServerDTO(mqServerHost, mqServerPort,mqServerUser,mqServerPwd);
        IimClientDTO immClientDTO = new IimClientDTO(pharmacyKey, pharmacyId, pharmacySWType, mqServerDTO);
        return immClientDTO;
    }

    private static Hashtable<String, Properties> getPropertiesList() {
        return propertiesList;
    }

    private static void setPropertiesList(Hashtable<String, Properties> propertiesList) {
        IimClientManagement.propertiesList = propertiesList;
    }
}