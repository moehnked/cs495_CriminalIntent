package com.example.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.Date;
import java.util.GregorianCalendar;

public class PhotoViewFragment extends DialogFragment {
    private static final String EXTRA_PHOTO = "com.example.criminalintent.photo";
    private static final String ARG_PHOTO = "photo";

    private ImageView mPhoto;

    public static PhotoViewFragment newInstance(String photoPath){
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, photoPath);

        PhotoViewFragment fragment = new PhotoViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Bitmap bitmap = PictureUtils.getScaledBitmap((String) getArguments().getSerializable(ARG_PHOTO), getActivity());


        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);
        mPhoto = v.findViewById(R.id.dialog_photo);
        mPhoto.setImageBitmap(bitmap);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
