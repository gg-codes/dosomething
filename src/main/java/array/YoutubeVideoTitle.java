package array;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by GAURAV on 4/26/2018.
 */
public class YoutubeVideoTitle {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.youtube.com/watch?v=xtfj4-r_Ahs&list=PLqM7alHXFySEQDk2MDfbwEdjd2svVJH9p").get();
        System.out.println(document.title());
    }
}
