package fr.tmaurier.creditcardmask;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreditCardMaskTest {

    @Test
    public void shouldMaskString() {
        assertThat(CreditCardMask.maskify("4556364607935616")).isEqualTo("############5616");
        assertThat(CreditCardMask.maskify("1")).isEqualTo("1");
        assertThat(CreditCardMask.maskify("11111")).isEqualTo("#1111");

        assertThat(CreditCardMask.maskify("Skippy")).isEqualTo("##ippy");
        assertThat(CreditCardMask.maskify("Nananananananananananananananana Batman!")).isEqualTo("####################################man!");
    }
}
