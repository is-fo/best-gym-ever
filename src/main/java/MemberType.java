public enum MemberType {
    CURRENT(" har ett aktivt medlemsskap."),
    FORMER(" är inte längre medlem."),
    NOTAMEMBER(" är inte medlem!");

    private final String message;

    MemberType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
