public class CipherScroll extends Scroll {
    private int shift;

    public CipherScroll(String content, int shift) {
        super(content);
        this.shift = shift;
    }

    @Override
    public String process() {
        return applyShift(this.content, this.shift);
    }

    public String decode() {
        return applyShift(this.content, -this.shift);
    }

    private String applyShift(String text, int shiftValue) {
        StringBuilder result = new StringBuilder();
        int normalizedShift = shiftValue % 26;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                int base = 'A';
                int offset = (c - base + normalizedShift) % 26;
                if (offset < 0) {
                    offset += 26;
                }
                result.append((char) (base + offset));
            } else if (c >= 'a' && c <= 'z') {
                int base = 'a';
                int offset = (c - base + normalizedShift) % 26;
                if (offset < 0) {
                    offset += 26;
                }
                result.append((char) (base + offset));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    protected String getType() {
        return "CIPHER";
    }
}
