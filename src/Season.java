import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author Tom Byrne, tom.byrne@apple.com
 * (C) 2015 Apple, Inc
 * "If I cannot see, it is because I am being stood upon by giants."
 */
public class Season {
    private final static SimpleDateFormat SEASON_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    boolean complete;
    String season_name;
    long season_number;
    Date startDate;
    Date endDate;
    Map<Division, List<Team>> teams = new HashMap<>();
    public Season(boolean complete, String seasonName, long season_number, String startDate, String endDate){
        this.complete = complete;
        this.season_name = seasonName;
        this.season_number = season_number;
        try {
            this.startDate = SEASON_FORMAT.parse(startDate);
            this.endDate = SEASON_FORMAT.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
