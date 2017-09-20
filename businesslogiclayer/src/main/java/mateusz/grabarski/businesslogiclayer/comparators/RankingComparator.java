package mateusz.grabarski.businesslogiclayer.comparators;

import java.util.Comparator;

import mateusz.grabarski.businesslogiclayer.models.standings.Ranking;

/**
 * Created by Mateusz Grabarski on 18.09.2017.
 */

public class RankingComparator {

    public static Comparator<Ranking> comparatorByRank() {
        return new Comparator<Ranking>() {
            @Override
            public int compare(Ranking ranking1, Ranking ranking2) {
                return ranking1.getRank() - ranking2.getRank();
            }
        };
    }
}
