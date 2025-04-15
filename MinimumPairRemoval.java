import java.util.*;

public class MinimumPairRemoval {
    public static int minimumRemovals(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements (space-separated):");
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                           .mapToInt(Integer::parseInt).toArray();
        System.out.println("Minimum removals: " + minimumRemovals(nums));
    }
}

