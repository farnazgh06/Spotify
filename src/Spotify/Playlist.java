package Spotify;

import java.util.ArrayList;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private User Owner;

    public Playlist(String title, User Owner){
        this.title = title;
        this.Owner = Owner;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    public String getTitle(){
        return title;
    }
    public User getOwner(){
        return Owner;
    }
    public void editTitle(String password, String editedTitle) throws InvalidOperationException {
        checkPassword(password);
        this.title = editedTitle;
    }

    public void addMusic(String password, Music music) throws InvalidOperationException {
        checkPassword(password);
        if (playlist.contains(music)) {
            throw new InvalidOperationException("Music is already in the playlist.");
        }
        playlist.add(music);
    }

    public void removeMusic(String password, Music music) throws InvalidOperationException {
        checkPassword(password);

        if (!playlist.contains(music)) {
            throw new InvalidOperationException("Music isn't in the playlist.");
        }

        playlist.remove(music);
    }


    public Music searchInPlaylist(String title){
        for(Music music : playlist){
            if(music.getTitle().equals(title)){
                return music;
            }
        }
        return null;
    }

    public void playPlaylist(){
        for(Music music : playlist){
            music.play();
        }

    }

    public void checkPassword(String password) throws InvalidOperationException {
        if (!(Owner.getPassword().equals(password))) {
            throw new InvalidOperationException("Password isnt correct");
        }
    }

}