public class Fine {
    public static final int FINE_PER_DAY = 5000;

    public static int calculate(long daysLate) {
        if (daysLate <= 0) return 0;
        return (int) (daysLate * FINE_PER_DAY);
    }
}
