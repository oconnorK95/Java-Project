import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.Random;

//While this class does have a massive amount of code, the methods contain many loops of repeated code

// "Synthesizer generates sound when its MidiChannels receive noteOn messages."
// "A hardware or software device that plays back a MIDI sequence is known as a sequencer"

//TODO Generate bass line to supplement the treble (need new channel?)
//TODO Write a music save method
//TODO Write a music read method
public abstract class MusicGenerator{

    int previousNote = 60; //This must be 60(C), as it is the first note of the key
    int[] validNotes = new int[6];  //Stores the notes currently playable, added removed throughout loop
    int countNote = 0; //Counts how many notes have been played to terminate loop
    Synthesizer synthesizerMG; //Setting up the synthesizer
    MidiChannel midiChannelMG; //Setting up the midi channel
    int[] notesPlayed = new int[24];

    //         60,62,64,65,67,69,71,72
    //C MAJOR  C, D, E, F, G, A, B, C

    //This method will generate notes, the note played determines which notes can play next
    public void generateMusic() {

        //Attempts to define synthesizer and midi channel
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }

        //TODO Start sequencer to store the musical notes
        //Ensuring the first valid note is C
        validNotes[0] = 60;
        while(countNote < 24) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (previousNote == 60 && countNote <= 24) {
                //C CHORD
                System.out.println("Note of C Chord played");
                //validNotes = null; //Empty the array of previous elements
                validNotes[0] = 60; //C
                validNotes[1] = 64; //E
                validNotes[2] = 67; //G

                validNotes[3] = 60; //C
                validNotes[4] = 64; //E
                validNotes[5] = 67; //G

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;

                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                    //System.out.println("Random number was 0");
                }

                //Have to play note 60 for the music theory to be correct
                midiChannelMG.noteOn(60, 50);

                //Play note(X, with force Y)
                midiChannelMG.noteOn(validNotes[randomNote], 50);
                //Setting previous note as the random note so the next markov chain state can generate valid notes

                previousNote = validNotes[randomNote];
                //System.out.println("Previous note: " + previousNote);
                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 62 && countNote <= 24) {
            //D CHORD
                System.out.println("Note of D Chord played");
               // validNotes = null; //Empty the array of previous elements

                validNotes[0] = 60;//C
                validNotes[1] = 64;//E
                validNotes[2] = 67;//G

                validNotes[3] = 62;//D
                validNotes[4] = 65;//F
                validNotes[5] = 69;//A

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;
                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }

                midiChannelMG.noteOn(validNotes[randomNote], 50);
                System.out.println(validNotes[randomNote]);
                previousNote = validNotes[randomNote];
                //System.out.println(previousNote);

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 64 && countNote <= 24) {
                //E CHORD
                System.out.println("Note of E Chord played");
                //validNotes = null; //Empty the array of previous elements
                validNotes[0] = 60; //C
                validNotes[1] = 64; //E
                validNotes[2] = 67; //G
                validNotes[3] = 71; //B
                validNotes[4] = 62;//D
                validNotes[5] = 65;//F

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;
                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }

                midiChannelMG.noteOn(validNotes[randomNote], 50);
                previousNote = validNotes[randomNote];
                System.out.println(validNotes[randomNote]);

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 65 && countNote <= 24) {
                //F CHORD
                System.out.println("Note of F Chord played");
                //validNotes = null; //Empty the array of previous elements
                validNotes[0] = 62; //D
                validNotes[1] = 65; //F
                validNotes[2] = 69; //A
                validNotes[3] = 72; //C
                validNotes[4] = 64; //E
                validNotes[5] = 67; //G

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;
                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }

                midiChannelMG.noteOn(validNotes[randomNote], 50);
                System.out.println(validNotes[randomNote]);
                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 67 && countNote <= 24) {
                //G CHORD
                System.out.println("Note of G Chord played");
                //validNotes = null; //Empty the array of previous elements
                validNotes[0] = 64; //E
                validNotes[0] = 67; //G
                validNotes[1] = 71; //B
                validNotes[2] = 74; //high D
                validNotes[3] = 65; //F
                validNotes[4] = 69; //A


                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;
                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }

                midiChannelMG.noteOn(validNotes[randomNote], 50);
                System.out.println(validNotes[randomNote]);
                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 69 && countNote <= 24) {
                //A CHORD
                System.out.println("Note of A Chord played");
                //validNotes = null; //Empty the array of previous elements
                validNotes[0] = 69; //A
                validNotes[1] = 72; //C
                validNotes[2] = 76; //high E
                validNotes[3] = 65; //F
                validNotes[4] = 67; //F
                validNotes[5] = 60; //F


                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;
                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }

                midiChannelMG.noteOn(validNotes[randomNote], 50);
                System.out.println(validNotes[randomNote]);
                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 71 && countNote <= 24) {
                //B CHORD
                System.out.println("Note of B Chord played");
               // validNotes = null; //Empty the array of previous elements

                validNotes[0] = 71; //B
                validNotes[1] = 74; //D
                validNotes[2] = 77; //
                validNotes[3] = 69; //A
                validNotes[4] = 65; //F
                validNotes[5] = 60; //C

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;
                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }

                midiChannelMG.noteOn(randomNote, 50);
                System.out.println(validNotes[randomNote]);
                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else{
                //C CHORD
                System.out.println("Note of C Chord played");
                //validNotes = null; //Empty the array of previous elements
                validNotes[0] = 60; //C
                validNotes[1] = 64; //E
                validNotes[2] = 67; //G

                validNotes[3] = 60; //C
                validNotes[4] = 64; //E
                validNotes[5] = 67; //G

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0" which cannot be played
                int randomNote = 0;

                while(randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                    //System.out.println("Random number was 0");
                }

                //Have to play note 60 for the music theory to be correct
                midiChannelMG.noteOn(60, 50);

                //Play note(X, with force Y)
                midiChannelMG.noteOn(validNotes[randomNote], 50);
                //Setting previous note as the random note so the next markov chain state can generate valid notes

                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }
        }//End while
        System.out.println("Display save dialog");
        for(int i = 0; i<24; i++){
            System.out.println(notesPlayed[i]);
            midiChannelMG.noteOn(notesPlayed[i],50);
        }

    }//End generateMusic

    //These methods will play a Chord(3 notes)
    public void playChordC(){
        //Attempt to set up Synthesizer and Midi Channel
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        //Play note(C with 50 force), (E with 50 force) and (G with 50 force)
        midiChannelMG.noteOn(60,50);
        midiChannelMG.noteOn(64,50);
        midiChannelMG.noteOn(67,50);
        System.out.println("Played C");
    }
    public void playChordD(){
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        midiChannelMG.noteOn(62,50);
        midiChannelMG.noteOn(65,50);
        midiChannelMG.noteOn(69,50);
        System.out.println("Played D");
    }
    public void playChordE(){
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        midiChannelMG.noteOn(64,50);
        midiChannelMG.noteOn(67,50);
        midiChannelMG.noteOn(71,50);
        System.out.println("Played E");
    }
    public void playChordF(){
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        midiChannelMG.noteOn(65,50);
        midiChannelMG.noteOn(69,50);
        midiChannelMG.noteOn(72,50);
        System.out.println("Played F");
    }
    public void playChordG(){
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        midiChannelMG.noteOn(67,50);
        midiChannelMG.noteOn(71,50);
        midiChannelMG.noteOn(74,50);
        System.out.println("Played G");
    }
    public void playChordA(){
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        midiChannelMG.noteOn(69,50);
        midiChannelMG.noteOn(72,50);
        midiChannelMG.noteOn(76,50);
        System.out.println("Played A");
    }
    public void playChordB(){
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        midiChannelMG.noteOn(71,50);
        midiChannelMG.noteOn(74,50);
        midiChannelMG.noteOn(77,50);
        System.out.println("Played B");
    }
    public void playChordHighC(){
        try{
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        midiChannelMG.noteOn(72,50);
        midiChannelMG.noteOn(74,50);
        midiChannelMG.noteOn(76,50);
        System.out.println("Played High C");
    }//End playHighC

    //This method uses a thread to loop through all the chords of C major
    public void playAllChords(){
        for(int i = 0; i<8; i++) {
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==0){playChordA();}
            if(i==1){playChordB();}
            if(i==2){playChordC();}
            if(i==3){playChordD();}
            if(i==4){playChordE();}
            if(i==5){playChordF();}
            if(i==6){playChordG();}
            if(i==7){playChordHighC();}
        }//End for
    }//End PlayAllChords


}//End MusicGenerator
