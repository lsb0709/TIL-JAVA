// 배열 구조 분해 할당

let users = ['Mike', 'Tom', 'Jane'];
let [user1, user2, user3] = users;
console.log("user1 : " + user1);
console.log("user2 : " + user2);
console.log("user3 : " + user3);

let str = "Mike-Tom-Jane";
let [user4, user5, user6] = str.split('-');
console.log("user4 : " + user4);
console.log("user5 : " + user5);
console.log("user6 : " + user6);

let [a=3,b=4, c=5] = [1,2];
console.log("a : " + a); // 1
console.log("b : " + b); // 2
console.log("c : " + c); // 5

let [user7, ,user9] = ['Mike', 'Tom', 'Jane', 'Tony'];
console.log("user7 : " + user7) // 'Mike'
console.log("user8 : " + user9) // 'Jane'

let x = 1;
let y = 2;
[x, y] = [y, x];
console.log("x : " + x);
console.log("y : " + y);

// 객체 구조 분해 할당

let user = {
    name: 'Mike',
    age: 30,
    gender: 'female'
};

// let age = user.age;
// let name = user.name;

let {name, age, gender='male'} = user;

console.log("name: " + name);
console.log("age: " + age);
console.log("gender: " + gender);

let member  = {
    name: 'Mike',
    age: 29,
}

let {name:userName, age:userAge} = member;
console.log(userName);
console.log(userAge);