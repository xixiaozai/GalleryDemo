package com.example.gallerydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ImageSwitcher;

public class MainActivity extends Activity implements OnItemSelectedListener,
		ViewFactory {
	private Gallery mGallery;
	private ImageSwitcher mSwitcher;
	// 自定义适配器
	private ImageAdapter adapter;
	private int[] resId = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
			R.drawable.pic4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);

		mGallery = (Gallery) findViewById(R.id.gallery);
		adapter = new ImageAdapter(resId, this);
		mGallery.setAdapter(adapter);
		mGallery.setOnItemSelectedListener(this);
		mSwitcher.setFactory(this);
		// 设置出入动画
		mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		// image.setBackgroundResource(res[position % res.length]);
		mSwitcher.setBackgroundResource(resId[position % resId.length]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterview) {
		// TODO Auto-generated method stub

	}

	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		ImageView image = new ImageView(this);
		// cente会让居中显示并缩放
		image.setScaleType(ScaleType.FIT_CENTER);
		return image;
	}

}
