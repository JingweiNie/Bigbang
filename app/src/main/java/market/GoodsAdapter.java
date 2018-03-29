package market;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.niejingwei.bigbang.R;

import java.util.List;

/**
 * Created by niejingwei on 2018/3/23.
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {
    private List<Goods> mGoodsList;
    private OnItemClickListener mOnItemClickListener;

    public GoodsAdapter(List<Goods> mGoodsList) {
        this.mGoodsList = mGoodsList;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        AppCompatImageView goods_pic;
        View rootview;
        TextView goods_describe;
        TextView price;
        TextView address;
        TextView selfLabel_1;
        TextView selfLabel_2;
        TextView selfLabel_3;
        TextView selfLabel_4;
        TextView selfLabel_5;
        TextView sysLabel_1;
        TextView sysLabel_2;
        TextView sysLabel_3;
        TextView sysLabel_4;
        ViewHolder(View itemView) {
            super(itemView);
            rootview=itemView;
            goods_pic=itemView.findViewById(R.id.goods_pic);
            goods_describe=itemView.findViewById(R.id.good_describe);
            price=itemView.findViewById(R.id.goods_price);
            address=itemView.findViewById(R.id.address);
            selfLabel_1=itemView.findViewById(R.id.selfdef_1);
            selfLabel_2=itemView.findViewById(R.id.selfdef_2);
            selfLabel_3=itemView.findViewById(R.id.selfdef_3);
            selfLabel_4=itemView.findViewById(R.id.selfdef_4);
            selfLabel_5=itemView.findViewById(R.id.selfdef_5);
            sysLabel_1=itemView.findViewById(R.id.syslabel_1);
            sysLabel_2=itemView.findViewById(R.id.syslabel_2);
            sysLabel_3=itemView.findViewById(R.id.syslabel_3);
            sysLabel_4=itemView.findViewById(R.id.syslabel_4);
        }
    }
    @Override
    public GoodsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GoodsAdapter.ViewHolder holder, final int position) {
        Goods goods=mGoodsList.get(position);
        holder.goods_pic.setImageResource(goods.getGoods_pic());
        holder.goods_describe.setText(goods.getGoods_describe());
        holder.price.setText(goods.getPrice());
        holder.address.setText(goods.getAddress());
        if(goods.getSelfLabel_1().equals("")){
            holder.selfLabel_1.setVisibility(View.GONE);
        }
        else {
            holder.selfLabel_1.setText(goods.getSelfLabel_1());
        }
        if(goods.getSelfLabel_2().equals("")){
            holder.selfLabel_2.setVisibility(View.GONE);
        }
        else {
            holder.selfLabel_2.setText(goods.getSelfLabel_2());
        }
        if(goods.getSelfLabel_3().equals("")){
            holder.selfLabel_3.setVisibility(View.GONE);
        }
        else {
            holder.selfLabel_3.setText(goods.getSelfLabel_3());
        }
        if(goods.getSelfLabel_4().equals("")){
            holder.selfLabel_4.setVisibility(View.GONE);
        }
        else {
            holder.selfLabel_4.setText(goods.getSelfLabel_4());
        }
        if(goods.getSelfLabel_5().equals("")){
            holder.selfLabel_5.setVisibility(View.GONE);
        }
        else {
            holder.selfLabel_5.setText(goods.getSelfLabel_5());
        }
        //设置系统标签
        if(goods.getSysLabel_1().equals("")){
            holder.sysLabel_1.setVisibility(View.GONE);
        }
        else {
            holder.sysLabel_1.setText(goods.getSysLabel_1());
        }
        if(goods.getSysLabel_2().equals("")){
            holder.sysLabel_2.setVisibility(View.GONE);
        }
        else {
            holder.sysLabel_2.setText(goods.getSysLabel_2());
        }
        if(goods.getSysLabel_3().equals("")){
            holder.sysLabel_3.setVisibility(View.GONE);
        }
        else {
            holder.sysLabel_3.setText(goods.getSysLabel_3());
        }
        if(goods.getSysLabel_4().equals("")){
            holder.sysLabel_4.setVisibility(View.GONE);
        }
        else {
            holder.sysLabel_4.setText(goods.getSysLabel_4());
        }
        holder.rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClickListener(holder.rootview,holder.getLayoutPosition());
            }
        });
        holder.rootview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnItemClickListener.onItemLongClickListener(holder.rootview,holder.getLayoutPosition());
                return true;
            }
        });
    }
    //为了实现自定义的监听接口，这是设置自定义监听器的监听器设置方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener=onItemClickListener;
    }
    public void removeItem(int position){
        mGoodsList.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }
}
