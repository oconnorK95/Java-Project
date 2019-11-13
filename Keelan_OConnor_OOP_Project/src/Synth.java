import javax.sound.midi.*;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.Flow;

//TODO Delete anything that is never used
//TODO Screen size for GUI.width and height

public class Synth extends MusicGenerator {
    protected Synth() throws MidiUnavailableException {
        System.out.println("MidiUnavailableException one");
    }

    public static void main(String[] args) throws MidiUnavailableException {


        MusicGenerator musicGenerator1 = new MusicGenerator() {};
        try {
            musicGenerator1.generateMusic();   //Instantiated class
        } catch (Exception e) {
            e.printStackTrace();
        }

        int velocity = 50; //The speed the note is played at, low is soft high is hard
        int sound = 50; //Sound is the value of the note played, 50 is D

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

        //Attempt to set sequencer and synthesizer
        try{
            sequencer1 = MidiSystem.getSequencer();
            synthesizer1 = MidiSystem.getSynthesizer();
            synthesizer1.open();
            System.out.println("Try executed successfully.");

            //The channel is used to create sound
            midiChannel1 = synthesizer1.getChannels()[14]; //Max 16?

            //Instruments store a sound which can be shifted in pitch
            Instrument[] allInstruments = synthesizer1.getAvailableInstruments();

        }//End try

        //Catch exceptions for unavailable sequencer and synthesizer
        catch(MidiUnavailableException e){
            System.out.println("Catch triggered.");
        }//End catch

    }//End main
}//End Synth
