public class FriendPairing {

    // Calculates the number of ways to pair up n friends
    public static int friendsPairing(int n) {
        // Base cases: 1 way for 1 friend, 2 ways for 2 friends
        if (n == 1 || n == 2) {
            return n;
        }

        // Recursive case
        // Choice 1: The friend stays single
        int singleWays = friendsPairing(n - 1);

        // Choice 2: The friend pairs up with any of the other (n-1) friends
        int pairWays = (n - 1) * friendsPairing(n - 2);

        // Total ways is the sum of both choices
        return singleWays + pairWays;
    }

    public static void main(String[] args) {
        int n = 3; // Example: 3 friends
        System.out.println("Total ways to pair " + n + " friends: " + friendsPairing(n));
    }
}
