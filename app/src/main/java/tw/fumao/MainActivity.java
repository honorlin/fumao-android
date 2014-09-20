package tw.fumao;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        // Tab for Photos
        TabSpec tab01 = tabHost.newTabSpec("tab01");
        // setting Title and Icon for the Tab
        //tab01.setIndicator((String) this.getResources().getText(R.string.tab01), getResources().getDrawable(R.drawable.ic_launcher));
        tab01.setIndicator((String) this.getResources().getText(R.string.tab01), null);
        Intent tab01Intent = new Intent(this, tw.fumao.tab01.class);
        tab01.setContent(tab01Intent);

        // Tab for Songs
        TabSpec tab02 = tabHost.newTabSpec("tab02");
        tab02.setIndicator((String) this.getResources().getText(R.string.tab02),null);
        Intent tab02Intent = new Intent(this, tw.fumao.tab02.class);
        tab02.setContent(tab02Intent);
/*
        // Tab for Videos
        TabSpec tab03 = tabHost.newTabSpec("tab03");
        tab03.setIndicator((String) this.getResources().getText(R.string.tab03), null);
        Intent tab03Intent = new Intent(this, tw.com.fumao.tab03.class);
        tab03.setContent(tab03Intent);

        // Tab for Videos
        TabSpec tab04 = tabHost.newTabSpec("tab04");
        tab04.setIndicator((String) this.getResources().getText(R.string.tab04), null);
        Intent tab04Intent = new Intent(this, tw.com.fumao.tab04.class);
        tab04.setContent(tab04Intent);
*/
        // Tab for Videos
        TabSpec tab05 = tabHost.newTabSpec("tab05");
        tab05.setIndicator((String) this.getResources().getText(R.string.tab05), null);
        Intent tab05Intent = new Intent(this, tw.fumao.tab05.class);
        tab05.setContent(tab05Intent);



        // Adding all TabSpec to TabHost
        tabHost.addTab(tab01); // Adding photos tab
        tabHost.addTab(tab02); // Adding songs tab
//        tabHost.addTab(tab03); // Adding videos tab
//        tabHost.addTab(tab04); // Adding videos tab
        tabHost.addTab(tab05); // Adding videos tab

        //set icons padding
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++){
            tabHost.getTabWidget().getChildAt(i).setPadding(5,5,5,15);
            tabHost.getTabWidget().getChildAt(i).getLayoutParams().height = 68;
        }


    }
}