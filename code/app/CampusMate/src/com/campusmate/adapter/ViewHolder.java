package com.campusmate.adapter;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ViewHolder{
	private final SparseArray<View> mViews;  
    private View mConvertView;  
    private Context context;
  
    private ViewHolder(Context context, ViewGroup parent, int layoutId,  
            int position)  
    {  
    	this.context=context;
        this.mViews = new SparseArray<View>();  
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,  
                false);  
        mConvertView.setTag(this);  
    }  
    /** 
     * 拿到一个ViewHolder对象 
     * @param context 
     * @param convertView 
     * @param parent 
     * @param layoutId 
     * @param position 
     * @return 
     */  
    public static ViewHolder get(Context context, View convertView,  
            ViewGroup parent, int layoutId, int position)  
    {  
      
        if (convertView == null)  
        {  
            return new ViewHolder(context, parent, layoutId, position);  
        }  
        return (ViewHolder) convertView.getTag();  
    }  
  
  
    /** 
     * 通过控件的Id获取对于的控件，如果没有则加入views 
     * @param viewId 
     * @return 
     */  
    public <T extends View> T getView(int viewId)  
    {  
          
        View view = mViews.get(viewId);  
        if (view == null)  
        {  
            view = mConvertView.findViewById(viewId);  
            mViews.put(viewId, view);  
        }  
        return (T) view;  
    }  
  
    public View getConvertView()  
    {  
        return mConvertView;  
    }  
    
    /** 
     * 为TextView设置字符串 
     *  
     * @param viewId 
     * @param text 
     * @return 
     */  
    public ViewHolder setText(int viewId, String text)  
    {  
        TextView view = getView(viewId);  
        view.setText(text);  
        return this;  
    } 
    /*
     * 设置评星等级
     */
    public ViewHolder setRating(int viewId, String n)  
    {  
    	RatingBar rb = getView(viewId);  
        rb.setRating(Integer.valueOf(n));
        return this;  
    } 
    /*
     * 设置某个试图不可见
     */
    public ViewHolder setImageVisible(int viewId, String n,String show)  
    {  
    	ImageView im = getView(viewId); 
    	if(Integer.valueOf(n)==Integer.valueOf(show)){
    		im.setVisibility(View.VISIBLE);
    	}else{
    		im.setVisibility(View.INVISIBLE);
    	}
        return this;  
    } 
    /*
     * 设置某个试图不可见
     */
    public ViewHolder setTextViewVisible(int viewId, String n,String show)  
    {  
    	TextView im = getView(viewId); 
    	if(Integer.valueOf(n)==Integer.valueOf(show)){
    		im.setVisibility(View.VISIBLE);
    	}else{
    		im.setVisibility(View.INVISIBLE);
    	}
        return this;  
    } 
    /*
     * 设置某个按钮状态
     */
    public ViewHolder setTextViewStatus(int viewId, String n,String flag)  
    {  
    	TextView im = getView(viewId); 
    	if(Integer.valueOf(n)==Integer.valueOf(flag)){
    		im.setEnabled(true);
    	}else{
    		im.setEnabled(false);
    	}
        return this;  
    } 
    public ViewHolder setImageViewStatus(int viewId, String n,String flag)  
    {  
    	ImageView im = getView(viewId); 
    	if(Integer.valueOf(n)==Integer.valueOf(flag)){
    		im.setEnabled(true);
    	}else{
    		im.setEnabled(false);
    	}
        return this;  
    } 
    public ViewHolder setImageViewClick(int viewId, OnClickListener listener)  
    { 
    	ImageView im = getView(viewId); 
    	im.setOnClickListener(listener);
        return this;
    }
    /*
     * 设置某个textview 字体颜色
     */
    public ViewHolder setTextColor(int viewId, int color)  
    {  
    	TextView tv = getView(viewId); 
    	tv.setTextColor(color);
        return this;  
    } 
    /** 
     * 为ImageView设置图片 
     *  
     * @param viewId 
     * @param drawableId 
     * @return 
     */  
    public ViewHolder setImageResource(int viewId, int drawableId)  
    {  
        ImageView view = getView(viewId);  
        view.setImageResource(drawableId);  
  
        return this;  
    }  
    public ViewHolder setImageResource(int viewId, String url){
    	ImageView view = getView(viewId); 
    	Picasso.with(context).load(url).into(view);
    	return this;
    	
    }
  
    /** 
     * 为ImageView设置图片 
     *  
     * @param viewId 
     * @param drawableId 
     * @return 
     */  
    public ViewHolder setImageResource(int viewId, Bitmap bm)  
    {  
        ImageView view = getView(viewId);  
        view.setImageBitmap(bm);  
        return this;  
    }  
  
}
