package mostActive;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MainTest {
    @Test
    public void readFileToHashTest() {

        Hashtable<String, Cookie> cookies = Main.readFileToCookieTable("src/mostActive/test.csv");
        ArrayList<String> test1 = getMostActiveStrings(cookies,"2018-12-09");
        ArrayList<String> test2 = getMostActiveStrings(cookies,"2018-12-08");

        assertEquals("each cookie should be stored uniquely",5,cookies.size());
        assertTrue("correct solution",test1.contains("AtY0laUfhglK3lC7"));
        assertTrue("correct solution for multiple answers",test2.contains("SAZuXPGUrfbcn5UA"));
        assertTrue("correct solution for multiple answers",test2.contains("4sMM2LxV07bPJzwf"));
        assertTrue("correct solution for multiple answers",test2.contains("fbcn5UAVanZf6UtG"));

    }

    private ArrayList<String> getMostActiveStrings(Hashtable<String, Cookie> cookies,String day) {
        ArrayList<Cookie> mostActive = Main.getMostActiveCookies(cookies, day);
        ArrayList<String> mostActives = new ArrayList<>();
        for(Cookie cookie:mostActive){
            mostActives.add(cookie.get_cookie());
        }
        return mostActives;
    }
}
