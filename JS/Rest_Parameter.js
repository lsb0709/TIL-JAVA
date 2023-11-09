// 전개 연산자를 이용한 나머지 매개변수(Rest Parameter) 예제

const add = (...numbers) => {
    let result = 0;
    numbers.forEach((num) => {
        result += num;
    })
    console.log("result: " + result);
}

add(1,2,3,4,5,6,7,8,9,10);

function User(name, age, ...skill){  // 여러개의 매개변수가 정해져 있다면 전개 연산자는 반드시 마지막 매개변수에만 적용
    this.name = name;
    this.age = age;
    this.skill = skill;
}

const user1 = new User('Mike', 30, 'html', 'css');
const user2 = new User('Mike', 30, 'html', 'css', 'JS');

console.log('user1 = ' + user1);
console.log('user2 = ' + user2);

let array1 = [1,2,3];
let array2 = [4,5,6];
let result = [0,...array1, ...array2, 7,8,9];
console.log(result);

let member = {name: 'Mike'};
let info = {age : 30};
let fe = ['JS', 'React'];
let lang = [ 'Korean', 'English'];

member = {
    ...member,
    ...info,
    skills : [...fe, ...lang],
}
console.log(member);

