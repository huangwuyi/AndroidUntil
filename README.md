# AndroidUntil
个人项目整理的Android基础类库
使用方法：
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.huangwuyi:AndroidUntil:V1.03'
	}
	<br/>
	包含类别信息
	===========

	* Checkinfo检查信息是否符合规范
	* ChineseData日期转化为中式的日期格式
	* ScreenUtil屏幕信息获取


