package ru.oleg.integration.dto;

import java.util.Objects;

public class InputMessageData {

    private String strField;
    private int intField;

    public String getStrField() {
        return strField;
    }

    public void setStrField(String strField) {
        this.strField = strField;
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InputMessageData that = (InputMessageData) o;
        return intField == that.intField && Objects.equals(strField, that.strField);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(strField);
        result = 31 * result + intField;
        return result;
    }

}
