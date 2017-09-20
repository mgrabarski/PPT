package mateusz.grabarski.businesslogiclayer.models.news;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class Channel {

    private String pubDate;
    private String title;
    private List<String> category;
    private String description;
    private String link;
    private List<Item> item;
    private String language;

    public Channel() {
        category = new ArrayList<>();
        item = new ArrayList<>();
    }

    public Channel(String pubDate, String title, List<String> category, String description, String link, List<Item> item, String language) {
        this.pubDate = pubDate;
        this.title = title;
        this.category = category;
        this.description = description;
        this.link = link;
        this.item = item;
        this.language = language;
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

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
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

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Channel)) return false;

        Channel channel = (Channel) o;

        if (getPubDate() != null ? !getPubDate().equals(channel.getPubDate()) : channel.getPubDate() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(channel.getTitle()) : channel.getTitle() != null)
            return false;
        if (getCategory() != null ? !getCategory().equals(channel.getCategory()) : channel.getCategory() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(channel.getDescription()) : channel.getDescription() != null)
            return false;
        if (getLink() != null ? !getLink().equals(channel.getLink()) : channel.getLink() != null)
            return false;
        if (getItem() != null ? !getItem().equals(channel.getItem()) : channel.getItem() != null)
            return false;
        return getLanguage() != null ? getLanguage().equals(channel.getLanguage()) : channel.getLanguage() == null;
    }

    @Override
    public int hashCode() {
        int result = getPubDate() != null ? getPubDate().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getLink() != null ? getLink().hashCode() : 0);
        result = 31 * result + (getItem() != null ? getItem().hashCode() : 0);
        result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", item=" + item +
                ", language='" + language + '\'' +
                '}';
    }
}
