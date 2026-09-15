public class Booking {
    public static final String[] ACTIVITIES = {"Programmeringsworkshop","Matlagningskurs","Träningspass"};
    public static final int[] PRICES = {200, 300, 150};
    public static final int MAX_NUM_PARTICIPANTS = 500;

    private int activityIndex;
    private int numOfParticipants;
    private int price;

    public Booking (int activityIndex, int numOfParticipants, int price) {
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
        return ACTIVITIES[activityIndex] + ", " + numOfParticipants + " deltagare, " + price + " kr";
    }

    static int calculateBookingPrice (int activityIndex, int numOfParticipants){
        return PRICES[activityIndex] * numOfParticipants;
    }
}
