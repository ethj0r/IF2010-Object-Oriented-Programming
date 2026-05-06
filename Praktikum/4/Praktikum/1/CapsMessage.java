public class CapsMessage extends Pesan {
    public CapsMessage(String pesan) {
        super(pesan);
    }

    @Override
    public String process() {
        return getPesan().toUpperCase();
    }

    public int countVowels() {
        int count = 0;
        String text = getPesan().toLowerCase();
        for (char c : text.toCharArray()) {
            if (c=='a' || c=='i' || c=='u' || c=='e' || c=='o') {
                count++;
            }
        }
        return count;
    }
}