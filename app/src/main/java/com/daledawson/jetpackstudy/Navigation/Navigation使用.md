注意：如果您要在 Android Studio 中使用 Navigation 组件，则必须使用 Android Studio 3.3 或更高版本。

NavGraph：导航图，包含一组页面和它们之间的跳转关系，比如A页面跳到B页面 B页面跳到C页面这样的关系信息
NavHost：一个可以显示导航页面的空白容器，系统默认实现了一个NavHostFragment
NavController：管理应用导航的对象，用来控制NavHost容器中当前应该显示的页面

# 1.添加最新依赖：
def nav_version = "2.2.2"
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

# 2.创建导航图
右键res文件夹
依次选择New->Android Resource File
第一行File name 中输入一个文件名 比如 nav_graph
第二行在Resource type 下拉列表中选择 Navigation，然后点击 OK

# 3.给activity添加NavHost
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <fragment
        android:id="@+id/fragment"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:defaultNavHost="true"
        app:navGraph="@navigation/nav_graph" />

</FrameLayout>
```
标签为fragment，android:name就是NavHost的实现类，这里是NavHostFragment
app:navGraph 属性就是我们前面在res文件夹下创建的文件
app:defaultNavHost="true" 意思是可以拦截系统的返回键，这样我们点击手机返回按钮的时候就能跟activity一样回到上一个页面了。

# 4.开启导航
```
OneToTwo.setOnClickListener {
            //页面跳转加通过bundle传参
            Navigation.findNavController(it).navigate(R.id.fragment1_action, Bundle().apply {
                putString("name", "Dale")
                putInt("age", 18)
            })
        }
```
//使用safe Args传参
使用afe Args，首先在工程的build.gradle文件夹中添加afe Args的gradle插件的依赖
```
classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.2.2"//使用Safe Args来传递数据
```
然后在app下的build.gradle文件中引入插件
```
apply plugin: "androidx.navigation.safeargs"
//kotlin使用下面方式引入
apply plugin: "androidx.navigation.safeargs.kotlin"
```
然后在最开始创建的nav_graph导航图文件中添加argument标签如下
```
  <fragment
        android:id="@+id/fragment3"
        android:name="com.daledawson.jetpackstudy.Navigation.Fragment3"
        android:label="Fragment3"
        tools:layout="@layout/fragment3_layout">

        <action
            android:id="@+id/fragment3_action"
            app:enterAnim="@anim/slide_in_right"
            app:exitAnim="@anim/slide_out_left"
            app:popEnterAnim="@anim/slide_in_left"
            app:popExitAnim="@anim/slide_out_right"
            app:popUpTo="@id/fragment1" />
        <argument
            android:name="title"
            android:defaultValue="i am title"
            app:argType="string" />
    </fragment>
```
# 动画
```
<action
            android:id="@+id/fragment3_action"
            app:enterAnim="@anim/slide_in_right"
            app:exitAnim="@anim/slide_out_left"
            app:popEnterAnim="@anim/slide_in_left"
            app:popExitAnim="@anim/slide_out_right"
            app:popUpTo="@id/fragment1" />
```

