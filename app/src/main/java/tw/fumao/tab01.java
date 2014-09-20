
package tw.fumao;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class tab01 extends Activity {
    WebView this_webview;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab01);


        this_webview = (WebView) findViewById(R.id.webView);

        this_webview.setHorizontalScrollBarEnabled(true);
        this_webview.setVerticalScrollBarEnabled(true);
        this_webview.getSettings().setJavaScriptEnabled(false);
        this_webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this_webview.getSettings().setBuiltInZoomControls(false);
        this_webview.getSettings().setSupportZoom(false);
        this_webview.getSettings().setUseWideViewPort(false);

        this_webview.getSettings().setDefaultTextEncodingName("UTF-8");
        this_webview.loadUrl("file:///android_asset/desp");
    }
}