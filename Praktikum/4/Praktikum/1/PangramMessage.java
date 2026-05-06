public class PangramMessage extends Pesan {
    public PangramMessage(String pesan) {
        super(pesan);
    }

    @Override
    public String process() {
        String[] words = pesan.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            if (i < words.length-1) {
                result.append(" ");
            }
            result.append(words[i]);
        }
        return result.toString();
    }

    public boolean isPangram() {
        String text = pesan.toLowerCase();
        boolean[] letters = new boolean[26];
        for (char c : text.toCharArray()) {
            if (c>='a' && c<='z') {
                letters[c-'a'] = true;
            }
        }
        for (boolean b : letters) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
