package com.example.typing;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Practice implements TypingInterface {

    private long totalTime;
    private int okCount;
    private String record;
    private EditText editText;
    private TextView textView;
    private TextView text;
    private TextView text1;
    private Button button;
    String string;

    public void toPractice(MainActivity mainActivity) {
        textView = (TextView) mainActivity.findViewById(R.id.text_view);
        editText = (EditText) mainActivity.findViewById(R.id.edit_text);
        text = (TextView) mainActivity.findViewById(R.id.answer);
        text1 = (TextView) mainActivity.findViewById(R.id.total);
        button = (Button) mainActivity.findViewById(R.id.next);

        for (int i = 0; i < questionNumber; i++) {
            doWord();
        }
        doResult();
    }

    private void doWord () {
        long time = System.currentTimeMillis();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.equals(string)) {
                    text.setText("正解");
                    okCount++;
                } else {
                    text.setText("残念");
                }
            }
        });
        totalTime = totalTime + System.currentTimeMillis() - time;
    }

    private void doResult() {
        text1.setText("今回の成績は" + record);
        //今回の成績
        //正解数(okCount + "/" + questionNumber);
        record = (okCount > 4) ? result[0] : result[1];
        //入力タイム(totalTime / 1000 + 秒);
        //改行
        //プリントrecord*/
    }

}