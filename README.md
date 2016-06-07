# 自定义的titlebar和沉浸式状态栏
标题居中万能的titlebar 以及 沉浸状态栏。
沉浸式状态栏支持android 4.4 以上

###效果图
![效果图1](https://raw.githubusercontent.com/wlj32011/BaseTitleBar/master/device-2016-06-07-162947.png)
![效果图2](https://raw.githubusercontent.com/wlj32011/BaseTitleBar/master/device-2016-06-07-163019.png)
![效果图3](https://raw.githubusercontent.com/wlj32011/BaseTitleBar/master/device-2016-06-07-163040.png)

###使用方法
####添加依赖
	
	compile 'com.iiseeuu:basetitlebar:1.0'
	or
	直接引入rootview工程lib
	
####demo
	参考demo工程	
	https://github.com/wlj32011/BaseTitleBar 下载下来可以直接运行
####使用步骤：
1.修改工程的values/style.xml为:
	
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">

    </style>
2.创建activity的布局文件，将RootLayout设置为根目录

	<?xml version="1.0" encoding="utf-8"?>
	<com.iiseeuu.rootview.RootLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:statusBarColor="@color/colorPrimary"
    app:titleBarColor="@color/colorPrimaryDark"
    app:titleBarTextColor="@android:color/white"
    app:titleBarTitle="标题">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:background="#cccccc"
        >

        <Button
            android:id="@+id/only_title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="仅标题"/>

        

      </LinearLayout>

	</com.iiseeuu.rootview.RootLayout>


3.RootLayout可选项说明
	
	 app:statusBarColor：状态栏颜色值
	 app:titleBarColor: 标题栏背景颜色
	 app:titleBarTextColor：标题栏文字颜色
	 app:titleBarTitle：activity标题
	 app:titleBarTitleHeight 标题栏高度 默认为48dp

4.在activity设置标题样式样式以及按钮点击事件：

	public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RootLayout.getInstance(this).setTitleBar("仅标题");

        findViewById(R.id.only_title).setOnClickListener(this);
        findViewById(R.id.title_with_back).setOnClickListener(this);
        findViewById(R.id.left_and_right_img).setOnClickListener(this);
        findViewById(R.id.only_right_img).setOnClickListener(this);
        findViewById(R.id.right_and_left_text).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.only_title:
                RootLayout.getInstance(this).setTitleBar("仅标题");
                break;
            case R.id.title_with_back:
                RootLayout.getInstance(this).setTitleBarWithBack("标题加返回");
                RootLayout.getInstance(this).setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            case R.id.left_and_right_img:
                RootLayout.getInstance(this).setTitleBar("左右都图标", android.R.drawable.btn_plus, android.R.drawable.btn_minus);
                RootLayout.getInstance(this).setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                RootLayout.getInstance(this).setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case R.id.only_right_img:
                RootLayout.getInstance(this).setTitleBar("右边图标", android.R.drawable.btn_minus);
                RootLayout.getInstance(this).setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case R.id.right_and_left_text:
                RootLayout.getInstance(this).setTitleBar("左右都是文字", "取消", "确定");
                RootLayout.getInstance(this).setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                RootLayout.getInstance(this).setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
        }
    }


}









