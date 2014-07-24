package org.iyzi.my;

import org.iyzi.my.redirect.FailActivity;
import org.iyzi.my.redirect.SuccessActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.iyzi.card.entity.CurrencyEnum;
import com.iyzi.card.entity.MobileLib;
import com.iyzi.card.entity.RedirectPolicy;
import com.iyzi.mobile.android.R;
import com.payment.connect.request.CardPaymentTypeEnum;
import com.payment.mobile.android.PaymentActivity;

public class SingleCheckoutActivity extends PaymentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	this.setApiId("api_id");
	this.setSecret("secret");
	this.setAmount(0.01);
	this.setCurrency(CurrencyEnum.TRY);
	this.setSuccessMessage(getString(R.string.title_activity_success));
	this.setFailMessage(getString(R.string.title_activity_fail));
	this.setProduct("Samsung Note 3");
	this.setEnvironment(MobileLib.DEVELOPMENT);
	this.setTransactionId("mobile_sample_application_" + Math.random());
	this.showInstallment(false);
	this.setSuccessActivity(SuccessActivity.class);
	this.setFailActivity(FailActivity.class);
	this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);
	this.setProgressMessage("Making payment...");
	this.setPaymentType(CardPaymentTypeEnum.CREDIT);
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
	    Dialog dialog = new Dialog(SingleCheckoutActivity.this);
	    LayoutInflater inflater = LayoutInflater.from(SingleCheckoutActivity.this);
	    dialog.setTitle(getString(R.string.about));
	    View view = inflater.inflate(R.layout.activity_about, null);
	    dialog.setContentView(view);

	    dialog.show();
	    return false;
	case R.id.menu_card_register:
	    intent = new Intent(SingleCheckoutActivity.this, CardRegisterActivity.class);
	    SingleCheckoutActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_installment:
	    intent = new Intent(SingleCheckoutActivity.this, SingleCheckoutActivity.class);
	    SingleCheckoutActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_registered_cards:
	    intent = new Intent(SingleCheckoutActivity.this, SampleCardListActivity.class);
	    SingleCheckoutActivity.this.startActivity(intent);
	    return true;
	case R.id.menu_single_checkout:
	    intent = new Intent(SingleCheckoutActivity.this, SingleCheckoutActivity.class);
	    SingleCheckoutActivity.this.startActivity(intent);
	    return true;
	default:
	    return super.onContextItemSelected(item);
	}
    }
}