public enum ReaderType {
    SINH_VIEN(3),
    GIANG_VIEN(5);

    private final int maxBorrow;

    ReaderType(int maxBorrow) {
        this.maxBorrow = maxBorrow;
    }

    public int getMaxBorrow() {
        return maxBorrow;
    }
}
