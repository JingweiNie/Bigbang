package com.example.niejingwei.bigbang;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.vincent.filepicker.Constant;
import com.vincent.filepicker.activity.ImagePickActivity;
import com.vincent.filepicker.filter.entity.ImageFile;

import java.io.File;
import java.util.ArrayList;

import market.OnItemClickListener;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit_inteface.UpLoadImages;

import static com.vincent.filepicker.activity.VideoPickActivity.IS_NEED_CAMERA;

public class GoodsPublishActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout pickimage;//选择图片的触发区域根布局
    ImageView image1;//预览图1、2、3
    ImageView image2;
    ImageView image3;
    LinearLayout preview_area;//照片选取预览区域的根布局
    Button publish_goods;//发布按钮
    ArrayList<ImageFile> imagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_publish);
        //获取控件id
        pickimage=findViewById(R.id.pickimage_publishgoods);
        image1=findViewById(R.id.imagepreview_1_publishgoods);
        image2=findViewById(R.id.imagepreview_2_publishgoods);
        image3=findViewById(R.id.imagepreview_3_publishgoods);
        preview_area=findViewById(R.id.picture_preview_area_publishgoods);
        publish_goods=findViewById(R.id.publish_goods_btn);
        //设置监听事件
        pickimage.setOnClickListener(this);
        publish_goods.setOnClickListener(this);
        //
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pickimage_publishgoods:
                Intent intent1 = new Intent(this, ImagePickActivity.class);
                intent1.putExtra(IS_NEED_CAMERA, true);
                intent1.putExtra(Constant.MAX_NUMBER, 3);
                startActivityForResult(intent1, Constant.REQUEST_CODE_PICK_IMAGE);
                break;
            case R.id.publish_goods_btn:
                File file=new File(imagelist.get(0).getPath());
                RequestBody requestBody=RequestBody.create(MediaType.parse("image/png"),file);
                MultipartBody.Part photo=MultipartBody.Part.createFormData("PHOTOS","testimage.png",requestBody);
                Retrofit retrofit=new Retrofit.Builder().baseUrl("http://39.106.223.131:8080/Test/").addConverterFactory(ScalarsConverterFactory.create()).build();
                UpLoadImages upLoadImages=retrofit.create(UpLoadImages.class);
                Call<String> doUpload=upLoadImages.uploadimage(photo,RequestBody.create(null,"niejingwei"));
                doUpload.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(),response.body(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case Constant.REQUEST_CODE_PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    imagelist = data.getParcelableArrayListExtra(Constant.RESULT_PICK_IMAGE);
                    BitmapFactory.Options options=new BitmapFactory.Options();
                    options.inJustDecodeBounds=false;
                    options.inSampleSize=5;

                    if (imagelist.size()==3){
                        preview_area.setVisibility(View.VISIBLE);
                        image3.setImageBitmap(BitmapFactory.decodeFile(imagelist.get(2).getPath(), options));
                        image3.setVisibility(View.VISIBLE);
                        image2.setImageBitmap(BitmapFactory.decodeFile(imagelist.get(1).getPath(),options));
                        image2.setVisibility(View.VISIBLE);
                        image1.setImageBitmap(BitmapFactory.decodeFile(imagelist.get(0).getPath(),options));
                        image1.setVisibility(View.VISIBLE);
                    }
                    if(imagelist.size()==2){
                        preview_area.setVisibility(View.VISIBLE);
                        image3.setVisibility(View.GONE);
                        image2.setImageBitmap(BitmapFactory.decodeFile(imagelist.get(1).getPath(),options));
                        image2.setVisibility(View.VISIBLE);
                        image1.setImageBitmap(BitmapFactory.decodeFile(imagelist.get(0).getPath(),options));
                        image1.setVisibility(View.VISIBLE);
                    }
                    if (imagelist.size()==1){
                        preview_area.setVisibility(View.VISIBLE);
                        image3.setVisibility(View.GONE);
                        image2.setVisibility(View.GONE);
                        image1.setImageBitmap(BitmapFactory.decodeFile(imagelist.get(0).getPath(),options));
                        image1.setVisibility(View.VISIBLE);
                    }
                    if(imagelist.size()==0){
                        image3.setVisibility(View.GONE);
                        image2.setVisibility(View.GONE);
                        image1.setVisibility(View.GONE);
                        preview_area.setVisibility(View.GONE);
                    }
                }
                break;
        }

    }
}
