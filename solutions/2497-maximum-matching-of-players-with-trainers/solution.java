class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int maxi = 0;
        int player = 0;
        int i = 0, j = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                player++;
            } else {
                j++;
            }
        }
        return player;
    }
}
