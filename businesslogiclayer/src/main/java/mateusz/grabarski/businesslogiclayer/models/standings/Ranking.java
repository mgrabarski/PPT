package mateusz.grabarski.businesslogiclayer.models.standings;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Ranking {

    private String matchesTotal;
    private String matchesDraw;
    private String areaId;
    private String countryCode;
    private String matchesLost;
    private String lastRank;
    private String matchesWon;
    private String rank;
    private String goalsAgainst;
    private String clubName;
    private String zoneStart;
    private String goalsPro;
    private String points;
    private String teamId;

    public Ranking() {
    }

    public Ranking(String matchesTotal, String matchesDraw, String areaId, String countryCode, String matchesLost, String lastRank, String matchesWon, String rank, String goalsAgainst, String clubName, String zoneStart, String goalsPro, String points, String teamId) {
        this.matchesTotal = matchesTotal;
        this.matchesDraw = matchesDraw;
        this.areaId = areaId;
        this.countryCode = countryCode;
        this.matchesLost = matchesLost;
        this.lastRank = lastRank;
        this.matchesWon = matchesWon;
        this.rank = rank;
        this.goalsAgainst = goalsAgainst;
        this.clubName = clubName;
        this.zoneStart = zoneStart;
        this.goalsPro = goalsPro;
        this.points = points;
        this.teamId = teamId;
    }

    public String getMatchesTotal() {
        return matchesTotal;
    }

    public void setMatchesTotal(String matchesTotal) {
        this.matchesTotal = matchesTotal;
    }

    public String getMatchesDraw() {
        return matchesDraw;
    }

    public void setMatchesDraw(String matchesDraw) {
        this.matchesDraw = matchesDraw;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(String matchesLost) {
        this.matchesLost = matchesLost;
    }

    public String getLastRank() {
        return lastRank;
    }

    public void setLastRank(String lastRank) {
        this.lastRank = lastRank;
    }

    public String getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(String matchesWon) {
        this.matchesWon = matchesWon;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(String goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getZoneStart() {
        return zoneStart;
    }

    public void setZoneStart(String zoneStart) {
        this.zoneStart = zoneStart;
    }

    public String getGoalsPro() {
        return goalsPro;
    }

    public void setGoalsPro(String goalsPro) {
        this.goalsPro = goalsPro;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranking)) return false;

        Ranking ranking = (Ranking) o;

        if (getMatchesTotal() != null ? !getMatchesTotal().equals(ranking.getMatchesTotal()) : ranking.getMatchesTotal() != null)
            return false;
        if (getMatchesDraw() != null ? !getMatchesDraw().equals(ranking.getMatchesDraw()) : ranking.getMatchesDraw() != null)
            return false;
        if (getAreaId() != null ? !getAreaId().equals(ranking.getAreaId()) : ranking.getAreaId() != null)
            return false;
        if (getCountryCode() != null ? !getCountryCode().equals(ranking.getCountryCode()) : ranking.getCountryCode() != null)
            return false;
        if (getMatchesLost() != null ? !getMatchesLost().equals(ranking.getMatchesLost()) : ranking.getMatchesLost() != null)
            return false;
        if (getLastRank() != null ? !getLastRank().equals(ranking.getLastRank()) : ranking.getLastRank() != null)
            return false;
        if (getMatchesWon() != null ? !getMatchesWon().equals(ranking.getMatchesWon()) : ranking.getMatchesWon() != null)
            return false;
        if (getRank() != null ? !getRank().equals(ranking.getRank()) : ranking.getRank() != null)
            return false;
        if (getGoalsAgainst() != null ? !getGoalsAgainst().equals(ranking.getGoalsAgainst()) : ranking.getGoalsAgainst() != null)
            return false;
        if (getClubName() != null ? !getClubName().equals(ranking.getClubName()) : ranking.getClubName() != null)
            return false;
        if (getZoneStart() != null ? !getZoneStart().equals(ranking.getZoneStart()) : ranking.getZoneStart() != null)
            return false;
        if (getGoalsPro() != null ? !getGoalsPro().equals(ranking.getGoalsPro()) : ranking.getGoalsPro() != null)
            return false;
        if (getPoints() != null ? !getPoints().equals(ranking.getPoints()) : ranking.getPoints() != null)
            return false;
        return getTeamId() != null ? getTeamId().equals(ranking.getTeamId()) : ranking.getTeamId() == null;

    }

    @Override
    public int hashCode() {
        int result = getMatchesTotal() != null ? getMatchesTotal().hashCode() : 0;
        result = 31 * result + (getMatchesDraw() != null ? getMatchesDraw().hashCode() : 0);
        result = 31 * result + (getAreaId() != null ? getAreaId().hashCode() : 0);
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        result = 31 * result + (getMatchesLost() != null ? getMatchesLost().hashCode() : 0);
        result = 31 * result + (getLastRank() != null ? getLastRank().hashCode() : 0);
        result = 31 * result + (getMatchesWon() != null ? getMatchesWon().hashCode() : 0);
        result = 31 * result + (getRank() != null ? getRank().hashCode() : 0);
        result = 31 * result + (getGoalsAgainst() != null ? getGoalsAgainst().hashCode() : 0);
        result = 31 * result + (getClubName() != null ? getClubName().hashCode() : 0);
        result = 31 * result + (getZoneStart() != null ? getZoneStart().hashCode() : 0);
        result = 31 * result + (getGoalsPro() != null ? getGoalsPro().hashCode() : 0);
        result = 31 * result + (getPoints() != null ? getPoints().hashCode() : 0);
        result = 31 * result + (getTeamId() != null ? getTeamId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "matchesTotal='" + matchesTotal + '\'' +
                ", matchesDraw='" + matchesDraw + '\'' +
                ", areaId='" + areaId + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", matchesLost='" + matchesLost + '\'' +
                ", lastRank='" + lastRank + '\'' +
                ", matchesWon='" + matchesWon + '\'' +
                ", rank='" + rank + '\'' +
                ", goalsAgainst='" + goalsAgainst + '\'' +
                ", clubName='" + clubName + '\'' +
                ", zoneStart='" + zoneStart + '\'' +
                ", goalsPro='" + goalsPro + '\'' +
                ", points='" + points + '\'' +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}
