package com.example.qrapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    EditText qr_value;
    Button generateBtn,scanBtn;
    ImageView qrImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qr_value = findViewById(R.id.qrinput);
        generateBtn = findViewById(R.id.generateBtn);
        qrImage = findViewById(R.id.qrPlaceHolder);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = qr_value.getText().toString();
                if(data.isEmpty()){
                    qr_value.setError("WE NEED VALUE IDIOT.");
                }else {
                    QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 500);
                    Bitmap qrbits = qrgEncoder.getBitmap();
                    qrImage.setImageBitmap(qrbits);
                }
            }
        });


    }
}