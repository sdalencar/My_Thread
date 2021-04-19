package com.sdainfo.mythread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2;
    private boolean parar = false;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.buttonIniciar);
        button2 = findViewById(R.id.buttonTerminar);

    }


    public void iniciar(View view) {
        // Thread thread = new MyThread();
        //thread.start();
        parar = false;

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

    }

    int i, o;

    public void parar(View view) {
        parar = true;
    }


    class MyRunnable implements Runnable {

        @Override
        public void run() {

            for (i = 0; i <= 15; i++) {
                Log.d("thread", "iniciar:  " + i);

                if (parar){
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button1.setText("número : " + i);
                        button2.setText("número : " + o + i);
                    }
                });
            /*
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        button1.setText("número : " + i);
                        button2.setText("número : " + o + i );
                    }
                });
            */

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //Thread thread = new MyThread();
            //thread.start();
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 15; i++) {
                Log.d("thread", "iniciar:  " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}










