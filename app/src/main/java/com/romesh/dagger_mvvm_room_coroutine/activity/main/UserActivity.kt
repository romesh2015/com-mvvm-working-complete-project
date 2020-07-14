package com.romesh.dagger_mvvm_room_coroutine.activity.main
import android.os.Bundle
import android.os.Parcelable
import com.romesh.dagger_mvvm_room_coroutine.R
import com.romesh.dagger_mvvm_room_coroutine.Users
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_user.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class UserActivity : DaggerAppCompatActivity() {
    val LOG="TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val intent = intent
      //  val first: String?
     //   val last: String?
        val user = intent.getSerializableExtra("test") as? Test
        //first=intent.getStringExtra("first")
       // last=intent.getStringExtra("last")
        editTextTextPersonName.setText(user?.name)
        editTextTextPersonName2.setText(user?.mobile)


    }
}