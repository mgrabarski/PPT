package mateusz.grabarski.businesslogiclayer.handlers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import mateusz.grabarski.businesslogiclayer.models.Standings;
import mateusz.grabarski.businesslogiclayer.models.standings.Competition;
import mateusz.grabarski.businesslogiclayer.models.standings.Method;
import mateusz.grabarski.businesslogiclayer.models.standings.Parameter;
import mateusz.grabarski.businesslogiclayer.models.standings.Ranking;
import mateusz.grabarski.businesslogiclayer.models.standings.ResultStable;
import mateusz.grabarski.businesslogiclayer.models.standings.Root;
import mateusz.grabarski.businesslogiclayer.models.standings.Round;
import mateusz.grabarski.businesslogiclayer.models.standings.Season;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class StandingsHandler {

    private static final String KEY_METHOD = "method";
    private static final String KEY_METHOD_METHOD_ID = "method_id";
    private static final String KEY_METHOD_NAME = "name";

    private static final String KEY_METHOD_PARAMETER_NAME = "name";
    private static final String KEY_METHOD_PARAMETER_VALUE = "value";

    private static final String KEY_COMPETITION = "competition";
    private static final String KEY_COMPETITION_ID = "competition_id";
    private static final String KEY_COMPETITION_NAME = "name";
    private static final String KEY_COMPETITION_TEAM_TYPE = "teamtype";
    private static final String KEY_COMPETITION_DISPLAY_ORDER = "display_order";
    private static final String KEY_COMPETITION_TYPE = "type";
    private static final String KEY_COMPETITION_AREA_ID = "area_id";
    private static final String KEY_COMPETITION_AREA_NAME = "area_name";
    private static final String KEY_COMPETITION_LAST_UPDATED = "last_updated";
    private static final String KEY_COMPETITION_SOCCER_TYPE = "soccertype";

    private static final String KEY_SEASON = "season";
    private static final String KEY_SEASON_SEASON_ID = "season_id";
    private static final String KEY_SEASON_NAME = "name";
    private static final String KEY_SEASON_START_DATE = "start_date";
    private static final String KEY_SEASON_END_DATE = "end_date";
    private static final String KEY_SEASON_SERVICE_LEVEL = "service_level";
    private static final String KEY_SEASON_LAST_UPDATED = "last_updated";

    private static final String KEY_ROUND = "round";
    private static final String KEY_ROUND_ID = "round_id";
    private static final String KEY_ROUND_NAME = "name";
    private static final String KEY_ROUND_START_DATE = "start_date";
    private static final String KEY_ROUND_END_DATE = "end_date";
    private static final String KEY_ROUND_TYPE = "type";
    private static final String KEY_ROUND_GROUPS = "groups";
    private static final String KEY_ROUND_HAS_OUT_GROUP_MATCHES = "has_outgroup_matches";
    private static final String KEY_ROUND_ORDER_METHOD = "ordermethod";

    private static final String KEY_RESULT_STABLE = "resultstable";
    private static final String KEY_RESULT_STABLE_TYPE ="type";

    private static final String KEY_RANKING = "ranking";
    private static final String KEY_RANKING_RANK = "rank";
    private static final String KEY_RANKING_LAST_RANK = "last_rank";
    private static final String KEY_RANKING_ZONE_START = "zone_start";
    private static final String KEY_RANKING_TEAM_ID = "team_id";
    private static final String KEY_RANKING_CLUB_NAME = "club_name";
    private static final String KEY_RANKING_COUNTRY_CODE = "countrycode";
    private static final String KEY_RANKING_AREA_ID = "area_id";
    private static final String KEY_RANKING_MATCHES_TOTAL = "matches_total";
    private static final String KEY_RANKING_MATCHES_WON = "matches_won";
    private static final String KEY_RANKING_MATCHES_DRAW = "matches_draw";
    private static final String KEY_RANKING_MATCHES_LOST = "matches_lost";
    private static final String KEY_RANKING_GOALS_PRO = "goals_pro";
    private static final String KEY_RANKING_GOALS_AGAINST = "goals_against";
    private static final String KEY_RANKING_POINTS = "points";

    public static Standings parseStanding(String xml) {

        Document doc = getDomElement(xml);

        if (doc != null) {
            Element rootElement = doc.getDocumentElement();
            NodeList nodes = rootElement.getChildNodes();

            return parseStandingXML(nodes);
        }

        return null;
    }

    private static Document getDomElement(String xml) {
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return null;
        }

        return doc;
    }

    private static Standings parseStandingXML(NodeList nodes) {
        Standings standings = new Standings(new Root());

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_METHOD)) {
                    standings.getRoot().setMethod(new Method());

                    standings.getRoot().getMethod().setName(child.getAttribute(KEY_METHOD_METHOD_ID));
                    standings.getRoot().getMethod().setMethodId(child.getAttribute(KEY_METHOD_NAME));
                    standings.getRoot().getMethod().setParameter(parseMethodParameters(child.getChildNodes()));
                } else if (name.equals(KEY_COMPETITION)) {
                    Competition competition = new Competition();
                    competition.setCompetitionId(child.getAttribute(KEY_COMPETITION_ID));
                    competition.setName(child.getAttribute(KEY_COMPETITION_NAME));
                    competition.setTeamType(child.getAttribute(KEY_COMPETITION_TEAM_TYPE));
                    competition.setDisplayOrder(child.getAttribute(KEY_COMPETITION_DISPLAY_ORDER));
                    competition.setType(child.getAttribute(KEY_COMPETITION_TYPE));
                    competition.setAreaId(child.getAttribute(KEY_COMPETITION_AREA_ID));
                    competition.setAreaName(child.getAttribute(KEY_COMPETITION_AREA_NAME));
                    competition.setLastUpdated(child.getAttribute(KEY_COMPETITION_LAST_UPDATED));
                    competition.setSoccerType(child.getAttribute(KEY_COMPETITION_SOCCER_TYPE));

                    standings.getRoot().setCompetition(competition);
                    competition.setSeason(parseSession(child.getChildNodes()));
                }
            }
        }

        return standings;
    }

    private static List<Parameter> parseMethodParameters(NodeList nodes) {
        List<Parameter> parameters = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getAttribute(KEY_METHOD_PARAMETER_NAME);
                String value = child.getAttribute(KEY_METHOD_PARAMETER_VALUE);

                Parameter parameter = new Parameter(name, value);

                parameters.add(parameter);
            }
        }

        return parameters;
    }

    private static Season parseSession(NodeList nodes) {
        Season season = new Season();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_SEASON)) {
                    season.setSeasonId(child.getAttribute(KEY_SEASON_SEASON_ID));
                    season.setName(child.getAttribute(KEY_SEASON_NAME));
                    season.setStartDate(child.getAttribute(KEY_SEASON_START_DATE));
                    season.setEndDate(child.getAttribute(KEY_SEASON_END_DATE));
                    season.setServiceLevel(child.getAttribute(KEY_SEASON_SERVICE_LEVEL));
                    season.setLastUpdated(child.getAttribute(KEY_SEASON_LAST_UPDATED));

                    season.setRound(parseRound(child.getChildNodes()));
                }
            }
        }

        return season;
    }

    private static Round parseRound(NodeList nodes) {
        Round round = new Round();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_ROUND)) {

                    round.setRoundId(child.getAttribute(KEY_ROUND_ID));
                    round.setName(child.getAttribute(KEY_ROUND_NAME));
                    round.setStartDate(child.getAttribute(KEY_ROUND_START_DATE));
                    round.setEndDate(child.getAttribute(KEY_ROUND_END_DATE));
                    round.setType(child.getAttribute(KEY_ROUND_TYPE));
                    round.setOrderMethod(child.getAttribute(KEY_ROUND_ORDER_METHOD));
                    round.setGroups(child.getAttribute(KEY_ROUND_GROUPS));
                    round.setHasOutGroupMatches(child.getAttribute(KEY_ROUND_HAS_OUT_GROUP_MATCHES));
                    round.setResultStable(parseResultStable(child.getChildNodes()));
                }
            }
        }

        return round;
    }

    private static ResultStable parseResultStable(NodeList nodes) {
        ResultStable resultStable = new ResultStable();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_RESULT_STABLE)) {

                    resultStable.setType(child.getAttribute(KEY_RESULT_STABLE_TYPE));
                    resultStable.setRanking(parseRankings(child.getChildNodes()));
                }
            }
        }

        return resultStable;
    }

    private static List<Ranking> parseRankings(NodeList nodes) {
        List<Ranking> rankings = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_RANKING)) {
                    Ranking ranking = new Ranking();

                    ranking.setRank(Integer.parseInt(child.getAttribute(KEY_RANKING_RANK)));
                    ranking.setLastRank(Integer.parseInt(child.getAttribute(KEY_RANKING_LAST_RANK)));
                    ranking.setZoneStart(child.getAttribute(KEY_RANKING_ZONE_START));
                    ranking.setTeamId(Long.parseLong(child.getAttribute(KEY_RANKING_TEAM_ID)));
                    ranking.setClubName(child.getAttribute(KEY_RANKING_CLUB_NAME));
                    ranking.setCountryCode(child.getAttribute(KEY_RANKING_COUNTRY_CODE));
                    ranking.setAreaId(Long.parseLong(child.getAttribute(KEY_RANKING_AREA_ID)));
                    ranking.setMatchesTotal(Integer.parseInt(child.getAttribute(KEY_RANKING_MATCHES_TOTAL)));
                    ranking.setMatchesWon(Integer.parseInt(child.getAttribute(KEY_RANKING_MATCHES_WON)));
                    ranking.setMatchesDraw(Integer.parseInt(child.getAttribute(KEY_RANKING_MATCHES_DRAW)));
                    ranking.setMatchesLost(Integer.parseInt(child.getAttribute(KEY_RANKING_MATCHES_LOST)));
                    ranking.setGoalsPro(Integer.parseInt(child.getAttribute(KEY_RANKING_GOALS_PRO)));
                    ranking.setGoalsAgainst(child.getAttribute(KEY_RANKING_GOALS_AGAINST));
                    ranking.setPoints(Integer.parseInt(child.getAttribute(KEY_RANKING_POINTS)));

                    rankings.add(ranking);
                }
            }
        }

        return rankings;
    }
}
