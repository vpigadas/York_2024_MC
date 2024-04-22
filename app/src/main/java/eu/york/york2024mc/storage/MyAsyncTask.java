package eu.york.york2024mc.storage;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<String, Void, String> {

    interface Listener {
        void onResults(String data);
    }

    private Listener listener;

    public MyAsyncTask(Listener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String item : strings) {
            builder.append(item);
        }
        return builder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.onResults(s);
    }
}
