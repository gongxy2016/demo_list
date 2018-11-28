package com.demo.gong.mydemoapplication.DemoCamera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.demo.gong.mydemoapplication.R;

import java.io.File;

public class TestPhotoActivity extends AppCompatActivity {

    private Button btnTakePhoto;
    private ImageView ivShowPhoto;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_photo);

        btnTakePhoto = (Button)findViewById(R.id.btn_takephoto);
        ivShowPhoto = (ImageView)findViewById(R.id.iv_showphoto);

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_takephoto) {
                    Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(),"2.jpg");

                    if (filePath == null) {
                        Toast.makeText(TestPhotoActivity.this,"无法打开相机",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!filePath.exists()) {
                        Log.i("TestPhotoActivity","filePath不存在：filePath="+filePath.getPath());
                    }
                    uri = Uri.fromFile(filePath);
                    openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                    startActivityForResult(openCameraIntent,0);
                }
            }
        });
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
        }
    }
}
