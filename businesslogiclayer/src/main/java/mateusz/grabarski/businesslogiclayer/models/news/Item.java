package mateusz.grabarski.businesslogiclayer.models.news;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class Item {

    private String guid;
    private String pubDate;
    private String title;
    private String category;
    private Enclosure enclosure;
    private String description;
    private String link;

    public Item() {
    }

    public Item(String guid, String pubDate, String title, String category, Enclosure enclosure, String description, String link) {
        this.guid = guid;
        this.pubDate = pubDate;
        this.title = title;
        this.category = category;
        this.enclosure = enclosure;
        this.description = description;
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (getGuid() != null ? !getGuid().equals(item.getGuid()) : item.getGuid() != null)
            return false;
        if (getPubDate() != null ? !getPubDate().equals(item.getPubDate()) : item.getPubDate() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(item.getTitle()) : item.getTitle() != null)
            return false;
        if (getCategory() != null ? !getCategory().equals(item.getCategory()) : item.getCategory() != null)
            return false;
        if (getEnclosure() != null ? !getEnclosure().equals(item.getEnclosure()) : item.getEnclosure() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(item.getDescription()) : item.getDescription() != null)
            return false;
        return getLink() != null ? getLink().equals(item.getLink()) : item.getLink() == null;

    }

    @Override
    public int hashCode() {
        int result = getGuid() != null ? getGuid().hashCode() : 0;
        result = 31 * result + (getPubDate() != null ? getPubDate().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getEnclosure() != null ? getEnclosure().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getLink() != null ? getLink().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "guid='" + guid + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", enclosure=" + enclosure +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
