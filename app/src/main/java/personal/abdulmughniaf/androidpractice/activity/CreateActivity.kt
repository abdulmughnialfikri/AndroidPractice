package personal.abdulmughniaf.androidpractice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create.*
import personal.abdulmughniaf.androidpractice.R

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            textView.text = if (this == NavigationActivity.FRAGMENT_TYPE_TASK){
                "This is Task"
            }else if(this == NavigationActivity.FRAGMENT_TYPE_NOTE){
                "This is Note"
            }else{
                "Something Went Wrong!"
            }
        }
    }
}
