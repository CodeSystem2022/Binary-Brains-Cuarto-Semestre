//la palabra async no es necesaria en la funciones por que ya son asincronas 
// igual proyectan una sincronia visual 
async function hola (nombre){
    return new Promise (function (resolve,reject) {
        setTimeout( function () {
            console.log('hola'+nombre);
            resolve(nombre);
        }, 1000);
    });
}

async function hablar(nombre){  //Antes nos moestraba en formato syncrono
    return new Promise( (resolve,reject) => {  // usamos la sintaxis ES6
        setTimeout( function () {
            console.log('bla bla bla bla');
            resolve(nombre);
        }, 1000);
    });
}

async function adios(nombre) {// async nos crea un formato (aparentemente) sincrono, es lo q estamos buscando.
    return new Promise( ( resolve, reject) => {
        setTimeout(function() {
            console.log('adios' +nombre);
            resolve();
        }, 1000);
    });
}

//await hola('Ariel'); // esto es una mala sintaxis
//await solo es valido dentro de una funcion asincrona
async function main (){
    await hola('Ariel');
    let nombre = await hola('Ariel');
    await hablar();
    await hablar();
    await hablar();
    await adios(nombre);
    console.log('Termina el proceso....');
}

console.log('Empezamos el proceso....');
main();
console.log('esta va a ser la segunda instruccion');

//codigo en ingles

async function hello(name){
    return new Promise(function(resolve, reject){
        setTimeout(function () {
            console.log('Hello '+name);
            resolve(name);
        },1000);
    });
  
    
}

async function talk (name){
  return new Promise( ( resolve, reject) =>{ //usamos la sintaxis ES6
    setTimeout(function () {
        console.log('bla bla bla bla ');
       resolve(name);
      
    }, 1000);
  });
}

async  function sayBye(name){
    return new Promise( (resolve, reject) =>{
        setTimeout(function (){
            console.log('goodBye '+ name);
            resolve();
           //reject ('Hay un Error ')
        }, 1000);
    });
}
async function conversation(name){
    console.log('Code in english')
    console.log('Starting async process...');
    await hello(name);
    await talk();
    await talk();
    await talk();
    await sayBye(name);
    console.log('Process completed');
}
conversation('Ariel');
