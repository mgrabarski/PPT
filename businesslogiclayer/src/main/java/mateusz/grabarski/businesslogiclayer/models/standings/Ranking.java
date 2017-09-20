package mateusz.grabarski.businesslogiclayer.models.standings;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Ranking {

    private int matchesTotal;
    private int matchesDraw;
    private long areaId;
    private String countryCode;
    private int matchesLost;
    private int lastRank;
    private int matchesWon;
    private int rank;
    private String goalsAgainst;
    private String clubName;
    private String zoneStart;
    private int goalsPro;
    private int points;
    private long teamId;

    public Ranking() {
    }

    public Ranking(int matchesTotal, int matchesDraw, long areaId, String countryCode, int matchesLost, int lastRank, int matchesWon, int rank, String goalsAgainst, String clubName, String zoneStart, int goalsPro, int points, long teamId) {
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

    public int getMatchesTotal() {
        return matchesTotal;
    }

    public void setMatchesTotal(int matchesTotal) {
        this.matchesTotal = matchesTotal;
    }

    public int getMatchesDraw() {
        return matchesDraw;
    }

    public void setMatchesDraw(int matchesDraw) {
        this.matchesDraw = matchesDraw;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getLastRank() {
        return lastRank;
    }

    public void setLastRank(int lastRank) {
        this.lastRank = lastRank;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
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

    public int getGoalsPro() {
        return goalsPro;
    }

    public void setGoalsPro(int goalsPro) {
        this.goalsPro = goalsPro;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranking)) return false;

        Ranking ranking = (Ranking) o;

        if (getMatchesTotal() != ranking.getMatchesTotal()) return false;
        if (getMatchesDraw() != ranking.getMatchesDraw()) return false;
        if (getAreaId() != ranking.getAreaId()) return false;
        if (getMatchesLost() != ranking.getMatchesLost()) return false;
        if (getLastRank() != ranking.getLastRank()) return false;
        if (getMatchesWon() != ranking.getMatchesWon()) return false;
        if (getRank() != ranking.getRank()) return false;
        if (getGoalsPro() != ranking.getGoalsPro()) return false;
        if (getPoints() != ranking.getPoints()) return false;
        if (getTeamId() != ranking.getTeamId()) return false;
        if (getCountryCode() != null ? !getCountryCode().equals(ranking.getCountryCode()) : ranking.getCountryCode() != null)
            return false;
        if (getGoalsAgainst() != null ? !getGoalsAgainst().equals(ranking.getGoalsAgainst()) : ranking.getGoalsAgainst() != null)
            return false;
        if (getClubName() != null ? !getClubName().equals(ranking.getClubName()) : ranking.getClubName() != null)
            return false;
        return getZoneStart() != null ? getZoneStart().equals(ranking.getZoneStart()) : ranking.getZoneStart() == null;

    }

    @Override
    public int hashCode() {
        int result = getMatchesTotal();
        result = 31 * result + getMatchesDraw();
        result = 31 * result + (int) (getAreaId() ^ (getAreaId() >>> 32));
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        result = 31 * result + getMatchesLost();
        result = 31 * result + getLastRank();
        result = 31 * result + getMatchesWon();
        result = 31 * result + getRank();
        result = 31 * result + (getGoalsAgainst() != null ? getGoalsAgainst().hashCode() : 0);
        result = 31 * result + (getClubName() != null ? getClubName().hashCode() : 0);
        result = 31 * result + (getZoneStart() != null ? getZoneStart().hashCode() : 0);
        result = 31 * result + getGoalsPro();
        result = 31 * result + getPoints();
        result = 31 * result + (int) (getTeamId() ^ (getTeamId() >>> 32));
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
