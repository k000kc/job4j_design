package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Sphere")
                .isNotEmpty()
                .isNotNull();
    }

    @Test
    void isThisUNKNOWN() {
        Box box = new Box(1, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Unknown object")
                .contains("object")
                .isNotNull();
    }

    @Test
    void whenVertex4() {
        Box box = new Box(4, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isEqualTo(4)
                .isEven()
                .isPositive();
    }

    @Test
    void whenVertex1() {
        Box box = new Box(1, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isEqualTo(-1)
                .isNotZero()
                .isNegative();
    }

    @Test
    void whenExist() {
        Box box = new Box(8, 10);
        boolean res = box.isExist();
        assertThat(res)
                .isEqualTo(true)
                .isTrue()
                .isNotNull();
    }

    @Test
    void whenNotExist() {
        Box box = new Box(2, 10);
        boolean res = box.isExist();
        assertThat(res)
                .isEqualTo(false)
                .isFalse()
                .isNotNull();
    }

    @Test
    void whenSphereAndEdge1ThenArea12Dot5() {
        Box box = new Box(0, 1);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(12.5, withPrecision(0.1d))
                .isCloseTo(12.6, withPrecision(0.5d))
                .isGreaterThan(12.5d)
                .isLessThan(12.6d);
    }

    @Test
    void whenUnknownObjectThenArea0() {
        Box box = new Box(3, 1);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(0)
                .isLessThan(1)
                .isGreaterThan(-1)
                .isNotNull();
    }
}