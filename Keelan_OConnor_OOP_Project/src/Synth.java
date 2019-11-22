import javax.sound.midi.*;
import javax.sound.midi.Synthesizer; //TODO delete unneeded imports
import javax.swing.*;
import java.awt.*;

//TODO Delete anything that is never used

//TODO File reading and writing in separate instantiable class

public class Synth extends MusicGenerator{
    public static void main(String[] args) {


        //Declaring a sequencer and synthesizer
        Sequencer sequencer1; //TODO Use sequencer for something
        Synthesizer synthesizer1;
        MidiChannel midiChannel1 = null;  //Midi channels take in midi events for a synthesizer

        //                        C, D, E, F, G, A, B, C
        int[] cMajor = new int[] {60,62,64,65,67,69,71,72}; //midiChannel needs to read this in

        MusicGenerator musicGenerator;
        musicGenerator = new MusicGenerator() {
            public void generateMusic() {
                super.generateMusic();
            }
        };


        int velocity = 50; //The speed the note is played at, low is soft high is hard
        int sound = 50; //Sound is the value of the note played, 50 is D

        try{
            sequencer1 = MidiSystem.getSequencer();
            synthesizer1 = MidiSystem.getSynthesizer(); //Define a synthesizer
            synthesizer1.open(); //Open the synthesizer so it can operate
            System.out.println("Tried successfully.");

            //The channel is used to create sound
            midiChannel1 = synthesizer1.getChannels()[15]; //Max 16

            //Instruments store a sound which can be shifted in pitch
            Instrument[] allInstruments = synthesizer1.getAvailableInstruments();
        }//End try

        //Catch exceptions for unavailable sequencer, synthesizer and channel
        catch(MidiUnavailableException e){
            System.out.println("Catch triggered.");
        }//End catch

        //TODO GUI MENU STRIP
//<editor-fold desc="GUI">
        //GUI Setup
        JFrame frame1 = new JFrame("Synthesizer");
        frame1.setBounds(400, 250, 400, 400); //Location + position of GUI
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        //JLabel label1 = new JLabel("Key of C:");
        //frame1.add(label1);
        JTextPane textPane1 = new JTextPane();
        textPane1.setBounds(1, 1, 200, 200);
        textPane1.setText("Click on a note in the key of C to play it");
        textPane1.setEditable(false);
        FlowLayout layout = new FlowLayout();
        textPane1.setLayout(layout);
        JButton button1 = new JButton("C");
        JButton button2 = new JButton("D");
        JButton button3 = new JButton("E");
        JButton button4 = new JButton("F");
        JButton button5 = new JButton("G");
        JButton button6 = new JButton("A");
        JButton button7 = new JButton("B");
        JButton button8 = new JButton("C");

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);

        //TODO make menu options do things
        JMenuBar menuBar1;
        menuBar1 = new JMenuBar();
        JMenu menu1;
        JMenuItem submenu1, submenu2;
        menu1 = new JMenu("Play: ");
        submenu1 = new JMenuItem("Chords");
        submenu2 = new JMenuItem("Notes");
        menuBar1.add(menu1);
        menu1.add(submenu1);
        menu1.addSeparator();
        menu1.add(submenu2);
        menu1.addSeparator();
        frame1.add(menuBar1);

        //Auto generated lambda from action listener
        // noteOn(note in the index of cMajor array, how forcefully to play the note)
        MidiChannel finalMidiChannel = midiChannel1;
        button1.addActionListener(e -> finalMidiChannel.noteOn(cMajor[0], velocity));
        button1.addActionListener(e -> System.out.println("C Major C: " + cMajor[0]));
        button2.addActionListener(e -> finalMidiChannel.noteOn(cMajor[1], velocity));
        button2.addActionListener(e -> System.out.println("C Major D: " + cMajor[1]));
        button3.addActionListener(e -> finalMidiChannel.noteOn(cMajor[2], velocity));
        button3.addActionListener(e -> System.out.println("C Major E: " + cMajor[2]));
        button4.addActionListener(e -> finalMidiChannel.noteOn(cMajor[3], velocity));
        button4.addActionListener(e -> System.out.println("C Major F: " + cMajor[3]));
        button5.addActionListener(e -> finalMidiChannel.noteOn(cMajor[4], velocity));
        button5.addActionListener(e -> System.out.println("C Major G: " + cMajor[4]));
        button6.addActionListener(e -> finalMidiChannel.noteOn(cMajor[5], velocity));
        button6.addActionListener(e -> System.out.println("C Major A: " + cMajor[5]));
        button7.addActionListener(e -> finalMidiChannel.noteOn(cMajor[6], velocity));
        button7.addActionListener(e -> System.out.println("C Major B: " + cMajor[6]));
        button8.addActionListener(e -> finalMidiChannel.noteOn(cMajor[7], velocity));
        button8.addActionListener(e -> System.out.println("C Major C: " + cMajor[7]));

        JButton button9 = new JButton("Generate Random Music");
        frame1.add(button9);
        button9.addActionListener(e -> musicGenerator.generateMusic());

        JButton button10 = new JButton("Record");
        frame1.add(button10);
        button10.addActionListener(e -> System.out.println("Record Enabled"));

        JButton button11 = new JButton("Stop Recording");
        frame1.add(button11);
        button11.addActionListener(e -> System.out.println("Record Finished"));

        //TODO list of playable midis
        JButton button12 = new JButton("Play a Recording");
        frame1.add(button12);
        button12.addActionListener(e -> System.out.println("Play something"));

        frame1.add(panel1);
        frame1.add(textPane1);
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setLayout(layout);
        frame1.setVisible(true);
        //</editor-fold>

    }//End main
}//End Synth
