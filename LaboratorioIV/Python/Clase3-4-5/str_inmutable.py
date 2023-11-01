
# help(str.capitalize) # esto lo que hace es convertir el primer caracter a mayúscula

mensaje1 = "hola mundo"
mensaje2 = mensaje1.capitalize() # debería poner la H en mayúscula pero NO la modifica
# Lo que hace es crear en mensaje2 una cadena nueva, no modificar la de mensaje1

print(f'Mensaje1: {mensaje1}, id: {id(mensaje1)}')
print(f'Mensaje2: {mensaje2}, id: {id(mensaje2)}') # id es diferente, Se trata de dos objetos

mensaje1 += ' Adiós'  # se trata de una nueva cadena
print(f'Mensaje1: {mensaje1}, id: {id(mensaje1)}')  # aquí podemos apreciar el ID de la nueva cadena

# STRING INMUTABLES - Recordar que las variables que tienen cadenas, no se pueden modificar.