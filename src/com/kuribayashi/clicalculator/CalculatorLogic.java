package com.kuribayashi.clicalculator;

public class CalculatorLogic {

	// 引数として CalculationData を受け取り、計算結果を double で返す
    // ゼロ除算の可能性があるため、ArithmeticException をスローするように宣言する
	public double calculate(CalculationData data) throws ArithmeticException{

		double result = 0.0;

		//①CalculationDataから3つの値を取り出す (getterを使う)
		double num1 = data.getValue1();
		double num2 = data.getValue2();
		String operator = data.getOperator();

		//② switch文で演算子（+ - * /）ごとに処理を分岐させる

		switch(operator) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				if(num2 == 0) {
					throw new ArithmeticException("0で割ることはできません。");
				}
				result = num1 / num2;
				break;
		}

		return result;

	}

}
