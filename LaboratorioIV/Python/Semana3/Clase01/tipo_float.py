# Base Decimal
a = int('23', 10)
print(f'a = base decimal: {a}')

# Base Binario
a = int('10111', 2)
print(f'a = base binario: {a}')

# Profundizando en el tipo float
a = 3.0
#print(f'a: {a:.2f}') # podemos indicar la cantidad de decimales que va a mostrar y nos sirve para achicar el número o agrandarlo

# Constructor de tipo float -> Puede recibir tipos enteros (int) y también strings (str) y convertirlo a flotante
a = float(10) # le pasamos un tipo entero (int)
a = float('10') # puede recibir también un tipo string
print(f'a: {a:.2f}') # podemos indicar la cantidad de decimales que va a mostrar y nos sirve para achicar el número o agrandarlo

# Notación Exponencial (valores positivos o negativos)
a = 3e5 # 3 exponencial 5, al número 3 le agregamos 5 ceros
print(f'a: {a}')

a = 3e-5
print(f'a: {a:.5f}')
print(f'a: {a:.9f}')

#Cualquier calculo que incluye un float, todo cambia a float

a = 4.0 + 5
print(a)
print(type(a))

