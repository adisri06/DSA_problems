
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

// star(3);
// function star (n){
//     console.log("Star Pattern"+n);
//     for(let i=1;i<=n;i++){
//         let line = '';
//         for(let j=1;j<=i;j++){
//             line += `${i} `;
//         }
//         console.log(line);
//     }
// }
//-----------------------------------------

// let x = ((a,b)=>{ return a+b})(5,6);
// console.log(" output of x(5,6) is"+x);
// //-----------------------------------------
// //arrow function in JavaScript.
// //	•	It is a concise way to write a function without using the function keyword.
// let t= (a,b) => a+b;
// console.log(" output of t(5,6) is"+t(5,6));
// //-----------------------------------------

// const arr = [1,2,3,4,5,6,7,8,9,10];
// let val = (([arg1,arg2]) => { return arg1 + arg2;} )(arr);
// console.log(" output of val is"+val);
// //-----------------------------------------

// const obj = [ {name: "shubham", age: 25, country: "india"}, 
//     {name: "shub", age: 25, country: "india"}];

// let obj1 = (({name,age})=> { return {name,age};})(obj[0]);
// console.log(" output of obj1 is"+ JSON.stringify(obj1));
// //-----------------------------------------

// function hello(){
//     console.log("hello ");
// }
// function personal( val, choice = hello){
//     choice();
//     console.log(val);
// }
// personal("shubham", ()=>{console.log("Hi ")});


// let names= (name,name2)=>{console.log(name + name2)};
// console.log(names("shubham","sharma"));
// //-----------------------------------------
// //single parameter
// let names1 =  _ => {console.log("Hello "+_);};
// names1("adi");
// //-----------------------------------------
// //no parameter
// let values = "Hello my name is shubham";
// let valuesarr = values.split(" ");
// for (let j =0;j< valuesarr.length;j++){
// let length = valuesarr[j].length;
// let news = "" ;
// for(let i = length-1;i>=0;i--){
//     news+=valuesarr[j].charAt(i); 
// }
// valuesarr[j] = news;
// }
// news = "";
// for(let i =0;i<valuesarr.length;i++){
//     news += valuesarr[i]+" ";
    
// }
// console.log(news.trim());

let x = { name : "shubham", age: 25, country: "india"};
// let {name , age} = x;
// console.log({} = x);
// x = {...x, time: "12:00"};
// console.log(x);
//-----------------------------------------
function print(...x){

    x = {...x, time: "12:00"};
    Object.entries(x).forEach((key) => console.log(key[0] + " " + key[1]));
   
}

print (x.name, x.age, x.country);
let y = {x};
print (y);

