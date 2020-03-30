package com.example.listacontactos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.bumptech.glide.Glide;
import com.example.listacontactos.R;

import com.example.listacontactos.model.Contact;

public class Adapter extends ArrayAdapter<Contact>{
    private Context context;
    private List<Contact> contactArrayList;


    public Adapter (Context context, List<Contact> contactArrayList) {
        super(context, R.layout.activity_item_list);
        this.context = context;
        this.contactArrayList = contactArrayList;
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Contact getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get a View that displays the data at the specified position in the data set
        View view;
        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.activity_item_list, parent, false);
            viewHolder.mContactName = (TextView) view.findViewById(R.id.textViewItemName);
            viewHolder.mContactImage = (ImageView) view.findViewById(R.id.image);
            viewHolder.mContactCity = (TextView) view.findViewById(R.id.textViewItemCity);

            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        // Set text with the item name
        viewHolder.mContactName.setText(contactArrayList.get(position).getName());

        // set text with the item city

        viewHolder.mContactCity.setText(contactArrayList.get(position).getCity());


        // Set image using Picasso library

        //Picasso.get().load(contactArrayList.get(position).getImageUrl()).into(viewHolder.mContactImage);

        // set imagen using Glide
        Glide.with(context)
                .load(contactArrayList.get(position).getImageUrl())
                .centerCrop()

                .into(viewHolder.mContactImage);



        return view;
    }

    static class ViewHolder {
        protected TextView mContactName;
        protected ImageView mContactImage;
        protected TextView mContactCity;



    }
}