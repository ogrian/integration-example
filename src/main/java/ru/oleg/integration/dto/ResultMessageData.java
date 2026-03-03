package ru.oleg.integration.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultMessageData {

    private List<String> strings = new ArrayList<>();

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ResultMessageData that = (ResultMessageData) o;
        return Objects.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(strings);
    }

}
