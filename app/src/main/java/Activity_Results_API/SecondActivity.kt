package Activity_Results_API

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daledawson.jetpackstudy.R
import kotlinx.android.synthetic.main.activity_srcond.*

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/11/4
 * 修改时间：
 * 修改备注：
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_srcond)
        val name = intent.getStringExtra("name")
        content2.text = "接收到的数据为：$name"

        jump2.setOnClickListener {
            val intent = Intent().apply {
                putExtra("result", "莫西莫西，我是页面二回传的数据！")
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}