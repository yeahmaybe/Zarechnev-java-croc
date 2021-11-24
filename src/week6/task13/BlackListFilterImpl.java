package week6.task13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        List<String> tmpComments = new ArrayList<>(comments);
        for(String comment: tmpComments) {
            String[] commentWords = comment.split("[^A-Za-zА-Яа-я0-9-]+");
            List<String> commentList = new ArrayList<>();
            Collections.addAll(commentList, commentWords);

            for (String word : blackList) {
                if(commentList.contains(word)) {
                    comments.remove(comment);
                    break;
                }
            }
        }
        System.out.println(comments);
    }
}
