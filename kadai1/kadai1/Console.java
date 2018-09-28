package jp.ibscorp.java.kadai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//キーボードの入力を制御をするクラス
public class Console {

	/**
	* Enter of Console
	* @author T.Nozawa
	*/

	private static BufferedReader reader;

	static{
		reader = new BufferedReader
			(new InputStreamReader(System.in));
	}

	//1行入力
	public static String readLine(){
		try {
			return reader.readLine();
		}catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	//１行出力
	public static void println(String line){
		System.out.println(line);
	}

	//1行出力した後、１行入力
	//メッセージを表示した後に入力を行い場合などに利用する
	public static String printlnAndReadLine(String line){
		System.out.println(line);
		return readLine();
	}


	//指定した時間（ミリ秒）スリープする
	public static void sleep(int ms){
		try {
			Thread.sleep(ms);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
