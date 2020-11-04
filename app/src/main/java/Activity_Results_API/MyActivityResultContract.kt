package Activity_Results_API

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/11/4
 * 修改时间：
 * 修改备注：
 */
class MyActivityResultContract : ActivityResultContract<String, String>() {
    override fun createIntent(context: Context, input: String?): Intent {
        return Intent(context, SecondActivity::class.java).apply {
            putExtra("name", input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        val data = intent?.getStringExtra("result")
        return if (resultCode == Activity.RESULT_OK && data != null) data
        else ""
    }

}