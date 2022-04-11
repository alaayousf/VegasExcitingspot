package com.alaaclips.vegasexcitingspot

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.*
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.adjust.sdk.webbridge.AdjustBridge
import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerStateListener
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.kochava.base.Tracker
import com.onesignal.OSSubscriptionObserver
import com.onesignal.OSSubscriptionStateChanges
import com.onesignal.OneSignal
import java.io.IOException

class MainActivity : AppCompatActivity(){

    private val ONESIGNAL_APP_ID = "833d1180-ae97-4439-bbf7-3ae60ef496fa"
    lateinit var webView: WebView
    lateinit var mReferrerClient: InstallReferrerClient

    // long backPressedTime = 0;
    var ref: String? = null
    var push: String? = null
    //lateinit var userId :String

    var doubleBackPressedInterval = 500.toLong()
    var doubleTap = false
    var pressCount = 0.toLong()
    var timeLimit = 0.toLong()



    @SuppressLint("SetJavaScriptEnabled", "WrongViewCast", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        );
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//
//            );
//
//           // getWindow().setNavigationBarColor(Color.TRANSPARENT)
//            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
//       }
//
//        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
//                or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                 )



//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        );
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//            );
//            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
//        }
//
//        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
//                or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//               )

        setContentView(R.layout.activity_main)

        var valueurl=intent.getStringExtra("ur")

        //Log.e("ALAA","urlvalue in sacend secreen "+webView.url.toString())
        // Enable verbose OneSignal logging to debug issues if needed.


        // Enable verbose OneSignal logging to debug issues if needed.
//        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
//        // OneSignal Initialization
//        // OneSignal Initialization
//        OneSignal.initWithContext(this)
//        OneSignal.setAppId(ONESIGNAL_APP_ID)
//        val device = OneSignal.getDeviceState()
//
//
//        if (device != null) {
//            Log.e("ALAA", "" + device.userId)
//        }
//


//        OneSignal.addSubscriptionObserver(this)
//
//
//
//        mReferrerClient = InstallReferrerClient.newBuilder(applicationContext).build()
//        mReferrerClient.startConnection(this)
//        Tracker.configure(
//            Tracker.Configuration(applicationContext)
//                .setAppGuid("kovegas-exciting-spot-9puwk")
//                .setLogLevel(Tracker.LOG_LEVEL_NONE)
//        )
//



        webView = findViewById(R.id.webview_sample1)
        assert(webView != null)
        val webSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
        webSettings.allowFileAccess = true
        webView.getSettings().setSupportZoom(true)
        webView.getSettings().builtInZoomControls = true
        webView.getSettings().setDisplayZoomControls(false);

        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)


        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.mixedContentMode = 0
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        } else if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        } else if (Build.VERSION.SDK_INT < 19) {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
        webView.webViewClient = Callback()

        AdjustBridge.registerAndGetInstance(application, webView)

        if(valueurl !=null){


                webView.loadUrl(valueurl)
               // webView.loadUrl("https://www.pinterest.com/")



        }



//        webView.webChromeClient = object : WebChromeClient() {
//            override fun onProgressChanged(view: WebView, progress: Int) {
//                //Make the bar disappear after URL is loaded, and changes string to Loading...
//                findViewById<View>(R.id.progress2).visibility = View.VISIBLE
//                setProgress(progress * 100) //Make the bar disappear after URL is loaded
//
//                // Return the app name after finish loading
//                if (progress == 100) findViewById<View>(R.id.progress2).visibility = View.GONE
//                setTitle(R.string.app_name)
//            }
//        }


    }
//
//    override fun onOSSubscriptionChanged(stateChanges: OSSubscriptionStateChanges?) {
//
//        if (stateChanges != null) {
//            if (!stateChanges.getFrom().isSubscribed() &&
//                    stateChanges.getTo().isSubscribed()) {
////                AlertDialog.Builder(this)
////                        .setMessage("You've successfully subscribed to push notifications!")
////                        .show()
//                // get player ID
//
//                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
//
//                val task: AsyncTask<Void?, Void?, String?> = object : AsyncTask<Void?, Void?, String?>() {
//                    override fun doInBackground(vararg p0: Void?): String? {
//
//
//                        var idInfo: AdvertisingIdClient.Info? = null
//                        try {
//                            idInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext)
//                        } catch (e: GooglePlayServicesNotAvailableException) {
//                            e.printStackTrace()
//                        } catch (e: GooglePlayServicesRepairableException) {
//                            e.printStackTrace()
//                        } catch (e: IOException) {
//                            e.printStackTrace()
//                        }
//                        var advertId: String? = null
//                        try {
//                            advertId = idInfo!!.id
//                        } catch (e: NullPointerException) {
//                            e.printStackTrace()
//                        }
//
//
//                        return advertId
//                    }
//
//
//                    override fun onPostExecute(advertId: String?) {
//
//
//                        Log.e("ALAA", "device_id:\t$id")
//                        //Log.e("ALAA", "push-token:\t$userId")
//                        Log.e("ALAA", "kd_id:\t " + Tracker.getDeviceId())
//                        Log.e("ALAA", "gaid:\t$advertId")
//                        //Log.e("ALAA", "push-token Callbac :\t"+push);
//
//
//                        //Log.e("ALAA", "push-token Callbac :\t"+push);
//                        AdjustBridge.registerAndGetInstance(application, webView)
//                        try {
//                            webView.loadUrl(
//                                "http://vegsesl.sbs?utm_source=vegsesl_aosapp&device_id=" + id + "&push-token=" + stateChanges.getTo()
//                                    .getUserId() + "&kd_id=" + Tracker.getDeviceId() + "&ref=" + ref + "&gaid=" + advertId + ""
//                            )
//                            Log.v("ALAA", webView.url!!)
//                            print("${webView.url!!}");
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//
//
//                    }
//
//                }
//
//                task.execute()
//
//
//
//
//                Log.i("Debug", "onOSPermissionChanged: ${stateChanges.getTo().getUserId()}")
//
//            }
//        }
//
//        Log.i("Debug", "onOSPermissionChanged: $stateChanges")
//    }













//
//
//    override fun onInstallReferrerSetupFinished(responseCode: Int) {
//
//
//        when (responseCode) {
//            InstallReferrerClient.InstallReferrerResponse.OK -> try {
//                val response = mReferrerClient.installReferrer
//                ref = response.installReferrer
//                Log.e("ALAA", "InstallReferrer conneceted:\t" + response.installReferrer)
//
//                val id = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
//
//
//                val device = OneSignal.getDeviceState()
//                val userId = device!!.userId
//                if (userId != null) {
//                    val task: AsyncTask<Void?, Void?, String?> =
//                        object : AsyncTask<Void?, Void?, String?>() {
//                            override fun doInBackground(vararg p0: Void?): String? {
//
//
//                                var idInfo: AdvertisingIdClient.Info? = null
//                                try {
//                                    idInfo =
//                                        AdvertisingIdClient.getAdvertisingIdInfo(applicationContext)
//                                } catch (e: GooglePlayServicesNotAvailableException) {
//                                    e.printStackTrace()
//                                } catch (e: GooglePlayServicesRepairableException) {
//                                    e.printStackTrace()
//                                } catch (e: IOException) {
//                                    e.printStackTrace()
//                                }
//                                var advertId: String? = null
//                                try {
//                                    advertId = idInfo!!.id
//                                } catch (e: NullPointerException) {
//                                    e.printStackTrace()
//                                }
//
//
//                                return advertId
//                            }
//
//
//                            override fun onPostExecute(advertId: String?) {
//
//
//                                Log.e("ALAA", "device_id:\t$id")
//                                Log.e("ALAA", "push-token:\t$userId")
//                                Log.e("ALAA", "kd_id:\t " + Tracker.getDeviceId())
//                                Log.e("ALAA", "gaid:\t$advertId")
//                                //Log.e("ALAA", "push-token Callbac :\t"+push);
//
//
//                                //Log.e("ALAA", "push-token Callbac :\t"+push);
//                                AdjustBridge.registerAndGetInstance(application, webView)
//                                try {
//                                    webView.loadUrl("http://vegsesl.sbs?utm_source=vegsesl_aosapp&device_id=" + id + "&push-token=" + userId + "&kd_id=" + Tracker.getDeviceId() + "&ref=" + ref + "&gaid=" + advertId + "")
//                                    Log.e("ALAA", webView.url!!)
//                                } catch (e: Exception) {
//                                    e.printStackTrace()
//                                }
//
//
//                            }
//
//                        }
//                    task.execute()
//                }
//
//
//
//                mReferrerClient.endConnection()
//            } catch (e: RemoteException) {
//                e.printStackTrace()
//            }
//            InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED -> Log.e(
//                "ALAA",
//                "InstallReferrer not supported"
//            )
//            InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE -> Log.e(
//                "ALAA",
//                "Unable to connect to the service"
//            )
//            else -> {
//            }
//        }
//
//
//    }
//
//
//
//
//
//
//








//    override fun onInstallReferrerServiceDisconnected() {
//        TODO("Not yet implemented")
//    }

    class Callback : WebViewClient() {
        override fun onReceivedError(
            view: WebView,
            errorCode: Int,
            description: String,
            failingUrl: String
        ) {
           // Toast.makeText(MainActivity, "Failed loading app!", Toast.LENGTH_SHORT).show()
        }
    }


    fun showExitInstructions() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (!doubleTap) {
                webView.goBack()
            }
        }, doubleBackPressedInterval)
    }


    override fun onBackPressed() {

        
        if (webView.canGoBack()) {
            pressCount++
            if (pressCount == 1L) {
                timeLimit = System.currentTimeMillis() + doubleBackPressedInterval
                if (!doubleTap) {
                    showExitInstructions()
                }
            }
            if (pressCount == 2L) {
                if (timeLimit > System.currentTimeMillis()) {
                    doubleTap = true
                    exitByBackKey()
                } else {
                    showExitInstructions()
                }
                pressCount = 1.toLong()
                timeLimit = System.currentTimeMillis() + doubleBackPressedInterval
            }
        } else {
            exitByBackKey()
        }
    }






    protected fun exitByBackKey() {

        val alertbox = AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes") { arg0, arg1 ->
                    doubleTap = false
                    pressCount = 0.toLong()
                    timeLimit = 0.toLong()
                    // do something when the button is clicked
                    finish()
                    //close();
                }
                .setNegativeButton(
                    "No"
                ) // do something when the button is clicked
                { arg0, arg1 ->

                    doubleTap = false
                    pressCount = 0.toLong()
                    timeLimit = 0.toLong()
                }
                .show()
    }


    override fun onDestroy() {
        AdjustBridge.unregister()
        super.onDestroy()
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        webView.saveState(outState);
    }



}