package fr.tmaurier.humanreadabletime;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HumanReadableTimeTest {

    HumanReadableTime hrt = new HumanReadableTime();

    @Test
    public void formatDurationTest() {
        assertThat(hrt.formatDuration(0)).isEqualTo("now");
        assertThat(hrt.formatDuration(1)).isEqualTo("1 second");
        assertThat(hrt.formatDuration(62)).isEqualTo("1 minute and 2 seconds");
        assertThat(hrt.formatDuration(120)).isEqualTo("2 minutes");
        assertThat(hrt.formatDuration(3600)).isEqualTo("1 hour");
        assertThat(hrt.formatDuration(3662)).isEqualTo("1 hour, 1 minute and 2 seconds");
        assertThat(hrt.formatDuration(15731080)).isEqualTo("182 days, 1 hour, 44 minutes and 40 seconds");
    }
}
