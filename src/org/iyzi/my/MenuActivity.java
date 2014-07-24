package org.iyzi.my;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.iyzi.mobile.android.R;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu, menu);
	return true;
    }

    /**
     * Register card menu
     * @param View view
     */
    public void onCardRegisterButton(View v) {
	Intent intent = new Intent(MenuActivity.this, CardRegisterActivity.class);
	MenuActivity.this.startActivity(intent);
    }

    /**
     * Single payment
     * @param View view
     */
    public void onSinglePaymentButton(View v) {
	Intent intent = new Intent(MenuActivity.this, SingleCheckoutActivity.class);
	MenuActivity.this.startActivity(intent);
    }

    /**
     * Installment menu
     * @param View view
     */
    public void onInstallmentPayButton(View v) {
	Intent intent = new Intent(MenuActivity.this, InstallmentActivity.class);
	MenuActivity.this.startActivity(intent);
    }

    /**
     * Registered card menu
     * @param View view
     */
    public void onRegisteredCardList(View v) {
	Intent intent = new Intent(MenuActivity.this, SampleCardListActivity.class);
	MenuActivity.this.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	Intent intent;
	switch (item.getItemId()) {
	case R.id.menu_about:
	    Dialog dialog = new Dialog(MenuActivity.this);
	    LayoutInflater inflater = LayoutInflater.from(MenuActivity.this);
	    dialog.setTitle(getString(R.string.about));
	    View view = inflater.inflate(R.layout.activity_about, null);
	    dialog.setContentView(view);

	    dialog.show();
	    return false;
	case R.id.menu_card_register:
	    intent = new Intent(MenuActivity.this, CardRegisterActivity.class);
	    MenuActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_installment:
	    intent = new Intent(MenuActivity.this, InstallmentActivity.class);
	    MenuActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_registered_cards:
	    intent = new Intent(MenuActivity.this, SampleCardListActivity.class);
	    MenuActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_single_checkout:
	    intent = new Intent(MenuActivity.this, SingleCheckoutActivity.class);
	    MenuActivity.this.startActivity(intent);
	    return true;
	default:
	    return super.onContextItemSelected(item);
	}
    }
}