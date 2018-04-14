package fragments;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.niejingwei.bigbang.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import market.Goods;
import market.GoodsAdapter;
import market.OnItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit_inteface.GoodsInfo;

public class MarketFragment extends Fragment {
    private Activity mActivity;
    private View rootview;
    private RecyclerView goodsList;
    private List<Goods> mGoods;
    private SmartRefreshLayout smartRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_market, container, false);
        goodsList=rootview.findViewById(R.id.goodsList);
        goodsList.setItemAnimator(new RecyclerView.ItemAnimator() {
            @Override
            public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @Nullable ItemHolderInfo postLayoutInfo) {
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(viewHolder.itemView,"translationX",2000);
                objectAnimator.setDuration(500);
                objectAnimator.start();
                return false;
            }

            @Override
            public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animateChange(@NonNull RecyclerView.ViewHolder oldHolder, @NonNull RecyclerView.ViewHolder newHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public void runPendingAnimations() {

            }

            @Override
            public void endAnimation(RecyclerView.ViewHolder item) {

            }

            @Override
            public void endAnimations() {

            }

            @Override
            public boolean isRunning() {
                return false;
            }
        });
        initGoods();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        goodsList.setLayoutManager(linearLayoutManager);
        final GoodsAdapter goodsAdapter=new GoodsAdapter(mGoods);
        goodsAdapter.setOnItemClickListener(new OnItemClickListener() {//设置自己的recyclerview的点击事件监听器
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(getActivity(),"点击的是第"+position+"个",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClickListener(View view, final int position) {
                new AlertDialog.Builder(getActivity()).setPositiveButton("确认删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goodsAdapter.removeItem(position);
                    }
                }).setNegativeButton("取消",null).setTitle("确认删除吗？").show();
            }
        });
        goodsList.setAdapter(goodsAdapter);
        return rootview;
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    //初始化
    private void init(){
        smartRefreshLayout=rootview.findViewById(R.id.refreshgoodslist);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishRefresh(1000);
            }
        });
    }
    //recycler数据的准备
    private void initGoods(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://39.106.223.131:8080/bigbang/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        GoodsInfo goodsInfo=retrofit.create(GoodsInfo.class);
        Call<String> returndata=goodsInfo.getGoodsList("book");
        returndata.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String[] s=response.body().split("<br>");
                String[] div=s[0].split("\\|");
                StringBuilder t=new StringBuilder();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        mGoods=new ArrayList<>();
        Goods goods=new Goods(R.drawable.goods_test,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","68.00","学二十四","开发板","挥泪甩卖","九成新","","","实名认证","送货上门","数量有限","");
        Goods goods2=new Goods(R.drawable.goods_test2,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","498.00","外招一号楼","开发板","挥泪甩卖","九成新","","","实名认证","送货上门","数量有限","");
        Goods goods3=new Goods(R.drawable.good_test3,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","12.00","学二十四","化妆品","","九成新","","","","送货上门","数量有限","");
        Goods goods4=new Goods(R.drawable.test4,"毕业出闲置了，有需要的学弟学妹吗？","23.00","学二十四","开发板","挥泪甩卖","九成新","","","实名认证","送货上门","数量有限","");
        Goods goods5=new Goods(R.drawable.test5,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","33.00","学十","化妆品","挥泪甩卖","","","","实名认证","送货上门","数量有限","");
        Goods goods6=new Goods(R.drawable.test6,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","10.00","学二十四","化妆品","挥泪甩卖","九成新","","","","送货上门","数量有限","");
        Goods goods7=new Goods(R.drawable.test7,"毕业出闲置了，有需要的学弟学妹吗？","60.00","学二十四","开发板","化妆品","九成新","","","实名认证","送货上门","数量有限","");
        Goods goods8=new Goods(R.drawable.test8,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","13.00","学二十四","化妆品","","九成新","","","实名认证","送货上门","数量有限","");
        Goods goods9=new Goods(R.drawable.test9,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","30.00","学二","化妆品","","九成新","","","","送货上门","","");
        Goods goods10=new Goods(R.drawable.test10,"计算机大三上学期硬件课程需要使用，有需要的学弟学妹吗？","22.00","学二十四","化妆品","挥泪甩卖","九成新","","","实名认证","送货上门","数量有限","");
        for(int i=0;i<10;i++)
        {
            mGoods.add(goods);
            mGoods.add(goods2);
            mGoods.add(goods3);
            mGoods.add(goods4);
            mGoods.add(goods5);
            mGoods.add(goods6);
            mGoods.add(goods7);
            mGoods.add(goods8);
            mGoods.add(goods9);
            mGoods.add(goods10);
        }
    }
}
