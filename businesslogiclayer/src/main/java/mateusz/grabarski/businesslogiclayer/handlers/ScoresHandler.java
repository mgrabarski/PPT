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

import mateusz.grabarski.businesslogiclayer.models.Scores;
import mateusz.grabarski.businesslogiclayer.models.scores.Competition;
import mateusz.grabarski.businesslogiclayer.models.scores.Group;
import mateusz.grabarski.businesslogiclayer.models.scores.Gsmrs;
import mateusz.grabarski.businesslogiclayer.models.scores.Match;
import mateusz.grabarski.businesslogiclayer.models.scores.Method;
import mateusz.grabarski.businesslogiclayer.models.scores.Parameter;
import mateusz.grabarski.businesslogiclayer.models.scores.Round;
import mateusz.grabarski.businesslogiclayer.models.scores.Season;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class ScoresHandler {

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
    private static final String KEY_ROUND_LAST_UPDATED = "last_updated";

    private static final String KEY_GROUP = "group";
    private static final String KEY_GROUP_ID = "group_id";
    private static final String KEY_GROUP_NAME = "name";
    private static final String KEY_GROUP_DETAILS = "details";
    private static final String KEY_GROUP_WINNER = "winner";
    private static final String KEY_GROUP_LAST_UPDATED = "last_updated";

    private static final String KEY_MATCH = "match";
    private static final String KEY_MATCH_ID = "match_id";
    private static final String KEY_MATCH_DATE_UTC = "date_utc";
    private static final String KEY_MATCH_TIME_UTC = "time_utc";
    private static final String KEY_MATCH_DATE_LONDON = "date_london";
    private static final String KEY_MATCH_TIME_LONDON = "time_london";
    private static final String KEY_MATCH_TEAM_A_ID = "team_A_id";
    private static final String KEY_MATCH_TEAM_A_NAME = "team_A_name";
    private static final String KEY_MATCH_TEAM_A_COUNTRY = "team_A_country";
    private static final String KEY_MATCH_TEAM_B_ID = "team_B_id";
    private static final String KEY_MATCH_team_B_NAME = "team_B_name";
    private static final String KEY_MATCH_TEAM_B_COUNTRY = "team_B_country";
    private static final String KEY_MATCH_STATUS = "status";
    private static final String KEY_MATCH_GAME_WEEK = "gameweek";
    private static final String KEY_MATCH_WINNER = "winner";
    private static final String KEY_MATCH_FS_A = "fs_A";
    private static final String KEY_MATCH_FS_B = "fs_B";
    private static final String KEY_MATCH_HTS_A = "hts_A";
    private static final String KEY_MATCH_HTS_B = "hts_B";
    private static final String KEY_MATCH_ETS_A = "ets_A";
    private static final String KEY_MATCH_ETS_B = "ets_B";
    private static final String KEY_MATCH_PS_A = "ps_A";
    private static final String KEY_MATCH_PS_B = "ps_B";
    private static final String KEY_MATCH_LAST_UPDATED = "last_updated";

    public static Scores parseScores(String xml) {
        Document doc = getDomElement(xml);

        if (doc != null) {
            Element rootElement = doc.getDocumentElement();
            NodeList nodes = rootElement.getChildNodes();

            return parseScoresXML(nodes);
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

    private static Scores parseScoresXML(NodeList nodes) {
        Scores scores = new Scores();
        scores.setGsmrs(new Gsmrs());

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_METHOD)) {
                    scores.getGsmrs().setMethod(parseMethodParameters(child.getChildNodes()));

                    scores.getGsmrs().getMethod().setMethodId(child.getAttribute(KEY_METHOD_METHOD_ID));
                    scores.getGsmrs().getMethod().setName(child.getAttribute(KEY_METHOD_NAME));
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
                    scores.getGsmrs().setCompetition(competition);

                    scores.getGsmrs().getCompetition().setSeason(parseSession(child.getChildNodes()));
                }
            }
        }

        return scores;
    }

    private static Method parseMethodParameters(NodeList nodes) {
        Method method = new Method();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getAttribute(KEY_METHOD_PARAMETER_NAME);
                String value = child.getAttribute(KEY_METHOD_PARAMETER_VALUE);

                method.getParameter().add(new Parameter(name, value));
            }
        }

        return method;
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
                    round.setGroups(child.getAttribute(KEY_ROUND_GROUPS));
                    round.setHasOutGroupMatches(child.getAttribute(KEY_ROUND_HAS_OUT_GROUP_MATCHES));
                    round.setLastUpdated(child.getAttribute(KEY_ROUND_LAST_UPDATED));
                    round.setGroup(parseGroups(child.getChildNodes()));
                }
            }
        }

        return round;
    }

    private static List<Group> parseGroups(NodeList nodes) {
        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_GROUP)) {
                    Group group = new Group();

                    group.setGroupId(child.getAttribute(KEY_GROUP_ID));
                    group.setName(child.getAttribute(KEY_GROUP_NAME));
                    group.setDetails(child.getAttribute(KEY_GROUP_DETAILS));
                    group.setWinner(child.getAttribute(KEY_GROUP_WINNER));
                    group.setLastUpdated(child.getAttribute(KEY_GROUP_LAST_UPDATED));
                    group.setMatch(parseMatches(child.getChildNodes()));

                    groups.add(group);
                }
            }
        }

        return groups;
    }

    private static List<Match> parseMatches(NodeList nodes) {
        List<Match> matches = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_MATCH)) {
                    Match match = new Match();
                    match.setMatchId(child.getAttribute(KEY_MATCH_ID));
                    match.setDateUtc(child.getAttribute(KEY_MATCH_DATE_UTC));
                    match.setTime_utc(child.getAttribute(KEY_MATCH_TIME_UTC));
                    match.setDateLondon(child.getAttribute(KEY_MATCH_DATE_LONDON));
                    match.setTimeLondon(child.getAttribute(KEY_MATCH_TIME_LONDON));
                    match.setTeamAId(child.getAttribute(KEY_MATCH_TEAM_A_ID));
                    match.setTeamAName(child.getAttribute(KEY_MATCH_TEAM_A_NAME));
                    match.setTeamACountry(child.getAttribute(KEY_MATCH_TEAM_A_COUNTRY));
                    match.setTeamBId(child.getAttribute(KEY_MATCH_TEAM_B_ID));
                    match.setTeamBName(child.getAttribute(KEY_MATCH_team_B_NAME));
                    match.setTeamBCountry(child.getAttribute(KEY_MATCH_TEAM_B_COUNTRY));
                    match.setStatus(child.getAttribute(KEY_MATCH_STATUS));
                    match.setGameWeek(child.getAttribute(KEY_MATCH_GAME_WEEK));
                    match.setWinner(child.getAttribute(KEY_MATCH_WINNER));
                    match.setFsA(child.getAttribute(KEY_MATCH_FS_A));
                    match.setFsB(child.getAttribute(KEY_MATCH_FS_B));
                    match.setHtsA(child.getAttribute(KEY_MATCH_HTS_A));
                    match.setHtsB(child.getAttribute(KEY_MATCH_HTS_B));
                    match.setEtsA(child.getAttribute(KEY_MATCH_ETS_A));
                    match.setEtsB(child.getAttribute(KEY_MATCH_ETS_B));
                    match.setPsA(child.getAttribute(KEY_MATCH_PS_A));
                    match.setPsB(child.getAttribute(KEY_MATCH_PS_B));
                    match.setLastUpdated(child.getAttribute(KEY_MATCH_LAST_UPDATED));

                    matches.add(match);
                }
            }
        }

        return matches;
    }
}
