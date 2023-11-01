# dar formato a un string

nombre = 'Ariel'
edad = 28
mensaje_con_formato = 'Mi nombre es %s y tengo %d años' % (nombre, edad)  # %s tipo string

# Creamos una tupla
persona = ('Gustavo', 'Ortiz', 10000.00)
mensaje_con_formato = 'Hola %s %s. Tu sueldo es %.2f'  # % persona #le pasamos el objeto que es una tupla

# print(mensaje_con_formato % persona)  #podemos pasarlo en el print directamente

nombre = 'Juan'
edad = 19
sueldo = 20000

# se puede modificar el orden de los elementos debido a que manejamos índices.
mensaje = 'Nombre {0} Edad {1} Sueldo {2:.2f}'.format(nombre, edad, sueldo)  #se ven dos decimales después del punto
print(mensaje)

mensaje = 'Nombre {n} edad {e} Sueldo {s:.2f}'.format(n=nombre, e=edad, s=sueldo)
# print(mensaje)

diccionario = {'nombre': 'Ivan', 'edad': 35, 'sueldo': 8000.00}
mensaje = 'Nombre {dic[nombre]} edad {dic[edad]} Sueldo{dic[sueldo]: .2f}'.format(dic=diccionario)
print(mensaje)
