package org.iyzi.my.redirect;

import org.iyzi.my.MenuActivity;

import com.iyzi.mobile.android.R;
import com.payment.mobile.register.CardListActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class InstallmentSuccessActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_success);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.success, menu);
	return true;
    }

    /**
     * Menu button
     * 
     * @param View view
     */
    public void onMenuButton(View v) {
	Intent intent = new Intent(InstallmentSuccessActivity.this, MenuActivity.class);
	InstallmentSuccessActivity.this.startActivity(intent);
    }
}