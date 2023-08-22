package fr.tmaurier.banking;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BankingTest {

    @ParameterizedTest(name = "should update balance when deposit {0}")
    @CsvSource({
            "50, 150",
            "100, 200",
            "200, 300"
    })
    void shouldUpdateBalanceWhenDeposit(int amount, int expectedBalance) {
        // GIVEN
        Account account = new Account(100);
        // WHEN
        account.deposit(50);
        // THEN
        assertThat(account.balance).isEqualTo(150);
    }

    @ParameterizedTest(name = "should update balance when withdraw {0}")
    @CsvSource({
            "50, 50",
            "100, 0",
            "200, -100"
    })
    void shouldUpdateBalanceWhenWithdraw(int amount, int expectedBalance) {
        // GIVEN
        Account account = new Account(100);
        // WHEN
        account.withdraw(50);
        // THEN
        assertThat(account.balance).isEqualTo(50);
    }

    @Test
    @Name("should print statement")
    void shouldPrintStatement() {

        // GIVEN
        Account account = new Account(100);
        // WHEN
        account.deposit(50);
        account.withdraw(50);
        // THEN
        assertThat(account.transactions.size()).isEqualTo(2);
        assertThat(account.transactions.get(0).getAmount()).isEqualTo("+50.00");
        assertThat(account.transactions.get(0).getBalance()).isEqualTo("150.00");

    }

}
