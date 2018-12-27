package com.demo.gong.mydemoapplication.DemoCameraAndRecoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

import static android.graphics.Canvas.ALL_SAVE_FLAG;

public class TestPhotoActivity extends BaseActivity {

    @BindViews({R.id.btn_takephoto, R.id.btn_go_recoder})
    List<Button> buttonList;
    @BindView(R.id.iv_showphoto)
    ImageView ivShowPhoto;

    Button btnTakePhoto;
    Button btnGoRecoder;
    Uri uri;

    @OnClick({R.id.btn_takephoto, R.id.btn_go_recoder})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_takephoto:
                Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "image2mage2.jpg");

                if (!filePath.exists()) {
                    try {
                        filePath.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(TestPhotoActivity.this, "打开相机失败，无法创建文件", Toast.LENGTH_SHORT).show();
                    }
                    Log.i("TestPhotoActivity", filePath.getAbsolutePath());
                }

                uri = Uri.fromFile(filePath);
                openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(openCameraIntent, 0);
                break;

            case R.id.btn_go_recoder :
                startActivity(new Intent(TestPhotoActivity.this, RecoderActivity.class));
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_photo);

        btnTakePhoto = buttonList.get(0);
        btnGoRecoder = buttonList.get(1);

    }

    private void takeCameraFor7() {
        File tempFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(), "image2.jpg2.jpg");
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        Uri fileUri = getUriForFile(TestPhotoActivity.this, tempFile);
        Log.i("fn_tag", "takeCameraFor7: " + fileUri.getPath());
        i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(i, Activity.DEFAULT_KEYS_DIALER);
    }

    private Uri getUriForFile(Context context, File file) {
        if (context == null || file == null) {
            throw new NullPointerException();
        }
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.demo.gong.fileprovider", file);

        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
/*
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ivShowPhoto.setImageBitmap(bitmap);
*/
            ivShowPhoto.setImageURI(uri);

            Bitmap src = BitmapFactory.decodeFile(uri.getPath());
            int width = src.getWidth();
            int height = src.getHeight();

            //如果图片过大，就需要处理内存不够的问题


            Bitmap newbitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);//创建一个新的位图，长宽和之前一样
            Canvas canvas = new Canvas(newbitmap);
            canvas.drawBitmap(src, 0, 0, null);//在0,0坐标开始画入src
            Paint paint = new Paint();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = sdf.format(new Date(System.currentTimeMillis()));
            paint.setColor(Color.RED);
            paint.setTextSize(100);
            canvas.drawText(time, (float) width / 7, (float) (height * 14) / 15, paint);
            canvas.save(ALL_SAVE_FLAG);
            canvas.restore();

            String photoName = time + ".jpg";
            String photoFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "TestPhoto";
            File file = new File(photoFilePath);
            if (!file.exists()) {
                file.mkdirs();
            }

            String photoPath = photoFilePath + File.separator + photoName;

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(photoPath);
                newbitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Uri uri = Uri.fromFile(file);
//            ivShowPhoto.setImageURI(uri);


        }
    }
}
