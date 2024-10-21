public class CodingBat {
    public static void main(String[] args) {
        int[] a = {7,7};
        System.out.println(has77(a));

    }

    private static String delDel(String str) {
        if (str.length() < 4)
            return str;
        if (str.substring(1, 4).equals("del")) {
            return str.charAt(0) + str.substring(4, str.length());
        }
        return str;
    }

    private static boolean icyHot(int temp1, int temp2) {
        if ((temp1 < 0 || temp2 < 0) && (temp1 > 100 || temp2 > 100)) {
            return true;
        }
        return false;
    }

    private static boolean has77(int[] nums) {

        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < 3; j++) {
                if (i >= j) {
                    if (nums[i] == 7 && nums[i - j] == 7) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int[] fizzArray3(int start, int end) {
        int[] result = new int[end-start];
        for (int i = start; i < end; i++) {
            result[i-start] = i;
        }
        return result;
    }

    public static boolean bobThere(String str) {
        if (str.length() > 2) {
            for (int i = 2; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(i - 2) && str.charAt(i) == 'b') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean xyBalance(String str) {
        boolean tripwire = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                tripwire = false;
            }
            else if (str.charAt(i) == 'y') {
                tripwire = true;
            }
        }

        return tripwire;
    }

    private static boolean linearIn(int[] outer, int[] inner) {
        int innerNum = inner.length-1;
        for (int n : outer) {
            
        }

        return false;
    }
}