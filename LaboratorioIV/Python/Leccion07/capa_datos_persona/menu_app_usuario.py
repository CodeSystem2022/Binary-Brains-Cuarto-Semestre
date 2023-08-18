from capa_datos_persona.usuario_dao import UsuarioDao
from logger_base import log
opcion = None
while opcion != 5:
    print('Opciones: ')
    print('1. Listar Usuarios ')
    print('2. Agregar usuario ')
    print('3. Modificar Usuarios ')
    print('4. Eliminar Usuarios ')
    print('5. Salir ')
    opcion = int(input('Digite la opcion (1-5): '))
    if opcion ==1:
        usuarios = UsuarioDao.seleccionar()
        for usuario in usuarios:
            log.info(usuario)

else:
    log.info('Salimos de la aplicacion, Hasta pronto')
