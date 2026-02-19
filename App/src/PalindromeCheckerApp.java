public class PalindromeCheckerApp {
    public static void main(String[] var0) {
        String var1 = "madam";
        boolean var2 = true;

        for(int var3  = 0; var3 < var1.length() / 2; ++var3) {
            if (var1.charAt(var3) != var1.charAt(var1.length() - 1 - var3)) {
                var2 = false;
                break;
            }
        }

        System.out.println(var2);
    }
}
