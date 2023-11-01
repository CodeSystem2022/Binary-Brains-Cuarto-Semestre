# help(str.join) el método recibe dos parámetros, en el self recibe la cadena en sí y el parámetro iterable

tupla_str = ('Hola', 'alumnos', 'Tecnicatura', 'Universitaria')  # tupla que posee 4 elementos
mensaje = ' '.join(tupla_str)  # crea una nueva cadena; se unen espacios entre las palabras
print(f'Mensaje: {mensaje}')  # devuelve una sola cadena

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