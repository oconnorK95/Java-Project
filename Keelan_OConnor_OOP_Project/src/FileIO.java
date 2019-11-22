import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import java.io.File;

//https://docs.oracle.com/javase/tutorial/sound/MIDI-seq-methods.html
public abstract class FileIO {

    Sequencer sequencer1;

    //Needed help saving a loading sequences
    //https://docs.oracle.com/javase/tutorial/sound/MIDI-seq-methods.html
    //Sequence will store notes
    Sequence sequence1;
    //sequence1.recordEnable;
    //sequence1.startRecording;
    //sequence1.stopRecording;
    // MidiSystem.write. write method of MidiSystem takes Sequence as argument, and write Sequence to file.

    public void saveMusic() throws MidiUnavailableException {

        //Attempt to get default sequencer
        sequencer1 = MidiSystem.getSequencer();
        if (sequencer1 == null) {
            System.out.println("No sequencer found");
        } else {
            //Load the sequencer
            sequencer1.open();
            //sequencer1.recordEnable(/*create track*/);
            sequencer1.startRecording();
            //Stop recording after certain amount of notes or before save: (if still recording, stop recording)
        }//End else

    }//End saveMusic


   /*
    try{
            //PPQ = pulses per quarter, Resolution = timing
            sequence1 = new Sequence(Sequence.PPQ, 10);

            //The track stores an instance of a sequences music
            sequence1.createTrack();

        } catch (Exception ex) {
            ex.printStackTrace();
        }//End catch
     */


    public void readMusic() {
        try {
            File midiFile1 = new File("sequence1.mid");
            // Create sequence object
            // load sequence object into sequencer
            Sequence sequence1 = MidiSystem.getSequence(midiFile1);
            sequencer1.setSequence(sequence1);
        } catch (Exception e) {
            System.out.println("Failed to assign sequence to sequencer");
        }//End catch
    }//End writeMusic


}//End FileIO
