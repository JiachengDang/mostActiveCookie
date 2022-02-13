package mostActive;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CookieTest {

    @Test
    public void getDayTimesTest() {
        Cookie cookie = new Cookie("4sMM2LxV07bPJzwf");

        TimeStamp[] times = {
            new TimeStamp("2018-12-09T14:19:00+00:00"),
            new TimeStamp("2018-12-08T14:18:00+00:00"),
            new TimeStamp("2018-12-09T14:17:00+00:00")
        };
        for (TimeStamp time : times) {
            cookie.addTime(time);
        }
        assertEquals(1, cookie.getDayTimes("2018-12-08"));
        assertEquals(2, cookie.getDayTimes("2018-12-09"));
    }


}
