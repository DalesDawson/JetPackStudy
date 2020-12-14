package Activity_Results_API

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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
//            requestPermission.launch(Manifest.permission.CAMERA)//请求单个权限
            //请求多权限
//            requestMultiplePermissions.launch(
//                arrayOf(
//                    Manifest.permission.BLUETOOTH,
//                    Manifest.permission.NFC,
//                    Manifest.permission.ACCESS_FINE_LOCATION
//                )
//            )
            val intent = Intent().apply {
                putExtra("result", "莫西莫西，我是页面二回传的数据！")
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    // 请求单个权限
    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            // Do something if permission granted
            if (isGranted) Toast.makeText(this, "Permission is granted", Toast.LENGTH_LONG).show()
            else Toast.makeText(this, "Permission is denied", Toast.LENGTH_LONG).show()
        }

    // 请求一组权限
    private val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions: Map<String, Boolean> ->
            // Do something if some permissions granted or denied
            permissions.entries.forEach {
                // Do checking here
            }
        }
}