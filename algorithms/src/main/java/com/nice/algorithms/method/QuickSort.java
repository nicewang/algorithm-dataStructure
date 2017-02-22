package com.nice.algorithms.method;

public class QuickSort {

	public void Sort(int input[], int left, int right) {
		int temp;
		if(right - left == 0) {
			if(input[left] > input[right + 1]) {
				temp = input[left];
				input[left] = input[right + 1];
				input[right + 1] = temp;
			}
			return;
		}
		if(right - left < 0) {
			return;
		}
    	int flag = input[right + 1];
    	int i = left, j = right;
    	while( i < j ) {
    		int a = input[i];
    		while(a < flag && i <= right){
    			i++;
    			a = input[i];
    		}
    		if(i > right) {
    			Sort(input, left, right-1);
    			return;
    		}
    		int b = input[j];
    		while(b > flag && j >= left){
    			j--;
    			b = input[j];
    		}
    		if(j < left) {
    			temp = input[left];
    			input[left] = flag;
    			input[right + 1] = temp;
    			Sort(input, left + 1, right);
    			return;
    		}
    		temp = input[i];
    		input[i] = input[j];
    		input[j] = temp;
    		i++;
    		j--;
    	}
    	temp = input[i];
    	input[i] = input[right + 1];
    	input[right + 1] = temp;
    	int left_L = left, right_L = i - 2;
    	Sort(input, left_L, right_L);
    	int left_R = i + 1, right_R = right;
    	Sort(input, left_R, right_R);
    }

	
}
