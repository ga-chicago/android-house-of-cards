package org.codeforcoffee.houseofcards;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by codeforcoffee on 7/6/16.
 */
public class CardFragment extends android.support.v4.app.Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {

        Bundle argumentsFromActivity = this.getArguments(); // get my arguments from my activity

        View cardFragment = inflater.inflate(R.layout.card_template, container, false);

        TextView header = (TextView) cardFragment.findViewById(R.id.card_header);
        TextView body = (TextView) cardFragment.findViewById(R.id.card_body);

        header.setText(argumentsFromActivity.getString("HEAD"));
        body.setText(argumentsFromActivity.getString("BODY"));

        return cardFragment;
    }

}
