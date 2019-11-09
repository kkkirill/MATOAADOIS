package com.kukhotskovolets.lab.model.submodel;

public class Area {
    public enum FieldNamesXmlSync {
        AREA("area"),
        UNITS("units");

        private final String xmlName;

        FieldNamesXmlSync(String xmlName) {
            this.xmlName = xmlName;
        }

        public String getXmlName() {
            return xmlName;
        }
    }
    private long areaSize;
    private String areaUnits;

    public Area(long areaSize, String areaUnits) {
        this.areaSize = areaSize;
        this.areaUnits = areaUnits;
    }

    public long getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(long areaSize) {
        this.areaSize = areaSize;
    }

    public String getAreaUnits() {
        return areaUnits;
    }

    public void setAreaUnits(String areaUnits) {
        this.areaUnits = areaUnits;
    }
}
