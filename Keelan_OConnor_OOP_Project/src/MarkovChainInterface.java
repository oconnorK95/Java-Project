import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;

public interface MarkovChainInterface {
    //TODO Generate probability of a note playing at start C is 100%, afterwards all notes of chord have
    // equal probability. Set them to 100/array.length and the rest to 0

    public void generateMusic();

    void generateMusic(Synthesizer synthesizerMG, MidiChannel midiChannelMG)//End generateMusic
    ;

    public void saveMusic(); //As binary
    public void readMusic(); //From binary file

}//End MarkovChainInterface
