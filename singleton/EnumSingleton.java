package singleton;

public enum EnumSingleton {
    INSTANCE;

    private String configValue;

    public void setConfigValue(String value) {
        this.configValue = value;
    }

    public String getConfigValue() {
        return configValue;
    }
}