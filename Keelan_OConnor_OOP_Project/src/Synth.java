import javax.sound.midi.*;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.Flow;

//TODO Delete anything that is never used

//TODO Implement proper inheritance
//TODO Screen size for GUI.width and height
//TODO Learn how to use Channels + Also remove redundant code

//public void blahblah(int[]){}  //Take in key[] as variable

public class Synth extends MusicGenerator {
    public static void main(String[] args) {


        MusicGenerator musicGenerator1 = new MusicGenerator() {};
        try {
            musicGenerator1.generateMusic();   //Instantiated class
        } catch (Exception e) {
            e.printStackTrace();
        }

        int velocity = 50; //The speed the note is played at, low is soft high is hard
        int sound = 50; //Sound is the value of the note played, 50 is D
        // Collapsed GUI to clean up code

//<editor-fold desc="GUI">
        //GUI Setup
        JFrame frame1 = new JFrame("Synthesizer");
        frame1.setBounds(400, 250, 400, 400); //Location + position of GUI
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        JLabel label1 = new JLabel("Label");
        JTextPane textPane1 = new JTextPane();
        textPane1.setBounds(1, 1, 200, 200);
        textPane1.setText("This is a text area\n\n\n\n\n\n\n____________");
        textPane1.setEditable(false);
        FlowLayout layout = new FlowLayout();
        textPane1.setLayout(layout);
        JButton button1 = new JButton("Test");
        frame1.add(label1);
        panel1.add(button1);

        //Auto generated lambda from action listener
        button1.addActionListener(e -> System.out.println("Button pressed.")
        );


        frame1.add(panel1);
        frame1.add(textPane1);
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setLayout(layout);
        frame1.setVisible(true);
        //</editor-fold>
        //Declaring a sequencer and synthesizer
        Sequencer sequencer1; //TODO Use sequencer for something
        Synthesizer synthesizer1;
        MidiChannel midiChannel1 = null;
        Instrument[] instruments1;
        //                        C, D, E, F, G, A, B, C
        int[] cMajor = new int[] {60,62,64,65,67,69,71,72}; //midiChannel needs to read this in

       //Method to take in array of ints, key, and assign alpha values to them

        //Attempt to set sequencer and synthesizer
        try{
            sequencer1 = MidiSystem.getSequencer();
            synthesizer1 = MidiSystem.getSynthesizer();
            synthesizer1.open();
            System.out.println("Try executed successfully.");

            //The channel is used to create sound
            midiChannel1 = synthesizer1.getChannels()[15]; //Max 16?

            //Instruments store a sound which can be shifted in pitch
            Instrument[] allInstruments = synthesizer1.getAvailableInstruments();



//<editor-fold desc="DebugLoops">
            /*
            int count = 0;
            //Loop through all available instruments
            for(int i = 0; i<allInstruments.length; i++){
                //System.out.println(allInstruments[i]);
                count++;
               // System.out.println(count); //Should be 230~ instruments
            }//End for

            //Loading an instrument from allInstruments array at given index
*/
//</editor-fold>
        }//End try

        //Catch exceptions for unavailable sequencer and synthesizer
        catch(MidiUnavailableException e){
            System.out.println("Catch triggered.");
        }//End catch


//<editor-fold desc="For Loop Debugging">
        /*
        for(int i = 0; i<cMajor.length;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 0){
                midiChannel1.noteOn(cMajor[0], velocity);
            }
            else if(i == 1){
                midiChannel1.noteOn(cMajor[1], velocity);
            }
            else if(i == 2){
                midiChannel1.noteOn(cMajor[2], velocity);
            }
            else if(i == 3){
                midiChannel1.noteOn(cMajor[3], velocity);
            }
            else if(i == 4){
                midiChannel1.noteOn(cMajor[4], velocity);
            }
            else if(i == 5){
                midiChannel1.noteOn(cMajor[5], velocity);
            }
            else {
                midiChannel1.noteOn(cMajor[6], velocity);
                System.out.println("Last Note Played");
            }//End else
        }//End for
*/
        ///////////////////////////////////////////////////////////

        /*
        //Loop to alter pitch of a note over time for debugging
        for(int i = 0; i<200; i++){
            try {
                Thread.sleep(100);
                //   (noteNumber = note pitch 0-127, velocity = volume/brightness)
               // midiChannel1.noteOn(sound + i,velocity);
                //System.out.println("Note should play");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//End catch
        }//End for
        */
//</editor-fold>

    }//End main
}//End Synth
