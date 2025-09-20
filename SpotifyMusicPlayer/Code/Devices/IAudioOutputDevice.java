package SpotifyMusicPlayer.Code.Devices;
import SpotifyMusicPlayer.Code.Models.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}