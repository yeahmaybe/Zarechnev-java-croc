package week7.task15;

import java.util.*;
import java.util.function.Predicate;

public interface BlackListFilter {

    default <T1 extends Iterable<String>,
            T2 extends Iterable<String>>
                List<String> filterComments(T1 comments, T2 blackList, Predicate<String> condition) {

        List<String> tmpComments = new ArrayList<>();

        for(String comment: comments) {
            if(condition.test(comment)) {
                tmpComments.add(comment);
            }
        }
        return tmpComments;
    }
}
