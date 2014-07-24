package org.iyzi.my;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.iyzi.mobile.android.R;
import com.payment.mobile.register.CardListActivity;

public class SampleCardListActivity extends CardListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	this.setCardRegisterActivity(CardRegisterActivity.class);
	this.setPayRegisteredActivity(PayRegisteredActivity.class);
	this.setCardListActivity(SampleCardListActivity.class);
	super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	Intent intent;
	switch (item.getItemId()) {
	case R.id.menu_about:
	    Dialog dialog = new Dialog(SampleCardListActivity.this);
	    LayoutInflater inflater = LayoutInflater.from(SampleCardListActivity.this);
	    dialog.setTitle(getString(R.string.about));
	    View view = inflater.inflate(R.layout.activity_about, null);
	    dialog.setContentView(view);

	    dialog.show();
	    return false;
	case R.id.menu_card_register:
	    intent = new Intent(SampleCardListActivity.this, CardRegisterActivity.class);
	    SampleCardListActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_installment:
	    intent = new Intent(SampleCardListActivity.this, InstallmentActivity.class);
	    SampleCardListActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_registered_cards:
	    intent = new Intent(SampleCardListActivity.this, SampleCardListActivity.class);
	    SampleCardListActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_single_checkout:
	    intent = new Intent(SampleCardListActivity.this, SingleCheckoutActivity.class);
	    SampleCardListActivity.this.startActivity(intent);
	    return true;
	default:
	    return super.onContextItemSelected(item);
	}
    }
}