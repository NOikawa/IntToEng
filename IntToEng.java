import java.util.Scanner;

public class IntToEng {
	// メインメソッド
	//　数字配列
	static String[] number = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static String[] teen = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };
	static String[] mult10 = { "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(translateEng(input));
	}

	// 数値を英訳する変換するメソッド
	static String translateEng(int n) {
		String str = "";
		int digit = String.valueOf(n).length();
		switch (digit) {
		case 4:
			str = str + translateNumber((n / 1000) % 10) + " thousand ";
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



	// 10~19
	static String translateTeen(int n) {
		return teen[n - 11];
	}

	static String translateMult10(int n) {
		if (n % 10 == 0)
			return mult10[(n / 10) - 1];
		else
			return mult10[(n / 10) - 1] + " " + translateNumber(n % 10);
	}

	static String translateNumber(int n) {
		return number[n - 1];
	}
}
