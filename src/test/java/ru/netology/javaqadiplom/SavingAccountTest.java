package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    // Тест 1
    @Test
    public void ShouldCreateSavingAccount() {
        SavingAccount account = new SavingAccount(1_500, 1_000, 5_000, 5);
        Assertions.assertEquals(1_500, account.getBalance());
    }

    // Тест 2
    @Test
    public void ShouldCreateSavingAccountWithRateZero() {
        SavingAccount account = new SavingAccount(1_500, 1_000, 5_000, 0);
        Assertions.assertEquals(0, account.getRate());
    }

    // Тест 3
    @Test
    public void ShouldThrowSavingAccountWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1_000, 500, 5_000, -1);
        });
    }

    // Тест 4
    @Test
    public void ShouldThrowSavingAccountWithBalanceOverMaxAndInitial() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(6_000, 0, 5_000, 5);
        });
    }

    // Тест 5
    @Test
    public void ShouldThrowSavingAccountWithInitialBalanceOverMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(15_000, 2_000, 5_000, 5);
        });
    }

    // Тест 6
    @Test
    public void ShouldPaySuccessfully() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(500);
        Assertions.assertEquals(1_500, account.getBalance());
    }

    // Тест 7
    @Test
    public void ShouldPaymentFailOverMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(1500);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    // Тест 8
    @Test
    public void ShouldPaymentReturnFalseOverMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertFalse(account.pay(1_500));
    }

    // Тест 9
    @Test
    public void ShouldPaymentFailOverNegativeBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(6_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    // Тест 10
    @Test
    public void ShouldPaymentReturnFalseOverNegativeBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertFalse(account.pay(7_500));
    }

    // Тест 11
    @Test
    public void ShouldPaymentReturnTrueWithSuccessfullyOperation() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertTrue(account.pay(500));
    }

    // Тест 12
    @Test
    public void ShouldAddSuccessfully() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.add(3_000);
        Assertions.assertEquals(5_000, account.getBalance());
    }

    // Тест 13
    @Test
    public void ShouldReturnTrueThenAddSuccessfully() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertTrue(account.add(2_000));
    }

    // Тест 14
    @Test
    public void ShouldAddFailOverLimit() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.add(12_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    // Тест 15
    @Test
    public void ShouldReturnFalseForAddOverLimit() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertFalse(account.add(12_000));
    }

    // Тест 16
    @Test
    public void ShouldCalculatePercents() {
        SavingAccount account = new SavingAccount(200, 100, 10_000, 15);
        Assertions.assertEquals(30, account.yearChange());
    }

    // Тест 17
    @Test
    public void ShouldCalculatePercentsWithZeroBalance() {
        SavingAccount account = new SavingAccount(0, 0, 10_000, 15);
        Assertions.assertEquals(0, account.yearChange());
    }

    // Тест 18
    @Test
    public void ShouldCreateSavingAccountEqualMinBalance() {
        SavingAccount account = new SavingAccount(1_000, 1_000, 5_000, 5);
        Assertions.assertEquals(1_000, account.getBalance());
    }

    // Тест 19
    @Test
    public void ShouldCreateSavingAccountEqualMaxBalance() {
        SavingAccount account = new SavingAccount(5_000, 1_000, 5_000, 5);
        Assertions.assertEquals(5_000, account.getBalance());
    }

    // Тест 20
    @Test
    public void ShouldThrowSavingAccountWithInitialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(15_000, 20_000, 25_000, 5);
        });
    }
}

