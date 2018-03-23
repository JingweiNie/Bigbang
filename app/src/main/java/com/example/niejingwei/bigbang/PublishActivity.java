package com.example.niejingwei.bigbang;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class PublishActivity extends Activity implements View.OnClickListener{
    private FrameLayout frameLayout;
    private ImageView taskPublish;
    private ImageView goodspublish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        frameLayout=findViewById(R.id.publish_activity);
        taskPublish=findViewById(R.id.task_publish_imagebutton);
        goodspublish=findViewById(R.id.goods_publish_imagebutton);
        frameLayout.setOnClickListener(this);
        taskPublish.setOnClickListener(this);
        goodspublish.setOnClickListener(this);
        overridePendingTransition(R.anim.enter,R.anim.out);
    }

    @Override
    public void onBackPressed() {
        setResult(0);
        finish();
        overridePendingTransition(R.anim.enter,R.anim.out);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.publish_activity:
                setResult(0);
                finish();
                overridePendingTransition(R.anim.enter,R.anim.out);
                break;
                default:break;
        }
    }
}
