// Facade Pattern: Home Theater System

// Subsystem 1: DVD Player
class DvdPlayer {
    public void on() {
        System.out.println("DVD Player is now ON.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD Player is now OFF.");
    }
}

// Subsystem 2: Projector
class Projector {
    public void on() {
        System.out.println("Projector is now ON.");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to: " + input);
    }

    public void off() {
        System.out.println("Projector is now OFF.");
    }
}

// Subsystem 3: Sound System
class SoundSystem {
    public void on() {
        System.out.println("Sound System is now ON.");
    }

    public void setVolume(int level) {
        System.out.println("Sound System volume set to: " + level);
    }

    public void off() {
        System.out.println("Sound System is now OFF.");
    }
}

// Facade Class
class HomeTheaterFacade {
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DvdPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Getting ready to watch a movie...");
        dvdPlayer.on();
        projector.on();
        projector.setInput("DVD");
        soundSystem.on();
        soundSystem.setVolume(10);
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down home theater...");
        dvdPlayer.off();
        projector.off();
        soundSystem.off();
    }
}

// Client Code
public class FacadePattern {
    public static void main(String[] args) {
        DvdPlayer dvdPlayer = new DvdPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem);

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}

// Implemented home theatre using Facade Pattern. The home theater has multiple 
// components like a DVD player, projector, and sound system, which can be complex 
// to operate individually. The Facade will provide a simple interface to 
// control the entire system. 