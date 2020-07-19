//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.util.Pair;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int len;
    HashMap<String, List<String>> cacheWords;

    // 第一遍
    // 想法：双向广度优先
    // 时间：
    // 空间：
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        cacheWords = new HashMap<>();
        len = beginWord.length();
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> words = cacheWords.getOrDefault(newWord, new ArrayList<>());
                words.add(word);
                cacheWords.put(newWord, words);
            }
        });

        Queue<Pair<String, Integer>> beginQ = new LinkedList<>();
        Queue<Pair<String, Integer>> endQ = new LinkedList<>();
        beginQ.add(new Pair<>(beginWord, 1));
        endQ.add(new Pair<>(endWord, 1));

        HashMap<String, Integer> beginVisited = new HashMap<>();
        HashMap<String, Integer> endVisited = new HashMap<>();
        beginVisited.put(beginWord, 1);
        endVisited.put(endWord, 1);
        while (!beginQ.isEmpty() && !endQ.isEmpty()) {
            int result = visitWordNode(beginQ, beginVisited, endVisited);
            if (result > 0) return result;
            result = visitWordNode(endQ, endVisited, beginVisited);
            if (result > 0) return result;
        }
        return 0;
    }

    private int visitWordNode(Queue<Pair<String, Integer>> queue, HashMap<String, Integer> visited, HashMap<String, Integer> otherVisited) {
        Pair<String, Integer> curWord = queue.poll();
        for (int i = 0; i < len; i++) {
            String newWord = curWord.getKey().substring(0, i) + "*" + curWord.getKey().substring(i + 1, len);
            for (String word : cacheWords.getOrDefault(newWord, new ArrayList<>())) {
                if (otherVisited.containsKey(word)) return curWord.getValue() + otherVisited.get(word);
                if (!visited.containsKey(word)) {
                    queue.add(new Pair<>(word, curWord.getValue() + 1));
                    visited.put(word, curWord.getValue() + 1);
                }
            }
        }
        return -1;
    }
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int length = beginWord.length();
//        HashMap<String, List<String>> map = new HashMap<>();
//        wordList.forEach(word -> {
//            for (int i = 0; i < length; i++) {
//                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
//                List<String> wList = map.getOrDefault(newWord, new ArrayList<String>());
//                wList.add(word);
//                map.put(newWord, wList);
//            }
//        });
//        HashMap<String, Boolean> visited = new HashMap<>();
//        Queue<Pair<String, Integer>> queue = new LinkedList<>();
//        queue.add(new Pair<String, Integer>(beginWord, 1));
//        visited.put(beginWord, true);
//        while (!queue.isEmpty()) {
//            Pair<String, Integer> curr = queue.poll();
//            for (int i = 0; i < length; i++) {
//                String s = curr.getKey().substring(0, i) + "*" + curr.getKey().substring(i + 1, length);
//                List<String> words = map.getOrDefault(s, new ArrayList<>());
//                for (String word : words) {
//                    if (endWord.equals(word)) return curr.getValue() + 1;
//                    if (!visited.containsKey(word)) {
//                        queue.add(new Pair<String, Integer>(word, curr.getValue() + 1));
//                        visited.put(word, true);
//                    }
//
//                }
//            }
//        }
//        return 0;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
