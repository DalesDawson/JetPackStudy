Activity Results API 是 Google官方推荐的Activity、Fragment获取返回结果的方式。

Activity Results API 到底怎么用？相比onActivityResult有哪些优势？接下来，将一一为你解答。

在介绍如何使用之前，先为大家介绍Activity Results API 中两个重要的组件：ActivityResultContract和ActivityResultLauncher。

ActivityResultContract: 协议，它定义了如何传递数据和如何处理返回的数据。ActivityResultContract是一个抽象类，你需要继承它来创建自己的协议，每个 ActivityResultContract 都需要定义输入和输出类，如果您不需要任何输入，可使用 Void（在 Kotlin 中，使用 Void? 或 Unit）作为输入类型。

ActivityResultLauncher: 启动器，调用ActivityResultLauncher的launch方法来启动页面跳转，作用相当于原来的startActivity()

使用 Activity Results API 获取Activity返回的结果
1. 首先，在app下的build.gradle中加入依赖:
implementation 'androidx.activity:activity:1.2.0-beta01'
implementation 'androidx.fragment:fragment:1.3.0-beta01'
2. 定义协议
新建一个Contract类，继承自ActivityResultContract<I,O>，其中，I是输入的类型，O是输出的类型。需要实现2个方法，createIntent和parseResult,输入类型I作为createIntent的参数，输出类型O作为parseResult方法的返回值，在下面的例子中，输入输出类型都是String:
```
 class MyActivityResultContract: ActivityResultContract<String,String>(){
        override fun createIntent(context: Context, input: String?): Intent {
            return Intent(context,SecondActivity::class.java).apply {
                putExtra("name",input)
            }
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            val data = intent?.getStringExtra("result")
            return if (resultCode == Activity.RESULT_OK && data != null) data
            else null
        }

    }
```
如上代码，我们在createIntent方法中创建了Intent，并且携带了参数name,在parseResult方法中，获取了返回的数据result。

3. 注册协议，获取启动器-ActivityResultLauncher
注册协议，使用registerForActivityResult方法，该方法由ComponentActivity或者Fragment提供,接受2个参数，第一个参数就是我们定义的Contract协议，第二个参数是一个回调ActivityResultCallback<O>,其中O就是前面Contract的输出类型。代码如下：
```
private val myActivityLauncher = registerForActivityResult(MyActivityResultContract()){result ->
   Toast.makeText(applicationContext,result,Toast.LENGTH_SHORT).show()
   textView.text = "回传数据：$result"
}
```
如上代码，注册了MyActivityResultContract,registerForActivityResult方法的返回值是ActivityResultLauncher, 因此我们定义了一个myActivityLauncher,回调方法中，result就是从上一个界面传回的值。这里我们简单的用Toast显示。

4. 最后，调用启动器的launch方法开启界面跳转
MainActivity中添加一个Button,点击Button时，调用launch方法跳转：
```
 button.setOnClickListener {
      // 开启页面跳转
      myActivityLauncher.launch("Hello,技术最TOP")
 }
```
SecondActivity的代码很简单：
```
class SecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        val name = intent.getStringExtra("name")
        textView3.text = "接收到的数据为：$name"

        button2.setOnClickListener {
            val intent = Intent().apply {
                putExtra("result","Hello，依然范特西稀，我是回传的数据！")
            }
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
```
以上3步，就实现了使用新的Activity Results API 来完成Activity之间的数据传递，并获取Activity返回的数据

看一下效果:


这就完了吗？


你可能会有疑问，虽然确实减少了代码耦合，但是使用并不简单啊。

确实，但这并没有完！！！

预定义的Contract
大伙都看出来，新的Activity Results API使用起来好像有点麻烦，每次都得定义Contract。Google肯定考虑到了这个问题的，于是，Google 预定义了很多Contract,把你们能想到的使用场景基本上都想到了，它们都定义在类ActivityResultContracts中,有以下这些Contract:

StartActivityForResult() 
RequestMultiplePermissions()
RequestPermission()
TakePicturePreview()
TakePicture()
TakeVideo()
PickContact()
CreateDocument()
OpenDocumentTree()
OpenMultipleDocuments()
OpenDocument()
GetMultipleContents()
GetContent()
下面分别介绍一下这些Contract:

StartActivityForResult: 通用的Contract,不做任何转换，Intent作为输入，ActivityResult作为输出，这也是最常用的一个协定。

RequestMultiplePermissions： 用于请求一组权限

RequestPermission: 用于请求单个权限

TakePicturePreview: 调用MediaStore.ACTION_IMAGE_CAPTURE拍照，返回值为Bitmap图片

TakePicture: 调用MediaStore.ACTION_IMAGE_CAPTURE拍照，并将图片保存到给定的Uri地址，返回true表示保存成功。

TakeVideo: 调用MediaStore.ACTION_VIDEO_CAPTURE 拍摄视频，保存到给定的Uri地址，返回一张缩略图。

PickContact: 从通讯录APP获取联系人

GetContent: 提示用选择一条内容，返回一个通过ContentResolver#openInputStream(Uri)访问原生数据的Uri地址（content://形式） 。默认情况下，它增加了Intent#CATEGORY_OPENABLE, 返回可以表示流的内容。

CreateDocument: 提示用户选择一个文档，返回一个(file:/http:/content:)开头的Uri。

OpenMultipleDocuments: 提示用户选择文档（可以选择多个），分别返回它们的Uri，以List的形式。

OpenDocumentTree: 提示用户选择一个目录，并返回用户选择的作为一个Uri返回，应用程序可以完全管理返回目录中的文档。

上面这些预定义的Contract中，除了StartActivityForResult和RequestMultiplePermissions之外，基本都是处理的与其他APP交互，返回数据的场景，比如，拍照，选择图片，选择联系人，打开文档等等。使用最多的就是StartActivityForResult和RequestMultiplePermissions了。

有了这些预定义的Contract, Activity之间传递数据就简单多了，比如，前面的例子，可以简化成这样：

1. 注册协议，获取ActivityResultLauncher:

 private val myActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ activityResult ->  
        if(activityResult.resultCode == Activity.RESULT_OK){
            val result = activityResult.data?.getStringExtra("result")
            Toast.makeText(applicationContext,result,Toast.LENGTH_SHORT).show()
            textView.text = "回传数据：$result"
        }
    }
2. 构造需要传递的数据，启动页面跳转

 button.setOnClickListener {
        val  intent = Intent(this,SecondActivity::class.java).apply {
             putExtra("name","Hello,技术最TOP")
        }
        myActivityLauncher.launch(intent)
}
OK，就是这么简单！！！