package application;

import java.util.Arrays;



public class Game {
    public static void main(String[] args) throws InterruptedException {
        int numBikers = 10;
        Biker[] bikers = new Biker[numBikers];

        for (int i = 0; i < numBikers; i++) {
            bikers[i] = Biker.getInstanceOfBiker("Biker" + (i + 1));
        }

        System.out.println("Starting countdown:");
        for (int i = 10; i >= 0; i--) {
            System.out.println(i + (i > 0 ? "..." : "!"));
            Thread.sleep(1000);
        }

        System.out.println("Race started!");
        synchronized (Biker.lock) {
            Biker.raceStarted = true; 
            Biker.lock.notifyAll();  
        }

        for (Biker biker : bikers) {
            biker.start();
        }

        for (Biker biker : bikers) {
            biker.join();
        }

        Arrays.sort(bikers, (b1, b2) -> Long.compare(b1.getRaceDuration(), b2.getRaceDuration()));

        System.out.println("\nRace Results:");
        System.out.printf("%-10s %-20s %-20s %-20s\n", "Rank", "Name", "Start Time (ns)", "End Time (ns)", "Race Duration (ns)");
        for (int i = 0; i < bikers.length; i++) {
            Biker biker = bikers[i];
            System.out.printf("%-10d %-20s %-20d %-20d %-20d\n",
                i + 1,
                biker.getBikerName(),
                biker.getStartTime(),
                biker.getEndTime(),
                biker.getRaceDuration());
        }
    }
}
