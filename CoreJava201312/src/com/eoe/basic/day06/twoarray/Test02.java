package com.eoe.basic.day06.twoarray;

public class Test02 {
	/**
	 * 二维数组打印不重复的九九表。
	 */
	public static void main(String[] args) {
		int[][] a = new int[9][9];
		// 计算九九表，并将结果保存在二维数组的每个元素中。
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (i + 1) * (j + 1);
			}
		}
		// 打印九九表(1)
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a[i].length; j++) {
				System.out.print((i + 1) + "*" + (j + 1) + "=");
				if (a[i][j] < 10) {
					System.out.print(" ");
				}
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		//打印九九表(2)
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((i + 1) + "*" + (j + 1) + "=");
				if (a[i][j] < 10) {
					System.out.print(" ");
				}
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
