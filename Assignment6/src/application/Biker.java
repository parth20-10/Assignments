package application;

class Biker extends Thread {
    private String name;
    private long startTime;
    private long endTime;
    private long raceDuration;
    private static final int DISTANCE = 1000;
    public static final Object lock = new Object();
    public static boolean raceStarted = false;

    private Biker(String name) {
        this.name = name;
    }
    public static  Biker getInstanceOfBiker(String name) {
    	return new Biker(name);
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (!raceStarted) {
                    lock.wait();
                }
            }
            startTime = System.nanoTime();
            int progress = 0;
            while (progress < DISTANCE) {
                progress += (int) (Math.random() * 10 + 1);
                Thread.sleep(10);
            }
            endTime = System.nanoTime();
            raceDuration = endTime - startTime;
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
    }

    public String getBikerName() {
        return name;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getRaceDuration() {
        return raceDuration;
    }
}