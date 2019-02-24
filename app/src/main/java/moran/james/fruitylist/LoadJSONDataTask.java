package moran.james.fruitylist;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Asynchronous task that connects to URL and returns JSON
 * data a String
 */
public class LoadJSONDataTask extends AsyncTask<String, String, String> {


    @Override
    protected String doInBackground(String... strings) {

        try {
            String fruitDataURL = "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/data.json";


            URL url = new URL(fruitDataURL);
            Scanner sc = new Scanner(url.openStream());

            String result = "";

            while (sc.hasNext()) {
                result += sc.next();
            }

            sc.close();

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {

    }
}
