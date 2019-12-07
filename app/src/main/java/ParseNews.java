import com.hypercane.swish.NewsFeed;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseNews {

    private ArrayList<NewsFeed> newsArticle;

    public ParseNews() {
        this.newsArticle = new ArrayList<>();
    }

    public ArrayList<NewsFeed> getNewsArticle() {
        return newsArticle;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        NewsFeed currentArticle = null;
        boolean inItem = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("item".equalsIgnoreCase(tagName)) {
                            inItem = true;
                            currentArticle = new NewsFeed();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (inItem) {

                            if ("item".equalsIgnoreCase(tagName)) {
                                newsArticle.add(currentArticle);
                                inItem = false;
                            } else if ("title".equalsIgnoreCase(tagName)) {
                                currentArticle.setTitle(textValue);
                            } else if ("description".equalsIgnoreCase(tagName)) {
                                currentArticle.setDescription(textValue);
                            } else if ("author".equalsIgnoreCase(tagName)) {
                                currentArticle.setDescription((textValue));
                            }
                        }
                        break;

                    default:
                        //Nothing else to do.
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }

        return status;
    }
}