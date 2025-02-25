package ladder;

public class NaturalNumber {
    private final int number;

    private NaturalNumber(int number) {
        validateNumber(number);
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public static NaturalNumber createNaturalNumber(int number){
        validateNumber(number);
        return new NaturalNumber(number);
    }

    private static void validateNumber(int number){
        if(number <= 0) {
            throw new IllegalArgumentException("자연수는 1이상이어야 합니다!");
        }
    }
}
