package id.kuato.ancientclock;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import id.kuato.ancientclock.R;
public class SugionoWibowo extends AppWidgetProvider
{
    public void onReceive(Context context, Intent intent)
    {
        String act=intent.getAction();
        if (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(act))
        {
            RemoteViews SugionoWibowoclock =new RemoteViews(context.getPackageName(), R.layout.big_clock);
            AppWidgetManager.getInstance(context).updateAppWidget(intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS), SugionoWibowoclock);
        }
    }
}
