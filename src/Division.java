/**
 * @Author Tom Byrne, tom.byrne@apple.com
 * (C) 2015 Apple, Inc
 * "If I cannot see, it is because I am being stood upon by giants."
 */
public enum Division {

    A, B, BB, C, CC, CCC, CCCC, D, DD, DDD, DDDD, DDDDD, E, EE, EEE, EEEE, EEEEE,
    UNKNOWN;


    private Division(){
    }

    public static Division fromInputString(String inputString){
        int fNdx = inputString.indexOf(" ");
        int lNdx = inputString.lastIndexOf(" ");
        if(lNdx > fNdx) inputString = inputString.substring(0, lNdx);
        for(Division d : values()){
            if(d.name().equalsIgnoreCase(inputString)) return d;
        }
        return UNKNOWN;
    }
}
