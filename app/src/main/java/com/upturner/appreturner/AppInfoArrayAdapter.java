package com.upturner.appreturner;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    packageManager.getApplicationIcon(values[position]), null, null, null);
        } else
        {
            textView.setCompoundDrawablesWithIntrinsicBounds(
                    packageManager.getApplicationIcon(values[position]), null, null, null);
        }

        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(packageManager.getApplicationLabel(values[position]));
        textView.setText(stringBuilder);

        return convertView;
    }
}
