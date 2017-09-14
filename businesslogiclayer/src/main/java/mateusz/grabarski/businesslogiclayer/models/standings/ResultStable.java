package mateusz.grabarski.businesslogiclayer.models.standings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class ResultStable {

    private String type;
    private List<Ranking> ranking;

    public ResultStable() {
        ranking = new ArrayList<>();
    }

    public ResultStable(String type, List<Ranking> ranking) {
        this.type = type;
        this.ranking = ranking;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ranking> getRanking() {
        return ranking;
    }

    public void setRanking(List<Ranking> ranking) {
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultStable)) return false;

        ResultStable that = (ResultStable) o;

        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null)
            return false;
        return getRanking() != null ? getRanking().equals(that.getRanking()) : that.getRanking() == null;

    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getRanking() != null ? getRanking().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResultStable{" +
                "type='" + type + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
