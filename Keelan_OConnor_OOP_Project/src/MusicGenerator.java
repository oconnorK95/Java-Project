import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.Random;

// "Synthesizer generates sound when its MidiChannels receive noteOn messages."
// "A hardware or software device that plays back a MIDI sequence is known as a sequencer"

//TODO Generate bass line to supplement the treble (need new channel?)
//TODO Write a music save method
//TODO Write a music read method

//TODO add more notes to each loop

public abstract class MusicGenerator{
    //File file1 = new File(filepath);



    int previousNote = 60; //This must be C, the first note of the key regardless
    int[] validNotes = new int[6];  //Add + Remove notes at runtime in loop
    int countNote = 0;
    //         60,62,64,65,67,69,71,72
    //C MAJOR  C, D, E, F, G, A, B, C






//TODO Fix the exception being thrown, commenting out the midi channel fixed catch executing
//TODO Fix logical error that only allows notes to increase in pitch, should also decrease
    MusicGenerator(Synthesizer synthesizerMG,MidiChannel midiChannelMG){
    }

    public void generateMusic(Synthesizer synthesizerMG, MidiChannel midiChannelMG) {

        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        //TODO Start sequencer to store the musical notes
        validNotes[0] = 60; //Fixed error bound must be positive

        if(previousNote == 60 && countNote <= 24){
            //C CHORD
            System.out.println("Note of C Chord played");
            //validNotes = null; //Empty the array of previous elements
            validNotes[0] = 60; //C
            validNotes[1] = 64; //E
            validNotes[2] = 67; //G

            //TODO Fix midi exception triggering here
            int randomNote = new Random().nextInt(validNotes.length);  //TODO fix this printing 0, only 60-64-67
            //TODO define what the previous note was for the next loop cycle

            System.out.println(validNotes[randomNote]);

            midiChannelMG.noteOn(validNotes[randomNote], 50);
            previousNote = validNotes[randomNote]; System.out.println(previousNote);
            countNote ++;
        }//End if
        else if(previousNote == 62 && countNote <= 24){
            //D CHORD
            System.out.println("Note of D Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 60;
            validNotes[1] = 64;
            validNotes[2] = 67;

            validNotes[3] = 62;//D
            validNotes[4] = 65;//F
            validNotes[5] = 69;//A

            int randomNote = new Random().nextInt(validNotes.length);
            //select one randomly
            //midiChannelMG.noteOn(validNotes[randomNote], 50);
            System.out.println(validNotes[randomNote]);
            previousNote = validNotes[randomNote]; System.out.println(previousNote);
            countNote ++;
        }//End if
        else if(previousNote == 64 && countNote <= 24){
            //E CHORD
            System.out.println("Note of E Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 64; //E
            validNotes[1] = 67; //G
            validNotes[2] = 71; //B

            validNotes[3] = 62;//D
            validNotes[4] = 65;//F
            validNotes[5] = 69;//A

            int randomNote = new Random().nextInt(validNotes.length);
            //select one randomly
           // midiChannelMG.noteOn(validNotes[randomNote], 50);
            System.out.println(validNotes[randomNote]);
            countNote ++;
        }//End if
        else if(previousNote == 65 && countNote <= 24){
            //F CHORD
            System.out.println("Note of F Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 65; //F
            validNotes[1] = 69; //A
            validNotes[2] = 72; //C

            validNotes[3] = 64; //E
            validNotes[4] = 67; //G
            validNotes[5] = 71; //B

            int randomNote = new Random().nextInt(validNotes.length);
            //select one randomly
            //midiChannelMG.noteOn(validNotes[randomNote], 50);
            System.out.println(validNotes[randomNote]);
            countNote ++;
        }//End if
        else if(previousNote == 67 && countNote <= 24){
            //G CHORD
            System.out.println("Note of G Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 67; //G
            validNotes[1] = 71; //B
            validNotes[2] = 74; //high D

            validNotes[3] = 65; //F
            validNotes[4] = 69; //A
            validNotes[5] = 72; //C

            int randomNote = new Random().nextInt(validNotes.length);
            //select one randomly
            //midiChannelMG.noteOn(validNotes[randomNote], 50);
            System.out.println(validNotes[randomNote]);
            countNote ++;
        }//End if
        else if(previousNote == 69 && countNote <= 24){
            //A CHORD
            System.out.println("Note of A Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 69; //A
            validNotes[1] = 72; //C
            validNotes[2] = 76; //high E

            int randomNote = new Random().nextInt(validNotes.length);
            //select one randomly
            //midiChannelMG.noteOn(validNotes[randomNote], 50);
            System.out.println(validNotes[randomNote]);
            countNote ++;
        }//End if
        else if(previousNote == 71 && countNote <= 24){
            //B CHORD
            System.out.println("Note of B Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 71; //B
            validNotes[1] = 74; //D
            validNotes[2] = 77; //F

            int randomNote = new Random().nextInt(validNotes.length);
            //select one randomly
            //midiChannelMG.noteOn(randomNote, 50);
            System.out.println(validNotes[randomNote]);
            countNote ++;
        }//End if
    }//End generateMusic


    public void saveMusic() {
        //MidiSystem.write();
        //access sequencer
    }//End saveMusic


    public void readMusic() {
        //AudioInputStream audioInputStream =
        // AudioSystem.getAudioInputStream(fileIn);
    }//End writeMusic

}//End MusicGenerator
