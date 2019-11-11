import javax.sound.midi.MidiSystem;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Random;

//Generate arrays to hold possible next playable note, based on the last note played
//First note of key must be equal to key, Key:C = Note:C

//Maybe generate all the notes of each chord, select notes from each valid chord to play

public abstract class MusicGenerator implements MarkovChainInterface {
    //File file1 = new File(filepath);

    int previousNote = 0;
    int[] validNotes = new int[0];  //Add + Remove notes at runtime in loop
    int countNote = 0;
    //         60,62,64,65,67,69,71,72
    //C MAJOR  C, D, E, F, G, A, B, C
    //Adding valid playable notes to the array, based on the previous note. Clear after a new note is played.



    @Override
    public void generateMusic() {
        int randomNote = new Random().nextInt(validNotes.length);
        if(previousNote == 60){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 60;
            validNotes[1] = 64;
            validNotes[2] = 67;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
        else if(previousNote == 62){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 62;
            validNotes[1] = 65;
            validNotes[2] = 69;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
        else if(previousNote == 64){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 64;
            validNotes[1] = 67;
            validNotes[2] = 71;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
        else if(previousNote == 65){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 65;
            validNotes[1] = 69;
            validNotes[2] = 72;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
        else if(previousNote == 67){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 67;
            validNotes[1] = 71;
           // validNotes[2] = 72; high d

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
        else if(previousNote == 69){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 69;
            validNotes[1] = 72;
            // validNotes[2] = 72;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
        else if(previousNote == 71){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 71;
            //validNotes[1] = 72;
            // validNotes[2] = 72;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
        else if(previousNote == 72){
            validNotes = null; //Empty the array of previous elements
            validNotes[0] = 72;
            //validNotes[1] = 72;
            // validNotes[2] = 72;

            //select one randomly
            //midiChannel1.noteOn(randomNote, 50);//validNotes[randomNote];
        }//End if
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
