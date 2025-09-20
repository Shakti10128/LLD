package SpotifyMusicPlayer.Code.Factories;

import SpotifyMusicPlayer.Code.Devices.BluetoothSpeakerAdapter;
import SpotifyMusicPlayer.Code.Devices.HeadphonesAdapter;
import SpotifyMusicPlayer.Code.Devices.IAudioOutputDevice;
import SpotifyMusicPlayer.Code.Devices.WiredSpeakerAdapter;
import SpotifyMusicPlayer.Code.Enums.DeviceType;
import SpotifyMusicPlayer.Code.External.BluetoothSpeakerAPI;
import SpotifyMusicPlayer.Code.External.HeadphonesAPI;
import SpotifyMusicPlayer.Code.External.WiredSpeakerAPI;

public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType deviceType) {
        switch (deviceType) {
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED:
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONES:
            default:
                return new HeadphonesAdapter(new HeadphonesAPI());
        }
    }
}