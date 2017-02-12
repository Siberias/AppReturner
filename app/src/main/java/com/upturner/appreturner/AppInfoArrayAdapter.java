package com.upturner.appreturner;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class AppInfoArrayAdapter extends ArrayAdapter<ApplicationInfo> {

    private final Context context;
    private final ApplicationInfo[] values;

    AppInfoArrayAdapter(Context context, ApplicationInfo[] values) {
        super(context, R.layout.sample_list_view, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.sample_list_view, parent, false);
        }

        final PackageManager packageManager = context.getPackageManager();

        TextView textView = (TextView) convertView.findViewById(R.id.label);
        textView.setText(values[position].loadLabel(packageManager));

        return convertView;
    }
}
