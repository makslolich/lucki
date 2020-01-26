package com.superseven.goose


import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.superseven.goose.model.ContentType


class PictureListActivity : AppCompatActivity() {

    var pictures = arrayOf<Int>(
            R.drawable.lemon,
            R.drawable.banana,
            R.drawable.srawbr,
            R.drawable.cherr)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_list)

        val adapter = ImageListAdapter(this, pictures)
        val list = findViewById<ListView>(R.id.picture_list) as ListView
        list.adapter = adapter
        list.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@PictureListActivity, HomeActivity::class.java)
            intent.putExtra(IntentConstants.CONTENT_TYPE_PARAM_NAME, ContentType.PICTURE.name)
            intent.putExtra(IntentConstants.IMAGE_RES_ID_PARAM_NAME, pictures[position])
            startActivity(intent)
        }

    }
}
