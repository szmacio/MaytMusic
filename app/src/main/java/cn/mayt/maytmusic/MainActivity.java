package cn.mayt.maytmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import cn.mayt.maytmusic.adapter.MyAdapter;
import cn.mayt.maytmusic.view.ScrollableViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv_curduration;
    private TextView mTv_minilrc;
    private TextView mTv_totalduration;
    private SeekBar mSk_duration;
    private ImageView mIv_bottom_model;
    private ImageView mIv_bottom_play;
    private ListView mLv_list;
    private ScrollableViewGroup mSvg_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
        initListener();
    }

    private void initListener() {
        findViewById(R.id.ib_top_play).setOnClickListener(this);
        findViewById(R.id.ib_top_list).setOnClickListener(this);
        findViewById(R.id.ib_top_lrc).setOnClickListener(this);
        findViewById(R.id.ib_top_volumn).setOnClickListener(this);
        findViewById(R.id.ib_bottom_model).setOnClickListener(this);
        findViewById(R.id.ib_bottom_last).setOnClickListener(this);
        findViewById(R.id.ib_bottom_play).setOnClickListener(this);
        findViewById(R.id.ib_bottom_next).setOnClickListener(this);
        findViewById(R.id.ib_bottom_update).setOnClickListener(this);
        mSvg_main.setOnCurrentViewChangedListener(new ScrollableViewGroup.OnCurrentViewChangedListener() {
            @Override
            public void onCurrentViewChanged(View view, int currentview) {
                setTopSelected(topArr[currentview]);
            }
        });
    }
   int[] topArr ={R.id.ib_top_list, R.id.ib_top_play,  R.id.ib_top_lrc, R.id.ib_top_volumn };
    private void initDate() {
        mLv_list.setAdapter(new MyAdapter());
       
    }

    private void initView() {
        mTv_curduration = (TextView) findViewById(R.id.tv_curduration);
        mTv_minilrc = (TextView) findViewById(R.id.tv_minilrc);
        mTv_totalduration = (TextView) findViewById(R.id.tv_totalduration);
        mSk_duration = (SeekBar) findViewById(R.id.sk_duration);
        mIv_bottom_model = (ImageView) findViewById(R.id.iv_bottom_model);
        mIv_bottom_play = (ImageView) findViewById(R.id.iv_bottom_play);
        mLv_list = (ListView) findViewById(R.id.lv_list);
        mSvg_main = (ScrollableViewGroup) findViewById(R.id.svg_main);
        findViewById(R.id.ib_top_list).setSelected(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_top_play:
                mSvg_main.setCurrentView(1);
                setTopSelected(R.id.ib_top_play);
                break;
            case R.id.ib_top_list:
                mSvg_main.setCurrentView(0);
                setTopSelected(R.id.ib_top_list);
                break;
            case R.id.ib_top_lrc:
                mSvg_main.setCurrentView(2);
                setTopSelected(R.id.ib_top_lrc);
                break;

            case R.id.ib_top_volumn:
                mSvg_main.setCurrentView(3);
                setTopSelected(R.id.ib_top_volumn);
                break;

        }
    }

    private void setTopSelected(int selectedId) {
        findViewById(R.id.ib_top_play).setSelected(false);
        findViewById(R.id.ib_top_list).setSelected(false);
        findViewById(R.id.ib_top_lrc).setSelected(false);
        findViewById(R.id.ib_top_volumn).setSelected(false);
        findViewById(selectedId).setSelected(true);
    }
}
