package com.test.exam02;

public class PolymorphismExam02 {
    public static void main(String[] args) {
        new Animal1Move(new Human1());
        new Animal1Move(new Tiger1());
        new Animal1Move(new Eagle1());
        
    }
}

class Animal1Move { // 스프링 배울때 의존성 주입의 기본 작동 원리
    Animal1 Animal1; // 멤버변수
    public Animal1Move(Animal1 Animal11){
        this.Animal1 = Animal11;
        Animal1.move();
    }
}

interface Animal1 {
    public void move();
}

class Human1 implements Animal1{

    @Override
    public void move(){
        System.out.println("사람이 두발로 걷습니다.");
    }
}

class Tiger1 implements Animal1 {
    
    @Override
    public void move(){
        System.out.println("호랑이가 네발로 뜁니다.");
    }
}

class Eagle1 implements Animal1{

    @Override
    public void move(){
        System.out.println("독수리가 하늘을 납니다.");
    }
    
}