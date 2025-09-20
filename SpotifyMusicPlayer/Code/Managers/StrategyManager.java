package SpotifyMusicPlayer.Code.Managers;

import SpotifyMusicPlayer.Code.Enums.PlayStrategyType;
import SpotifyMusicPlayer.Code.Factories.StrategyFactor;
import SpotifyMusicPlayer.Code.Strategies.IPlayStrategy;
import SpotifyMusicPlayer.Code.Strategies.SequentialPlayStrategy;

public class StrategyManager {
    private static StrategyManager instance = null;
    private IPlayStrategy playStrategy;

    private StrategyManager() {
        playStrategy = new SequentialPlayStrategy();
    }

    public static synchronized StrategyManager getInstance() {
        if (instance == null) {
            instance = new StrategyManager();
        }
        return instance;
    }

    public IPlayStrategy getStrategy(PlayStrategyType type) {
        playStrategy = StrategyFactor.createStrategy(type);
        return playStrategy;
    }
}