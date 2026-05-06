public class Test {
    public static void main(String[] args) {
        String[] tests = {
            "aku sayang kamu",
            "kaki kudanil",
            "kristal dingin",
            "elang ompong"
        };
        
        String[] expected = {
            "aidenkupru saidenyaidenstrengen kaidenmupru",
            "kaidenkipri kuprudaidennipriles",
            "kesriprisestaidenles dipringiprines",
            "eprelaidenstrengen opromespoprostrengen"
        };
        
        for (int i = 0; i < tests.length; i++) {
            String result = Umandana.toUmandana(tests[i]);
            System.out.println("Input: " + tests[i]);
            System.out.println("Expected: " + expected[i]);
            System.out.println("Got:      " + result);
            System.out.println("Match: " + result.equals(expected[i]));
            System.out.println();
        }
    }
}
