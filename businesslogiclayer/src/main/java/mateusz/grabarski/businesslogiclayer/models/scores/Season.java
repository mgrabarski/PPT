package mateusz.grabarski.businesslogiclayer.models.scores;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Season {

    private String endDate;
    private String name;
    private String seasonId;
    private String lastUpdated;
    private Round round;
    private String startDate;
    private String serviceLevel;

    public Season() {
    }

    public Season(String endDate, String name, String seasonId, String lastUpdated, Round round, String startDate, String serviceLevel) {
        this.endDate = endDate;
        this.name = name;
        this.seasonId = seasonId;
        this.lastUpdated = lastUpdated;
        this.round = round;
        this.startDate = startDate;
        this.serviceLevel = serviceLevel;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Season)) return false;

        Season season = (Season) o;

        if (getEndDate() != null ? !getEndDate().equals(season.getEndDate()) : season.getEndDate() != null)
            return false;
        if (getName() != null ? !getName().equals(season.getName()) : season.getName() != null)
            return false;
        if (getSeasonId() != null ? !getSeasonId().equals(season.getSeasonId()) : season.getSeasonId() != null)
            return false;
        if (getLastUpdated() != null ? !getLastUpdated().equals(season.getLastUpdated()) : season.getLastUpdated() != null)
            return false;
        if (getRound() != null ? !getRound().equals(season.getRound()) : season.getRound() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(season.getStartDate()) : season.getStartDate() != null)
            return false;
        return getServiceLevel() != null ? getServiceLevel().equals(season.getServiceLevel()) : season.getServiceLevel() == null;

    }

    @Override
    public int hashCode() {
        int result = getEndDate() != null ? getEndDate().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSeasonId() != null ? getSeasonId().hashCode() : 0);
        result = 31 * result + (getLastUpdated() != null ? getLastUpdated().hashCode() : 0);
        result = 31 * result + (getRound() != null ? getRound().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getServiceLevel() != null ? getServiceLevel().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Season{" +
                "endDate='" + endDate + '\'' +
                ", name='" + name + '\'' +
                ", seasonId='" + seasonId + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", round=" + round +
                ", startDate='" + startDate + '\'' +
                ", serviceLevel='" + serviceLevel + '\'' +
                '}';
    }
}
