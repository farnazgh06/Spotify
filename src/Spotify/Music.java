package Spotify;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music (String title, User singer){
        this.title = title;
        this.singer = singer;
        allMusics.add(this);

    }
    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }
    public int getNumberOfStream() {
        return numberOfStream;
    }

    public void play(){
        System.out.println("Song :" + title);
        System.out.println("Artist: " + singer.getUsername());
        System.out.println("is playing now!");
        numberOfStream ++;
    }
    public ArrayList<Music> search(String title){
        ArrayList<Music> sameTitle = new ArrayList<>();
        for(Music music : allMusics){
            if (title.equals(music.getTitle())) {
                sameTitle.add(music);
            }
        }
        return sameTitle;
    }
    public Music search(String title, User singer) {
        for (Music music : allMusics) {
            if (title.equals(music.getTitle()) && music.getSinger().equals(singer)) {
                return music;
            }
        }
        return null;
    }
}

