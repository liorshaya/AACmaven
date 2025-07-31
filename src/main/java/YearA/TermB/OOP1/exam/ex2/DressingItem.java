package YearA.TermB.OOP1.exam.ex2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DressingItem {
    private DressingItemType type;
    private String color;
    private List<Season> seasons;
    private int size;
    private int amount;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DressingItemType getType() {
        return type;
    }

    public void setType(DressingItemType type) {
        this.type = type;
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

    public Map<Season , List<DressingItem>> filterGroupBySeason(List<DressingItem> items, int minSize){
        return items.stream().filter(item -> item.getSize() >= minSize).flatMap(item -> item.getSeasons().stream()
                        .map(season -> Map.entry(season,item)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }

    public int countItems(List<DressingItem> items , List<Season> seasons){
        return items.stream().filter(item -> item.getSeasons().stream().anyMatch(seasons::contains)).mapToInt(DressingItem::getAmount).sum();
    }

    public String mostCommonColor(List<DressingItem> items , DressingItemType dressingItemType){
        return items.stream().filter(item -> item.getType() == dressingItemType).collect(Collectors
                        .groupingBy(DressingItem::getColor,Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }
}
