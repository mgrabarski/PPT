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
import mateusz.grabarski.businesslogiclayer.models.standings.Root;

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
}
