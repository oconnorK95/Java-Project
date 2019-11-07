import javax.sound.midi.*;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

//TODO Implement proper inheritance
//TODO Write base features of driver
//TODO Music generation function
//TODO Define rules music must follow
//TODO Read/Write music function
//TODO Learn how to use Channels


public class Synth {
    public static void main(String[] args) {

        //TODO make nicer GUI
        //GUI Setup
        JFrame frame1 = new JFrame("Synth1");
        frame1.setBounds(400,400,400,400); //Location + position of GUI
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("Play");
        panel1.add(button1);
        frame1.add(panel1);
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        //Declaring a sequencer and synthesizer
        Sequencer sequencer1;
        Synthesizer synthesizer1;

        //Attempt to set sequencer and synthesizer
        try{
            sequencer1 = MidiSystem.getSequencer();
            synthesizer1 = MidiSystem.getSynthesizer();
            synthesizer1.open(); //TODO make this always open
            System.out.println("Tried successfully");
        }//End try


        //Catch exceptions for unavailable sequencer and synthesizer
        catch(MidiUnavailableException e){
        }//End catch

    }//End main

}//End Synth
