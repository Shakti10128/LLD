package SpotifyMusicPlayer.Code.Strategies;

import SpotifyMusicPlayer.Code.Models.Playlist;
import SpotifyMusicPlayer.Code.Models.Song;

public interface IPlayStrategy {
    void setPlaylist(Playlist playlist);
    Song next();
    boolean hasNext();
    Song previous();
    boolean hasPrevious();
    default void addToNext(Song song) {}
}