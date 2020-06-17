import java.util.Scanner;

public class IntToEng {
	// メインメソッド
	//　数字配列
	static String[] number = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static String[] teen = { "","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };
	static String[] mult10 = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	static String[] keta = {"" ,"thousand","million", "billion"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(translateEng(input));
	}

	// 数値を英訳する変換するメソッド
	static String translateEng(int n) {
		String str = "";
		int digit = String.valueOf(n).length();
		int roop = (digit/3) + 1;
		int amari = digit % 3;
		//後ろから3桁ずつ切り分ける
		String nToString = String.valueOf(n);
		int[] ThreeketaArr = new int[roop];
		int i = 0;
		if(amari != 0) {
			ThreeketaArr[0] = Integer.parseInt(nToString.substring(0,amari));
			i++;
		}
		for(i=0;i<roop;i++)  ThreeketaArr[i] = Integer.parseInt(nToString.substring(i,3));
		int j = roop;
		for(int k=0;k<roop;j++) {
			str = str + getHundred(ThreeketaArr[k],String.valueOf(ThreeketaArr[k]).length()) + keta[j];
			j--;
		}

		return str;
	}

	// 10~19
	static String translateTeen(int n) {
		return teen[n - 10];
	}

	static String translateMult10(int n) {
		if (n % 10 == 0)
			return mult10[(n / 10)];
		else
			return mult10[(n / 10)] + " " + translateNumber(n % 10);
	}

	static String translateNumber(int n) {
		return number[n];
	}

	static String getHundred(int n, int digit) {
		String str = "";

		switch (digit) {
		case 3:
			str = str + translateNumber((n / 100) % 10) + " hundred ";
		case 2:
			if ((n / 10) % 10 == 1) {
				str += translateTeen(n % 100);
				break;
			} else {
				str += translateMult10(n % 100);
				break;
			}
		case 1:
			str += translateNumber(n % 10);
			break;
		}
		return str;
	}
}
