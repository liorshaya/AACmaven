package YearA.TermB.OOP1.exam.ex3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }


    public Map<String, Integer> calculateActionCountByDates(List<UserAction> actions){
        return actions.stream().collect(Collectors.groupingBy(action -> action.getDate().substring(0,10),Collectors.summingInt(a -> 1)));
    }

    public int CountSuccessfulDistinctUserActions(List<UserAction> actions , String date){
        return (int)actions.stream().filter(UserAction::isSuccess).filter(action -> action.getDate().substring(0,10).equals(date)).map(UserAction::getUserId).distinct().count();
    }

    public List<Integer> calculateMostActiveUsersOnDates(List<UserAction> actions , String date , int limit){
        return actions.stream().filter(action -> action.getDate().equals(date)).collect(Collectors
                .groupingBy(UserAction::getUserId , Collectors.summingInt(a -> 1))).entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<Integer,Integer>::getValue).reversed()).
                map(Map.Entry::getKey).limit(limit).toList();
    }

    public Map<String,Integer> calculateActionsCountByDates(List<UserAction> actions){
        return actions.stream().collect(Collectors.groupingBy(action-> action.getDate().substring(0,10),Collectors.summingInt(a-> 1)));
    }

   // public int countSuccessfulDistinctUsersActions(List<UserAction> )
}
