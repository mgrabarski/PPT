package mateusz.grabarski.businesslogiclayer.models.scores;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Group {

    private String details;
    private String name;
    private String groupId;
    private String winner;
    private String lastUpdated;
    private List<Match> match;

    public Group() {
        match = new ArrayList<>();
    }

    public Group(String details, String name, String groupId, String winner, String lastUpdated, List<Match> match) {
        this.details = details;
        this.name = name;
        this.groupId = groupId;
        this.winner = winner;
        this.lastUpdated = lastUpdated;
        this.match = match;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        if (getDetails() != null ? !getDetails().equals(group.getDetails()) : group.getDetails() != null)
            return false;
        if (getName() != null ? !getName().equals(group.getName()) : group.getName() != null)
            return false;
        if (getGroupId() != null ? !getGroupId().equals(group.getGroupId()) : group.getGroupId() != null)
            return false;
        if (getWinner() != null ? !getWinner().equals(group.getWinner()) : group.getWinner() != null)
            return false;
        if (getLastUpdated() != null ? !getLastUpdated().equals(group.getLastUpdated()) : group.getLastUpdated() != null)
            return false;
        return getMatch() != null ? getMatch().equals(group.getMatch()) : group.getMatch() == null;

    }

    @Override
    public int hashCode() {
        int result = getDetails() != null ? getDetails().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGroupId() != null ? getGroupId().hashCode() : 0);
        result = 31 * result + (getWinner() != null ? getWinner().hashCode() : 0);
        result = 31 * result + (getLastUpdated() != null ? getLastUpdated().hashCode() : 0);
        result = 31 * result + (getMatch() != null ? getMatch().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "details='" + details + '\'' +
                ", name='" + name + '\'' +
                ", groupId='" + groupId + '\'' +
                ", winner='" + winner + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", match=" + match +
                '}';
    }
}
