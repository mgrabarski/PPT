package mateusz.grabarski.businesslogiclayer.models;

import mateusz.grabarski.businesslogiclayer.models.scores.Gsmrs;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Scores {

    private Gsmrs gsmrs;

    public Scores() {
    }

    public Scores(Gsmrs gsmrs) {
        this.gsmrs = gsmrs;
    }

    public Gsmrs getGsmrs() {
        return gsmrs;
    }

    public void setGsmrs(Gsmrs gsmrs) {
        this.gsmrs = gsmrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scores)) return false;

        Scores scores = (Scores) o;

        return getGsmrs() != null ? getGsmrs().equals(scores.getGsmrs()) : scores.getGsmrs() == null;

    }

    @Override
    public int hashCode() {
        return getGsmrs() != null ? getGsmrs().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "gsmrs=" + gsmrs +
                '}';
    }
}
