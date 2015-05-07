package com.jike.imageloaderdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * 1、 Universal-ImageLoader的配置
 * 
 * 2、用Universal-ImageLoader加载网络图片和本地图片
 * 
 * @author Administrator
 * 
 */
public class MainActivity extends Activity {
	private ImageLoader loader;
	private ImageView iv_img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loader = ImageLoader.getInstance();
		iv_img = (ImageView) this.findViewById(R.id.iv_img);
		String uri = "file:///" + "本地路径";
//		loader.displayImage(
//				"http://s1.jikexueyuan.com/current/static/images/logo.png",
//				iv_img);
		loader.displayImage(
				"http://s1.jikexueyuan.com/current/static/images/logo.png",
				iv_img, new ImageLoadingListener() {

					@Override
					public void onLoadingStarted(String arg0, View arg1) {
						Log.i("info", "onLoadingStarted");
					}

					@Override
					public void onLoadingFailed(String arg0, View arg1,
							FailReason arg2) {
						Log.i("info", "onLoadingFailed");
					}

					@Override
					public void onLoadingComplete(String arg0, View arg1,
							Bitmap arg2) {
						Log.i("info", "onLoadingComplete");
					}

					@Override
					public void onLoadingCancelled(String arg0, View arg1) {
						Log.i("info", "onLoadingCancelled");
					}
				});
	}

}
