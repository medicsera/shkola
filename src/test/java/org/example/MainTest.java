package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test

    public  void testOne(){
        Button button = new Button();
        button.click();
        assertEquals(2, button.click(), "click count should be 1");
    }


}
