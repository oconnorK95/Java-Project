import javax.sound.midi.*;
import javax.sound.midi.Synthesizer;

//Need proper inheritance + driver
//What are the base features of a synthesizer, what variations will it need, what will the driver do
//What class will generate music?
//What class will read/write music files

public class Synth {
    public static void main(String[] args) {


        Sequencer sequencer1;
        Synthesizer synthesizer1;

        //Attempt to set sequencer and synthesizer
        try{
            sequencer1 = MidiSystem.getSequencer();
            synthesizer1 = MidiSystem.getSynthesizer();
            synthesizer1.open(); //TODO make this always open
            System.out.println("Tried successfully");
        }


        //Catch exceptions for unavailable sequencer and synthesizer
        catch(MidiUnavailableException e){
        }

    }
/*
    JFrame frame1 = new JFrame("Synth1");
    JFrame.setSize(100,100);
    JPanel panel1 = new JPanel();
    JButton button1 = new JButton("Play");

    panel1.add(button1);
    frame1.add(panel1);
    frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
    frame1.show();
*/

}//End Synth
