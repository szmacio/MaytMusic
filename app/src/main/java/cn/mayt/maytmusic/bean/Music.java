package cn.mayt.maytmusic.bean;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Music {
    public String title;//歌曲名
    public String artist;//歌手
    public String path;//路径
    public Music(String title, String artist, String path) {
        super();
        this.title = title;
        this.artist = artist;
        this.path = path;
    }
}
