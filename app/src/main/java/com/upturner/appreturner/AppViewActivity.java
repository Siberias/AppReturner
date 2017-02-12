package com.upturner.appreturner;

import android.app.ListActivity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class AppViewActivity extends ListActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get list of installed apps so that we can display them
        final PackageManager packageManager = getPackageManager();

        List<ApplicationInfo> packages =
                packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        Collections.sort(packages, new ApplicationInfo.DisplayNameComparator(packageManager));

        ApplicationInfo[] appInfoArray = new ApplicationInfo[packages.size()];
        packages.toArray(appInfoArray);

        AppInfoArrayAdapter appInfoAdapter = new AppInfoArrayAdapter(this, appInfoArray);
        setListAdapter(appInfoAdapter);

        /*String[] listTestData = new String[]{"lorem", "ipsum", "dolor", "sit", "amet"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.sample_list_view,
                R.id.label,
                listTestData);
        setListAdapter(adapter);*/
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        ApplicationInfo item = (ApplicationInfo) getListAdapter().getItem(position);
        final PackageManager packageManager = getPackageManager();
        Toast.makeText(this, item.loadLabel(packageManager) + " selected", Toast.LENGTH_LONG).show();
    }
}
