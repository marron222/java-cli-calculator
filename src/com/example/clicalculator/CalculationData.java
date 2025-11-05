package com.example.clicalculator;

public class CalculationData {

	//フィールド
	private final double value1;
	private final double value2;
	private final String operator;

	//データの詰め込み
	//3つの引数を持ち、フィールドを初期化する
	public CalculationData(double val1, double val2, String op) {
		this.value1		= val1;
		this.value2		= val2;
		this.operator	= op;
	}

	//データの取り出し（getterメソッド）

	public double getValue1() {
		return value1;
	}

	public double getValue2() {
		return value2;
	}

	public String getOperator() {
		return operator;
	}

}
