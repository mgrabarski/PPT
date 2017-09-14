package mateusz.grabarski.businesslogiclayer.models.standings;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Competition {

    private String areaId;
    private String soccerType;
    private Season season;
    private String name;
    private String areaName;
    private String competitionId;
    private String teamType;
    private String lastUpdated;
    private String type;
    private String displayOrder;

    public Competition() {
    }

    public Competition(String areaId, String soccerType, Season season, String name, String areaName, String competitionId, String teamType, String lastUpdated, String type, String displayOrder) {
        this.areaId = areaId;
        this.soccerType = soccerType;
        this.season = season;
        this.name = name;
        this.areaName = areaName;
        this.competitionId = competitionId;
        this.teamType = teamType;
        this.lastUpdated = lastUpdated;
        this.type = type;
        this.displayOrder = displayOrder;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getSoccerType() {
        return soccerType;
    }

    public void setSoccerType(String soccerType) {
        this.soccerType = soccerType;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Competition)) return false;

        Competition that = (Competition) o;

        if (getAreaId() != null ? !getAreaId().equals(that.getAreaId()) : that.getAreaId() != null)
            return false;
        if (getSoccerType() != null ? !getSoccerType().equals(that.getSoccerType()) : that.getSoccerType() != null)
            return false;
        if (getSeason() != null ? !getSeason().equals(that.getSeason()) : that.getSeason() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        if (getAreaName() != null ? !getAreaName().equals(that.getAreaName()) : that.getAreaName() != null)
            return false;
        if (getCompetitionId() != null ? !getCompetitionId().equals(that.getCompetitionId()) : that.getCompetitionId() != null)
            return false;
        if (getTeamType() != null ? !getTeamType().equals(that.getTeamType()) : that.getTeamType() != null)
            return false;
        if (getLastUpdated() != null ? !getLastUpdated().equals(that.getLastUpdated()) : that.getLastUpdated() != null)
            return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null)
            return false;
        return getDisplayOrder() != null ? getDisplayOrder().equals(that.getDisplayOrder()) : that.getDisplayOrder() == null;

    }

    @Override
    public int hashCode() {
        int result = getAreaId() != null ? getAreaId().hashCode() : 0;
        result = 31 * result + (getSoccerType() != null ? getSoccerType().hashCode() : 0);
        result = 31 * result + (getSeason() != null ? getSeason().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAreaName() != null ? getAreaName().hashCode() : 0);
        result = 31 * result + (getCompetitionId() != null ? getCompetitionId().hashCode() : 0);
        result = 31 * result + (getTeamType() != null ? getTeamType().hashCode() : 0);
        result = 31 * result + (getLastUpdated() != null ? getLastUpdated().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDisplayOrder() != null ? getDisplayOrder().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "areaId='" + areaId + '\'' +
                ", soccerType='" + soccerType + '\'' +
                ", season=" + season +
                ", name='" + name + '\'' +
                ", areaName='" + areaName + '\'' +
                ", competitionId='" + competitionId + '\'' +
                ", teamType='" + teamType + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", type='" + type + '\'' +
                ", displayOrder='" + displayOrder + '\'' +
                '}';
    }
}
