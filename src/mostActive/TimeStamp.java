package mostActive;

public class TimeStamp {
    private final String _date;
    private final String _time;
    private final String _zone;

    public TimeStamp(String time_stamp) {

        _date = time_stamp.substring(0, 10);
        _time = time_stamp.substring(11, 19);
        _zone = time_stamp.substring(20, 25);


    }

    public boolean isSameDay(String date) {
        return _date.equals(date);
    }

    public String get_date() {
        return _date;
    }

    public String get_time() {
        return _time;
    }

    public String get_zone() {
        return _zone;
    }
}
