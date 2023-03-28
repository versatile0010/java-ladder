package ladder;

public class Row {
    int[] row;

    public Row(NaturalNumber numberOfPerson) {
        row = new int[numberOfPerson.getNumber()];
        // 유효하다면 참여하는 사람 수 만큼 생성
    }

    public void drawLine(int startPosition) {
        validateDrawingPosition(startPosition);
        // startPosition 에서 Line 을 그릴 수 있는 지 확인
        row[startPosition] = Direction.RIGHT.getFlag();
        row[startPosition + 1] = Direction.LEFT.getFlag();
    }

    public int getNextPosition(int nowPosition) {
        validatePosition(nowPosition);
        // nowPosition 이 유효한 지 확인
        if (connectedNothing(nowPosition)) {
            // 아무것도 연결되어 있지 않다면
            return nowPosition; // go Straight!
        }
        if (connectedLeft(nowPosition)) {
            // startPoSITION 에서 왼쪽으로 연결되어 있다면?
            return nowPosition - 1;
            // 왼쪽을 먼저 간다.
        }
        // 아무것도 연결되어 있는 것이 아니지만
        // 왼쪽으로도 연결되어 있지 않다면 오른쪽으로 연결되어 있다는 것
        return nowPosition + 1;
    }

    public boolean connectedNothing(int position) {
        return row[position] == Direction.STRAIGHT.getFlag();
    }

    public boolean connectedLeft(int position) {
        return row[position] == Direction.LEFT.getFlag();
    }

    public void validateDrawingPosition(int startPosition) {
        if (startPosition < 0 || startPosition >= row.length - 1) {
            throw new IllegalArgumentException("startPosition 위치에서 Line 을 생성할 수 없습니다.");
        }
    }

    public void validatePosition(int nowPosition) {
        if (nowPosition < 0 || nowPosition >= row.length) {
            throw new IllegalArgumentException("유효하지 않은 Position 입니다.");
        }
    }
}
