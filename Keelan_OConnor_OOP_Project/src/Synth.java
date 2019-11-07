import javax.sound.midi.*;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

//TODO Implement proper inheritance
//TODO Write base features of driver
//TODO Music generation function
//TODO Define rules music must follow
//TODO Read/Write music function
//TODO Learn how to use Channels
//TODO Screen size for GUI.width and height


public class Synth {
    public static void main(String[] args) {

        // Collapsed GUI to clean up code
//<editor-fold desc="GUI">
        //GUI Setup
        JFrame frame1 = new JFrame("Synthesizer");
        frame1.setBounds(400, 250, 400, 400); //Location + position of GUI
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        JLabel label1 = new JLabel("Label");
        JTextPane textPane1 = new JTextPane();
        textPane1.setBounds(1, 1, 200, 200);//TODO Make this work
        textPane1.setText("This is a text area\n\n\n\n\n\n\n____________"); //TODO Make this work
        textPane1.setEditable(false);
        FlowLayout layout = new FlowLayout();
        textPane1.setLayout(layout);
        JButton button1 = new JButton("Play");
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
        Sequencer sequencer1;
        Synthesizer synthesizer1;
        MidiChannel[] midiChannel1;
        Instrument[] instruments1;

        //Attempt to set sequencer and synthesizer
        try{
            sequencer1 = MidiSystem.getSequencer();
            synthesizer1 = MidiSystem.getSynthesizer();
            synthesizer1.open(); //TODO make this always open
            System.out.println("Tried successfully.");

            //The channel is used to create sound
            midiChannel1 = synthesizer1.getChannels();

            //Instruments store a sound which can be shifted in pitch
            Instrument[] allInstruments = synthesizer1.getAvailableInstruments();

            int count = 0;
            //Loop through all available instruments
            for(int i = 0; i<allInstruments.length; i++){
                System.out.println(allInstruments[i]); //TODO: Select option to display all instruments, display on GUI
                count++;
               // System.out.println(count); //Should be 234 instruments
            }//End for
            //TODO call load instrument method on botton click
            //Loading an instrument from allInstruments array at given index
            synthesizer1.loadInstrument(allInstruments[185]);
            //Unload instrument
            //Get loaded Instrument
            //final Instrument[] loadedInstruments = synthesizer1.getLoadedInstruments();

        }//End try

        //Catch exceptions for unavailable sequencer and synthesizer
        catch(MidiUnavailableException e){
            System.out.println("Catch triggered.");
        }//End catch

        //void noteOn(int noteNumber, int velocity)

        //TODO void noteOn(int noteNumber,
        //          int velocity)
        //Starts the specified note sounding. The key-down velocity usually controls the note's volume and/or brightness.
        //If velocity is zero, this method instead acts like noteOff(int), terminating the note.
        //Parameters:
        //noteNumber - the MIDI note number, from 0 to 127 (60 = Middle C)
        //velocity - the speed with which the key was depressed

    }//End main
}//End Synth
