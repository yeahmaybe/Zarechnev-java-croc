package week7.task15;

import java.util.*;
import java.util.function.Predicate;

public interface BlackListFilter {

    default <T1 extends Iterable<String>,
                T2 extends Iterable<String>>
                    void filterComments(T1 comments, T2 blackList, Predicate<String> condition) {

        List<String> tmpComments = new ArrayList<>();

        for(String comment: comments) {
            String[] commentWords = comment.split("[^A-Za-zА-Яа-я0-9-]+");
            List<String> commentList = new ArrayList<>();
            Collections.addAll(commentList, commentWords);

            boolean contains = false;

            for (String word : blackList) {
                if(commentList.contains(word)) {
                    contains = true;
                    break;
                }
            }
            if(!contains) {
                tmpComments.add(comment);
            }
        }
        System.out.println(comments);
    }
}
