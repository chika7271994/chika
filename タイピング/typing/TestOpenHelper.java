package com.example.typing;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestOpenHelper extends SQLiteOpenHelper {

    // データーベースのバージョン
    private static final int DATABASE_VERSION = 1;

    // データーベース名
    private static final String DATABASE_NAME = "TestDB.db";
    private static final String TABLE_NAME = "testdb";
    private static final String _ID = "_id";
    private static final String COLUMN_NAME_TITLE = "words";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    TestOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブル作成
        db.execSQL(
                SQL_CREATE_ENTRIES
        );

        saveData(db, "abstract");
        saveData(db, "assert");
        saveData(db, "boolean");
        saveData(db, "break");
        saveData(db, "byte");
        saveData(db, "case");
        saveData(db, "catch");
        saveData(db, "char");
        saveData(db, "class");
        saveData(db, "continue");
        saveData(db, "default");
        saveData(db, "do");
        saveData(db, "double");
        saveData(db, "enum");
        saveData(db, "else");
        saveData(db, "extends");
        saveData(db, "final");
        saveData(db, "finally");
        saveData(db, "float");
        saveData(db, "for");
        saveData(db, "if");
        saveData(db, "import");
        saveData(db, "implements");
        saveData(db, "instanceof");
        saveData(db, "int");
        saveData(db, "interface");
        saveData(db, "long");
        saveData(db, "native");
        saveData(db, "new");
        saveData(db, "package");
        saveData(db, "private");
        saveData(db, "protected");
        saveData(db, "public");
        saveData(db, "return");
        saveData(db, "short");
        saveData(db, "static");
        saveData(db, "strictfp");
        saveData(db, "super");
        saveData(db, "switch");
        saveData(db, "synchronized");
        saveData(db, "this");
        saveData(db, "throw");
        saveData(db, "throws");
        saveData(db, "transient");
        saveData(db, "try");
        saveData(db, "void");
        saveData(db, "volatile");
        saveData(db, "while");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // アップデートの判別
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    void saveData(SQLiteDatabase db, String words){
        ContentValues values = new ContentValues();
        values.put("words", words);

        db.insert("testdb", null, values);
    }
}
