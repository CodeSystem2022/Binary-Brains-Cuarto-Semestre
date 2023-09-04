console.log("Inicio del programa") ;

setTimeout(() => {
    console.log("Primer Time out")
}, 3000 );

setTimeout(() => {
    console.log("Segundo del programa")
}, 0 );


setTimeout(() => {
    console.log("Tercero del programa")
}, 0 );


console.log("Fin del programa")
