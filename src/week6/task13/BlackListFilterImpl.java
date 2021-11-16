package week6.task13;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BlackListFilterImpl implements BlackListFilter {
    @Override
    public

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments list of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    void filterComments(List<String> comments, Set<String> blackList) {
        comments = comments.stream().filter(word -> !blackList.contains(word)).collect(Collectors.toList());

        System.out.println(comments.toString());
    }

}
