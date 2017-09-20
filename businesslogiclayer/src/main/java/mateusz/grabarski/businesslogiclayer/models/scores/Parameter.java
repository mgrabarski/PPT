package mateusz.grabarski.businesslogiclayer.models.scores;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Parameter {

    public static final String PARAMETER_DATE = "date";
    public static final String PARAMETER_DETAILED = "detailed";
    public static final String PARAMETER_ID = "id";
    public static final String PARAMETER_LANG = "lang";
    public static final String PARAMETER_MINUTES = "minutes";
    public static final String PARAMETER_NOW_PLAYING = "now_playing";
    public static final String PARAMETER_TYPE = "type";

    private String name;
    private String value;

    public Parameter() {
    }

    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parameter)) return false;

        Parameter parameter = (Parameter) o;

        if (getName() != null ? !getName().equals(parameter.getName()) : parameter.getName() != null)
            return false;
        return getValue() != null ? getValue().equals(parameter.getValue()) : parameter.getValue() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
