package com.example.clicalculator;

import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {

		//インスタンス化
		Scanner scanner = new Scanner(System.in);
		UserEntry ue = new UserEntry();
		CalculatorLogic cl = new CalculatorLogic();

		//無限ループの開始
		while(true) {
			//A.入力待ち
			System.out.println("計算式を入力してください(例: 10 + 5) または 'quit' で終了:");

			//B.入力受付
			String inputValue = scanner.nextLine();
			if (inputValue.trim().equalsIgnoreCase("quit")) {
                System.out.println("電卓アプリを終了します。");
                //ループを抜ける
                break;
            }

			try {
				//C.解析検証
				CalculationData data = ue.parseAndValidate(inputValue);

				//D.計算実行
				double result = cl.calculate(data);

				//E.計算結果を表示
				System.out.println("結果：" + result);

			}catch(InputFormatException e){
				//入力エラーの捕捉と表示
				System.out.println("エラー (入力形式): " + e.getMessage());

			} catch (ArithmeticException e) {
                //ゼロ除算エラーの捕捉と表示
                System.out.println("エラー (計算): " + e.getMessage());
			}catch (Exception e) {
                // 予期せぬその他のエラーの捕捉
                System.out.println("予期せぬエラーが発生しました: " + e.getMessage());
            }
		}

		// アプリ終了時にScannerをクローズする（リソース解放）
        scanner.close();

	}
}
