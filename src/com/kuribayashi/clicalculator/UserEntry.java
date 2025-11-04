package com.kuribayashi.clicalculator;

public class UserEntry {

	CalculationData parseAndValidate(String inputLine) throws InputFormatException{

		//コマンドラインの引数を3つに分割
		String[] split = inputLine.split(" ");

		//3要素か確認
		if(split.length != 3) {
			throw new InputFormatException("入力が不正です。数値 演算子 数値の3つを順番に入力してください。");
		}

		//3つに分割したものを変数に格納
		String splitNum1	 = split[0];
		String splitOperator = split[1];
		String splitNum2	 = split[2];


		//演算子を確認
		if(
			!(
				splitOperator.equals("+") ||
				splitOperator.equals("-") ||
				splitOperator.equals("*") ||
				splitOperator.equals("/")
			)
		) {
			throw new InputFormatException("入力が不正です。演算子の入力を確認してください。");
		}

		//double型変数を宣言
		double num1;
		double num2;


		try {
			//1つ目の要素と3つ目の要素をdoubleに代入
			num1 = Double.parseDouble(splitNum1);
			num2 = Double.parseDouble(splitNum2);
		}catch(NumberFormatException origiException){
			throw new InputFormatException("入力が不正です。数値の入力を確認してください。",origiException);
		}

		CalculationData cd = new CalculationData(num1, num2, splitOperator);
		return cd;

	}

}
