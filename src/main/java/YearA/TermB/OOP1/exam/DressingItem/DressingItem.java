package YearA.TermB.OOP1.exam.DressingItem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DressingItem {
    private DressingitemType type;
    private String color;
    private List<Season> seasons;
    private int size;
    private int amount;

    public DressingitemType getType() {
        return type;
    }

    public void setType(DressingitemType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int countItems (List<DressingItem> items , List<Season> seasons){
        return items.stream().filter(item-> item.getSeasons().stream().anyMatch(seasons::contains))
                .mapToInt(DressingItem::getAmount).sum();
    }
    //(K - COLOR , V - AMOUNT) - M(K,V)Å
    public String mostCommonColor(List<DressingItem> items , DressingitemType type){
        return items.stream().filter(a-> a.getType().equals(type))   //filter only type!
                .collect(Collectors.groupingBy(DressingItem::getColor , Collectors.counting())).entrySet().stream()// map(K- Color , V- counting)
                .max(Map.Entry.comparingByValue())//Giving us only the highest map
                .map(Map.Entry::getKey).orElse(null); //mapping to String - the Color!
    }
}
