package SpotifyMusicPlayer.Code.Devices;

import SpotifyMusicPlayer.Code.External.WiredSpeakerAPI;
import SpotifyMusicPlayer.Code.Models.Song;

public class WiredSpeakerAdapter implements IAudioOutputDevice {
    private WiredSpeakerAPI wiredApi;

    public WiredSpeakerAdapter(WiredSpeakerAPI api) {
        this.wiredApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        wiredApi.playSoundViaCable(payload);
    }
}