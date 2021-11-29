package week7.task15;

import java.util.*;
import java.util.function.Predicate;

public interface BlackListFilter {

    default <E> List<E> filterComments(Iterable<E> comments, Predicate<E> condition) {

        List<E> tmpComments = new ArrayList<>();

        for(E comment: comments) {
            if(condition.test(comment)) {
                tmpComments.add(comment);
            }
        }
        return tmpComments;
    }
}
