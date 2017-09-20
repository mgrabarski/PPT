package mateusz.grabarski.businesslogiclayer.models.standings;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Root {

    private String lastGenerated;
    private String sport;
    private Method method;
    private String lang;
    private String version;
    private Competition competition;

    public Root() {
    }

    public Root(String lastGenerated, String sport, Method method, String lang, String version, Competition competition) {
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
        if (!(o instanceof Root)) return false;

        Root root = (Root) o;

        if (getLastGenerated() != null ? !getLastGenerated().equals(root.getLastGenerated()) : root.getLastGenerated() != null)
            return false;
        if (getSport() != null ? !getSport().equals(root.getSport()) : root.getSport() != null)
            return false;
        if (getMethod() != null ? !getMethod().equals(root.getMethod()) : root.getMethod() != null)
            return false;
        if (getLang() != null ? !getLang().equals(root.getLang()) : root.getLang() != null)
            return false;
        if (getVersion() != null ? !getVersion().equals(root.getVersion()) : root.getVersion() != null)
            return false;
        return getCompetition() != null ? getCompetition().equals(root.getCompetition()) : root.getCompetition() == null;

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
        return "Root{" +
                "lastGenerated='" + lastGenerated + '\'' +
                ", sport='" + sport + '\'' +
                ", method=" + method +
                ", lang='" + lang + '\'' +
                ", version='" + version + '\'' +
                ", competition=" + competition +
                '}';
    }
}
