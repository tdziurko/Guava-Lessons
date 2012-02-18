package pl.tomaszdziurko.guava.geo;

public enum Continent {

    EUROPE("Europe"),
    ASIA("Asia"),
    AFRICA("Africa"),
    SOUTH_AMERICA("South America"),
    NORTH_AMERICA("North America"),
    AUSTRALIA_OCEANIA("Australia and Oceania");
    private String label;

    Continent(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}