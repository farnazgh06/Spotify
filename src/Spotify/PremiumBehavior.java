package Spotify;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month) {
        this.month = month;
    }

    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException {
        Playlist playlist = new Playlist(Title, Owner);
        Owner.addPlaylist(playlist);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        if(month > 0) {
            this.month += month;
        }
    }
}

