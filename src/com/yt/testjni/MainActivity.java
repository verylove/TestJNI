package com.yt.testjni;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private Button button,button2;
	private TextView textview;
	
	static {
        // 加载动态库
        System.loadLibrary("TestJNI");
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		this.textview = (TextView)this.findViewById(R.id.textView1);
		
		this.button	 = (Button) this.findViewById(R.id.button1);

		this.button.setOnClickListener(new OnClickListener()
		 {
		    	public void onClick(View v) {

		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss",Locale.US);

		        String	 fname = "/sdcard/"+ sdf.format(new Date()) + ".png";

		        View view = v.getRootView();

		        view.setDrawingCacheEnabled(true);

		        view.buildDrawingCache();

		        Bitmap	 bitmap = view.getDrawingCache();

		        if(bitmap != null)
		        {
		          System.out.println("bitmap got!");

		          try{

		            FileOutputStream out = new FileOutputStream(fname);

		            bitmap.compress(Bitmap.CompressFormat.PNG,100,		 out);

		            System.out.println("file " 	+ fname + "output done.");

		          }catch(Exception	 e) {

		            e.printStackTrace();

		          }

		        }else{

		          System.out.println("bitmap is NULL!");

		        }

		      }

		 

		    });
	
		this.button2 = (Button)this.findViewById(R.id.button2);
		
		this.button2.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TestJNI testJNI = new TestJNI();
		        // 调用native方法
		        boolean init = testJNI.Init();
		        if (init == true) {
		            // 调用Add函数
		            int sum = testJNI.Add(100, 500);
		            textview.setText("100+500等于" + sum);
		        } else {
		        	textview.setText("没有初始化成功！");
		        }
		        testJNI.Destory();
				
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
