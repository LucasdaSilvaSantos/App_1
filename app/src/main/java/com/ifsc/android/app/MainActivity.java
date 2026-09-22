package com.ifsc.android.app;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<PackageInfo> installedApps;
    List<ResolveInfo> appsListIntentMain;
    ArrayList<ApplicationInfo> apps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // sempre deve ter o ContentView!!!
        ListView listView = findViewById(R.id.listview_apps);
        PackageManager packageManager = getPackageManager();

        /*Cria uma Intent com a ação ACTION_MAIN, que é usada para filtrar aplicativos
        * que tenham uma atividade principal. O segundo argumento null indica que não há
        * um componente expecífico a ser direcionado neste momento.*/
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        appsListIntentMain = packageManager.queryIntentActivities(mainIntent, 0);
        //Convert resolveInfo em PackageInfo para podermos listar os apps.
        apps=new ArrayList<>();
        for (ResolveInfo resolveInfo : appsListIntentMain) {
            try {
                String packageName = resolveInfo.activityInfo.packageName;
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                apps.add(packageInfo.applicationInfo);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        AppAdapter appAdapter = new AppAdapter(this, R.layout.item_list, apps);
        listView=findViewById(R.id.listview_apps);
        listView.setAdapter(appAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            PackageInfo packageInfo = installedApps.get(position);
            String packageName = packageInfo.packageName;
            Intent launchintent = packageManager.getLaunchIntentForPackage(packageName);
            if (launchintent != null) {
                startActivity(launchintent);
            }
        }
        );

    }



}