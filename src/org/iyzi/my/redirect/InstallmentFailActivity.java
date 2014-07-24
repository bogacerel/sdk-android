package org.iyzi.my.redirect;

import org.iyzi.my.SingleCheckoutActivity;
import org.iyzi.my.MenuActivity;

import com.iyzi.mobile.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.iyzi.my.InstallmentActivity;

public class InstallmentFailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fail);
    }

    /**
     * Menu button
     * 
     * @param View view
     */
    public void onMenuButton(View v) {
	Intent intent = new Intent(InstallmentFailActivity.this, MenuActivity.class);
	InstallmentFailActivity.this.startActivity(intent);
    }

    /**
     * Try again button
     * 
     * @param View view
     */
    public void onTryAgainButton(View v) {
	Intent intent = new Intent(InstallmentFailActivity.this, InstallmentActivity.class);
	InstallmentFailActivity.this.startActivity(intent);
    }
}