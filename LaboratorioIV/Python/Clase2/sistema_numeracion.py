#Sistemas de numeracion

#Decimal 
a = 10 
print(f'El valor de a es {a} y su tipo es {type(a)}')

#Binario
b = 0b1010 #Vale diez en decimal
print(f'El valor de b es {b} y su tipo es {type(b)}')

#Octal
c = 0o12 #Vale diez en decimal
print(f'El valor de c es {c} y su tipo es {type(c)}')

#Hexadecimal
d = 0xA #Vale diez en decimal
print(f'El valor de d es {d} y su tipo es {type(d)}')

#Constructor clase int
e = int('23', 10) #Decimal
print(f'El valor de e es {e} y su tipo es {type(e)}')

f = int('10111', 2) #Binario
print(f'El valor de f es {f} y su tipo es {type(f)}')

g = int('27', 8) #Octal
print(f'El valor de g es {g} y su tipo es {type(g)}')

h = int('17', 16) #Hexadecimal
print(f'El valor de h es {h} y su tipo es {type(h)}')

#Base 5
i = int('44', 5) #SOlo funciona con numeros del 0 al 4
print(f'El valor de i es {i} y su tipo es {type(i)}')