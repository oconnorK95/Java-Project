import javax.sound.midi.MidiSystem;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Random;

// "Synthesizer generates sound when its MidiChannels receive noteOn messages."
// "A hardware or software device that plays back a MIDI sequence is known as a sequencer"

//TODO Generate bass line to supplement the treble (need new channel?)
//TODO Write a music save method
//TODO Write a music read method

//Generate arrays to hold possible next playable note, based on the last note played
//First note of key must be equal to key, Key:C = Note:C

//Maybe generate all the notes of each chord, select notes from each valid chord to play

public abstract class MusicGenerator implements MarkovChainInterface {
    //File file1 = new File(filepath);



    int previousNote = 60; //This must be C, the first note of the key regardless
    int[] validNotes = new int[0];  //Add + Remove notes at runtime in loop
    int countNote = 0;
    //         60,62,64,65,67,69,71,72
    //C MAJOR  C, D, E, F, G, A, B, C
    //Adding valid playable notes to the array, based on the previous note. Clear after a new note is played.

//TODO Solution: Set randomNote to 60 by default, overwrite it with the new Random number?
//TODO Fix logical error that only allows notes to increase in pitch, should also decrease

    @Override
    public void generateMusic() {
        //TODO Start sequencer to store the musical notes
        int randomNote = new Random().nextInt(validNotes.length);
        if(previousNote == 60 && countNote <= 24){
            //C CHORD
            System.out.println("Note of C Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 60; //C
            validNotes[1] = 64; //E
            validNotes[2] = 67; //G

            //TODO select a member of array randomly + play it
            //TODO define what the previous note was for the next loop cycle
            //midiChannel1.noteOn(validNotes[randomNote], 50);
            countNote ++;
        }//End if
        else if(previousNote == 62 && countNote <= 24){
            //D CHORD
            System.out.println("Note of D Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 62; //D
            validNotes[1] = 65; //F
            validNotes[2] = 69; //A

            //select one randomly
            //midiChannel1.noteOn(validNotes[randomNote], 50);
            countNote ++;
        }//End if
        else if(previousNote == 64 && countNote <= 24){
            //E CHORD
            System.out.println("Note of E Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 64; //E
            validNotes[1] = 67; //G
            validNotes[2] = 71; //B

            //select one randomly
            //midiChannel1.noteOn(validNotes[randomNote], 50);
            countNote ++;
        }//End if
        else if(previousNote == 65 && countNote <= 24){
            //F CHORD
            System.out.println("Note of F Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 65; //F
            validNotes[1] = 69; //A
            validNotes[2] = 72; //C

            //select one randomly
            //midiChannel1.noteOn(validNotes[randomNote], 50);
            countNote ++;
        }//End if
        else if(previousNote == 67 && countNote <= 24){
            //G CHORD
            System.out.println("Note of G Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 67; //G
            validNotes[1] = 71; //B
            validNotes[2] = 74; //high D

            //select one randomly
            //midiChannel1.noteOn(validNotes[randomNote], 50);
            countNote ++;
        }//End if
        else if(previousNote == 69 && countNote <= 24){
            //A CHORD
            System.out.println("Note of A Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 69; //A
            validNotes[1] = 72; //C
            validNotes[2] = 76; //high E

            //select one randomly
            //midiChannel1.noteOn(validNotes[randomNote], 50);
            countNote ++;
        }//End if
        else if(previousNote == 71 && countNote <= 24){
            //B CHORD
            System.out.println("Note of B Chord played");
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 71; //B
            validNotes[1] = 74; //D
            validNotes[2] = 77; //F

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);
            countNote ++;
        }//End if
        /*else if(previousNote == 72 && countNote <= 24){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 72;
            //validNotes[1] = 72;
            // validNotes[2] = 72;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
            countNote ++;
        }//End if */
    }//End generateMusic

    @Override
    public void saveMusic() {
        //MidiSystem.write();
    }//End saveMusic

    @Override
    public void readMusic() {
        //AudioInputStream audioInputStream =
        // AudioSystem.getAudioInputStream(fileIn);
    }//End writeMusic

}//End MusicGenerator
