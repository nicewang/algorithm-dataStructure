package com.nice.algorithms.sort.method;

/**
 * 快排实现从左到右从小到大排序，每一次排序所选取的middle为最右边元素（数组最后一个元素）
 * @author NiceWang
 *
 */
public class QuickSort {
	/**
	 * 针对的场景：所要排序的一组元素中不包含相同元素
	 * @param input
	 * @param left
	 * @param right
	 */
	public void Sort(int input[], int left, int right) {
		int temp;
		//针对只有两个元素的情况
		if(right - left == 0) {
			if(input[left] > input[right + 1]) {
				temp = input[left];
				input[left] = input[right + 1];
				input[right + 1] = temp;
			}
			return;
		}
		//针对只有一个元素的情况
		if(right - left < 0) {
			return;
		}
    	int flag = input[right + 1];
    	int i = left, j = right;
    	while( i < j ) { //左指针和右指针还没有交叉时
    		//移动左指针
    		int a = input[i];
    		while(a < flag && i <= right){
    			i++;
    			if(i <= right) {
    				a = input[i];
    			}
    		}
    		if(i > right) {
    			Sort(input, left, right-1);
    			return;
    		}
    		//移动右指针
    		int b = input[j];
    		while(b > flag && j >= left){
    			j--;
    			if(j >= left) {
    				b = input[j];
    			}
    		}
    		if(j < left) {
    			temp = input[left];
    			input[left] = flag;
    			input[right + 1] = temp;
    			Sort(input, left + 1, right);
    			return;
    		}
    		//交换左指针所指位置元素和右指针所指位置元素，仅当左右指针还没有交叉时交换才有意义
    		if(i < j) { //这句判断很重要啊，不然就有bug！！！
    			temp = input[i];
        		input[i] = input[j];
        		input[j] = temp;
        		i++; //这两句话有没有对时间复杂度有何影响？
        		j--;
    		}
    	}
    	//交换左指针所指元素和middle
    	temp = input[i];
    	input[i] = input[right + 1];
    	input[right + 1] = temp;
    	//递归的方式，对middle左边进行快排
    	int left_L = left, right_L = i - 2;
    	Sort(input, left_L, right_L);
    	//对middle右边进行快排
    	int left_R = i + 1, right_R = right;
    	Sort(input, left_R, right_R);
    }

	
}
