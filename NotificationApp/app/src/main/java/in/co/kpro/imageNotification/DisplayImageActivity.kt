package `in`.co.kpro.imageNotification

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView

class DisplayImageActivity : AppCompatActivity() {

    var imageView: ImageView?= null
    var title : TextView?= null
    var message : TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_image)

        imageView =  findViewById(R.id.imageView)
        title = findViewById(R.id.title)
        message = findViewById(R.id.message)


        if(Config.imageLink != null){
            imageView!!.setImageBitmap(Config.imageLink)
        }

        if(!TextUtils.isEmpty(Config.title))
            title!!.text = Config.title

        if(!TextUtils.isEmpty(Config.message))
            message!!.text = Config.message

    }
}
