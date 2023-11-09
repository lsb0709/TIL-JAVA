// 전개 구문(Spread Syntax) 예제

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