package leetcode100;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class Q039 {



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,res,path,target,0);
        return res;
    }




    /**
     * 递归解法
     */
    void dfs(int[] arr ,List<List<Integer>> res,List<Integer> path,int target,int begin) {
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
            // 选中
            path.add(arr[i]);
            // 进入下一层
            dfs(arr,res,path,target-arr[i],i);
            // 取消选中
            path.remove(path.size()-1);
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
        Q039 jz = new Q039();
        int[] arr = {2,3,5};
        List<List<Integer>> res = jz.combinationSum(arr,8);
        for (List<Integer> item:res) {
            for (Integer i:item) {
                System.out.print (i+" ");
            }
            System.out.println();
        }

    }

}

