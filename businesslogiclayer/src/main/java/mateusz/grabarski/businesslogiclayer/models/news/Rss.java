package mateusz.grabarski.businesslogiclayer.models.news;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class Rss {

    private Channel channel;
    private String version;

    public Rss() {
    }

    public Rss(Channel channel, String version) {
        this.channel = channel;
        this.version = version;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rss)) return false;

        Rss rss = (Rss) o;

        if (getChannel() != null ? !getChannel().equals(rss.getChannel()) : rss.getChannel() != null)
            return false;
        return getVersion() != null ? getVersion().equals(rss.getVersion()) : rss.getVersion() == null;

    }

    @Override
    public int hashCode() {
        int result = getChannel() != null ? getChannel().hashCode() : 0;
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rss{" +
                "channel=" + channel +
                ", version='" + version + '\'' +
                '}';
    }
}
