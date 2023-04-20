package com.galaxy.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentManagementApplicationTests {

    @Test
    void testAddition() {
        int result = 1 + 1;
        assertEquals(2, result);
    }

}
