public class PlainScroll extends Scroll {
    public PlainScroll(String content) {
        super(content);
    }

    @Override
    public String process() {
        String trimmed = this.content.trim();
        if (trimmed.isEmpty()) {
            return "";
        }

        String[] words = trimmed.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (!w.isEmpty()) {
                String lower = w.toLowerCase();
                String cap = lower.substring(0, 1).toUpperCase() + lower.substring(1);
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(cap);
            }
        }
        return result.toString();
    }

    @Override
    protected String getType() {
        return "PLAIN";
    }
}
