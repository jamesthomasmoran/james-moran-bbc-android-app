package moran.james.fruitylist;

import android.net.Uri;
import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Asynchronous task that requests URL with query parameters
 */
public class InteractionRecordTask extends AsyncTask<String[], String, String> {


    private String uri;

    @Override
    protected String doInBackground(String[]... strings) {

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("raw.githubusercontent.com")
                .appendPath("fmtvp")
                .appendPath("recruit-test-data")
                .appendPath("master")
                .appendPath("stats")
                .appendQueryParameter("event", strings[0][0])
                .appendQueryParameter("data", strings[0][1]);

        String uri = builder.build().toString();


        try {
            URL url = new URL(uri);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            request.setRequestMethod("GET");
            request.setConnectTimeout(700);

        } catch (Exception e) {

        }

        return uri.toString();

    }

    @Override
    protected void onPostExecute(String result) {

    }
}

