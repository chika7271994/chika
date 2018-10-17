package com.example.typing;

import android.app.Activity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;
    private TestOpenHelper helper;

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
            }
        });

        textView = findViewById(R.id.text_view);

        new Practice();

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

        //for (int i = 0; i < cursor.getCount(); i++) {
        sbuilder.append(cursor.getString(0));
        sbuilder.append("");
        sbuilder.append("\n\n");
        cursor.moveToNext();
        //}

        cursor.close();

        textView.setText(sbuilder.toString());
    }
}