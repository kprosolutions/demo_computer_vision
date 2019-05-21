package `in`.co.kpro.imageNotification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener(this@MainActivity) { instanceIdResult ->
            val newToken = instanceIdResult.token
            Log.e("newToken", newToken)
        }


    }
}

