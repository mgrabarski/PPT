package mateusz.grabarski.businesslogiclayer.handlers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import mateusz.grabarski.businesslogiclayer.models.News;
import mateusz.grabarski.businesslogiclayer.models.news.Channel;
import mateusz.grabarski.businesslogiclayer.models.news.Enclosure;
import mateusz.grabarski.businesslogiclayer.models.news.Item;
import mateusz.grabarski.businesslogiclayer.models.news.Rss;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class NewsHandler {

    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_CHANNEL_TITLE = "title";
    private static final String KEY_CHANNEL_DESCRIPTION = "description";
    private static final String KEY_CHANNEL_LANGUAGE = "language";
    private static final String KEY_CHANNEL_PUB_DATE = "pubDate";
    private static final String KEY_CHANNEL_LINK = "link";
    private static final String KEY_CHANNEL_CATEGORY = "category";

    private static final String KEY_ITEM = "item";
    private static final String KEY_ITEM_GUID = "guid";
    private static final String KEY_ITEM_TITLE = "title";
    private static final String KEY_ITEM_PUB_DATE = "pubDate";
    private static final String KEY_ITEM_DESCRIPTION = "description";
    private static final String KEY_ITEM_LINK = "link";
    private static final String KEY_ITEM_CATEGORY = "category";

    private static final String KEY_ENCLOSURE = "enclosure";
    private static final String KEY_ENCLOSURE_LENGTH = "length";
    private static final String KEY_ENCLOSURE_URL = "url";
    private static final String KEY_ENCLOSURE_TYPE = "type";

    public static News parseNews(String xml) {
        Document doc = getDomElement(xml);

        if (doc != null) {
            Element rootElement = doc.getDocumentElement();
            NodeList nodes = rootElement.getChildNodes();

            return parseNewsXML(nodes);
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

    private static News parseNewsXML(NodeList nodes) {
        News news = new News();
        news.setRss(new Rss());
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();

                if (name.equals(KEY_CHANNEL)) {
                    news.getRss().setChannel(parseChannel(child.getChildNodes()));
                }
            }
        }

        return news;
    }

    private static Channel parseChannel(NodeList nodes) {
        Channel channel = new Channel();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();
                String value = child.getTextContent();

                switch (name) {
                    case KEY_CHANNEL_TITLE:
                        channel.setTitle(value);
                        break;
                    case KEY_CHANNEL_DESCRIPTION:
                        channel.setTitle(value);
                        break;
                    case KEY_CHANNEL_LANGUAGE:
                        channel.setLanguage(value);
                        break;
                    case KEY_CHANNEL_PUB_DATE:
                        channel.setPubDate(value);
                        break;
                    case KEY_CHANNEL_LINK:
                        channel.setLink(value);
                        break;
                    case KEY_CHANNEL_CATEGORY:
                        channel.getCategory().add(value);
                        break;
                    case KEY_ITEM:
                        channel.getItem().add(parseItem(child.getChildNodes()));
                        break;
                }
            }
        }

        return channel;
    }

    private static Item parseItem(NodeList nodes) {
        Item item = new Item();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();
                String value = child.getTextContent();

                switch (name) {
                    case KEY_ITEM_GUID:
                        item.setGuid(value);
                        break;
                    case KEY_ITEM_TITLE:
                        item.setTitle(value);
                        break;
                    case KEY_ITEM_PUB_DATE:
                        item.setPubDate(value);
                        break;
                    case KEY_ITEM_DESCRIPTION:
                        item.setDescription(value);
                        break;
                    case KEY_ITEM_LINK:
                        item.setLink(value);
                        break;
                    case KEY_ITEM_CATEGORY:
                        item.setCategory(value);
                        break;
                    case KEY_ENCLOSURE:
                        item.setEnclosure(parseEnclosure(child.getChildNodes()));
                        break;
                }
            }
        }

        return item;
    }

    private static Enclosure parseEnclosure(NodeList nodes) {
        Enclosure enclosure = new Enclosure();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {

                Element child = (Element) node;
                String name = child.getNodeName();
                String value = child.getTextContent();

                switch (name) {
                    case KEY_ENCLOSURE_LENGTH:
                        enclosure.setLength(value);
                        break;
                    case KEY_ENCLOSURE_URL:
                        enclosure.setUrl(value);
                        break;
                    case KEY_ENCLOSURE_TYPE:
                        enclosure.setType(value);
                        break;
                }
            }
        }

        return enclosure;
    }
}
