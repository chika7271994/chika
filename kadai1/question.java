package jp.ibscorp.java.kadai1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question {

	public static List<String> question = new ArrayList<String>();
	boolean answer;

	public void setSameWord(String setWord){
		this.question.add(setWord);
	}

	public boolean getSameWord(String getWord){
		return answer = Arrays.asList(question).contains(getWord);
	}
}
