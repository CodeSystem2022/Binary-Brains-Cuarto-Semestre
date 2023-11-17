const fs = require('fs');

// primero leemos el archivo txt
function leer(ruta, cb) {
    fs.readFile(ruta, (err, data) => {
        cb(data.toString());
    })
}

// segundo escribimos el archivo txt creandolo
function escribir(ruta, contenido, cb){
    fs.writeFile(ruta, contenido, function (err) {
        if (err) {
            cb("No se ha podido escribir", err);
        } else {
            cb("Se ha escrito correctamente");
        }
    })
}

// tercero eliminamos el archivo1.txt
function borrar(ruta, cb) {
    fs.unlink(ruta, cb); // elimina de manera asincrona
}

borrar(`${__dirname}/archivo1.txt`, console.log);
// escribir(`${__dirname}/archivo1.txt`, "Reescribimos el archivo", console.log); // sintaxis ES6
// leer(`${__dirname}/archivo1.txt`, console.log); // sintaxis ES6
