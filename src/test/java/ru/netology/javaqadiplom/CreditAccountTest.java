package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    // БАГ: В конструкторе нет проверки на отрицательный creditLimit
    public void shouldThrowExceptionForNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, -5_000, 15);
        });
    }

    @Test
    // БАГ: В конструкторе нет проверки на отрицательный initialBalance
    public void shouldThrowExceptionForNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1_000, 5_000, 15);
        });
    }

    @Test
    // БАГ: Метод add() не пополняет, а заменяет баланс
    public void shouldCorrectlyAddAmount() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);
        account.add(3_000);
        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    // БАГ: Метод yearChange() некорректно работает с положительным балансом
    public void shouldReturnZeroInterestForPositiveBalance() {
        CreditAccount account = new CreditAccount(200, 5_000, 15);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    // Проверяем, что метод ВЕРНУЛ правильное значение для отрицательного баланса
    public void shouldReturnCorrectInterestForNegativeBalance() {
        CreditAccount account = new CreditAccount(-200, 5_000, 15);
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    // Проверка, что нельзя заплатить больше, чем есть с учётом лимита
    public void shouldNotPayBeyondLimit() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);
        account.pay(7_000);
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    // Проверка, что нельзя создать счёт с отрицательной ставкой
    public void shouldThrowExceptionForNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, 5_000, -15);
        });
    }
}
