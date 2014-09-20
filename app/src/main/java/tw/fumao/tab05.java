package tw.fumao;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;

public class tab05 extends Activity implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView(R.layout.tab05);
        WebView webView1 = (WebView) findViewById(R.id.webView);

        webView1.getSettings().setDefaultTextEncodingName("UTF-8");
        webView1.getSettings().setBuiltInZoomControls(true);
        webView1.getSettings().setSupportZoom(true);
        webView1.loadUrl("file:///android_asset/about");

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }


    private String getResourceValue(String xmlName,String resourceName)
    {

        int id = getResources().getIdentifier(resourceName, xmlName, getPackageName());
        String value = id == 0 ? "" : (String) getResources().getText(id);

        return value;

    }

}
