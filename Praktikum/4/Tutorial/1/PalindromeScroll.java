public class PalindromeScroll extends Scroll {
    public PalindromeScroll(String content) {
        super(content);
    }

    @Override
    public String process() {
        return new StringBuilder(this.content).reverse().toString();
    }

    public boolean isPalindrome() {
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < this.content.length(); i++) {
            char c = this.content.charAt(i);
            if (!Character.isWhitespace(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        String normalized = filtered.toString();
        String reversed = filtered.reverse().toString();
        return normalized.equals(reversed);
    }

    @Override
    protected String getType() {
        return "PALINDROME";
    }
}
