package Spotify;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password, UserBehavior behavior) throws InvalidOperationException {
        for(User user : allUsers){
            String userUsername = user.username;
            if(userUsername.equals(username)){
                throw new InvalidOperationException("This username is already taken.");
            }
        }
        if(password.length() < 8){
            throw new InvalidOperationException("Password must have at least 8 characters.");
        }
        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void follow (User user){
        if (!(followingList.contains(user))) {
            followingList.add(user);
        }
    }

    public void createPlaylist (String Title) throws InvalidOperationException {
        this.behavior.createPlaylist(Title, this);
    }

    public void playMusic (Music music) throws InvalidOperationException {
        this.behavior.playMusic(music);
    }
    public void buyPremium (int month){
        this.behavior.buyPremium(this, month) ;
    }
    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }
}
