package cn.mayt.maytmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import cn.mayt.maytmusic.view.ScrollableViewGroup;

public class MainActivity extends AppCompatActivity {
    private ScrollableViewGroup scrollableViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
