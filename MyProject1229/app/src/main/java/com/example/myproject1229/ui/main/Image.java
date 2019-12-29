package com.example.myproject1229.ui.main;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject1229.MainActivity;
import com.example.myproject1229.R;

import java.util.ArrayList;
import java.util.List;

public class Image extends Fragment {

    private GalleryManager mGalleryManager;

    private RecyclerView recyclerGallery;
    private myAdapter galleryAdapter;

    static Image newInstance() {
        return new Image();
    }

    private List<PhotoVO> initGalleryPathList() {

        mGalleryManager = new GalleryManager(getActivity().getApplicationContext());
        //return mGalleryManager.getDatePhotoPathList(2015, 9, 19);
        return mGalleryManager.getAllPhotoPathList();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_image, container, false);
        recyclerGallery = (RecyclerView) root.findViewById(R.id.recyclerGallery);

        galleryAdapter = new myAdapter(getActivity(), initGalleryPathList(), R.layout.item);
        //galleryAdapter.setOnItemClickListener(mOnItemClickListener);
        recyclerGallery.setAdapter(galleryAdapter);
        recyclerGallery.setLayoutManager(new GridLayoutManager( getContext(), 4));
        recyclerGallery.setItemAnimator(new DefaultItemAnimator());

        return recyclerGallery;
    }
}
