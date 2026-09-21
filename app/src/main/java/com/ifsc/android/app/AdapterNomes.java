package com.ifsc.android.app;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class AdapterNomes extends ArrayAdapter<String> {

    public AdapterNomes(@NonNull Context context, int resource, int textViewResourceId, @NonNull String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView=inflater.inflate(R.layout.item_list, null);

        String nome = getItem(position);
        TextView textNome = convertView.findViewById(R.id.textNome);
        EditText editNome = convertView.findViewById(R.id.edNome);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        textNome.setText(Integer.toString(position));
        editNome.setText(nome);

        return convertView;
    }
}
