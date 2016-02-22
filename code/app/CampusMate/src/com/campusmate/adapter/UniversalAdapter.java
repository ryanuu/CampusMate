package com.campusmate.adapter;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


/**
 * 
 * 万能适配器
 * @author GZB
 * 
 * **/
public abstract class UniversalAdapter<T> extends BaseAdapter {
	protected LayoutInflater mInflater;
	public Context mContext;
	protected List<T> mDatas;
	protected final int mItemLayoutId;
	
	protected int flag=0;//用于多个gridview/listview共用一个adapter时的判断

	public UniversalAdapter(Context context, List<T> mDatas, int itemLayoutId) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
	}
	
	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
    
	/**
	 * @return the mDatas
	 */
	public List<T> getmDatas() {
		return mDatas;
	}
	/**
	 * @param mDatas the mDatas to set
	 */
	public void setmDatas(List<T> mDatas) {
		this.mDatas = mDatas;
		notifyDataSetInvalidated();
	}

	@Override
	public int getCount() {
		return mDatas==null||mDatas.isEmpty()? 0:mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder = getViewHolder(position, convertView,
				parent);
		convert(viewHolder, getItem(position),position);
		return viewHolder.getConvertView();

	}

	public abstract void convert(ViewHolder viewHolder, T item,int positon);

	private ViewHolder getViewHolder(int position, View convertView,
			ViewGroup parent) {
		return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
				position);
	}
}
