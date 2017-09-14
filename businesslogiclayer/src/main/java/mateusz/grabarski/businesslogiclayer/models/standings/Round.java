package mateusz.grabarski.businesslogiclayer.models.standings;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Round {

    private String orderMethod;
    private String endDate;
    private String roundId;
    private String name;
    private String type;
    private String startDate;
    private ResultStable resultStable;
    private String groups;
    private String hasOutGroupMatches;

    public Round() {
    }

    public Round(String orderMethod, String endDate, String roundId, String name, String type, String startDate, ResultStable resultStable, String groups, String hasOutGroupMatches) {
        this.orderMethod = orderMethod;
        this.endDate = endDate;
        this.roundId = roundId;
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.resultStable = resultStable;
        this.groups = groups;
        this.hasOutGroupMatches = hasOutGroupMatches;
    }

    public String getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = orderMethod;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ResultStable getResultStable() {
        return resultStable;
    }

    public void setResultStable(ResultStable resultStable) {
        this.resultStable = resultStable;
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

        if (getOrderMethod() != null ? !getOrderMethod().equals(round.getOrderMethod()) : round.getOrderMethod() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(round.getEndDate()) : round.getEndDate() != null)
            return false;
        if (getRoundId() != null ? !getRoundId().equals(round.getRoundId()) : round.getRoundId() != null)
            return false;
        if (getName() != null ? !getName().equals(round.getName()) : round.getName() != null)
            return false;
        if (getType() != null ? !getType().equals(round.getType()) : round.getType() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(round.getStartDate()) : round.getStartDate() != null)
            return false;
        if (getResultStable() != null ? !getResultStable().equals(round.getResultStable()) : round.getResultStable() != null)
            return false;
        if (getGroups() != null ? !getGroups().equals(round.getGroups()) : round.getGroups() != null)
            return false;
        return getHasOutGroupMatches() != null ? getHasOutGroupMatches().equals(round.getHasOutGroupMatches()) : round.getHasOutGroupMatches() == null;

    }

    @Override
    public int hashCode() {
        int result = getOrderMethod() != null ? getOrderMethod().hashCode() : 0;
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getRoundId() != null ? getRoundId().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getResultStable() != null ? getResultStable().hashCode() : 0);
        result = 31 * result + (getGroups() != null ? getGroups().hashCode() : 0);
        result = 31 * result + (getHasOutGroupMatches() != null ? getHasOutGroupMatches().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Round{" +
                "orderMethod='" + orderMethod + '\'' +
                ", endDate='" + endDate + '\'' +
                ", roundId='" + roundId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", startDate='" + startDate + '\'' +
                ", resultStable=" + resultStable +
                ", groups='" + groups + '\'' +
                ", hasOutGroupMatches='" + hasOutGroupMatches + '\'' +
                '}';
    }
}
