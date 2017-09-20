package mateusz.grabarski.businesslogiclayer.models.scores;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Match {

    private String time_utc;
    private String teamBId;
    private String dateUtc;
    private String teamBName;
    private String teamBCountry;
    private String fsB;
    private String psA;
    private String teamAName;
    private String gameWeek;
    private String status;
    private String etsB;
    private String dateLondon;
    private String matchId;
    private String etsA;
    private String psB;
    private String winner;
    private String teamACountry;
    private String timeLondon;
    private String htsB;
    private String htsA;
    private String teamAId;
    private String lastUpdated;
    private String fsA;

    public Match() {
    }

    public Match(String time_utc, String teamBId, String dateUtc, String teamBName, String teamBCountry, String fsB, String psA, String teamAName, String gameWeek, String status, String etsB, String dateLondon, String matchId, String etsA, String psB, String winner, String teamACountry, String timeLondon, String htsB, String htsA, String teamAId, String lastUpdated, String fsA) {
        this.time_utc = time_utc;
        this.teamBId = teamBId;
        this.dateUtc = dateUtc;
        this.teamBName = teamBName;
        this.teamBCountry = teamBCountry;
        this.fsB = fsB;
        this.psA = psA;
        this.teamAName = teamAName;
        this.gameWeek = gameWeek;
        this.status = status;
        this.etsB = etsB;
        this.dateLondon = dateLondon;
        this.matchId = matchId;
        this.etsA = etsA;
        this.psB = psB;
        this.winner = winner;
        this.teamACountry = teamACountry;
        this.timeLondon = timeLondon;
        this.htsB = htsB;
        this.htsA = htsA;
        this.teamAId = teamAId;
        this.lastUpdated = lastUpdated;
        this.fsA = fsA;
    }

    public String getTime_utc() {
        return time_utc;
    }

    public void setTime_utc(String time_utc) {
        this.time_utc = time_utc;
    }

    public String getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(String teamBId) {
        this.teamBId = teamBId;
    }

    public String getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(String dateUtc) {
        this.dateUtc = dateUtc;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public String getTeamBCountry() {
        return teamBCountry;
    }

    public void setTeamBCountry(String teamBCountry) {
        this.teamBCountry = teamBCountry;
    }

    public String getFsB() {
        return fsB;
    }

    public void setFsB(String fsB) {
        this.fsB = fsB;
    }

    public String getPsA() {
        return psA;
    }

    public void setPsA(String psA) {
        this.psA = psA;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public String getGameWeek() {
        return gameWeek;
    }

    public void setGameWeek(String gameWeek) {
        this.gameWeek = gameWeek;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEtsB() {
        return etsB;
    }

    public void setEtsB(String etsB) {
        this.etsB = etsB;
    }

    public String getDateLondon() {
        return dateLondon;
    }

    public void setDateLondon(String dateLondon) {
        this.dateLondon = dateLondon;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getEtsA() {
        return etsA;
    }

    public void setEtsA(String etsA) {
        this.etsA = etsA;
    }

    public String getPsB() {
        return psB;
    }

    public void setPsB(String psB) {
        this.psB = psB;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getTeamACountry() {
        return teamACountry;
    }

    public void setTeamACountry(String teamACountry) {
        this.teamACountry = teamACountry;
    }

    public String getTimeLondon() {
        return timeLondon;
    }

    public void setTimeLondon(String timeLondon) {
        this.timeLondon = timeLondon;
    }

    public String getHtsB() {
        return htsB;
    }

    public void setHtsB(String htsB) {
        this.htsB = htsB;
    }

    public String getHtsA() {
        return htsA;
    }

    public void setHtsA(String htsA) {
        this.htsA = htsA;
    }

    public String getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(String teamAId) {
        this.teamAId = teamAId;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getFsA() {
        return fsA;
    }

    public void setFsA(String fsA) {
        this.fsA = fsA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;

        Match match = (Match) o;

        if (getTime_utc() != null ? !getTime_utc().equals(match.getTime_utc()) : match.getTime_utc() != null)
            return false;
        if (getTeamBId() != null ? !getTeamBId().equals(match.getTeamBId()) : match.getTeamBId() != null)
            return false;
        if (getDateUtc() != null ? !getDateUtc().equals(match.getDateUtc()) : match.getDateUtc() != null)
            return false;
        if (getTeamBName() != null ? !getTeamBName().equals(match.getTeamBName()) : match.getTeamBName() != null)
            return false;
        if (getTeamBCountry() != null ? !getTeamBCountry().equals(match.getTeamBCountry()) : match.getTeamBCountry() != null)
            return false;
        if (getFsB() != null ? !getFsB().equals(match.getFsB()) : match.getFsB() != null)
            return false;
        if (getPsA() != null ? !getPsA().equals(match.getPsA()) : match.getPsA() != null)
            return false;
        if (getTeamAName() != null ? !getTeamAName().equals(match.getTeamAName()) : match.getTeamAName() != null)
            return false;
        if (getGameWeek() != null ? !getGameWeek().equals(match.getGameWeek()) : match.getGameWeek() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(match.getStatus()) : match.getStatus() != null)
            return false;
        if (getEtsB() != null ? !getEtsB().equals(match.getEtsB()) : match.getEtsB() != null)
            return false;
        if (getDateLondon() != null ? !getDateLondon().equals(match.getDateLondon()) : match.getDateLondon() != null)
            return false;
        if (getMatchId() != null ? !getMatchId().equals(match.getMatchId()) : match.getMatchId() != null)
            return false;
        if (getEtsA() != null ? !getEtsA().equals(match.getEtsA()) : match.getEtsA() != null)
            return false;
        if (getPsB() != null ? !getPsB().equals(match.getPsB()) : match.getPsB() != null)
            return false;
        if (getWinner() != null ? !getWinner().equals(match.getWinner()) : match.getWinner() != null)
            return false;
        if (getTeamACountry() != null ? !getTeamACountry().equals(match.getTeamACountry()) : match.getTeamACountry() != null)
            return false;
        if (getTimeLondon() != null ? !getTimeLondon().equals(match.getTimeLondon()) : match.getTimeLondon() != null)
            return false;
        if (getHtsB() != null ? !getHtsB().equals(match.getHtsB()) : match.getHtsB() != null)
            return false;
        if (getHtsA() != null ? !getHtsA().equals(match.getHtsA()) : match.getHtsA() != null)
            return false;
        if (getTeamAId() != null ? !getTeamAId().equals(match.getTeamAId()) : match.getTeamAId() != null)
            return false;
        if (getLastUpdated() != null ? !getLastUpdated().equals(match.getLastUpdated()) : match.getLastUpdated() != null)
            return false;
        return getFsA() != null ? getFsA().equals(match.getFsA()) : match.getFsA() == null;

    }

    @Override
    public int hashCode() {
        int result = getTime_utc() != null ? getTime_utc().hashCode() : 0;
        result = 31 * result + (getTeamBId() != null ? getTeamBId().hashCode() : 0);
        result = 31 * result + (getDateUtc() != null ? getDateUtc().hashCode() : 0);
        result = 31 * result + (getTeamBName() != null ? getTeamBName().hashCode() : 0);
        result = 31 * result + (getTeamBCountry() != null ? getTeamBCountry().hashCode() : 0);
        result = 31 * result + (getFsB() != null ? getFsB().hashCode() : 0);
        result = 31 * result + (getPsA() != null ? getPsA().hashCode() : 0);
        result = 31 * result + (getTeamAName() != null ? getTeamAName().hashCode() : 0);
        result = 31 * result + (getGameWeek() != null ? getGameWeek().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getEtsB() != null ? getEtsB().hashCode() : 0);
        result = 31 * result + (getDateLondon() != null ? getDateLondon().hashCode() : 0);
        result = 31 * result + (getMatchId() != null ? getMatchId().hashCode() : 0);
        result = 31 * result + (getEtsA() != null ? getEtsA().hashCode() : 0);
        result = 31 * result + (getPsB() != null ? getPsB().hashCode() : 0);
        result = 31 * result + (getWinner() != null ? getWinner().hashCode() : 0);
        result = 31 * result + (getTeamACountry() != null ? getTeamACountry().hashCode() : 0);
        result = 31 * result + (getTimeLondon() != null ? getTimeLondon().hashCode() : 0);
        result = 31 * result + (getHtsB() != null ? getHtsB().hashCode() : 0);
        result = 31 * result + (getHtsA() != null ? getHtsA().hashCode() : 0);
        result = 31 * result + (getTeamAId() != null ? getTeamAId().hashCode() : 0);
        result = 31 * result + (getLastUpdated() != null ? getLastUpdated().hashCode() : 0);
        result = 31 * result + (getFsA() != null ? getFsA().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "time_utc='" + time_utc + '\'' +
                ", teamBId='" + teamBId + '\'' +
                ", dateUtc='" + dateUtc + '\'' +
                ", teamBName='" + teamBName + '\'' +
                ", teamBCountry='" + teamBCountry + '\'' +
                ", fsB='" + fsB + '\'' +
                ", psA='" + psA + '\'' +
                ", teamAName='" + teamAName + '\'' +
                ", gameWeek='" + gameWeek + '\'' +
                ", status='" + status + '\'' +
                ", etsB='" + etsB + '\'' +
                ", dateLondon='" + dateLondon + '\'' +
                ", matchId='" + matchId + '\'' +
                ", etsA='" + etsA + '\'' +
                ", psB='" + psB + '\'' +
                ", winner='" + winner + '\'' +
                ", teamACountry='" + teamACountry + '\'' +
                ", timeLondon='" + timeLondon + '\'' +
                ", htsB='" + htsB + '\'' +
                ", htsA='" + htsA + '\'' +
                ", teamAId='" + teamAId + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", fsA='" + fsA + '\'' +
                '}';
    }
}
