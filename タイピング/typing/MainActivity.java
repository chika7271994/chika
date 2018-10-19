package com.example.typing;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static com.example.typing.TypingInterface.questionNumber;
import static com.example.typing.TypingInterface.result;

public class MainActivity extends Activity {

    private TextView textView;
    private TestOpenHelper helper;
    private long totalTime;
    private int okCount;
    private int setCount;
    private String record;
    private EditText editText;
    private TextView answer;
    private TextView total;
    private TextView question;
    private Button check;
    private Button next;
    private Button back;
    AlertDialog mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DB作成
        helper = new TestOpenHelper(getApplicationContext());

        Button readButton = findViewById(R.id.button);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
                toPractice();
            }
        });

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        answer = findViewById(R.id.answer);
        check = findViewById(R.id.check);
        next = findViewById(R.id.next);
        onDialog();

    }

    private void readData() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                "testdb",
                new String[]{"words"},
                null,
                null,
                null,
                null,
                "RANDOM()",
                "1"
        );

        cursor.moveToFirst();

        StringBuilder sbuilder = new StringBuilder();

        sbuilder.append(cursor.getString(0));
        sbuilder.append("");
        cursor.moveToNext();
        cursor.close();
        textView.setText(sbuilder.toString());
    }

    public void toPractice(){

        doWord();
        /*if (setCount == 10){
            setContentView(R.layout.result);
            doResult();
        } */
    }

    public void doWord () {
        long time = System.currentTimeMillis();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.show();
            }
        });
        totalTime = totalTime + System.currentTimeMillis() - time;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                editText.setText("");
                answer.setText("");
                setCount++;
                if (setCount == 10){
                    setContentView(R.layout.result);
                    doResult();
                }
            }
        });
    }

   private void doResult() {
        total = findViewById(R.id.total);
        back = findViewById(R.id.back);
        total.setText("今回の成績は" + record + "\n\n" + "正解数"+okCount + "/" + questionNumber);
        record = (okCount > 4) ? result[0] : result[1];
        //入力タイム(totalTime / 1000 + 秒);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               setContentView(R.layout.activity_main);
           }
       });

    }

    private void onDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("これでOK？");
        //builder.setMessage("OK?");
        builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String string = editText.getText().toString();
                final String word = textView.getText().toString();
                if (word.equals(string)) {
                    answer.setText("正解");
                    okCount++;
                } else {
                    answer.setText("残念");
                }
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        mBuilder = builder.create();
    }
}