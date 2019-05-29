package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderTest {
    LadderHeight ladderHeight;

    @Test
    public void 레더_테스트_사다리의_너비가_1일때() {
        ladderHeight = LadderHeight.of(1);
        Ladder ladder = new Ladder(ladderHeight, 1);
        assertThat(ladder.connectBridge(Position.of(1, 1))).isFalse();
    }

    @Test
    public void 연속된_연결로를_추가할때_검사_4X4사다리() {
        ladderHeight = LadderHeight.of(4);
        Ladder ladder = new Ladder(ladderHeight, 4);
        ladder.connectBridge(Position.of(1, 2));
        ladder.connectBridge(Position.of(1, 1));
        ladder.connectBridge(Position.of(1, 3));
        ladder.connectBridge(Position.of(2, 1));

        assertThat(ladder.connectBridge(Position.of(1, 1))).isFalse();
        assertThat(ladder.connectBridge(Position.of(1, 3))).isFalse();

        ladder.connectBridge(Position.of(2, 2));
        assertThat(ladder.connectBridge(Position.of(2, 2))).isFalse();
    }

    @Test
    public void 연속된_연결로를_추가할때_추가가_안되는지_검사_1X2사다리() {
        ladderHeight = LadderHeight.of(1);
        Ladder ladder = new Ladder(ladderHeight, 2);
        ladder.connectBridge(Position.of(1, 1));

        assertThat(ladder.connectBridge(Position.of(1, 1))).isTrue();
    }

    @Test
    public void 레더_테스트_2X2크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(2);
        Ladder ladder = new Ladder(ladderHeight, 2);
        ladder.connectBridge(Position.of(1, 1));
        ladder.connectBridge(Position.of(2, 1));

        assertThat(ladder.findDestination(1)).isEqualTo(1);
        assertThat(ladder.findDestination(2)).isEqualTo(2);
    }

    @Test
    public void 레더_테스트_3X3크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(3);
        Ladder ladder = new Ladder(ladderHeight, 3);
        ladder.connectBridge(Position.of(1, 1));
        ladder.connectBridge(Position.of(2, 1));
        ladder.connectBridge(Position.of(3, 2));

        assertThat(ladder.findDestination(1)).isEqualTo(1);
        assertThat(ladder.findDestination(3)).isEqualTo(2);
        assertThat(ladder.findDestination(2)).isEqualTo(3);
    }

    @Test
    public void 레더_테스트_1X1크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(1);
        Ladder ladder = new Ladder(ladderHeight, 1);
        assertThat(ladder.findDestination(1)).isEqualTo(1);

        ladder = new Ladder(ladderHeight, 1);
        assertThat(ladder.findDestination(1)).isEqualTo(1);
    }

    @Test
    public void 레더_테스트_1X2크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(1);
        Ladder ladder = new Ladder(ladderHeight, 2);
        ladder.connectBridge(Position.of(1, 1));

        assertThat(ladder.findDestination(1)).isEqualTo(2);
        assertThat(ladder.findDestination(2)).isEqualTo(1);
    }

    @Test
    public void 레더_테스트_1X5크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(1);
        Ladder ladder = new Ladder(ladderHeight, 5);
        ladder.connectBridge(Position.of(1, 2));
        ladder.connectBridge(Position.of(1, 4));

        assertThat(ladder.findDestination(1)).isEqualTo(1);
        assertThat(ladder.findDestination(2)).isEqualTo(3);
        assertThat(ladder.findDestination(3)).isEqualTo(2);
        assertThat(ladder.findDestination(4)).isEqualTo(5);
        assertThat(ladder.findDestination(5)).isEqualTo(4);
    }

    @Test
    public void 레더_테스트_2X5크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(2);
        Ladder ladder = new Ladder(ladderHeight, 5);
        ladder.connectBridge(Position.of(1, 2));
        ladder.connectBridge(Position.of(1, 4));
        ladder.connectBridge(Position.of(2, 1));
        ladder.connectBridge(Position.of(2, 3));

        assertThat(ladder.findDestination(1)).isEqualTo(2);
        assertThat(ladder.findDestination(2)).isEqualTo(4);
        assertThat(ladder.findDestination(3)).isEqualTo(1);
        assertThat(ladder.findDestination(4)).isEqualTo(5);
        assertThat(ladder.findDestination(5)).isEqualTo(3);
    }

    @Test
    public void 레더_테스트_3X5크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(3);
        Ladder ladder = new Ladder(ladderHeight, 5);
        ladder.connectBridge(Position.of(1, 2));
        ladder.connectBridge(Position.of(1, 4));
        ladder.connectBridge(Position.of(2, 1));
        ladder.connectBridge(Position.of(2, 3));
        ladder.connectBridge(Position.of(3, 3));

        assertThat(ladder.findDestination(1)).isEqualTo(2);
        assertThat(ladder.findDestination(2)).isEqualTo(3);
        assertThat(ladder.findDestination(3)).isEqualTo(1);
        assertThat(ladder.findDestination(4)).isEqualTo(5);
        assertThat(ladder.findDestination(5)).isEqualTo(4);
    }

    @Test
    public void 레더_테스트_6X3크기일때_경로를_제대로_찾는지() {
        ladderHeight = LadderHeight.of(6);
        Ladder ladder = new Ladder(ladderHeight, 3);
        ladder.connectBridge(Position.of(1, 1));
        ladder.connectBridge(Position.of(2, 1));
        ladder.connectBridge(Position.of(3, 1));
        ladder.connectBridge(Position.of(5, 2));

        assertThat(ladder.findDestination(1)).isEqualTo(3);
        assertThat(ladder.findDestination(2)).isEqualTo(1);
        assertThat(ladder.findDestination(3)).isEqualTo(2);
    }

    @Test
    public void 좌표로_0이하의_크기를_입력했을때_예외가_발생하는지_확인() {
        ladderHeight = LadderHeight.of(3);
        Ladder ladder = new Ladder(ladderHeight, 5);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ladder.connectBridge(Position.of(0, 0));
            ladder.connectBridge(Position.of(-1, 2));
        });
    }

    @Test
    public void Ladder의_크기를_벗어난_좌표를_입력했을때_연결로가_이어지는지_확인() {
        ladderHeight = LadderHeight.of(3);
        Ladder ladder = new Ladder(ladderHeight, 3);
        assertThat(ladder.connectBridge(Position.of(4, 3))).isFalse();
    }
}