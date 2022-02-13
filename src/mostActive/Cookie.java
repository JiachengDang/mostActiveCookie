package mostActive;

import java.util.ArrayList;

public class Cookie {

    private final String _cookie;
    private final ArrayList<TimeStamp> _times_log = new ArrayList<TimeStamp>();

    public Cookie(String new_cookie) {
        _cookie = new_cookie;

    }

    public void addTime(TimeStamp time) {
        _times_log.add(time);
    }

    public int getDayTimes(String day) {
        int times = 0;
        for (TimeStamp time : _times_log) {
            if (time.isSameDay(day)) {
                times += 1;
            }
        }
        return times;
    }

    public String get_cookie() {
        return _cookie;
    }


    public boolean isMoreActive(Cookie cookie, String Day) {
        return getDayTimes(Day) > cookie.getDayTimes(Day);
    }
}
