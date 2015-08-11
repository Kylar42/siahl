import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;


public class Main {

    List<Season> seasons = new ArrayList<>();
    Map<Integer, Team> teams = new HashMap<Integer, Team>();


    public static void main(String[] args) {
        Main m = new Main();
        m.readSeasons(new File("data/siahl-data-2015-08-07/leagues/1/seasons"));
        System.out.println(m.seasons);

    }

    public void readSeasons(File root){
        File[] jsons = root.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("json")|| new File(dir, name).isDirectory();
            }
        });
        List<File> teams = new ArrayList<File>();
        for(File kid : jsons){
            if(kid.isDirectory()){
                teams.add(kid);
            }else {
                readSeasonJson(kid);
            }
        }
        for(File f : teams){
            readTeams(f);
        }
    }

    public void readTeams(File f){
        File[] jsons = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("json") || new File(dir, name).isDirectory();
            }
        });
        for(File kid : jsons){
            if(kid.isDirectory()){
                readTeams(kid);
            }else {
                readTeamSeason(kid);
            }
        }
    }

    private void readTeamSeason(File kid){

    }

    private void readSeasonJson(File f){
        JSONParser parser = new JSONParser();
        try {
            JSONObject parse = (JSONObject)parser.parse(new FileReader(f));
            long leagueNum = (Long)parse.get("league_number");
            long seasonNum = (Long)parse.get("season_number");
            String startDate = (String)parse.get("start_date");
            String endDate = (String)parse.get("end_date");
            boolean complete = (Boolean)parse.get("season_completed");
            String seasonName = (String)parse.get("season_name");
            Season s = new Season(complete, seasonName, seasonNum, startDate, endDate);
            seasons.add(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Season seasonForID(int seasonId){
        for(Season s : seasons){
            if(s.season_number == seasonId)
                return s;
        }
        return null;
    }
}
