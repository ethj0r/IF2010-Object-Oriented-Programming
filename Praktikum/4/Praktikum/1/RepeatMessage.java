public class RepeatMessage extends Pesan {
    private int n;

    public RepeatMessage(String pesan, int n) {
        super(pesan);
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public String process() {
        String[] words = pesan.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<n; j++) {
                if (i>0 && j==0) {
                    result.append(" ");
                } else if (j>0) {
                    result.append(" ");
                }
                result.append(words[i]);
            }
        }
        return result.toString();
    }
}
