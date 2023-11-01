
function hola(nombre, miCallback){
    setTimeout( function() {
        console.log('Hola ' + nombre);
        miCallback(nombre);
    }, 1000);
}

//Función asincrona - adios
function adios(nombre, otrocallback) {
    setTimeout(function(){
        console.log('Adiós '+ nombre);
        otrocallback();
    }, 1500);   
}

console.log('Iniciando el proceso...');

hola('Carlos', function(nombre) {
    adios(nombre, function(){
        console.log('Terminando el proceso...');    
    });
});

//hola('Carlos', function(){});
//adiós('Carlos', function(){});
