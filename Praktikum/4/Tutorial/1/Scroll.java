public abstract class Scroll {
    protected String content;

    public Scroll(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public abstract String process();

    protected abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] " + this.content;
    }
}
