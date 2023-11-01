from usuario_dao import usuarioDAO
from loger_base import log

opcion = None
while opcion != 5:
    print('Opciones:')
    print('1. Listar usuarios')
    print('2. Agregar usuario')
    print('3. Modificar usuario')
    print('4. Eliminar usuario')
    print('5. Salir')
    opcion = int(input('Escribe tu opción (1-5): '))
    if opcion == 1:
        usuarios = usuarioDAO.seleccionar()
        for usuario in usuarios:
            log.info(usuario)
    elif opcion == 2:
        username = input('Escribe el username: ')
        password = input('Escribe el password: ')
        usuario = usuario(username=username, password=password)
        usuarios_insertados = usuarioDAO.insertar(usuario)
        log.debug(f'Usuarios insertados: {usuarios_insertados}')
    elif opcion == 3:
        id_usuario = int(input('Escribe el id_usuario: '))
        username = input('Escribe el username: ')
        password = input('Escribe el password: ')
        usuario = usuario(id_usuario=id_usuario, username=username, password=password)
        usuarios_actualizados = usuarioDAO.actualizar(usuario)
        log.debug(f'Usuarios actualizados: {usuarios_actualizados}')
    elif opcion == 4:
        id_usuario = int(input('Escribe el id_usuario: '))
        usuario = usuario(id_usuario=id_usuario)
        usuarios_eliminados = usuarioDAO.eliminar(usuario)
        log.debug(f'Usuarios eliminados: {usuarios_eliminados}')
    else:
        print('Opción incorrecta')
        print('Fin del programa')
