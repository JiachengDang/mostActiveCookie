package mostActive;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TimeStampTest {


    @Test
    public void timeStampTest() {
        TimeStamp time1 = new TimeStamp("2018-12-09T14:19:00+00:00");
        assertEquals("14:19:00", time1.get_time());
        assertEquals("2018-12-09", time1.get_date());
        assertEquals("00:00", time1.get_zone());
        assertTrue(time1.isSameDay("2018-12-09"));
    }


}
