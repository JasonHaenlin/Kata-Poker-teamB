package poker;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class Score {

    public String score = "";

    public String scoring (List<String> HandScore) {

        Map<String, Integer> HandOccuration = new HashMap<>();

        for (String hs : HandScore) {

            if (HandOccuration.containsKey(hs)) {
                HandOccuration.put(hs,HandOccuration.get(hs)+1);
            }
            else {
                HandOccuration.put(hs,1);
            }

            if(HandOccuration.get(hs) == 2){
                score =  1 + hs;
            }
            else if(HandOccuration.get(hs) == 3){
                score = 10 + hs;
            }
            else if(HandOccuration.get(hs) == 4){
                score = 100 + hs;
            }
        }
        System.out.println(score);
        return score;
    }
}