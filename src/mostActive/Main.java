package mostActive;

import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption("d", true, "Selected Day");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        assert args.length == 3 : "Missing arguments, Expected: 3";
        assert cmd.hasOption("d") : "Day not specified";


        String day = cmd.getOptionValue("d");
        Hashtable<String, Cookie> cookies = readFileToCookieTable(args[0]);


        ArrayList<Cookie> mostActive = getMostActiveCookies(cookies, day);

        for (Cookie cookie : mostActive) {
            System.out.println(cookie.get_cookie());
        }


    }

    public static ArrayList<Cookie> getMostActiveCookies(Hashtable<String, Cookie> cookies, String day) {
        ArrayList<Cookie> mostActive = new ArrayList<>();



        mostActive.add((Cookie) cookies.values().toArray()[0]);

        for (Cookie cookie : cookies.values()) {

            if (cookie.isMoreActive(mostActive.get(0), day)) {
                mostActive.clear();
                mostActive.add(cookie);
            }
            if ((cookie.getDayTimes(day) == mostActive.get(0).getDayTimes(day)) && !mostActive.contains(cookie)) {
                mostActive.add(cookie);
            }
        }
        return mostActive;
    }

    public static Hashtable<String, Cookie> readFileToCookieTable(String file_path) {
        String line = "";
        Hashtable<String, Cookie> cookies = new Hashtable<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while ((line = br.readLine()) != null) {
                String[] elements = line.split(",");
                if (!cookies.containsKey(elements[0])) {
                    cookies.put(elements[0], new Cookie(elements[0]));
                }
                cookies.get(elements[0]).addTime(new TimeStamp(elements[1]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookies;
    }


}

