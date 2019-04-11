package com.rommansabbir.utils

import android.app.AlertDialog
import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.widget.Toast
import java.util.*

object Utils {
    /**
     * Show a simple native alert
     * @param context, context from parent activity
     * @param title, title of the alert
     * @param message, message that you wanna show
     */
    fun showAlert(context: Context, title: String, message: String) {
        val builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ -> dialog.cancel() }
        val ok = builder.create()
        ok.show()
    }

    /**
     * Show toast
     * @param context, context of parent activity
     * @param message, message to show in toast
     */
    fun showToast(context: Context, message : String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Show toast
     * @param context, context of parent activity
     * @param message, message to show in toast
     * @param length, toast length
     */
    fun showToast(context: Context, message : String, length : Int){
        Toast.makeText(context, message, length).show()
    }

    /**
     * Check if internet is available
     * return true if available else false
     * @param context, context from parent activity
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    /**
     * Check if GPS is enabled
     * return true if enabled, else false
     * @param context, context from parent activity
     */
    fun isGPSEnabled(context: Context): Boolean {
        val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    /**
     * Return current date time from system
     */
    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    /**
     * Check if a date is valid or not
     * @param validateFrom, the day from validated
     * @param validateTo, the day validate to
     */
    fun dateTimeValidator(validateFrom: Date, validateTo: Date): Boolean {
        return validateFrom.before(validateTo)
    }

    /**
     * Set data to shared preference
     * @param context, context from parent activity
     * @param key, key for the shared pref
     * @param value, value to set (Generic)
     */
    fun <T> setToSharedPref(context: Context, key: String, value: T) {
        val pref = context.getSharedPreferences("PrivatePref", 0)
        val editor = pref.edit()
        if (value is String){
            editor.putString(key, value)
        }
        if(value is Int){
            editor.putInt(key, value)
        }
        if(value is Boolean){
            editor.putBoolean(key, value)
        }
        if(value is Long){
            editor.putLong(key, value)
        }
        if(value is Float){
            editor.putFloat(key, value)
        }
        if(value is Set<*>){
            editor.putStringSet(key, value as Set<String>)
        }
        editor.apply()
    }

    /**
     * Get string from shared pref
     * @param context, context from parent activity
     * @param key, key to get value, default null
     */
    fun getStringFromSharedPref(context: Context, key: String) : String?{
        val pref = context.getSharedPreferences("PrivatePref", 0)
        return pref.getString(key, null)
    }

    /**
     * Get int from shared pref
     * @param context, context from parent activity
     * @param key, key to get value, default 0
     */
    fun getIntFromSharedPref(context: Context, key: String) : Int?{
        val pref = context.getSharedPreferences("PrivatePref", 0)
        return pref.getInt(key, 0)
    }

    /**
     * Get boolean from shared pref
     * @param context, context from parent activity
     * @param key, key to get value, default false
     */
    fun getBooleanFromSharedPref(context: Context, key: String) : Boolean?{
        val pref = context.getSharedPreferences("PrivatePref", 0)
        return pref.getBoolean(key, false)
    }

    /**
     * Get long from shared pref
     * @param context, context from parent activity
     * @param key, key to get value, default 0
     */
    fun getLongFromSharedPref(context: Context, key: String) : Long?{
        val pref = context.getSharedPreferences("PrivatePref", 0)
        return pref.getLong(key, 0)
    }

    /**
     * Get float from shared pref
     * @param context, context from parent activity
     * @param key, key to get value, default 0.0F
     */
    fun getFloatFromSharedPref(context: Context, key: String) : Float?{
        val pref = context.getSharedPreferences("PrivatePref", 0)
        return pref.getFloat(key, 0.0F)
    }

    /**
     * Get string set from shared pref
     * @param context, context from parent activity
     * @param key, key to get value, default null
     */
    fun getStringSetFromSharedPref(context: Context, key: String) : Set<String>?{
        val pref = context.getSharedPreferences("PrivatePref", 0)
        return pref.getStringSet(key, null)
    }
}