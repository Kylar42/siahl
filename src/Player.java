/**
 * @Author Tom Byrne, tom.byrne@apple.com
 * (C) 2015 Apple, Inc
 * "If I cannot see, it is because I am being stood upon by giants."
 */
public class Player {
    String fname;
    String lname;

    Player (String name){
        fname = name.substring(0, name.indexOf(" "));
        lname = name.substring(name.lastIndexOf(" "));
    }
}
