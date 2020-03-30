package com.example.listacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listacontactos.adapter.Adapter;
import com.example.listacontactos.manger.FirebaseContactManager;
import com.example.listacontactos.model.Contact;

import java.util.ArrayList;

public class List extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    private ListView mListView;
    private Adapter adapter;
    private  ArrayList <Contact> mListContact = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListView =(ListView) findViewById(R.id.listView);
        mListView.setOnItemClickListener(this);

        mListContact = (ArrayList<Contact>) FirebaseContactManager.getInstance().getAllContacts();

        if (mListContact != null && mListContact.size() > 0 ){
            mListView.setVisibility(View.VISIBLE);
            adapter = new Adapter(this, mListContact);
            mListView.setAdapter(adapter);

        }else {
            mListView.setVisibility(View.GONE);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // start detail screen when an item list is pressed
        Contact contacto = mListContact.get(position);
        Intent intent = new Intent(getApplicationContext(), ContacDetail.class);
        intent.putExtra("name",contacto.getName());
        intent.putExtra("image",contacto.getImageUrl());
        intent.putExtra("city",contacto.getCity());
        intent.putExtra("phone",contacto.getPhone());
        intent.putExtra("detail",contacto.getDescription());
        intent.putExtra("email",contacto.getEmail());

        startActivity(intent);

    }
}
