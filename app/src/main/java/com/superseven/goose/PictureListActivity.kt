package com.superseven.goose


import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.superseven.goose.model.ConstrType


class PictureListActivity : AppCompatActivity() {

    var pictures = arrayOf<Int>(
            R.drawable.element2,
            R.drawable.element1,
            R.drawable.srawbr,
            R.drawable.cherr)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_list)

        val adapter = ImageListAdapter(this, pictures)
        val list = findViewById<ListView>(R.id.picture_list) as ListView
        list.adapter = adapter
        list.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@PictureListActivity, MyActivity::class.java)
            intent.putExtra(IntentConstants.CONTENT_TYPE_PARAM_NAME, ConstrType.PICTURE.name)
            intent.putExtra(IntentConstants.IMAGE_RES_ID_PARAM_NAME, pictures[position])
            startActivity(intent)
        }

    }
}
