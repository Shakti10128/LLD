package SpotifyMusicPlayer.Code.Factories;

import SpotifyMusicPlayer.Code.Enums.PlayStrategyType;
import SpotifyMusicPlayer.Code.Strategies.CustomQueueStrategy;
import SpotifyMusicPlayer.Code.Strategies.IPlayStrategy;
import SpotifyMusicPlayer.Code.Strategies.RandomPlayStrategy;
import SpotifyMusicPlayer.Code.Strategies.SequentialPlayStrategy;

public class StrategyFactory {
    public static IPlayStrategy createStrategy(PlayStrategyType type) {
        switch (type) {
            case RANDOM:
                return new RandomPlayStrategy();
            case CUSTOM_QUEUE:
                return new CustomQueueStrategy();
            case SEQUENTIAL:
            default:
                return new SequentialPlayStrategy();
                    
        }
    }
}
