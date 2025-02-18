
console.log("hello world");
//-----------------------------------------

// Variables
// let x = 5;
// let y = 11;
// if(x + y == 15){
//     console.log("x + y is 15");
// }else if(x + y == 20){
//     console.log("x + y is 20");
// }else{
//     console.log("x + y is not 15 or 20");
// }

//-----------------------------------------
// Ternary Operator
// console.log(x + y == 15 ? "x + y is 15" : "x + y is not 15");

//-----------------------------------------
// Switch Statement
// let name = 'shubham'
// switch(name){
//     case 'shubham':
//         console.log('Hello Shubham');
//         break;
//     case 'john':
//         console.log('Hello John');
//         break;
//     default:
//         console.log('Hello Stranger');
//         break;
// }
//-----------------------------------------
// let obj = {
//     name: 'shubham',
//     age: 25,
//     isStudent: true
// }
// let obj1 = {
//     name: 'shubham',
//     age: 254,
//     isStudent: true
// }
// let obj2 = {
//     name: 'shubham',
//     age: 254,
//     isStudent: true
// }
// let array = [];
// array.push(obj);
// array.push(obj1);
// array.push(obj2);
// // Object.keys(array).forEach((key)=>{
// //     key.localeCompare('name');
// //     console.log(key);
// // })

// let x= array.map((item)=>{
//     console.log(item);
//     return item;
// }).filter((item) => item.age > 25);
// console.log(x);
//-----------------------------------------

star(3);
function star (n){
    console.log("Star Pattern"+n);
    for(let i=1;i<=n;i++){
        let line = '';
        for(let j=1;j<=i;j++){
            line += `${i} `;
        }
        console.log(line);
    }
}





