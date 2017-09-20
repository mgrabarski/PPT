package mateusz.grabarski.businesslogiclayer.models.scores;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Gsmrs {

    private String lastGenerated;
    private String sport;
    private Method method;
    private String lang;
    private String version;
    private Competition competition;

    public Gsmrs() {
    }

    public Gsmrs(String lastGenerated, String sport, Method method, String lang, String version, Competition competition) {
        this.lastGenerated = lastGenerated;
        this.sport = sport;
        this.method = method;
        this.lang = lang;
        this.version = version;
        this.competition = competition;
    }

    public String getLastGenerated() {
        return lastGenerated;
    }

    public void setLastGenerated(String lastGenerated) {
        this.lastGenerated = lastGenerated;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gsmrs)) return false;

        Gsmrs gsmrs = (Gsmrs) o;

        if (getLastGenerated() != null ? !getLastGenerated().equals(gsmrs.getLastGenerated()) : gsmrs.getLastGenerated() != null)
            return false;
        if (getSport() != null ? !getSport().equals(gsmrs.getSport()) : gsmrs.getSport() != null)
            return false;
        if (getMethod() != null ? !getMethod().equals(gsmrs.getMethod()) : gsmrs.getMethod() != null)
            return false;
        if (getLang() != null ? !getLang().equals(gsmrs.getLang()) : gsmrs.getLang() != null)
            return false;
        if (getVersion() != null ? !getVersion().equals(gsmrs.getVersion()) : gsmrs.getVersion() != null)
            return false;
        return getCompetition() != null ? getCompetition().equals(gsmrs.getCompetition()) : gsmrs.getCompetition() == null;

    }

    @Override
    public int hashCode() {
        int result = getLastGenerated() != null ? getLastGenerated().hashCode() : 0;
        result = 31 * result + (getSport() != null ? getSport().hashCode() : 0);
        result = 31 * result + (getMethod() != null ? getMethod().hashCode() : 0);
        result = 31 * result + (getLang() != null ? getLang().hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getCompetition() != null ? getCompetition().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Gsmrs{" +
                "lastGenerated='" + lastGenerated + '\'' +
                ", sport='" + sport + '\'' +
                ", method=" + method +
                ", lang='" + lang + '\'' +
                ", version='" + version + '\'' +
                ", competition=" + competition +
                '}';
    }
}
