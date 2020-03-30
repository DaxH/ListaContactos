package com.example.listacontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listacontactos.List;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.listacontactos.manger.FirebaseContactManager;
import com.example.listacontactos.model.Contact;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class Splash extends AppCompatActivity implements ValueEventListener {

//    private final int DURACION_SPLASH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(Splash.this, List.class);
//                startActivity(intent);
//                finish();
//            }
//        }, DURACION_SPLASH);
    }

    protected void onStart() {
        super.onStart();
        FirebaseContactManager.getInstance().getContactFromServer(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        for (DataSnapshot contact : dataSnapshot.getChildren()) {
            FirebaseContactManager.getInstance().addContactHashMap(contact.getValue(Contact.class));
        }
        startMainActivity();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

        startMainActivity();
    }


    private void startMainActivity() {
        startActivity(new Intent(Splash.this, List.class));
        finish();
    }
//    <[:{v\
}
