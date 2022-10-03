public enum Applience {
    REFRIGERATOR("Refrigerator"),
    KETTLE("Kettle"),
    MICROWAVE("Microwave"),
    COFFEEMACHINE("CoffeMachine"),
    DISHWASHER("Dishwasher");

    private String appName;
    Applience(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return this.appName;
    }
}
