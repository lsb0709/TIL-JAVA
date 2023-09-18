package com.test.exam02;

public class SuperExam {
    public static void main(String[] args) {
        Point3D point3d = new Point3D();
        System.out.println("point3d의 값 " + point3d.x + " " + point3d.y + " " + point3d.z);
    }
}

class Point {
    int x = 10;
    int y = 20;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point {
    int z = 30;

    Point3D() { // 인자가 없는 생성자
        this(100, 200, 300); // this --> 생성자를 의미. 인자가 3개인 생성자를 호출
    }

    Point3D(int x, int y, int z) { // 인자가 3개인 생성자
        super(x, y); // 인자가 2개인 부모 클래스의 생성자
        this.z = z;
    }
}