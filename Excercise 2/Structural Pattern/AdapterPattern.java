// Adapter Pattern: Media Player

// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface VlcPlayerInterface{
    void playVlc(String fileName);
}

// Adaptee
class VlcPlayer implements VlcPlayerInterface {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Adapter
class VlcPlayerAdapter implements MediaPlayer {
    private VlcPlayer vlcPlayer;

    // Constructor to initialize the adaptee
    public VlcPlayerAdapter(VlcPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    // Implementing the play method from MediaPlayer interface
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        } else {
            System.out.println("Error: Unsupported audio type.");
        }
    }
}

// Client Code
public class AdapterPattern {
    public static void main(String[] args) {
        // Creating an instance of VlcPlayer
        VlcPlayer vlcPlayer = new VlcPlayer();
        
        // Creating an adapter for VlcPlayer
        MediaPlayer mediaPlayer = new VlcPlayerAdapter(vlcPlayer);

        // Using the adapter to play a VLC file
        mediaPlayer.play("vlc", "example.vlc"); // Output: Playing VLC file: example.vlc
        mediaPlayer.play("mp3", "example.mp3"); // Output: Error: Unsupported audio type.
    }
}

// Created an adapter that allows an incompatible interface to be used as a target interface.
// The VlcPlayer class has a method playVlc that is incompatible with the MediaPlayer interface.
// The VlcPlayerAdapter class adapts the VlcPlayer class to the MediaPlayer interface, 
// allowing it to be used by client code that expects a MediaPlayer