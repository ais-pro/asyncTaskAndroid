package com.example.root.ansysclass;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansysActivity asysTask=new ansysActivity();
        asysTask.execute();
    }

    public class ansysActivity extends AsyncTask<Void,Void,Void>{
        ProgressDialog dialog;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this,"I am post execute.",Toast.LENGTH_LONG).show();
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onPreExecute() {
            dialog=new ProgressDialog(MainActivity.this);
            dialog.setTitle("Loading Task");
            dialog.show();
            super.onPreExecute();
        }
    }
}
