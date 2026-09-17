public class Booking {
    public static final String[] ACTIVITIES = {"Programmeringsworkshop","Matlagningskurs","Träningspass"};
    public static final int[] PRICES = {200, 300, 150};
    public static final int MAX_NUM_PARTICIPANTS = 500;

    private final int activityIndex;
    private final int numOfParticipants;
    private final int price;

    public Booking (int activityIndex, int numOfParticipants, int price) {
        if (activityIndex < 0 || activityIndex >= ACTIVITIES.length) {
            throw new IllegalArgumentException("Ogiltigt aktivitetsindex.");
        }

        if (numOfParticipants < 1 || numOfParticipants > MAX_NUM_PARTICIPANTS) {
            throw new IllegalArgumentException("Ogiltigt antal deltagare.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Ogiltigt pris.");
        }
        this.activityIndex = activityIndex;
        this.numOfParticipants = numOfParticipants;
        this.price = price;
    }

    public int getActivityIndex() {
        return activityIndex;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        // Returnerar bokningen som en läsbar text.
        return ACTIVITIES[activityIndex] + ", " + numOfParticipants + " deltagare, " + price + " kr";
    }

    public static int calculateBookingPrice (int activityIndex, int numOfParticipants){
        // Beräknar priset utifrån aktivitet och antal deltagare.
        return PRICES[activityIndex] * numOfParticipants;
    }
}
