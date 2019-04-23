package com.example.part3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;

public class RealmReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_read);

        TextView titleView = findViewById(R.id.realm_read_title);
        TextView contentView = findViewById(R.id.realm_read_content);

        // intent에서 넘어온 문자열 추출
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        Realm mRealm = Realm.getDefaultInstance();
        MemoVO vo = mRealm.where(MemoVO.class).equalTo("title", title).findFirst();
        titleView.setText(vo.title);
        contentView.setText(vo.content);
    }
}
