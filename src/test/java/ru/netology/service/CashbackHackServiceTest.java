package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {
    CashbackHackService service = new CashbackHackService();

    @Test
    public void testRemainAmountZero() {
        int amount = 0;

        int actual = service.remain(amount);
        int expected = 1000;
        assertEquals(actual,expected);

    }
    @Test
    public void testRemainAmountThousand(){

        //тут ошибка
        int amount = 1000;

        int actual = service.remain(amount);
        int expected = 0;
        assertEquals(actual,expected);
    }
    @Test
    public void testRemainAmount999(){
        int amount = 999;

        int actual = service.remain(amount);
        int expected = 1;
        assertEquals(actual,expected);
    }

    @Test
    public void testRemainAmount1001(){
        int amount = 1001;

        int actual = service.remain(amount);
        int expected = 999;
        assertEquals(actual,expected);
    }
    @Test
    public void testRemainAmount1500(){
        int amount = 1500;

        int actual = service.remain(amount);
        int expected = 500;
        assertEquals(actual,expected);
    }

    @Test
    public void testRemainAmountBelowZero(){

        //(логика сервисного класса не описывает, допустим ли расчет недостающей суммы, если amount принимает отрицательное значение)
        int amount = -100;

        int actual = service.remain(amount);
        int expected = 1100;
        assertEquals(actual,expected);

    }
}
