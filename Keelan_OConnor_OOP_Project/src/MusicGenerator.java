import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Random;


// "Synthesizer generates sound when its MidiChannels receive noteOn messages."
// "A hardware or software device that plays back a MIDI sequence is known as a sequencer"

public abstract class MusicGenerator implements Serializable {

    int previousNote = 60; //This must be 60(C), as it is the first note of the key
    int[] validNotes = new int[6];  //Stores the notes currently playable, added removed throughout loop
    int countNote = 0; //Counts how many notes have been played to terminate loop
    Synthesizer synthesizerMG; //Setting up the synthesizer
    MidiChannel midiChannelMG; //Setting up the midi channel
    int[] notesPlayed = new int[24];

    //Creating a string builder to write midi
    StringBuilder stringBuilder1 = new StringBuilder();
    String strLine = "";

    //         60,62,64,65,67,69,71,72
    //C MAJOR  C, D, E, F, G, A, B, C

    //This method will generate notes, the note played determines which notes can play next
    public void generateMusic() throws IOException {

        //Attempts to define synthesizer and midi channel
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch

        //NOTE: I swapped the loop below with a Switch statement as suggested, however the loop lost almost all its
        // functionality as it was no longer able to make decisions, instead it just played a note from each case until
        // completion.

        //Ensuring the first valid note is C
        validNotes[0] = 60;
        while (countNote < 24) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (previousNote == 60 && countNote <= 24) {
                //C CHORD
                System.out.println("Note of C Chord played");
                validNotes[0] = 60; //C
                validNotes[1] = 64; //E
                validNotes[2] = 67; //G
                validNotes[3] = 60; //C
                validNotes[4] = 64; //E
                validNotes[5] = 67; //G

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                //Have to play note 60 for the music theory to be correct
                midiChannelMG.noteOn(60, 50);

                //Play note(X, with force Y)
                midiChannelMG.noteOn(validNotes[randomNote], 50);

                //Setting previous note as the random note so the next markov chain state can generate valid notes
                previousNote = validNotes[randomNote];

                //Storing array of notes played, the index at count note is the current note
                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 62 && countNote <= 24) {
                //D CHORD
                System.out.println("Note of D Chord played");
                validNotes[0] = 60;//C
                validNotes[1] = 64;//E
                validNotes[2] = 67;//G
                validNotes[3] = 62;//D
                validNotes[4] = 65;//F
                validNotes[5] = 69;//A

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                midiChannelMG.noteOn(validNotes[randomNote], 50);

                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 64 && countNote <= 24) {
                //E CHORD
                System.out.println("Note of E Chord played");
                validNotes[0] = 60; //C
                validNotes[1] = 64; //E
                validNotes[2] = 67; //G
                validNotes[3] = 71; //B
                validNotes[4] = 62;//D
                validNotes[5] = 65;//F

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                midiChannelMG.noteOn(validNotes[randomNote], 50);

                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 65 && countNote <= 24) {
                //F CHORD
                System.out.println("Note of F Chord played");
                validNotes[0] = 62; //D
                validNotes[1] = 65; //F
                validNotes[2] = 69; //A
                validNotes[3] = 72; //C
                validNotes[4] = 64; //E
                validNotes[5] = 67; //G

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                midiChannelMG.noteOn(validNotes[randomNote], 50);

                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 67 && countNote <= 24) {
                //G CHORD
                System.out.println("Note of G Chord played");
                validNotes[0] = 67; //G
                validNotes[1] = 71; //B
                validNotes[2] = 74; //high D
                validNotes[3] = 65; //F
                validNotes[4] = 69; //A
                validNotes[5] = 64; //E

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                midiChannelMG.noteOn(validNotes[randomNote], 50);

                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 69 && countNote <= 24) {
                //A CHORD
                System.out.println("Note of A Chord played");
                validNotes[0] = 69; //A
                validNotes[1] = 72; //C
                validNotes[2] = 76; //high E
                validNotes[3] = 65; //F
                validNotes[4] = 67; //F
                validNotes[5] = 60; //F

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                midiChannelMG.noteOn(validNotes[randomNote], 50);

                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else if (previousNote == 71 && countNote <= 24) {
                //B CHORD
                System.out.println("Note of B Chord played");
                validNotes[0] = 71; //B
                validNotes[1] = 74; //D
                validNotes[2] = 77; //
                validNotes[3] = 69; //A
                validNotes[4] = 65; //F
                validNotes[5] = 60; //C

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                midiChannelMG.noteOn(randomNote, 50);

                previousNote = validNotes[randomNote];

                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End if
            else {
                //C CHORD
                System.out.println("Note of C Chord played");
                validNotes[0] = 60; //C
                validNotes[1] = 64; //E
                validNotes[2] = 67; //G
                validNotes[3] = 60; //C
                validNotes[4] = 64; //E
                validNotes[5] = 67; //G

                //Generate random note to play
                //This while statement prevents the music generator loop from accepting a "0"
                int randomNote = 0;
                while (randomNote == 0) {
                    randomNote = new Random().nextInt(validNotes.length);
                }//End while

                //Have to play note 60 for the music theory to be correct
                midiChannelMG.noteOn(60, 50);

                //Play note(X, with force Y)
                midiChannelMG.noteOn(validNotes[randomNote], 50);

                //Setting previous note as the random note so the next markov chain state can generate valid notes
                previousNote = validNotes[randomNote];

                //Adding all played notes to an array for storage
                notesPlayed[countNote] = validNotes[randomNote];
                countNote++;
            }//End else

        }//End while

        //The following code saves music to the midi.txt file
        System.out.println("Display save dialog");
        //Option dialog to save music
        int yesNo = JOptionPane.showConfirmDialog(null, "Would you like to save this midi?",
                "Save", JOptionPane.YES_NO_CANCEL_OPTION);
        if (yesNo == JOptionPane.YES_OPTION) {

            //If yes, create a file to store the midi
            try {
                String fileName = "midi.txt";
                FileOutputStream fileOutputStream1 = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);


                objectOutputStream1.writeObject(notesPlayed);
                objectOutputStream1.close();

                //Set countNote to zero so the loop can repeat
                countNote = 0;

               System.out.println("Music saved");
            }//End Try
            catch (IOException e) {
                e.printStackTrace();
            }//End catch

        }//End if
        else {
            System.out.println("Midi will not save");
        }//End else
    }//End generateMusic


    public void readMidi() throws IOException {
        String fileName = "midi.txt";
        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(fileName));

        for(int i = 0; i<notesPlayed.length; i++) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            midiChannelMG.noteOn(notesPlayed[i], 50);
        }//End for
    }//End readMidi

    //<editor-fold desc="Play Chords + Notes">
    //These methods will play a Chord(3 notes)
    public void playChordC() {
        //Attempt to set up Synthesizer and Midi Channel
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        //Play note(C with 50 force), (E with 50 force) and (G with 50 force)
        midiChannelMG.noteOn(60, 50);
        midiChannelMG.noteOn(64, 50);
        midiChannelMG.noteOn(67, 50);
        System.out.println("Played C");
    }//End Chord C

    public void playChordD() {
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        midiChannelMG.noteOn(62, 50);
        midiChannelMG.noteOn(65, 50);
        midiChannelMG.noteOn(69, 50);
        System.out.println("Played D");
    }//End Chord D

    public void playChordE() {
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        midiChannelMG.noteOn(64, 50);
        midiChannelMG.noteOn(67, 50);
        midiChannelMG.noteOn(71, 50);
        System.out.println("Played E");
    }//End Chord E

    public void playChordF() {
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        midiChannelMG.noteOn(65, 50);
        midiChannelMG.noteOn(69, 50);
        midiChannelMG.noteOn(72, 50);
        System.out.println("Played F");
    }//End Chord F

    public void playChordG() {
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        midiChannelMG.noteOn(67, 50);
        midiChannelMG.noteOn(71, 50);
        midiChannelMG.noteOn(74, 50);
        System.out.println("Played G");
    }//End Chord G

    public void playChordA() {
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        midiChannelMG.noteOn(69, 50);
        midiChannelMG.noteOn(72, 50);
        midiChannelMG.noteOn(76, 50);
        System.out.println("Played A");
    }//End Chord A

    public void playChordB() {
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        midiChannelMG.noteOn(71, 50);
        midiChannelMG.noteOn(74, 50);
        midiChannelMG.noteOn(77, 50);
        System.out.println("Played B");
    }//End Chord B

    public void playChordHighC() {
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }//End catch
        midiChannelMG.noteOn(72, 50);
        midiChannelMG.noteOn(74, 50);
        midiChannelMG.noteOn(76, 50);
        System.out.println("Played High C");
    }//End playHighC

    //This method uses a thread to loop through all the chords of C major
    public void playAllChords() {
        for (int i = 0; i < 8; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                playChordA();
            }
            if (i == 1) {
                playChordB();
            }
            if (i == 2) {
                playChordC();
            }
            if (i == 3) {
                playChordD();
            }
            if (i == 4) {
                playChordE();
            }
            if (i == 5) {
                playChordF();
            }
            if (i == 6) {
                playChordG();
            }
            if (i == 7) {
                playChordHighC();
            }
        }//End for
    }//End PlayAllChords

    //This method uses a thread to loop through all the notes of C major
    public void playAllNotes() {
        //Attempt to set up Synthesizer and Midi Channel
        try {
            synthesizerMG = MidiSystem.getSynthesizer();
            synthesizerMG.open();
            midiChannelMG = synthesizerMG.getChannels()[15];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Music generator catch triggered.");
        }
        for (int i = 0; i < 8; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                midiChannelMG.noteOn(60, 50);
            }
            if (i == 1) {
                midiChannelMG.noteOn(62, 50);
            }
            if (i == 2) {
                midiChannelMG.noteOn(64, 50);
            }
            if (i == 3) {
                midiChannelMG.noteOn(65, 50);
            }
            if (i == 4) {
                midiChannelMG.noteOn(67, 50);
            }
            if (i == 5) {
                midiChannelMG.noteOn(69, 50);
            }
            if (i == 6) {
                midiChannelMG.noteOn(71, 50);
            }
            if (i == 7) {
                midiChannelMG.noteOn(72, 50);
            }
        }//End for
        System.out.println("All notes played.");
    }//End playAllNotes
    //</editor-fold>
}//End MusicGenerator