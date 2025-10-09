package ru.netology.javaqadiplom;

public class SavingAccount extends Account {
    protected int minBalance;
    protected int maxBalance;

    public SavingAccount(int initialBalance, int minBalance, int maxBalance, int rate) {
        // ИСПРАВЛЕНИЕ №1: Добавляем проверки в конструктор
        if (rate < 0) {
            throw new IllegalArgumentException("Накопительная ставка не может быть отрицательной");
        }
        if (minBalance < 0) {
            throw new IllegalArgumentException("Минимальный баланс не может быть отрицательным");
        }
        if (maxBalance <= minBalance) {
            throw new IllegalArgumentException("Максимальный баланс должен быть больше минимального");
        }
        if (initialBalance < minBalance || initialBalance > maxBalance) {
            throw new IllegalArgumentException("Начальный баланс должен быть в пределах от minBalance до maxBalance");
        }

        this.balance = initialBalance;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.rate = rate;
    }

    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }

        // ИСПРАВЛЕНИЕ №2: Проверяем, что баланс не упадёт ниже minBalance
        if (balance - amount >= minBalance) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }

        // ИСПРАВЛЕНИЕ №3: Проверяем, что баланс не превысит maxBalance
        if (balance + amount <= maxBalance) {
            balance = balance + amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int yearChange() {
        // ИСПРАВЛЕНИЕ №4: Рассчитываем проценты от баланса, а не просто возвращаем ставку
        return balance * rate / 100;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public int getMaxBalance() {
        return maxBalance;
    }
}