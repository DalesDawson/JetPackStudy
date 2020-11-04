package Activity_Results_API

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.activity_first.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/11/4
 * 修改时间：
 * 修改备注：
 */
class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        jump1.setOnClickListener {
            // 开启页面跳转
            //方式一
//            myActivityLauncher.launch("Hello,我来自页面一")

            //方式二
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("name", "Hello,我来自页面一")
            }
            myActivityLauncher.launch(intent)
        }
    }

    //方式一
//    private val myActivityLauncher =
//        registerForActivityResult(MyActivityResultContract()) { result ->
//            Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()
//            content1.text = "回传数据：$result"
//        }

    //方式二
    private val myActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                val result = activityResult.data?.getStringExtra("result")
                Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()
                content1.text = "回传数据：$result"
            }
        }
}