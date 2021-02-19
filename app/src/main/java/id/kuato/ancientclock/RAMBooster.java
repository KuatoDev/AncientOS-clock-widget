package id.kuato.ancientclock;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import id.kuato.ancientclock.R;
import android.app.PendingIntent;
public class RAMBooster extends AppWidgetProvider{
    
    public void onReceive(Context context, Intent intent)
    {
        String act=intent.getAction();
        if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(act))
        {
            RemoteViews rambooster =new RemoteViews(context.getPackageName(), R.layout.ram_booster);
            AppWidgetManager.getInstance(context).updateAppWidget(intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS), rambooster);
        }
        
    }
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Create an Intent to launch ExampleActivity when clicked
        Intent intent = new Intent(context, RAMBooster.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ram_booster);
        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.boost, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

}
