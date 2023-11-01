
# help(str.join)

tupla_str = ('Hola', 'alumnos', 'Tecnicatura', 'Universitaria') # tupla con 4 elementos
mensaje = ' '.join(tupla_str) # crea una nueva cadena uniendo espacios entre las palabras
print(f'Mensaje: {mensaje}') # devuelve una sola cadena

lista_cursos = ['Java', 'Python', 'Angular', 'Spring']
mensaje = ', '.join(lista_cursos)
print(f'Mensaje: {mensaje}')

cadena = 'HolaMundo'
mensaje = '.'.join(cadena)
print(f'Mensaje: {mensaje}')

diccionario = {'nombre': 'Juan', 'apellido': 'Perez', 'edad': '18'}
llaves = '-'.join(diccionario.keys())
valores = '-'.join(diccionario.values())
print(f'Llaves: {llaves}, Type: {type(llaves)}')
print(f'Valores: {valores}, Type: {type(valores)}')
