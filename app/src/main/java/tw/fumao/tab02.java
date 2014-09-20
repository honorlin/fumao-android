package tw.fumao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tab02 extends Activity implements View.OnClickListener {

    WebView[] webview_show;
    TextView textv;
    Button button1;
    View this_webview;
    LinearLayout this_linearlLayout;
    String this_number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature( Window.FEATURE_NO_TITLE );

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        init_main_view();
    }

    private void init_main_view()
    {
        setContentView(R.layout.tab02);
        this_linearlLayout = new LinearLayout(this);
        ListView list = (ListView) findViewById(R.id.ListView01);

        int all_count = Integer.parseInt(getResourceValue("string","tab2_count"));

        webview_show = new WebView[all_count];

        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for(int i=1;i<=all_count;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
           // map.put("ItemImage", getResources().getIdentifier("drawable/" + getResourceValue("string","tab2_image"), null, getPackageName()));
            map.put("ItemImage", null);

            if (getResourceValue("string","tab2_" + i + "_type").equals("title"))
                map.put("ItemTitle", "●  " + getResourceValue("string","tab2_" + i));
            else if (getResourceValue("string","tab2_" + i + "_type").equals("subtitle"))
                map.put("ItemTitle", "○  " + getResourceValue("string","tab2_" + i));
            else if (getResourceValue("string","tab2_" + i + "_type").equals("item"))
                map.put("ItemTitle", " --    " + getResourceValue("string", "tab2_" + i));
            else if (getResourceValue("string","tab2_" + i + "_type").equals("item2"))
                map.put("ItemTitle", " -- --    " + getResourceValue("string", "tab2_" + i));
           // map.put("ItemSubTitle", getResourceValue("string","tab2_" + i + "_sub"));
           // map.put("ItemEZcontent", getResourceValue("string","tab2_" + i + "_ez_content"));
            listItem.add(map);
        }

        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,
                R.layout.tab02_item,

                new String[] {"ItemImage", "ItemTitle"},

                new int[] {R.id.ItemImage , R.id.ItemTitle }
        );

        list.setAdapter(listItemAdapter);


        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                show_webView(arg2);
            }
        });


        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

            @Override
            public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {

            }
        });

    }

    private void show_webView(int index)
    {


        int this_index = index + 1;

        if (getResourceValue("string", "tab2_" + this_index + "_url").equals("")) return;
        this_number = getResourceValue("string", "tab2_" + this_index + "_url");

/*
        if(webview_show[index] == null)
        {
            webview_show[index] = new WebView(this);
            webview_show[index].getSettings().setDefaultTextEncodingName("UTF-8");
            webview_show[index].loadUrl("file:///android_asset/tab2/categories" + getResourceValue("string", "tab2_" + this_index + "_url"));

        }

        this_webview = webview_show[index];

        textv = new TextView(this);
        textv.setText(getResourceValue("string", "tab2_" + this_index));

        //TextView thisTextView = (TextView) findViewById(R.id.textView_book_title);
        //thisTextView.setText(getResourceValue("string", "book_" + this_index));

        button1 = new Button(this);
       // button1.setText(getResourceValue("string", "back_book"));
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                init_main_view();
            }
        });
        webview_show[index].setWebViewClient(new WebViewClient() {
        });


        RelativeLayout popwindow=new RelativeLayout(this);
       // FrameLayout.LayoutParams rl= new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 50);
       // popwindow.setLayoutParams(rl);
;
        webview_show[index].setId(0X100);

        webview_show[index].getSettings().setJavaScriptEnabled(true);
        webview_show[index].getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
       // webview_show[index].setScrollContainer(false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        //params.setMargins(0, 20, 0, 0);
        webview_show[index].setLayoutParams(params);
        webview_show[index].getSettings().setBuiltInZoomControls(true);
        webview_show[index].getSettings().setSupportZoom(true);

        button1.setId(0X101);
        button1.setText("X");
        button1.setBackgroundColor(Color.WHITE);
        RelativeLayout.LayoutParams bparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        bparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        bparams.addRule(RelativeLayout.ALIGN_TOP, webview_show[index].getId());
        button1.setLayoutParams(bparams);
        popwindow.addView(webview_show[index]);
        popwindow.addView(button1);
        setContentView(popwindow);
*/

        setContentView(R.layout.bookcontent);

        WebView webview1 = (WebView) findViewById(R.id.webView1);

        webview1.getSettings().setDefaultTextEncodingName("UTF-8");
        webview1.loadUrl("file:///android_asset/tab2/categories" + getResourceValue("string", "tab2_" + this_index + "_url"));
        webview1.getSettings().setBuiltInZoomControls(true);
        webview1.getSettings().setSupportZoom(true);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setId(0X101);
        button1.setText("返回");
        button1.setBackgroundColor(Color.WHITE);
       // RelativeLayout.LayoutParams bparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
       // bparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
       // bparams.addRule(RelativeLayout.ALIGN_TOP, webview_show[index].getId());
       // button1.setLayoutParams(bparams);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                init_main_view();
            }
        });

        Button button_approval = (Button)findViewById(R.id.button_join);

        button_approval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String url = "http://review.fumao.today/categories/" + this_number;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                //WebView webview1 = (WebView) findViewById(R.id.webView1);
                //webview1.loadUrl("http://review.fumao.today/categories/" + this_number);
            }

        });

        String[] votes = getVotes("http://review.fumao.today/categories/" + getResourceValue("string", "tab2_" + this_index + "_url"));

        TextView textView_approval = (TextView)findViewById(R.id.textView_approval);
        textView_approval.setText(votes[0]);
        TextView textView_opposition = (TextView)findViewById(R.id.textView_opposition);
        textView_opposition.setText(votes[1]);
    }

    private boolean vote_approval(String number)
    {
        /*
        try
        {
            String page = chttpGet("http://review.fumao.today/categories/" + number + "/up_vote");
            return  true;
        }
        catch (Exception ex)
        {
            return false;
        }
        */

        WebView webview1 = new WebView(this);

        WebViewClient mWebClient = new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

             view.loadUrl(url);

                return true;
            }
        };
        webview1.setWebViewClient(mWebClient);

        webview1.loadUrl("http://review.fumao.today/categories/" + number);

        webview1.loadUrl("http://review.fumao.today/categories/" + number + "/up_vote");

        return true;
    }

    private boolean vote_opposition(String number)
    {
        /*
        try
        {
            String page = chttpGet("http://review.fumao.today/categories/" + number + "/down_vote");
            return  true;
        }
        catch (Exception ex)
        {
            return false;
        }
        */

        WebView webview1 = new WebView(this);

        webview1.loadUrl("http://review.fumao.today/categories/" + number);

        webview1.loadUrl("http://review.fumao.today/categories/" + number + "/down_vote");


        return true;
    }


    public String[] getVotes(String url)
    {
        String page = chttpGet(url);

        String[] result = new String[2];

        Pattern p = Pattern.compile("<span class=\"badge badge-success\">(.+)<\\/span>");
        Matcher m = p.matcher(page);

        if (m.find()) {
            result[0] = m.group(1);
        }

        p = Pattern.compile("<span class=\"badge badge-important\">(.+)<\\/span>");
        m = p.matcher(page);

        if (m.find()) {
            result[1] = m.group(1);
        }

        return result;
    }

    public String chttpGet(String url)
    {
        HttpClient client = new DefaultHttpClient();

        try
        {
            HttpGet get = new HttpGet(url);

            HttpResponse response = client.execute(get);

            HttpEntity resEntity = response.getEntity();

            String result = EntityUtils.toString(resEntity);

            return result;

        }
        catch (Exception ex)
        {
            return ex.toString();

        } finally {
            client.getConnectionManager().shutdown();
        }

    }

    public void showMessage(String message)
    {
        new AlertDialog.Builder(this)
                .setTitle("")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(null)
                .show();
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
