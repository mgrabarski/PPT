package mateusz.grabarski.businesslogiclayer.models;

import mateusz.grabarski.businesslogiclayer.models.standings.Root;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Standings {

    private Root root;

    public Standings() {
    }

    public Standings(Root root) {
        this.root = root;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Standings)) return false;

        Standings standings = (Standings) o;

        return getRoot() != null ? getRoot().equals(standings.getRoot()) : standings.getRoot() == null;

    }

    @Override
    public int hashCode() {
        return getRoot() != null ? getRoot().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Standings{" +
                "root=" + root +
                '}';
    }
}
