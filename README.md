# iyzi/sdk-android

## Contents

- [Changelog](#changelog)
- [Version](#version)
- [Introduction](#introduction)
- [What is Mobilelib](#what-is-mobilelib)
- [Integration](#integration)
    - [Integrating mobilelib to your application](#integrating-mobilelib-to-your-application)
    - [Libraries used for integration](#libraries-used-for-integration)
    - [Integration parameters](#integration-parameters)
        - [Payment parameters](#payment-parameters)
        - [Card registration parameters](#card-registration-parameters)
        - [Payment with registered card parameters](#payment-with-registered-card-parameters)
    - [Integration progress](#integration-progress)
        - [Integration - Test Environment](#test-environment)
        - [Integration - Production environment](#production-environment)
    - [Installments](#showing-installments)
        - [Showing Installments](#showing-installments)
        - [Configuring Installments](#configuring-installments)
    - [Payment results](#payment-results)
        - [Result screens](#result-screens)
        - [Payment redirect screens](#payment-redirect-screens)
        - [Card register redirect screens](#card-register-redirect-screens)
        - [Result Messages](#result-messages)
    - [Graphical User Interface](#graphical-user-interface)
        - [Layouts](#layouts)
        - [Changing colours](#changing-colours)
        - [Text colors](#text-colors)
        - [Input field styles](#input-field-styles)
    - [Android settings](#android-settings)
        - [AndroidManifest.xml](#androidmanifestxml)
        - [Android permissions](#android-permissions)
    - [Examples](#examples)
        - [Payment examples](#payment)
            - [Single checkout payment example](#single-checkout)
            - [Payment with installment example](#payment-with-installment)
            - [Payment with registered card](#payment-with-registered-card)
        - [Card registration examples](#card-registration)
            - [Card registration screen example](#card-registration)
            - [Registered card list example](#registered-card-list)
- [Security and encryption](#security-and-encryption)


## Changelog

24/07/2014
_______________________

+ README.md file updated for links
+ LICENSE updated to MIT license
+ iyzico api id and secret fields are added to sample application

08/07/2014
_______________________

+ Remove menu activity header from MenuActivity class in sample application
+ Scan card must have same font size with edit texts in sample application
+ MobileLib iyzico api post method integration

______________________

## Version


Current version is 1.2.0
______________________

### Introduction
--------------------

#### What is Mobilelib?
--------------------

Iyzi mobilelib api provides one-click checkout to Android applications. Your clients can easily buy products from your Android application. With its easy integration your applications can scan credit card data. Scanning card data by mobilelib payments become frictionless for your clients.
  
_____________________

### Integration
--------------------
#### Integrating mobilelib to your application
--------------------


You must open sample-iyzimobile project with Eclipse, then add integration code inside MainActivity class to your Activity class, which will show the payment screen. MainActivity class extends PaymentActivity class and shows payment screen in your application.



SuccessActivity and FailActivity are also inside the project and they are required because your application will show  success or fail messages in these activities. SuccessActivity and FailActivity must be in the same package with MainActivity class.



You can find all images related to banks and cards inside sample-iyzimobile res folder. You must copy all resources inside this folder to your application according to your needs.



Important; all resources under layout folder and drawable-hdpi folders must be copied into your application.


You must chane your AndroidManifest.xml ffile, and change package property to “com.iyzi.mobile.android”. Changing package property, R.layout file will be generated in the right structure.

--------------------

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.iyzi.mobile.android"
    android:versionCode="1"
    android:versionName="1.0" >
```    
--------------------

#### Libraries used for integration


You must copy libs folder under sample-iyzimobile content to your application's lib folder.

----------------------------------

#### Integration parameters


All parameters in this table can be found inside sample-iyzimobile MainActivity class. If you want to use your own Activity, you must set all these parameters inside onCreate method. Suggested way for integrating mobilelib to your application is copying all files under sample-iyzimobile to your android application, by doing this you can easily integrate mobilelib to your application.


---------------------------------


|Parameter           |Description       |Setter method          |Type           |
|--------------------|-------------------|-----------------------|---------------|
|apiId|Api Id|this.setApiId("your api id");|String|
|secret|Secret|this.setSecret("secret");|String|
|amount|Purchase amount|this.setAmount(0.01);|double|
|currency|Currency|this.setCurrency(CurrencyEnum.TRY);|CurrencyEnum|
|successMessage|Success message|this.setSuccessMessage("Payment successful");|String|
|failMessage|Fail message|this.setFailMessage("Payment failed");|String|
|product|Product information|this.setProduct("Samsung Note 3");|String|
|environment|MobileLib environment|this.setEnvironment(MobileLib.DEVELOPMENT);|MobileLib|
|transactionId|TransactionId|this.setTransactionId("mobile_sample_application_" + Math.random());|String|
|installment|Show installment|this.showInstallment(false);|boolean|
|redirectPolicy|Redirect policy|this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);|RedirectPolicy|
|successActivity|Success activity|this.setSuccessActivity(SuccessActivity.class);|Class|
|failActivity|Fail activity|this.setFailActivity(PayRegisterFailActivity.class);|Class|

###### Table 1. Integration parameters

-----------------------
#### Payment parameters
-----------------------
Payment parameters are documented on Table 1, the basic parameters for a payment (single checkout or payment with installment option) needs the prameters shown on Table 1. For a single checkout payment please check MainActivity.java in sample application and for a payment with installment option example please check InstallmentActivity.java in sample application. Sample activities are located under org.iyzi.my package.


-----------------------

#### Card registration parameters

-----------------------

Card registration screens can be used by adding following additional parameters. (Please check CardRegisterActivity.java on sample application)


-----------------------

|Parameter|Description|Setter method|Type|
|---------|-----------|-------------|----|
|apiId|Api Id|this.setApiId("your api id");|String|
|secret|Secret|this.setSecret("secret");|String|
|amount|Purchase amount|this.setAmount(0.01);|double|
|currency|Currency|this.setCurrency(CurrencyEnum.TRY);|CurrencyEnum|
|successMessage|Success message|this.setSuccessMessage("Payment successful");|String|
|failMessage|Fail message|this.setFailMessage("Payment failed");|String|
|product|Product information|this.setProduct("Samsung Note 3");|String|
|environment|MobileLib environment|this.setEnvironment(MobileLib.DEVELOPMENT);|MobileLib|
|transactionId|TransactionId|this.setTransactionId("mobile_sample_application_" + Math.random());|String|
|installment|Show installment|this.showInstallment(false);|boolean|
|redirectPolicy|Redirect policy|this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);|RedirectPolicy|
|showCardRegister|Show card register activity|this.showCardRegister(true);|boolean|
|cardRegisterSuccessActivity|Redirect to this activity when card registration is successful|this.setCardRegisterSuccessActivity(SampleCardListActivity.class);|Class|
|cardRegisterFailActivity|Redirect to this activity when card regitration is no successful|this.setCardRegisterFailActivity(RegisterFailActivity.class);|Class|
|seed|Seed for encryption|this.setSeed("your_seed");|String|
|paymentType|Payment type|this.setPaymentType(CardPaymentTypeEnum.REGISTER);|CardPaymentTypeEnum|

###### Table 2: Card registeration parameters

---------------------------------

#### Payment with registered card parameters

---------------------------------

Payment with registered card parameters automatically gets the card information in activity by using Intent's getExtraString method. Still we need to add some parameters for showing payment with registered card parameters.

---------------------------------


|Parameter|Description|Setter method|Type|
|---------|-----------|-------------|----|
|apiId|Api Id|this.setApiId("your api id");|String|
|secret|Secret|this.setSecret("secret");|String|
|amount|Purchase amount|this.setAmount(0.01);|double|
|currency|Currency|this.setCurrency(CurrencyEnum.TRY);|CurrencyEnum|
|successMessage|Success message|this.setSuccessMessage("Payment successful");|String|
|failMessage|Fail message|this.setFailMessage("Payment failed");|String|
|product|Product information|this.setProduct("Samsung Note 3");|String|
|environment|MobileLib environment|this.setEnvironment(MobileLib.DEVELOPMENT);|MobileLib|
|transactionId|TransactionId|this.setTransactionId("mobile_sample_application_" + Math.random());|String|
|installment|Show installment|this.showInstallment(false);|boolean|
|redirectPolicy|Redirect policy|this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);|RedirectPolicy|
|payRegisteredCardToken|Pay with registered card|this.setPayRegisteredCardToken(true);|boolean|
|cardNick|Card nick used when storing the card (Do not change)|this.setCardNick(getIntent().getStringExtra("cardNick"));|String|
|lastFourNumbers|Last four numbers of the stored card. (Do not change)|this.setLastFourNumbers(getIntent().getStringExtra("lastFourDigits"));|String|
|registrationUniqueId|Registration unique id for payment with registerd card (Do not change)|this.setRegistrationUniqueId(getIntent().getStringExtra("registrationUniqueId"));|String|

###### Table 3 : Payment with registered card parameters

------------------------------------------


### Integration progress

------------------------

#### Test Environment

------------------------

After you login to https://www.iyzico.com with your merchant information, you must get  Sender, Channel, Login, Password information. These parameters will be set inside MainActivity (or your own activity) class.

------------------------

For showing payment screen you must copy code inside table-1 to your activity's onCreate method.

```java
this.setApiId("your api id");
this.setSecret("secret");
this.setAmount(1.0);
this.setCurrency(CurrencyEnum.TRY);
this.setSuccessMessage("Payment successful");
this.setFailMessage("Payment failed");
this.setProduct("Product name");
this.setEnvironment(MobileLib.DEVELOPMENT);
this.setTransactionId("mobile_sample_application_" + Math.random());
this.showInstallment(false);
this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);
```

------------------------

#### Production environment


------------------------

Warning: Production environment payments are made in real environment.

------------------------

After you login to https://www.iyzico.com with your merchant information, you must  get Sender, Channel, Login, Password information. These parameters will be set inside MainActivity (or your own activity) class.

------------------------

For showing payment screen you must copy code inside table-2 to your activity's onCreate method.

------------------------

For production environment:

```java
this.setApiId("your api id");
this.setSecret("secret");
this.setAmount(0.01);
this.setCurrency(CurrencyEnum.TRY);
this.setSuccessMessage("Payment successful");
this.setFailMessage("Payment failed");
this.setProduct("Product name");
this.setEnvironment(MobileLib.PRODUCTION);
this.setTransactionId("mobile_sample_application_" + Math.random());
this.showInstallment(false);
this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);
```
  
------------------------


### Showing Installments
------------------------

You can show installment options inside payment screen to your clients.
For showing installment options you must call showInstallment method before onCreate method like following code

```java
this.showInstallment(true);
```

For hiding installment options you must call showInstallment method before onCreate method like following code

```java
this.showInstallment(false);
```

By default installment options are not shown.

------------------------

### Configuring Installments
------------------------

You must copy installment.xml file under res/raw folder. File structure is like following:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Brands>
  <Brand type="BONUS">
    <Installment>
      <Count>1</Count>
      <Ratio>0.1</Ratio>
    </Installment>
    <Installment>
      <Count>2</Count>
      <Ratio>0.2</Ratio>
    </Installment>
    <Installment>
      <Count>3</Count>
      <Ratio>0.3</Ratio>
    </Installment>
    <Installment>
      <Count>4</Count>
      <Ratio>0.4</Ratio>
    </Installment>
  </Brand>
  <Brand type="MAXIMUM">
    <Installment>
      <Count>1</Count>
      <Ratio>0.1</Ratio>
    </Installment>
    <Installment>
      <Count>2</Count>
      <Ratio>0.2</Ratio>
    </Installment>
    <Installment>
      <Count>3</Count>
      <Ratio>0.3</Ratio>
    </Installment>
    <Installment>
      <Count>4</Count>
      <Ratio>0.4</Ratio>
    </Installment>
  </Brand>
</Brands>
```


Brand xml tag's type attribute can have BONUS, MAXIMUM, AXESS, CARDFINANS values. Different values other
than them are not processed.


All card types are represented by Brand tag, and every Installment option for a card brand must be inside the Brand
tag.

```xml
<Brand>
  <Installment>
    ....
  </Installment>
</Brand>
```

Installment count is added inside <Count> tag, and ratio for the installment count must be inside <Ratio> tag.

------------------------

### Payment Results

------------------------

#### Result screens

------------------------

You can show payment results in two different ways by using mobilelib. You can change this by setting
RedirectPolicy inside your code. First option shows payment results in separate activities, and the second option
shows payment results inside dialog. Second option does not redirect your screen to another activity.
For showing payment results in dialog, please use the following code.

```java
this.setRedirectPolicy(RedirectPolicy.SHOW_DIALOG);
```

For showing payment results in separate activities, please use the following code.

```java
this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);
```

------------------------

#### Payment redirect screens

------------------------

When the payment is successful the following code will redirect to SuccessActivity, the class can be defined by the
developer.

```java
this.setSuccessActivity(SuccessActivity.class);
```

When the payment fails the following code will redirect to FailActivity, the class can be defined by the developer.

```java
this.setFailActivity(FailActivity.class);
```

------------------------

#### Card register redirect screens

------------------------

When the card registration is successful the following code will redirect to SampleCardListActivity. You can change
this activity. Here in the example, after a successful card registration, user will be redirect to registered card list.

```java
this.setCardRegisterSuccessActivity(SampleCardListActivity.class);
```

When the card registration fails the following code will redirect to CardRegisterFailActivity.java

```java
this.setCardRegisterFailActivity(RegisterFailActivity.class);
```

------------------------

### Result messages

------------------------

You can set success and fail messages inside code, messages are not related to redirect policy.
For successful payments you can set a successful message by using the following code.

```java
this.setSuccessMessage("Payment successful");
```

For failed payments you can set a successful message by using the following code.

```java
this.setFailMessage("Payment failed");
```

------------------------

### Graphical User Interface

------------------------

You can edit gui configuration by editing res/values/styles.xml file.

------------------------


#### Layouts

------------------------

Developers can edit files inside Res/layout folder according to their needs.

------------------------


#### Changing colours

------------------------

Screen background, text colours and foreground colour can be changed by application
developers.


------------------------


##### Changing background

------------------------

To change screen background colour, please edit following line:
<color name="background_color">#FFFFFF</color>
You can change #FFFFFF to another colour.


------------------------


##### Text colors

------------------------

```xml
To change text colors, please check lines inside layout file.
<color name="bright_blue">#C0D6EB</color>
<color name="darker_blue">#022A4F</color>
<color name="bright_red">#F74848</color>
<color name="bright_green">#85FF89</color>
```

------------------------


#### Input field styles

------------------------

You can change input fields for credit card, verification, card holder input fields' styles, please check styles inside
following table.

```xml
<?xml version="1.0" ?>
<resources xmlns:android="http://schemas.android.com/apk/res/android">
    <color name="bright_blue">#C0D6EB</color>
    <color name="darker_blue">#022A4F</color>
    <color name="bright_red">#F74848</color>
    <color name="bright_green">#85FF89</color>
    <style name="AppBaseTheme" parent="android:Theme.Light"/>
    <style name="AppTheme" parent="AppBaseTheme"/>
    <style name="iyziEditTextStyle" parent="@style/AppBaseTheme">
        <item name="android:paddingTop">3dp</item>
        <item name="android:paddingLeft">3dp</item>
        <item name="android:paddingBottom">3dp</item>
        <item name="android:paddingRight">3dp</item>
        <item name="android:height">80dp</item>
        <item name="android:textSize">16dp</item>
    </style>
    <style name="iyziTextViewStyle" parent="@style/AppBaseTheme">
        <item name="android:textColor">@color/text_color</item>
    </style>
    <style name="iyziCreditCardEditTextStyle" parent="@style/iyziEditTextStyle">
        <item name="android:height">80dp</item>
    </style>
    <!-- Eidtable -->
    <color name="background_color">#ebebeb</color>
    <color name="foreground_color">#85FF89</color>
    <color name="text_color">#777777</color>
    <!-- Editable -->
</resources>
```

------------------------

## Android Settings

------------------------

### AndroidManifest.xml

------------------------

You must edit your AndroidManifest.xml according to following AndroidManifest.xml file. The file is also inside
sample-app.

Please check file [here](#https://github.com/iyzi/sdk-android/blob/master/AndroidManifest.xml)

### Android permissions

------------------------

Following permissions are required for mobilelib.

+ INTERNET
+ CAMERA
+ ACCESS_NETWORK_STATE
+ VIBRATE

## Examples

------------------------

All examples have onOptionsItemSelected and onCreateOptionsMenu methods inside the activity classes. They
are not extending any other classes for menu functionally, so developer can use these samples without changing
anything inside the code. Developer must know that “PaymentActivity” must be the base class for all screens.
Example classes inside the documentation do not have import package directives and onOptionsItemSelected and
onCreateOptionsMenu methods.Activity classes are under org.iyzi.my package. View files are under res/layout
folder.

### Payment

------------------------

Examples are; Single checkout, Payment with installment, Payment with registered card.


#### Single Checkout

------------------------

```java
public class SingleCheckoutActivity extends PaymentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
          this.setApiId("apiId");
          this.setSecret("secret");
          this.setAmount(617.99);
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
          super.onCreate(savedInstanceState);
    }
}
```
|File type|File name|
|---------|---------|
|Activity class| SingleCheckoutActivity.java|
|View file| activity_taksit_main.xml|

------------------------

#### Payment with Installment

------------------------

```java
public class InstallmentActivity extends PaymentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.setApiId("apiId");
        this.setSecret("secret");
        this.setAmount(617.99);
        this.setCurrency(CurrencyEnum.TRY);
        this.setSuccessMessage(getString(R.string.title_activity_success));
        this.setFailMessage(getString(R.string.title_activity_fail));
        this.setProduct("Samsung Note 3");
        this.setEnvironment(MobileLib.DEVELOPMENT);
        this.setTransactionId("mobile_sample_application_" + Math.random());
        this.showInstallment(true);
        this.setSuccessActivity(InstallmentSuccessActivity.class);
        this.setFailActivity(InstallmentFailActivity.class);
        this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);
        super.onCreate(savedInstanceState);
    }
}
```
|File type|File name|
|---------|---------|
|Activity class| InstallmentActivity.java|
|View file| activity_main.xml|

------------------------

#### Payment with Registered Card

------------------------

```java
public class PayRegisteredActivity extends PaymentActivity {
      @Override
      public void onCreate(Bundle savedInstanceState) {
          this.setApiId("apiId");
          this.setSecret("secret");
          this.setAmount(617.99);
          this.setCurrency(CurrencyEnum.TRY);
          this.setSuccessMessage(getString(R.string.title_activity_success));
          this.setFailMessage(getString(R.string.title_activity_fail));
          this.setProduct("Samsung Note 3");
          this.setEnvironment(MobileLib.DEVELOPMENT);
          this.setTransactionId("mobile_sample_application_" + Math.random());
          this.showInstallment(false);
          this.setPayRegisteredCardToken(true);
          this.setSuccessActivity(SuccessActivity.class);
          this.setFailActivity(PayRegisterFailActivity.class);
          this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);
          this.setCardNick(getIntent().getStringExtra("cardNick"));
          this.setLastFourNumbers(getIntent().getStringExtra("lastFourDigits"));
          this.setProgressMessage("Making payment...");
          this.setRegistrationUniqueId(getIntent().getStringExtra("registrationUniqueId"));
          super.onCreate(savedInstanceState);
      }
}
```
|File type|File name|
|---------|---------|
|Activity class| PayRegisteredActivity.java|
|View file| activity_registered_card.xml|

------------------------

#### Card Registration

------------------------


Examples are; Card registration, listing registered cards, adding buttons to a registered card list.

------------------------


#### Card registration

------------------------

```java
public class CardRegisterActivity extends PaymentActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
          this.setApiId("apiId");
          this.setSecret("secret");
          this.setAmount(617.99);
          this.setCurrency(CurrencyEnum.TRY);
          this.setSuccessMessage(getString(R.string.card_registered_successful));
          this.setFailMessage(getString(R.string.card_registered_failed));
          this.setProgressMessage("Registering credit card...");
          this.setProduct("Samsung Note 3");
          this.setEnvironment(MobileLib.DEVELOPMENT);
          this.setTransactionId("mobile_sample_application_" + Math.random());
          this.showCardRegister(true);
          this.setRedirectPolicy(RedirectPolicy.REDIRECT_SECREEN);
          this.setSeed("hjasfh25782tghjkaqghjasfg23525378902356");
          this.setPaymentType(CardPaymentTypeEnum.REGISTER);
          this.setCardRegisterSuccessActivity(SampleCardListActivity.class);
          this.setCardRegisterFailActivity(RegisterFailActivity.class);
          super.onCreate(savedInstanceState);
    }
}
```
|File type|File name|
|---------|---------|
|Activity class| CardRegisterActivity.java|
|View file| activity_card_register.xml|

------------------------

#### Registered card list

------------------------


```java
public class SampleCardListActivity extends CardListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.setCardRegisterActivity(CardRegisterActivity.class);
        this.setPayRegisteredActivity(PayRegisteredActivity.class);
        this.setCardListActivity(SampleCardListActivity.class);
        super.onCreate(savedInstanceState);
    }
}
```
|File type|File name|
|---------|---------|
|Activity class SampleCardListActivity.java|
|View file| card_list.xml|
|View file| card_item.xml|

------------------------

### Security and encryption

------------------------


Warning: Protecting data inside your Android application is not iyzico's responsibility. Data inside your android
application must be protected and encrypted that can a human or a third party software cannot decompile your
code and see the private data like sender, channel, login and seed information by you.



Please keep in mind that, an apk package or a java package can be decompiled, and your source code can be
seen. This is not related to MobileLib, but all android applications.
There are some encrypting solutions for android applications in the market. Apk Protect is online and can be used
for those purposes. Please check http://www.apkprotect.com/