package com.example.lab5reddit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;

import com.example.lab5reddit.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {

    private Context myContext;
    private List<Message> messageList = new ArrayList<Message>();

    public MessageAdapter( Context context, ArrayList<Message> list)
    {
        super(context, 0, list);
        myContext = context;
        messageList = list;
    }

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(myContext).inflate(R.layout.reply_item, parent, false);
        }

        Message currentMessage = messageList.get(position);

        TextView messageText = (TextView) listItem.findViewById(R.id.message_string);
        messageText.setText(currentMessage.getText());
        TextView messageScore = (TextView) listItem.findViewById(R.id.message_score);
        int scoreText = currentMessage.getScore();
        messageScore.setText(String.valueOf(scoreText));

        Button upvoteBtn = (Button) listItem.findViewById(R.id.upvote);
        Button downBtn = (Button) listItem.findViewById(R.id.downvote);
        Button deleteBtn = (Button) listItem.findViewById(R.id.delete);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageList.remove(position);
                notifyDataSetChanged();
            }
        });
        upvoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = messageList.get(position).getScore() + 1;

                notifyDataSetChanged();
            }
        });

        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = messageList.get(position).getScore() - 1;

                notifyDataSetChanged();
            }
        });


        return listItem;
    }

}
