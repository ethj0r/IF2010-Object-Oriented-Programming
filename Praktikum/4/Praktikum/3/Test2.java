public class Test2 {
    public static void main(String[] args) {
        String[] tests = {
            "aku sayang kamu",
            "kaki kudanil",
            "kristal dingin",
            "elang ompong",
            "menyanyi sampai monyong"
        };
        
        for (String test : tests) {
            String encoded = Umandana.toUmandana(test);
            String decoded = Umandana.deUmandana(encoded);
            System.out.println("Original:  " + test);
            System.out.println("Encoded:   " + encoded);
            System.out.println("Decoded:   " + decoded);
            System.out.println("Match:     " + test.equals(decoded));
            System.out.println();
        }
    }
}
