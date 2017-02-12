package com.upturner.appreturner;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AppViewActivity extends ListActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] listTestData = new String[]{"lorem", "ipsum", "dolor", "sit", "amet"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.sample_list_view,
                R.id.label,
                listTestData);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + "selected", Toast.LENGTH_LONG).show();
    }
}
