package tw.fumao;

import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class SingleHttpClient {

    private static final String TAG = "SingleHttpClient";
    private static HttpClient httpClient;

    private SingleHttpClient() {
        // singleton
    }

    public static synchronized HttpClient get() {
        if (httpClient == null) {
            Log.i(TAG, "建立 Singleton HttpClient...");
            HttpParams params = new BasicHttpParams();
            // 取得 connection
            ConnManagerParams.setTimeout(params, 1000);
            // request timeout
            HttpConnectionParams.setConnectionTimeout(params, 5000);
            // response timeout
            HttpConnectionParams.setSoTimeout(params, 10000);
            SchemeRegistry schreg = new SchemeRegistry();
            schreg.register(new Scheme("http",
                    PlainSocketFactory.getSocketFactory(), 80));
            schreg.register(new Scheme("https",
                    SSLSocketFactory.getSocketFactory(), 443));
            // 因為 HttpClient 是 Singleton，所以使用特別的 ConnectionManager
            ClientConnectionManager ccMgr = new ThreadSafeClientConnManager(
                    params, schreg);
            httpClient = new DefaultHttpClient(ccMgr, params);
        }
        return httpClient;
    }
}