package guytsur.ex1_selfchat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView resource.
        mainListView = (ListView) findViewById(R.id.mainListView);

        ArrayList<String> chatList = new ArrayList<String>();

        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, chatList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );

        Button buttonOne = (Button) findViewById(R.id.send_button);
        final EditText userInput = (EditText) findViewById(R.id.userInput);

        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String text = userInput.getText().toString();
                listAdapter.add(text);
                mainListView.setSelection(listAdapter.getCount() - 1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
