package org.iyzi.my.redirect;

import org.iyzi.my.MenuActivity;

import com.iyzi.mobile.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class RegisterSuccessActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_success);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.success, menu);
	return true;
    }

    /**
     * Test button for tests
     * 
     * @param View view
     */
    public void onTestButton(View v) {
	//Log.d("MobileLib.iyzi", "HI");
    }

    /**
     * Menu button
     * 
     * @param View view
     */
    public void onMenuButton(View v) {
	Intent intent = new Intent(RegisterSuccessActivity.this, MenuActivity.class);
	RegisterSuccessActivity.this.startActivity(intent);
    }
}