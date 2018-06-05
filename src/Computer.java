import java.util.Optional;

/**
 * Created by Duc.Nguyen on 6/5/2018.
 */
public class Computer {
    public Computer(){}
    private Optional<SoundCard> soundCard;
    public Optional<SoundCard> getSoundCard(){
        return soundCard;
    }
}
