package org.codeforcoffee.houseofcards;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    AlertDialog.Builder mAlert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAlert = new AlertDialog.Builder(this);     // new alert dialog w/access to context
        mAlert.setView(R.layout.dialog_add_new);    // set dialog view to xml file

        // set a positive button :)
        // and override the OnClickListener
        mAlert.setPositiveButton(R.string.dialog_add, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Dialog popup = (Dialog) dialog;
                EditText headerText = (EditText) popup.findViewById(R.id.input_header);
                EditText bodyText = (EditText) popup.findViewById(R.id.input_body);

                // create a new bundle to send to our fragment
                Bundle fragmentArguments = new Bundle();
                fragmentArguments.putString("HEAD", headerText.getText().toString());
                fragmentArguments.putString("BODY", bodyText.getText().toString());
                // add our values ^^

                // do the fragment
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                CardFragment underwoodCard = new CardFragment();
                underwoodCard.setArguments(fragmentArguments);  // set our bundle from above
                // to our fragment's arguments

                ft.add(R.id.card_holder, underwoodCard);

                ft.commit();
                // commit my fragment
            }
        });
        mAlert.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ScrollingActivity.this, "User cancelled adding", Toast.LENGTH_SHORT).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAlert.show(); // show our dialog :)

                Snackbar.make(view, "AHAAAHAAHA CARDSSSSS", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
