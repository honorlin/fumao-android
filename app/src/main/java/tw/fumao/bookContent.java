package tw.fumao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;

public class bookContent extends Activity {
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView(R.layout.bookcontent);

        showBookContent();
        
        Button next = (Button) findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
    }
    
    private void showBookContent()
    {
       WebView wView = (WebView)findViewById(R.id.webView1);
        
        wView.loadUrl("file:///android_asset/" + common.paramater);
    	
       // TextView textv = (TextView)findViewById(R.id.textView1);
       // textv.setText(common.bookTitle);

        /*
        wView.setWebViewClient (new WebViewClient () {
            @ Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("vnd.youtube")){
                
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            
            return true;
            }
            else
            {
            return false;
            }
            }
        });

        */
    }
   
}
