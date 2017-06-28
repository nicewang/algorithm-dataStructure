package com.nice.algorithms.nomography.dynamic_programming.examples;

import java.util.Scanner;

//备注：该回文的例子使用了动态规划算法LCS的思想

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 * 时间限制：1秒
 * 空间限制：32768K
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 输出描述:
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 * 输入例子:
 * abcda
 * 输出例子：
 * 2
 * @author NiceWang
 */
public class PalindromeString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String input = in.nextLine();
			int del_min = getLongestPalindromeString(input);
			System.out.println(del_min);
		}
		in.close();
	}
	
	public static int getLongestPalindromeString(String input) {
		int max_len = 1;
		int length = input.length();
		//得到原输入字符串的逆序字符串
		StringBuffer sb = new StringBuffer();
		for(int i = length-1; i >= 0; i--) {
			sb.append(input.substring(i, i+1));
		}
		String reverse_input = sb.toString();
		int sb_len = sb.length();
		sb.delete(0, sb_len);
		//将原输入字符串和逆序之后的字符串转换位字符数组
		char[] original = input.toCharArray();
		char[] reverse = reverse_input.toCharArray();
		//列表
		int[][] opt = new int[length+1][length+1];
		for(int i = 0; i <= length; i++) {
			for(int j = 0; j <= length; j++) {
				if((i == 0) || (j == 0)) {
					opt[i][j] = 0;
				} else if(original[i-1] == reverse[j-1]) {
					opt[i][j] = opt[i-1][j-1] + 1;
				} else {
					opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]);
				}
			}
		}
		//查表
		if(max_len < opt[length][length]) {
			max_len = opt[length][length];
		}
		return (length - max_len);
	}
	
}
