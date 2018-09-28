package jp.ibscorp.java.kadai1;

import java.util.ArrayList;
import java.util.List;

//タイピングを行うクラス
public class Practice implements TypingInterface {

	/**
	* The practice of type
	* @author T.Nozawa
	*/

	private long totalTime;
	private int okCount;
	private String record;
	//static Practice instance = new Practice();
	private List<String> question = new ArrayList();

	public List<String> getQuestion() {
		return question;
	}


	public void setQuestion(List<String> question) {
		this.question = question;
	}


	/*public static Practice getInstance(){
		return instance;
	}*/

	//Start of the TypingGame
	public void toPractice() {
		Console.printlnAndReadLine
			("リターンを押すとはじまります！");

		for(int i=0; i<questionNumber; i++){
			doOneWord();
		}

		Console.println("終了です！");
		Console.println("");
		Console.sleep(3000);

		doResult();
	}

	//Practice java words
	private void doOneWord(){

		Console.println("[READY]");
		Console.sleep(1000);

		String word = manager.getWord();
		Console.println(word);
		question.add(word);

		long time = System.currentTimeMillis();
		String line = Console.readLine();
		//Console.println(line);

		if(line.equals(word)) {
			Console.println("[OK]");
			++this.okCount;
		} else {
			Console.println("[NG]");
		}
		Console.println("");

		this.totalTime = this.totalTime + System.currentTimeMillis() - time;

		Console.sleep(1000);
	}



	//Result announcement
	private void doResult(){
		Console.println("今回の成績は？");
		Console.println("正解数: " + this.okCount + "/" + 10);
		this.record = this.okCount > 4?result[0]:result[1];
		Console.println("入力タイム : " + this.totalTime / 1000L + "秒");
		Console.println("");
		Console.println(this.record);

	}

}

