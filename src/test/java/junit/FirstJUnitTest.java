package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

///класс называем по общему компоненту который тестируем
public class FirstJUnitTest {

    ///Анотация которая будет выполнена перед тестом
    @BeforeEach
    void  before() {
        System.out.println("Этот метод выполняется перед каждым тестом");
    }

    ///Анотация что нужно сделать после теста
    @AfterEach
    void after() {
        System.out.println("Этот метод выполняется перед каждым тестом");
    }

    @Test
    ///Метод который выполняет проверку по условиям. Методы называем исходя из отдельного функционала который проверяем.
    void textTest() {
        //поиск по тексту
        System.out.println("Это первый тест");
    }

    @Test
    void  videoTest (){
        //поиск видео
        System.out.println("Это второй тест");
    }
}
