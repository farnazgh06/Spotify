package Spotify;

public class RegularBehavior implements UserBehavior{
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException{
        throw new InvalidOperationException("You cant create a playlist, buy premium.");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if(playingLimit <= 0){
            throw new InvalidOperationException("You have reached the limit!");
        }
        music.play();
        playingLimit--;
    }

    @Override
    public void buyPremium(User owner, int month) {
        PremiumBehavior newPremiumAccount = new PremiumBehavior(month);
        owner.setBehavior(newPremiumAccount);
    }
}
