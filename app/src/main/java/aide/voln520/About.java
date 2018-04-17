package aide.voln520;

import android.app.*;
import android.os.*;
import android.text.*;
import android.widget.*;

public class About extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        TextView about = (TextView) findViewById(R.id.textabout);
        about.setText("\u0009\u0009AideTeach是一款针对AIDE在安卓移动终端进行安卓程序开发的教程，教程整理于百度AIDE吧，获AIDE吧授权许可。此教程是目前网上唯一一套针对手机端进行安卓开发的教程，教程讲解细致，无需编程基础，让你从零开始开发出自己的安卓应用，随时随地尽情享受安卓的乐趣。 \n\u0009\u0009 AIDE是一个Android Java集成开发环境，可以让你在Android系统内进行Android软件和游戏的开发。它不仅仅是一个编辑器，而且支持编写-编译-调试-运行整个周期，开发人员可以在Android手机或者平板上创建新的项目，借助功能丰富的编辑器进行代码编写，支持实时错误检查、代码重构、代码智能导航、生成APK，然后直接安装进行测试。这款软件还完全兼容现有的Eclipse项目，只需要将源代码复制到你的设备中然后打开，你就可以继续开始进行代码工作。 \n\n\u0009\u0009 ---本软件原本由百度 AIDE 贴吧成员lll编写，包含吧主爱上疯人院姑娘的27篇教程。由于软件作者不再更新，本人重构了这个APK并开放源码。不需要任何权限，纯净无广告，你、值得拥有！\u0009：来自某位吧友之手 2013.12.25\n\n\u0009\u0009 最后更新于：2013.12.28 ");
    }
}
