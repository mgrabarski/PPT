package mateusz.grabarski.businesslogiclayer.models.scores;

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

        if (areaId != null ? !areaId.equals(that.areaId) : that.areaId != null) return false;
        if (soccerType != null ? !soccerType.equals(that.soccerType) : that.soccerType != null)
            return false;
        if (season != null ? !season.equals(that.season) : that.season != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (areaName != null ? !areaName.equals(that.areaName) : that.areaName != null)
            return false;
        if (competitionId != null ? !competitionId.equals(that.competitionId) : that.competitionId != null)
            return false;
        if (teamType != null ? !teamType.equals(that.teamType) : that.teamType != null)
            return false;
        if (lastUpdated != null ? !lastUpdated.equals(that.lastUpdated) : that.lastUpdated != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return displayOrder != null ? displayOrder.equals(that.displayOrder) : that.displayOrder == null;

    }

    @Override
    public int hashCode() {
        int result = areaId != null ? areaId.hashCode() : 0;
        result = 31 * result + (soccerType != null ? soccerType.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (competitionId != null ? competitionId.hashCode() : 0);
        result = 31 * result + (teamType != null ? teamType.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (displayOrder != null ? displayOrder.hashCode() : 0);
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
