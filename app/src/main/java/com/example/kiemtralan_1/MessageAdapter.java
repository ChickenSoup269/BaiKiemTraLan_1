package com.example.kiemtralan_1;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<BankMessage> {

    private Context context;
    private int resource;

    public MessageAdapter(Context context, int resource, List<BankMessage> messages) {
        super(context, resource, messages);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }
        BankMessage message = getItem(position);

        if (message != null) {
            TextView txtDate = convertView.findViewById(R.id.txtDate);
            TextView txtContent = convertView.findViewById(R.id.txtContent);

            txtDate.setText(message.getDate());
            txtContent.setText(message.getContent());
        }

        return convertView;
    }
}
