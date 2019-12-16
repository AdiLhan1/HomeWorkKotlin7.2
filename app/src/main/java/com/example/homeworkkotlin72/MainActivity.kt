package com.example.homeworkkotlin72

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var number: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addIntoImageView()

    }

    private fun addIntoImageView() {
        val totalList: MutableList<String> = mutableListOf(
            "https://natgeo.imgix.net/factsheets/thumbnails/01-balance-of-nature.adapt.jpg?auto=compress,format&w=1600&h=900&fit=crop",
            "https://www.brinknews.com/wp-content/uploads/2019/09/GettyImages-81794997.jpg",
            "https://www.diyanar.com/wp-content/uploads/2019/05/natures-temples.jpg",
            "https://ciorg.imgix.net/images/default-source/default-album/ci_38159553?&auto=compress&auto=format&fit=crop&w=1440&h=900",
            "https://i.pinimg.com/originals/f9/06/ae/f906ae4ec27ef5a0f201c9a25d127a7f.jpg",
            "https://i0.wp.com/www.jodyrobbins.com/wp-content/uploads/2019/11/mountain-winter-reflection-on-lake.jpg?fit=1100%2C735&ssl=1",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3MoAeGj11l1ky2HHSrrKJIEpMZKPu_ZgorUuGuKeHSrg3vwa7JQ&s"
        )
        btnListener(totalList)
    }

    private fun btnListener(totalList: MutableList<String>) {
        btn_next.setOnClickListener {
            btn_previous.visibility = View.VISIBLE
            if (number < totalList.lastIndex) {
                number++
                Picasso.get()
                    .load(totalList[number])
                    .into(imageView)
            } else {
                showToast("No more pictures")
                btn_next.visibility = View.INVISIBLE
            }

        }
        btn_previous.setOnClickListener {
            btn_next.visibility = View.VISIBLE
            if (number > 0) {
                number--
                Picasso.get()
                    .load(totalList[number])
                    .into(imageView)
            } else {
                showToast("No more pictures!")
                btn_previous.visibility = View.INVISIBLE
            }
        }

    }

    private fun showToast(text: String?) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
