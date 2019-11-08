public class MusicRules {
    //Need to keep track of what rules my program will work around, might delete if unnecessary.

    // "Synthesizer generates sound when its MidiChannels receive noteOn messages."

    //Tempo: Speed of the song
    //Key: Determines the "Range of Notes" that can be played
    //Chords: Determined by key, made of 3 notes
    //Triads: A group of chords, must calculate which triads are acceptable.  I ii iii IV V vi vii MAJOR minor
    //Length: The duration of the music

    //C MAJOR  C, D, E, F, G, A, B, C         60,62,64,67,69,71,72
    //D MAJOR D, E, F#, G, A, B, C#, D
    //E MAJOR  E, F#, G#, A, B, C#, D#, E

    //Store notes as array of ints, loop through to assign notes to midi channel
    //Ultimately want program to read numbers from letters: Type C to get 60



}
