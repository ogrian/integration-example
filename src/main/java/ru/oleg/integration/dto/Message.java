package ru.oleg.integration.dto;

public class Message {

    private Object data;

    private Object sourceData;

    private Settings settings;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getSourceData() {
        return sourceData;
    }

    public void setSourceData(Object sourceData) {
        this.sourceData = sourceData;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message message = (Message) o;
        return data.equals(message.data) && sourceData.equals(message.sourceData) && settings.equals(message.settings);
    }

    @Override
    public int hashCode() {
        int result = data.hashCode();
        result = 31 * result + sourceData.hashCode();
        result = 31 * result + settings.hashCode();
        return result;
    }

}
