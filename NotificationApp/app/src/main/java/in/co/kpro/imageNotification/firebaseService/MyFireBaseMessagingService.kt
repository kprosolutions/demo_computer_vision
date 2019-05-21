package `in`.co.kpro.imageNotification.firebaseService

import `in`.co.kpro.imageNotification.Config
import `in`.co.kpro.imageNotification.DisplayImageActivity
import `in`.co.kpro.imageNotification.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*

class MyFireBaseMessagingService : FirebaseMessagingService() {

    private val TAG = "MyFirebaseToken"
    private lateinit var notificationManager: NotificationManager
    private val ADMIN_CHANNEL_ID = "Android4Dev"
    var style = NotificationCompat.BigPictureStyle()


    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.i(TAG, token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        remoteMessage?.let { message ->
            getImage(remoteMessage)
        }

    }

    private fun showNotificationWithImage(bitmap: Bitmap) {

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //Setting up Notification channels for android O and above
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            setupNotificationChannels()
        }


        style.setSummaryText(Config.message)
        style.bigPicture(bitmap)
        val notificationId = Random().nextInt(60000)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val uniqueInt = (System.currentTimeMillis() and 0xfffffff).toInt()

        var intent = Intent(applicationContext, DisplayImageActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        intent.action = "" + Math.random();
        var pendingIntent = PendingIntent.getActivity(applicationContext, uniqueInt, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationBuilder = NotificationCompat.Builder(this, ADMIN_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)  //a resource for your custom small icon
                .setContentTitle(Config.title) //the "title" value you sent in your notification
                .setContentText(Config.message) //ditto
                .setAutoCancel(true)  //dismisses the notification on click
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setStyle(style)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(notificationId /* ID of notification */, notificationBuilder.build())
    }


    private fun getImage(remoteMessage: RemoteMessage) {

        Config.message = remoteMessage.data["message"]
        Config.title = remoteMessage.data["name"]
        var bitmap = Config.getBitmapfromUrl(remoteMessage.data["image"])
        Config.imageLink = bitmap

        showNotificationWithImage(bitmap)
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun setupNotificationChannels() {
        val adminChannelName = getString(R.string.notifications_admin_channel_name)
        val adminChannelDescription = getString(R.string.notifications_admin_channel_description)

        val adminChannel: NotificationChannel
        adminChannel = NotificationChannel(ADMIN_CHANNEL_ID, adminChannelName, NotificationManager.IMPORTANCE_LOW)
        adminChannel.description = adminChannelDescription
        adminChannel.enableLights(true)
        adminChannel.lightColor = Color.RED
        adminChannel.enableVibration(true)
        notificationManager.createNotificationChannel(adminChannel)
    }
}