package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;

    public CustomAdapter(@NonNull Context context, int resource ,String[] colorNames) {
        super(context, resource,colorNames);
        this.context=context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.spinner_item, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textItemSpinner);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageItemSpinner);
        int i = position;
        i++;
        System.out.println(i);
        textView.setText(getContext().getResources().getString(getContext().getResources().getIdentifier("__" + i, "string", getContext().getPackageName())));
        imageView.setBackgroundColor(getContext().getResources().getColor(getContext().getResources().getIdentifier("color_" + i, "color", getContext().getPackageName())));

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.spinner_item, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textItemSpinner);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageItemSpinner);

        int i = position;
        i++;
        System.out.println(i);

        textView.setText(getContext().getResources().getString(getContext().getResources().getIdentifier("__" + i, "string", getContext().getPackageName())));
        imageView.setBackgroundColor(getContext().getResources().getColor(getContext().getResources().getIdentifier("color_" + i, "color", getContext().getPackageName())));

        return convertView;
    }
}
