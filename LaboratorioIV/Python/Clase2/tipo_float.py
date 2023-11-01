# tipo float

a = 3.0
print(f'El valor de a es {a:.2f} y su tipo es {type(a)}')

# Constructor clase float, recibe int y str

b = float(10) #int
print(f'El valor de b es {b:.2f} y su tipo es {type(b)}')

c = float('10.5') #str
print(f'El valor de c es {c:.2f} y su tipo es {type(c)}')

#Notacion exponencial (positivos y negativos)

e = 3e8
print(f'El valor de e es {e:.2f} y su tipo es {type(e)}')

e = 3e-5
print(f'El valor de e es {e:.5f} y su tipo es {type(e)}')

#CUalquier calculo con float, el resultado es float

e = 4.0 + 2
print(f'El valor de e es {e:.2f} y su tipo es {type(e)}')

