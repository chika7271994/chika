package com.example.kakeibo.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.kakeibo.R;
import com.example.kakeibo.database.DatabaseManager;
import com.example.kakeibo.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class SpendingFragment extends BaseFragment {

    private static final String TAG = SpendingFragment.class.getSimpleName();

    public static SpendingFragment newInstance(String day) {
        SpendingFragment fragment = new SpendingFragment();
        //値を受け取る
        Bundle bundle = new Bundle();
        bundle.putString("data", day);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.textSyuusi)
    TextView textView;
    @BindView(R.id.syuusi_switch)
    Switch aSwitch;

    private DatabaseManager mDatabase; //データベースクラス
    private String day;                //日付

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //日付の値を取得
        Bundle bundle = getArguments();
        day = bundle.getString("data");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //レイアウト作成
        View view = inflater.inflate(R.layout.spending_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnCheckedChanged(R.id.syuusi_switch)
    void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            LogUtil.debug("スイッチ", "支出");
        }else {
            LogUtil.debug("スイッチ", "収入");
            changeView();
        }
    }

    @OnClick(R.id.syuusi_input)
    void onClick() {
            LogUtil.debug(TAG, "onActivityCreated");
            mDatabase = DatabaseManager.getInstance(getActivity());
            addData();
        }

    private void addData(){
        String category = editText1.getText().toString();
        String price = editText2.getText().toString();
        int i = Integer.valueOf(price);
        LogUtil.debug("addData", "categoryは" + category);
        LogUtil.debug("addData", "priceは" + price);
        LogUtil.debug("addData", "日付は"+ day);
        //データベースに書き込み
        mDatabase.addSpending(category, i, day);
    }

    //入力したデータベースの出力
    @OnClick(R.id.syuusi_show)
    void onAddClick() {
        Cursor cursor = mDatabase.retrieveByDate(day);
        StringBuilder builder = new StringBuilder();
        if(cursor.moveToFirst()) {
            do {
                builder.append(cursor.getString(1) + " ");
                builder.append(cursor.getInt(2) + "\n");
            } while (cursor.moveToNext());
        }
        textView.setText(builder.toString());
    }

    void changeView(){
        navigateToFragment(IncomeFragment.newInstance(day));
    }
}
