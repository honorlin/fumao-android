package tw.fumao;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by tinghonglin on 2014/3/29.
 */
public class CHttpGet extends Thread {
    public String url;
    public String result;

    public CHttpGet(String url)
    {
        this.url = url;
    }

    public void run() { // override Thread's run()
        this.result = this.httpGet(this.url);
    }

    public String getResult()
    {
        return this.result;
    }

    private String httpGet(String url)
    {
        HttpClient client = new DefaultHttpClient();

        try
        {
            org.apache.http.client.methods.HttpGet get = new org.apache.http.client.methods.HttpGet(url);

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

}
