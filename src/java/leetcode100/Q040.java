package leetcode100;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Q040 {



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates,res,path,target,0,used);
        return res;
    }




    /**
     * 递归解法
     */
    void dfs(int[] arr , List<List<Integer>> res, LinkedList<Integer> path, int target, int begin, boolean[] used) {
        // 终止条件
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin;i < arr.length;i++) {
            // 剪枝
            if (target < arr[i]) {
                break;
            }
            if (used[i]) {
                continue;
            }


            // 选中
            path.addLast(arr[i]);
            used[i] = true;
            // 进入下一层
            dfs(arr,res,path,target-arr[i],i+1,used);
            // 取消选中
            path.removeLast();
            used[i] = false;
        }
    }


    /**
     * 非递归解法：利用栈实现
     * @param ch
     * @param n
     */
//    void dfs2(char[] ch ,int n) {
//
//        Stack<Character> stack = new Stack<>();
//        stack.push(1);
//        while (!stack.isEmpty()) {
//            stack
//        }
//
//        // 终止条件
//        // 遍历当前节点的所有情况
//        //
//        // 满足约束条件与限界条件
//        //
//    }


    public static void main(String[] args) {
        Q040 jz = new Q040();
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> res = jz.combinationSum(arr,8);
        for (List<Integer> item:res) {
            for (Integer i:item) {
                System.out.print (i+" ");
            }
            System.out.println();
        }

    }

}

