package com.example.niejingwei.bigbang;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragments.TaskFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout tab_1=null;
    private LinearLayout tab_2=null;
    private LinearLayout tab_3=null;
    private LinearLayout tab_4=null;
    private ImageView tab_1_icon=null;
    private ImageView tab_2_icon=null;
    private ImageView tab_3_icon=null;
    private ImageView tab_4_icon=null;
    private TextView tab_1_text=null;
    private TextView tab_2_text=null;
    private TextView tab_3_text=null;
    private TextView tab_4_text=null;
    private Fragment fragment_1=null;
    private Fragment fragment_2=null;
    private Fragment fragment_3=null;
    private Fragment fragment_4=null;
    private FragmentManager fragmentManager=getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_1=findViewById(R.id.tab_1);//找到tab的view
        tab_2=findViewById(R.id.tab_2);
        tab_3=findViewById(R.id.tab_3);
        tab_4=findViewById(R.id.tab_4);
        tab_1_icon=findViewById(R.id.tab_1_icon);
        tab_2_icon=findViewById(R.id.tab_2_icon);
        tab_3_icon=findViewById(R.id.tab_3_icon);
        tab_4_icon=findViewById(R.id.tab_4_icon);
        tab_1_text=findViewById(R.id.tab_1_text);
        tab_2_text=findViewById(R.id.tab_2_text);
        tab_3_text=findViewById(R.id.tab_3_text);
        tab_4_text=findViewById(R.id.tab_4_text);
        tab_1.setOnClickListener(this);//分别设置点击事件的监听器
        tab_2.setOnClickListener(this);
        tab_3.setOnClickListener(this);
        tab_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab_1:
                switchTab(1);
                break;
            case R.id.tab_2:
                switchTab(2);
                break;
            case R.id.tab_3:
                switchTab(3);
                break;
            case R.id.tab_4:
                switchTab(4);
                break;
                default:
                    break;
        }
    }
    //负责切换不同tab时的样式变换
    private void switchTab(int index){
        switch (index){
            case 1:
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                if(fragment_1==null)
                {
                    fragment_1=new TaskFragment();
                    fragmentTransaction.add(R.id.fragment_container,fragment_1,"task");
                }
                unselectAllTab();
                tab_1_icon.setImageResource(R.drawable.task_selected);
                tab_1_text.setTextColor(0xfff39c12);
                fragmentTransaction.show(fragment_1);
                fragmentTransaction.commit();
                break;
            case 2:
                unselectAllTab();
                tab_2_icon.setImageResource(R.drawable.secondhand_market_selected);
                tab_2_text.setTextColor(0xfff39c12);
                break;
            case 3:
                unselectAllTab();
                tab_3_icon.setImageResource(R.drawable.publish_selected);
                tab_3_text.setTextColor(0xfff39c12);
                break;
            case 4:
                unselectAllTab();
                tab_4_icon.setImageResource(R.drawable.user_selected);
                tab_4_text.setTextColor(0xfff39c12);
                break;
                default:break;
        }
    }
    private void unselectAllTab(){
        tab_1_icon.setImageResource(R.drawable.task_unselected);
        tab_2_icon.setImageResource(R.drawable.secondhand_market_unselected);
        tab_3_icon.setImageResource(R.drawable.publish_unselected);
        tab_4_icon.setImageResource(R.drawable.user_unselected);
        tab_1_text.setTextColor(0xff515151);
        tab_2_text.setTextColor(0xff515151);
        tab_3_text.setTextColor(0xff515151);
        tab_4_text.setTextColor(0xff515151);
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragment_1);
        fragmentTransaction.commit();
    }
}
