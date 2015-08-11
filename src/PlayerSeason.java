/**
 * @Author Tom Byrne, tom.byrne@apple.com
 * (C) 2015 Apple, Inc
 * "If I cannot see, it is because I am being stood upon by giants."
 */
public class PlayerSeason {
    Player player;
    int goals;
    int assists;
    Season s;

    public PlayerSeason(Player player, int goals, int assists, Season s) {
        this.player = player;
        this.goals = goals;
        this.assists = assists;
        this.s = s;
    }
}
