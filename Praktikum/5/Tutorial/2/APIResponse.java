public class APIResponse<U> {
    private int statusCode;
    private String message;
    private U data;

    public APIResponse(int statusCode, String message, U data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public void printResponse() {
        // String typeName = (this.data == null) ? "null" : this.data.getClass().getSimpleName();
        System.out.println("Response " + this.statusCode + " - " + this.message + " | Data: " + String.valueOf(this.data) + " (Type: " + this.data.getClass().getSimpleName() + ")");
    }
}