package mateusz.grabarski.businesslogiclayer.models.news;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class Enclosure {

    private String length;
    private String type;
    private String url;

    public Enclosure() {
    }

    public Enclosure(String length, String type, String url) {
        this.length = length;
        this.type = type;
        this.url = url;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enclosure)) return false;

        Enclosure enclosure = (Enclosure) o;

        if (getLength() != null ? !getLength().equals(enclosure.getLength()) : enclosure.getLength() != null)
            return false;
        if (getType() != null ? !getType().equals(enclosure.getType()) : enclosure.getType() != null)
            return false;
        return getUrl() != null ? getUrl().equals(enclosure.getUrl()) : enclosure.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getLength() != null ? getLength().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Enclosure{" +
                "length='" + length + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
