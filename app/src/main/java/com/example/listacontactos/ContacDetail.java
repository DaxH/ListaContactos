package com.example.listacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ContacDetail extends AppCompatActivity {

    private TextView txtName;
    private ImageView imgImage;
    private TextView txtPhone;
    private TextView txtDetail;
    private TextView txtEmail;
    private TextView txtCity;
    private String name;
    private String image;
    private String detail;
    private String phone;
    private String email;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contac_detail);

        txtName = (TextView) findViewById(R.id.textnombre);
        imgImage = (ImageView) findViewById(R.id.imageView);
        txtPhone = (TextView) findViewById(R.id.textelefono);
        txtEmail = (TextView) findViewById(R.id.textcorreo);
        txtCity = (TextView) findViewById(R.id.textciudad);
        txtDetail = (TextView) findViewById(R.id.textDescripcion);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        image = intent.getStringExtra("image");
        city = intent.getStringExtra("city");
        detail = intent.getStringExtra("detail");
        phone = intent.getStringExtra("phone");
        email = intent.getStringExtra("email");

        Contact();
    }

    private void Contact(){
        txtName.setText(name);
        Glide.with(this).load(image).into(imgImage);
        txtPhone.setText(phone);
        txtDetail.setText(detail);
        txtCity.setText(city);
        txtEmail.setText(email);

    }
}
