package com.study.leetcode.array;

import java.util.List;

public class Array1 {

    public static void main(String[] args) {

        // 123698745
//        int[][] matrix = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}
//        };
//
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
//            System.out.println("无效数组");
//        }
//
//        //行长度
//        int m = matrix.length;
//        //列长度
//        int n = matrix[0].length;
//        System.out.println(m + " " + n);
//        int i = 0,j = 0;
//        int result[] = new int[m * n];
//        int l = 0;
//        int z = m,y = n;
//
//        while( l< m*n ){
//
//
//
//            while(j < y){
//                result[l++] = matrix[i][j++];
//            }
//            j--;
//            i++;
//            while(i < z){
//                result[l++] = matrix[i++][j];
//            }
//            i--;
//            j--;
//            while(j >= n-y){
//                result[l++] = matrix[i][j--];
//            }
//            i--;
//            j++;
//            y--;
//            z--;
//            while(i >= m-z){
//                result[l++] = matrix[i--][j];
//            }
//            i++;
//            j++;
//            z--;
//        }
//
//        for (int a: result) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//        int len = removeDuplicates(nums);
//        System.out.println(len);
//        // 在函数里修改输入数组对于调用者是可见的。
//        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//        for (int i = 0; i < len; i++) {
//            System.out.print(nums[i]);
//        }

        int[][] intervals = {{1,4},{0,4}};
        int[][] re = 合并重叠空间(intervals);
        for(int i = 0; i<re.length;i++){
            for (int j = 0; j < 2; j++){
                System.out.print(  re[i][j] + " " );
            }
            System.out.println();
        }

        System.out.println(合并重叠空间(intervals));

    }

    /**
     * 移出重复参数，返回数组实际长度
     * @author zxl
     * @time 2020/1/15 16:24
     */
    public static int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[nums.length - 1];
        int maxC = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;

            if(j < nums.length && nums[j] > nums[i]){
                break;
            }

            while ( j < nums.length){
                if(maxC == 1){
                    break;
                }
                if(max == nums[j]){
                    maxC++;
                }
                if(nums[j] > nums[i] && j != i+1){
                    nums[j - 1] = nums[j];
                    break;
                }
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(max == nums[i]){
                return i+1;
            }
        }

        return 0;
    }

    /**
     * 杨辉三角
     * @author zxl
     * @time 2020/1/15 14:49
     */
    public List<List<Integer>> generate(int numRows) {




        return null;
    }

    /***
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * @method spiralOrder
     * @param matrix
     * @return java.util.List<java.lang.Integer>
     * @Author zxl
     * @Date 2019/11/6 15:21
     **/
    public List<Integer> spiralOrder(int[][] matrix) {

        return null;
    }


    /**
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return new int[0];
        int m = matrix.length;//几个一维数组
        int n = matrix[0].length;//每一个数组长度
        int[] result = new int[m * n];//结果集
        for(int l = 0; l < m + n - 1; l++) {//遍历次数
            if (l % 2 != 0) {
                int i = (l < n ? 0 : (l - n + 1));
                int j = (l < n ? l : (n - 1));
                while (i < m && j >= 0) {
                    result[l] = matrix[i][j];
                    System.out.print(matrix[i][j]);
                    i++;
                    j--;
                }
            } else {
                int i = (l < m ? l : (m - 1));
                int j = (l < m ? 0 : (l - m + 1));
                while(i >= 0 && j < n){
                    result[l] = matrix[i][j];
                    System.out.print(matrix[i][j]);
                    i--;
                    j++;
                }
            }
        }
        return result;
    }
    
    /***
     *  根据奇偶规则优化
     *                 (00)
     * 1:            (01)(10)
     * 2:          (20)(11)(02)
     * 3:        (03)(12)(21)(30)
     * 4:      (40)(31)(22)(13)(04)
     * 5:    (05)(14)(23)(32)(41)(50)
     * 6:  (60)(51)................(06)
     * **/
    public int[] findDiagonalOrder1(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return new int[0];
        int m = matrix.length;//几个一维数组
        int n = matrix[0].length;//每一个数组长度
        int[] result = new int[m * n];//结果集
        int i = 0, j = 0;
        for(int l = 0; l < m*n; l++) {//遍历次数
            result[l] = matrix[i][j];
            if ((i + j) % 2 == 0) {//上走
                if(j == n -1){//边界
                    i++;
                }else if(i == 0){//第一行
                    j++;
                }else{//正常走
                    i--;j++;
                }
            }else{//下走
                if(i == m - 1){//边界
                    j++;
                }else if(j == 0){//第一列
                    i++;
                } else{//正常
                    i++;j--;
                }
            }
        }
        return result;
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        int i = digits.length - 1;
        while (digits[i] == 9) {
            digits[i] = 0;
            if (--i < 0) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
        }
        digits[i]++;
        return digits;

    }

    /**
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     * 如果是，则返回最大元素的索引，否则返回-1
     *
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        /** 方法一：数组赋值方法 */
//        if(nums.length == 1){
//            return 0;
//        }
//        int[] newn = new int[nums.length];
//        System.arraycopy(nums,0,newn,0,nums.length);
//        Arrays.sort(newn);
//        if(newn[newn.length -1] >= newn[newn.length - 2] * 2 ){
//            for (int i = 0;i<nums.length ;i++){
//                if(nums[i] == newn[newn.length -1])return i;
//            }
//        }
//        return -1;

        /** 方法一：数组赋值方法 */
        if (nums.length == 1) return 0;
        int min = 0, max = nums.length - 1;
        while (min < max) {

        }

        return -1;
    }

    /**
     * 寻找中心索引（数组中存在一个数使得索引左边和等于右边和，不存在返回-1）
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == leftSum * 2) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     *
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     *
     * @param nums 有序数组
     * @param target 插入值
     * @return 插入索引
     */
    public int searchInsert(int[] nums, int target) {
        return searchInsert二分法(nums,target);
    }


    public int searchInsert基本搜索(int[] nums, int target) {
        if(nums[0] > target){
            return 0;
        }
        int i = 0;
        for (i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }

            if(nums[i] < target && i+1 < nums.length && nums[i+1] >target){
                return i + 1;
            }

        }
        return i;
    }

    public int searchInsert二分法(int[] nums, int target) {
        int pre = 0, last = nums.length - 1;
        while (pre <= last){
            // <<:左移运算符，num << 1,相当于num乘以2
            // >>:右移运算符，num >> 1,相当于num除以2
            // >>>:无符号右移，忽略符号位，空位都以0补齐
            int mid = (last + pre) >> 1;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                last = mid - 1;
            }else if(nums[mid] < target){
                pre = mid + 1;
            }
        }
        return last + 1;
    }


    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 输入: intervals = [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * 提示：
     * intervals[i][0] <= intervals[i][1]
     *
     * @param intervals 二维数据
     * @return 返回重叠之后数组
     */
    public static int[][] 合并重叠空间(int[][] intervals) {

        if(intervals == null || intervals.length == 0){
            return new int[][]{};
        }

        int[][] a = new int[intervals.length][];
        int min = 0;
        for(int i = 0; i < intervals.length; i++) {
            min = intervals[i][0];
            if(min > intervals[i+1][0]){

            }

        }


        int[] temp = new int[intervals.length*2];
        int t = 0;
        for(int i = 0; i < intervals.length; i++){
            for(int j = 0;j<intervals[i].length;j++){
                temp[t++] = intervals[i][j];
            }
        }

        int i = 0,k=0,j=0;
        int[] nums = new int[intervals.length*2];
        while(i < temp.length - 1){
            if(temp[i] >= temp[i+1]){
                i+=2;
                continue;
            }
            nums[k++] = temp[i++];
        }
        nums[k] = temp[i];
        int[][] result = new int[k/2+1][2];
        int y = 0;
        for(int z = 0; z < nums.length; z++){
            if(nums[z] != 0){
                result[y>>1][y%2] = nums[z];
                y++;
            }
        }


        return result;
    }




}
