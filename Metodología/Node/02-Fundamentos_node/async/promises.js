function hola (nombre){
    return new Promise (function (resolve,reject) {
        setTimeout( function () {
            console.log('hola'+nombre);
            resolve(nombre);
        }, 1000);
    });
}

function hablar(nombre){
    return new Promise( (resolve,reject) => {
        setTimeout( function () {
            console.log('bla bla bla bla');
            resolve(nombre);
        }, 1000);
    });
}

function adios(nombre) {
    return new Promise( ( resolve, reject) => {
        setTimeout(function() {

            console.log('adios' +nombre);

            resolve();
        }, 1000);
    });
}
                
//llamamos a la funcion
console.log("Iniciando el proceso...");
hola("ariel")
    .then(hablar)
    .then(hablar)
    .then(hablar)
    .then(adios) //.then nos retorna un valor
    .then((nombre)=> {
        console.log("Terminamos el proceso");
    })
    .catch(error => {
        console.log("Ha habido un error");
        console.log(error);

    })
