package org.iyzi.my.redirect;

import org.iyzi.my.SingleCheckoutActivity;
import org.iyzi.my.MenuActivity;
import org.iyzi.my.PayRegisteredActivity;

import com.iyzi.mobile.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PayRegisterFailActivity extends Activity {
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
	Intent intent = new Intent(PayRegisterFailActivity.this, MenuActivity.class);
	PayRegisterFailActivity.this.startActivity(intent);
    }

    /**
     * Try again button
     * 
     * @param View view
     */
    public void onTryAgainButton(View v) {
	Intent intent = new Intent(PayRegisterFailActivity.this, PayRegisteredActivity.class);
	PayRegisterFailActivity.this.startActivity(intent);
    }
}