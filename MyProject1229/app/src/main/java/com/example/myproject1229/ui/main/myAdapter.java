package com.example.myproject1229.ui.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myproject1229.R;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.PhotoViewHolder> {

    private Activity mActivity;

    private int itemLayout;
    private List<PhotoVO> mPhotoList;

    //PhotoList 반환
    public List<PhotoVO> getmPhotoList() {
        return mPhotoList;
    }

    //선택된 PhotoList 반환
    public List<PhotoVO> getSelectedPhotoList(){

        List<PhotoVO> mSelectPhotoList = new ArrayList<>();

        for (int i = 0; i < mPhotoList.size(); i++) {

            PhotoVO photoVO = mPhotoList.get(i);
            if(photoVO.isSelected()){
                mSelectPhotoList.add(photoVO);
            }
        }

        return mSelectPhotoList;
    }

    //생성자
    public myAdapter(Activity activity, List<PhotoVO> photoList, int itemLayout) {

        mActivity = activity;

        this.mPhotoList = photoList;
        this.itemLayout = itemLayout;

    }


    //레이아웃을 만들어서 holder에 저장
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder viewHolder, final int position) { //---------------------------------class PhotoViewHolder 만들고 다시 다듬기

        final PhotoVO photoVO = mPhotoList.get(position);

        Glide.with(mActivity)
                .load(photoVO.getImgPath())
                .centerCrop()
                .crossFade()
                .into(viewHolder.imgPhoto);
        //선택
        if(photoVO.isSelected()){
            viewHolder.layoutSelect.setVisibility(View.VISIBLE);
        }else{
            viewHolder.layoutSelect.setVisibility(View.INVISIBLE);
        }

        /*ewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(viewHolder, position);
                }
            }        });
    */
    }
    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgPhoto;
        public RelativeLayout layoutSelect;

        public PhotoViewHolder(View itemView) {
            super(itemView);

            imgPhoto = (ImageView) itemView.findViewById(R.id.imgPhoto);
            layoutSelect = (RelativeLayout) itemView.findViewById(R.id.layoutSelect);
        }

    }


}