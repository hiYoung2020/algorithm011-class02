//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表


import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第一遍：
    // 【想法】统计频率，桶排序，取前k个
    // 【时间复杂度】O(n)：统计频率O(n)，创建桶O(n)，遍历O(k)，k<=n
    // 【空间复杂度】O(n)：最差频率都不同统计频率O(n)，生成桶O(k)
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        map.entrySet().forEach(entry -> {
            List list = buckets[entry.getValue()];
            if (list == null) {
                list = new ArrayList<>();
                buckets[entry.getValue()] = list;
            }
            list.add(entry.getKey());
        });
        int finished = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> list = buckets[i];
            if (list != null) {
                for (int j = 0, size = list.size(); j < size; j++) {
                    if (finished == k) {
                        break;
                    }
                    result[finished++] = list.get(j);
                }
            }
        }
        return result;
    }

    // 第一遍：
    // 【想法】统计频率，小顶堆
    // 【时间复杂度】O(nlogk)：统计频率O(n)，生成小顶堆O(nlogk)，遍历输出 O(k)，k<=n
    // 【空间复杂度】O(n)：最差频率都不同统计频率O(n)，生成小顶堆O(k)
//    public int[] topKFrequent(int[] nums, int k) {
//        int[] result = new int[k];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((m1, m2) -> map.get(m1) - map.get(m2));
//        map.keySet().forEach(i -> {
//            priorityQueue.add(i);
//            if (priorityQueue.size() > k) {
//                priorityQueue.poll();
//            }
//        });
//        for (int i = result.length - 1; i >= 0; i--) {
//            result[i] = priorityQueue.poll();
//        }
//        return result;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
