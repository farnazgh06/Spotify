import Spotify.*;

public class Main {

    public static void main(String[] args) {
        try {
            User regularUser1 = new User("Farnaz", "farnazgh2006", new RegularBehavior());
            User regularUser = new User("Saman", "samaneb2006", new RegularBehavior());

            regularUser1.buyPremium(6);
            regularUser1.follow(regularUser);

            regularUser1.createPlaylist("Party");
            regularUser1.createPlaylist("Walk");
            regularUser1.createPlaylist("Random");

            System.out.println("add new musics");
            Music firstMusic = new Music("dance", regularUser1);
            Music secondMusic = new Music("dance pt.2", regularUser1);

            Playlist partyPlaylist = regularUser1.getPlaylists().get(0);
            partyPlaylist.addMusic("farnazgh2006", firstMusic);
            partyPlaylist.addMusic("farnazgh2006", secondMusic);

            System.out.println();
            System.out.println("Playing Party-playlist:");
            partyPlaylist.playPlaylist();

            System.out.println();
            System.out.println("Stream counts:");
            System.out.println(firstMusic.getTitle() + " stream count: " + firstMusic.getNumberOfStream());
            System.out.println(secondMusic.getTitle() + " stream count: " + secondMusic.getNumberOfStream());

            System.out.println();
            System.out.println("Farnaz's playlists:");
            for (Playlist playlist : regularUser1.getPlaylists()) {
                System.out.println(playlist.getTitle());
            }

            partyPlaylist.editTitle("farnazgh2006", "Raghs");

            try {
                partyPlaylist.removeMusic("123456", secondMusic);
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }

            partyPlaylist.removeMusic("farnazgh2006", secondMusic);

            System.out.println();
            System.out.println("Edited playlist:");
            partyPlaylist.playPlaylist();

            System.out.println();
            System.out.println("all edited-playlists");
            for (Playlist playlist : regularUser1.getPlaylists()) {
                System.out.println(playlist.getTitle());
            }

            regularUser.buyPremium(12);

            System.out.println();
            System.out.println("update to premium user!");

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
