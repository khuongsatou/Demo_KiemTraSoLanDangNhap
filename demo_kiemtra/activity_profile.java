package com.example.demo_kiemtra;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_profile extends AppCompatActivity {

    TextView tk, mk;
    ImageView imgDaidien;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        AnhXa();
        getData();
    }

    public void close(View v) {

        finish();
    }

    void getData() {
        Intent intent = getIntent();
        tk.setText(intent.getStringExtra(MainActivity.UserName));
        mk.setText(intent.getStringExtra(MainActivity.PassWord));

    }

    void AnhXa() {
        tk = findViewById(R.id.txtUsername);
        mk = findViewById(R.id.txtPassword);
        imgDaidien = findViewById(R.id.imgDaiDien);
    }


    public void onclickChangeImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 2){
                Uri selectedIMG = data.getData();

                imgDaidien.setImageURI(selectedIMG);
            }
        }
    }
}
