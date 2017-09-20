package mateusz.grabarski.businesslogiclayer.models.scores;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Round {

    private String endDate;
    private String roundId;
    private String name;
    private String lastUpdated;
    private String type;
    private List<Group> group;
    private String startDate;
    private String groups;
    private String hasOutGroupMatches;

    public Round() {
        group = new ArrayList<>();
    }

    public Round(String endDate, String roundId, String name, String lastUpdated, String type, List<Group> group, String startDate, String groups, String hasOutGroupMatches) {
        this.endDate = endDate;
        this.roundId = roundId;
        this.name = name;
        this.lastUpdated = lastUpdated;
        this.type = type;
        this.group = group;
        this.startDate = startDate;
        this.groups = groups;
        this.hasOutGroupMatches = hasOutGroupMatches;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getHasOutGroupMatches() {
        return hasOutGroupMatches;
    }

    public void setHasOutGroupMatches(String hasOutGroupMatches) {
        this.hasOutGroupMatches = hasOutGroupMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Round)) return false;

        Round round = (Round) o;

        if (getEndDate() != null ? !getEndDate().equals(round.getEndDate()) : round.getEndDate() != null)
            return false;
        if (getRoundId() != null ? !getRoundId().equals(round.getRoundId()) : round.getRoundId() != null)
            return false;
        if (getName() != null ? !getName().equals(round.getName()) : round.getName() != null)
            return false;
        if (getLastUpdated() != null ? !getLastUpdated().equals(round.getLastUpdated()) : round.getLastUpdated() != null)
            return false;
        if (getType() != null ? !getType().equals(round.getType()) : round.getType() != null)
            return false;
        if (getGroup() != null ? !getGroup().equals(round.getGroup()) : round.getGroup() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(round.getStartDate()) : round.getStartDate() != null)
            return false;
        if (getGroups() != null ? !getGroups().equals(round.getGroups()) : round.getGroups() != null)
            return false;
        return getHasOutGroupMatches() != null ? getHasOutGroupMatches().equals(round.getHasOutGroupMatches()) : round.getHasOutGroupMatches() == null;

    }

    @Override
    public int hashCode() {
        int result = getEndDate() != null ? getEndDate().hashCode() : 0;
        result = 31 * result + (getRoundId() != null ? getRoundId().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastUpdated() != null ? getLastUpdated().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getGroup() != null ? getGroup().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getGroups() != null ? getGroups().hashCode() : 0);
        result = 31 * result + (getHasOutGroupMatches() != null ? getHasOutGroupMatches().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Round{" +
                "endDate='" + endDate + '\'' +
                ", roundId='" + roundId + '\'' +
                ", name='" + name + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", type='" + type + '\'' +
                ", group=" + group +
                ", startDate='" + startDate + '\'' +
                ", groups='" + groups + '\'' +
                ", hasOutGroupMatches='" + hasOutGroupMatches + '\'' +
                '}';
    }
}
