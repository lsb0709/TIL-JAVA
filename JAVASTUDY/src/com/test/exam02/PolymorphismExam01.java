package com.test.exam02;

class Animal {
    public void move() { // 가상 메소드
        // System.out.println("동물이 움직입니다.");
    }
}

class Human extends Animal {
    @Override // 부모클래스의 기능을 덮어썼다(재정의했다) - 부모클래스가 가지고 있지 않는 기능을 추가!!
    public void move() {
        System.out.println("사람이 두 발로 걷습니다.");
    }
}

class Tiger extends Animal {
    @Override
    public void move() {
        System.out.println("호랑이가 네 발로 뜁니다.");
    }
}

class Eagle extends Animal {
    @Override
    public void move() {
        System.out.println("독수리가 하늘을 납니다.");
    }
}

// 다양성은 하나의 코드가 여러 자료형으로 구현되어 실행되는 것을 말함.
// 즉, 같은 코드에서 여러 실행 결과가 나오는 것을 의미함.
public class PolymorphismExam01 {
    public static void main(String[] args) {
        PolymorphismExam01 animalTest = new PolymorphismExam01(); // 인스턴스 생성
        // 여기서 메모리에 로딩되어 실행.
        // 인자로 클래스를 전달하기 위해서 메모리에 클래스를 생성하여아 하는데 이를 위해서 new 지시어를 사용하고
        // new 지시어와 생성자를 사용한다.
        animalTest.moveAnimal(new Human());
        animalTest.moveAnimal(new Tiger());
        animalTest.moveAnimal(new Eagle());
    }

    public void moveAnimal(Animal animal) { // 메소드의 틀만 만들어져 있는 것임.
        animal.move();
    }
}
