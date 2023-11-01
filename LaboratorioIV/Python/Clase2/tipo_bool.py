
valor = 0
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

valor = 15
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

#String false es "" y true es "cualquier cosa"

valor = ""
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

valor = "Hola"
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

#Tipo coleciones false es [] y true es [cualquier cosa]

valor = []
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)   

valor = [1,2,3]
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

#tupla

valor = ()
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

valor = (1,2,3)
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

#diccionario

valor = {}
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

valor = {"a":1, "b":2}
resultado = bool(valor)
print("El valor es:", valor, "y el resultado es:", resultado)

#Sentencias de control con bool

if '':
    print('es verdadero')
else:
    print('es falso')

#ciclos
variable = 0
while variable:
    print('es verdadero')
    break
else:
    print('es falso')



