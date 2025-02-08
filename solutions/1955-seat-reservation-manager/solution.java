class SeatManager {

    int maxSeat;
    SortedSet<Integer> sortedSeats;

    public SeatManager(int n) {
        this.maxSeat = n;
        sortedSeats = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            sortedSeats.add(i);
        }
    }

    public int reserve() {
        int smallest = sortedSeats.first();
        sortedSeats.remove(smallest);
        return smallest;
    }

    public void unreserve(int seatNumber) {
        sortedSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
