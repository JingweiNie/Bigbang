package fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.niejingwei.bigbang.R;

import java.util.ArrayList;
import java.util.List;

import market.Goods;
import market.GoodsAdapter;

public class MarketFragment extends Fragment {
    private View rootview;
    private RecyclerView goodsList;
    private List<Goods> mGoods;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_market, container, false);
        goodsList=rootview.findViewById(R.id.goodsList);
        RecyclerView recyclerView=rootview.findViewById(R.id.goodsList);
        initGoods();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        GoodsAdapter goodsAdapter=new GoodsAdapter(mGoods);
        recyclerView.setAdapter(goodsAdapter);
        return rootview;
    }
    private void initGoods(){
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
