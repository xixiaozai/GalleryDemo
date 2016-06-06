package com.example.gallerydemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {
	private int[] res;
	private Context context;

	public ImageAdapter(int[] res, Context context) {
		this.res = res;
		this.context = context;
	}

	// 返回数据源长度
	public int getCount() {
		// TODO Auto-generated method stub
		// xunhuan
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return res[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("main", "position" + position + "tupian"
				+ position % res.length);
		ImageView image = new ImageView(context);
		// xunhuan
		image.setBackgroundResource(res[position % res.length]);
		image.setLayoutParams(new Gallery.LayoutParams(200,150));
		// 缩放方式
		image.setScaleType(ScaleType.FIT_XY);
		return image;
	}

}
