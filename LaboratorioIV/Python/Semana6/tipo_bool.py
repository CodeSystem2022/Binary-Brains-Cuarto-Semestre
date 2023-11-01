# Bool contiene los valores de True y False
# Los tipos numéricos, son false para el 0 (cero), true para los demás valores
valor = 0
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

valor = 0.1
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')


# Tipo string -> False, representa lacadena vacía '' , True para los demas
valor = ''
resultado = bool(valor)
print(f'Valor: {valor}, Resultado: {resultado}')

valor = 'Hola'
resultado = bool(valor)
print(f'Valor: {valor}, Resultado: {resultado}')


#TIPO COLECCIONES -> False para colecciones vacias
#TIPO COLECCIONES -> True para todas las demas
#LISTA
valor = []
resultado = bool(valor)
print(f'valor de una lista vacia:{valor}, Resultado:{resultado}')

valor = [2,3,4]
resultado = bool(valor)
print(f'valor de una lista con elementos:{valor}, Resultado:{resultado}')

#TUPLA
valor = ()
resultado = bool(valor)
print(f'valor de una tupla vacia:{valor}, Resultado:{resultado}')

valor = (5,)
resultado = bool(valor)
print(f'valor de una tupla con elementos:{valor}, Resultado:{resultado}')

#DICCIONARIO
valor = {}
resultado = bool(valor)
print(f'valor de un diccionario vacio:{valor}, Resultado:{resultado}')

valor = {'Nombre':'Juan', 'Apellido':'Perez'}
resultado = bool(valor)
print(f'valor de un diccionario con elementos:{valor}, Resultado:{resultado}')

# Sentencias de control con bool
if (1,):
    print('Regresa verdadero')
else:
    print('Regresa falso')

# ciclos parte juany
variable = 0
while variable:
    print('Regresa verdadero')
    break
else:
    print('Regresa falso')
