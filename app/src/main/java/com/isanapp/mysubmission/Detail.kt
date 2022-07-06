package com.isanapp.mysubmission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class Detail : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getImage = findViewById<ImageView>(R.id.img_item_photo)
        val getName = findViewById<TextView>(R.id.id_item_name)
        val getUsername = findViewById<TextView>(R.id.id_item_username)
        val getFollower = findViewById<TextView>(R.id.id_item_follower)
        val getFollowing = findViewById<TextView>(R.id.id_item_following)
        val getcompany = findViewById<TextView>(R.id.id_item_company)
        val getlocation = findViewById<TextView>(R.id.id_item_location)

        val getData = intent.getParcelableExtra<government>(EXTRA_DATA) as government

        Glide.with(this@Detail)
            .load(getData?.avatar)
            .into(getImage)
        getName.text = getData?.name
        getUsername.text = getData?.username
        getFollower.text = getData?.followers
        getFollowing.text = getData?.following
        getcompany.text = getData?.company
        getlocation.text = getData?.location
    }

}



