package week6.task13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] words = {
                "Африканская страна Нигер тоже экспортирует черный кофе",
                "Отличное видео! Познавательное.",
                "Автору тележку лайков"};
        String[] blackList = {"Нигер", "черный"};

        List<String> list = new ArrayList<String>(List.of(words));
        Set<String> ban = new HashSet<String>(Set.of(blackList));

        BlackListFilter filter = new BlackListFilterImpl();
        filter.filterComments(list, ban);
    }
}
