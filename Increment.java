public class Increment {

    public String increment(String str) {

        StringBuilder builder = new StringBuilder();
        int carry = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int dig = str.charAt(i) - '0';
            if (dig + carry >= 10) {
                carry = 1;
                dig = 0;
            } else {
                dig += carry;
                carry = 0;
            }
            builder.append(dig);
        }
        if (carry == 1)
            builder.append(carry);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Increment in = new Increment();
        String number = "999";
        System.out.println(in.increment(number));
    }
}