package mateusz.grabarski.businesslogiclayer.models;

import mateusz.grabarski.businesslogiclayer.models.news.Rss;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class News {

    private Rss rss;

    public Rss getRss() {
        return rss;
    }

    public void setRss(Rss rss) {
        this.rss = rss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;

        News news = (News) o;

        return getRss() != null ? getRss().equals(news.getRss()) : news.getRss() == null;

    }

    @Override
    public int hashCode() {
        return getRss() != null ? getRss().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "News{" +
                "rss=" + rss +
                '}';
    }
}
