package ru.oleg.integration.dto;

import java.util.Objects;

public class SplitMessageData {

    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SplitMessageData that = (SplitMessageData) o;
        return number == that.number && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

}
