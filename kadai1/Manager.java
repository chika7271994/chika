package jp.ibscorp.java.kadai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Javaの予約語を制御するクラス
public class Manager implements TypingInterface {

	/**
	* The managment of word
	* @author T.Nozawa
	*/

	static final String FILE_PATH = "words.txt";
	private static Manager instance = new Manager();
	private List<String> words = new ArrayList();

	private Random rand = new Random();

	public static Manager getInstance(){
		return instance;
	}



	private Manager(){

		try{
			BufferedReader in = new BufferedReader
					(new FileReader("C:/java/words.txt"));

			String line;

			while( (line = in.readLine() )!= null){
				line = line.trim();

				//空白行と＃で始まるコメント行は無視する
				if(line.length() > 0 && !line.startsWith("#")){
					words.add(line);
					//if(!words.containsAll(question)){

				//}
			}
		}
		in.close();

		}catch(IOException e){
			e.printStackTrace();
			throw new IllegalStateException("initialize fail");
		}
	}

	public String getWord(){
		int index = rand.nextInt(words.size());
		return (String)words.get(index);
	}

}
