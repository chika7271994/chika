package com.example.ibs_001.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import android.view.View;

public class CanvasView extends View {

    private final ArrayList<Path> pathList;
    private final Paint paint;

    //コンストラクタ--------------------------------------------------
    public CanvasView(Context context) {
        super(context);

        //初期化
        //path
        pathList = new ArrayList<Path>(); //リスト作成

        //paint
        paint = new Paint();
        paint.setColor(Color.RED); //色指定
        paint.setStyle(Paint.Style.STROKE); //描画設定を線に設定
        paint.setAntiAlias(true); //アンチエイリアスの適用
        paint.setStrokeWidth(10); //線の太さ
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //初期化
        //path
        pathList = new ArrayList<Path>();

        //path
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
    }


    //描画メソッド-------------------------------------------------------
    @Override
    protected void onDraw(Canvas canvas){
        for (Path path : pathList){
            canvas.drawPath(path,paint); //pathの描画
        }
        invalidate(); //再描画
    }

    //タッチイベント------------------------------------------------------
    private Path drawingPath;

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: //画面タッチした時
                drawingPath = new Path(); //新たなpathのインスタンス作成
                drawingPath.moveTo(event.getX(),event.getY()); //始点を設定
                pathList.add(drawingPath); //リストにpath追加
                break;
            case MotionEvent.ACTION_UP: //画面から指を離した時
                drawingPath.moveTo(event.getX(),event.getY()); //移動先の追加
                break;
            case MotionEvent.ACTION_MOVE: //タッチしながら指をスライドさせた時
                drawingPath.lineTo(event.getX(),event.getY()); //移動先の追加
                break;
        }
        return true; //返却値は必ずtrueにする
    }

    //削除メソッド-------------------------------------------------------------

    public void allDelete(){
        pathList.clear();
    }
}