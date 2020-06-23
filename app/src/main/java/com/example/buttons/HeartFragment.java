package com.example.buttons;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HeartFragment extends Fragment {

    private static final String TAG = "ViewPostFragment";

    public HeartFragment(){
        super();
        setArguments(new Bundle());
    }

    private ImageView mHeartRed,mHeartWhite;
    private GestureDetector mGestureDetector;
    private Heart mHeart;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ;
        View view = inflater.inflate(R.layout.activity_main, container, false);

        mHeartRed = (ImageView) view.findViewById(R.id.image_heart_red);
        mHeartWhite = (ImageView) view.findViewById(R.id.image_heart);

        mHeartRed.setVisibility(View.GONE);
        mHeartWhite.setVisibility(View.VISIBLE);
        mHeart = new Heart(mHeartWhite,mHeartRed);
        mGestureDetector = new GestureDetector(getActivity(), new GestureListener());

        testToggle();
        return view;
    }

    private void testToggle(){
        mHeartRed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG,"onTouch: red heart touch detected");
                return mGestureDetector.onTouchEvent(event);
            }
        });
        mHeartWhite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG,"onTouch: white heart touch detected");
                return mGestureDetector.onTouchEvent(event);
            }
        });
    }

    public class GestureListener  extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            mHeart.toggleLike();
            return true;
        }
    }
}
