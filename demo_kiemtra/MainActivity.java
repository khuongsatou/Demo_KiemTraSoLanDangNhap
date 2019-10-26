package com.example.demo_kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String tk = "truongvanty", mk = "123456";
    private int dem = 0;
    public static final String UserName = "username";
    public static final String PassWord = "password";
    private Button btnDangNhap, btnClose;
     private EditText edtTK, edtMK;
     private TextView txtError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //start activities
                if( edtTK.getText().toString().equals(tk) && edtMK.getText().toString().equals(mk)){
                    Intent intent = new Intent(MainActivity.this, activity_profile.class);

                    intent.putExtra(UserName,tk);
                    intent.putExtra(PassWord,mk);
                    startActivity(intent);
                }
                else{
                    if(dem >= 3)
                        close();
                    dem++;
                    txtError.setText("Đăng nhập thất bại lần " + dem);


                }


            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    void close(){
        finish();

    }

    void AnhXa(){
        btnDangNhap = findViewById(R.id.btnLogin);
        btnClose = findViewById(R.id.btnClose);
        edtTK = findViewById(R.id.edtusername);
        edtMK = findViewById(R.id.edtpassword);
        txtError = findViewById(R.id.txtAlert);

    }


}
