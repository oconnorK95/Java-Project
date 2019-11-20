import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import java.io.File;

public abstract class FileIO {

    public File file1;

    //Needed help saving a loading sequences
    //https://docs.oracle.com/javase/tutorial/sound/MIDI-seq-methods.html
    //Sequence will store notes
    Sequence sequence1;
    //sequence1.recordEnable;
    //sequence1.startRecording;
    //sequence1.stopRecording;
    // MidiSystem.write. write method of MidiSystem takes Sequence as argument, and write Sequence to file.

    public void saveMusic() {

        try{
            //PPQ = pulses per quarter, Resolution = timing
            sequence1 = new Sequence(Sequence.PPQ, 10);

            //The track stores an instance of a sequences music
            sequence1.createTrack();

        } catch (Exception ex) {
            ex.printStackTrace();
        }//End catch
    }//End saveMusic

    public Sequence getSequence1() {
        return sequence1;
    }
    public void setSequence1(Sequence sequence1) {
        this.sequence1 = sequence1;
    }


    public void readMusic() {
        //AudioInputStream audioInputStream =
        // AudioSystem.getAudioInputStream(fileIn);
    }//End writeMusic
}
