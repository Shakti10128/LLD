package SpotifyMusicPlayer.Code.Devices;

import SpotifyMusicPlayer.Code.External.HeadphonesAPI;
import SpotifyMusicPlayer.Code.Models.Song;

public class HeadphonesAdapter implements IAudioOutputDevice {
    private HeadphonesAPI headphonesApi;

    public HeadphonesAdapter(HeadphonesAPI api) {
        this.headphonesApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        headphonesApi.playSoundViaJack(payload);
    }
}