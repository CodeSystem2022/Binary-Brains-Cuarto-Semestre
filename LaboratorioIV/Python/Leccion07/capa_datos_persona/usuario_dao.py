from capa_datos_persona.Usuario import cursorDelPool, Usuario
from capa_datos_persona.cursor_del_pool import CursorDelPool
from logger_base import log




class UsuarioDao:
    _SELECT = 'SELECT * FROM usuario ORDER BY id_usuario'
    _INSERTAR = 'INSERT INTO usuario(username, password) VALUES(%s, %s)'
    _ACTUALIZAR = 'UPDATE usuario SET username=%s, password=%s WHERE id_usuario=%s'
    _ELIMINAR = 'DELETE FROM usuario WHERE id_usuario=%s'

    @classmethod
    def seleccionar(cls):
        with CursorDelPool() as cursor:
            log.debug('Seleccionando usuarios')
            cursor.execute(cls._SELECT)
            registros = cursor.fetchall()
            usuarios = []
            for registro in registros:
                usuario = Usuario(registro[0], registro[1], registro[2])
                usuarios.append(usuario)
            return usuarios

    @classmethod
    def insertar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Insertando usuario: {usuario}')
            valores = (usuario.username, usuario.password)
            cursor.execute(cls._INSERTAR, valores)
            log.debug(f'Usuario insertado: {usuario}')

    @classmethod
    def actualizar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Actualizando usuario: {usuario}')
            valores = (usuario.username, usuario.password, usuario.id_usuario)
            cursor.execute(cls._ACTUALIZAR, valores)
            log.debug(f'Usuario actualizado: {usuario}')

    @classmethod
    def eliminar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Eliminando usuario: {usuario}')
            valores = (usuario.id_usuario,)
            cursor.execute(cls._ELIMINAR, valores)
            log.debug(f'Usuario eliminado: {usuario}')

if __name__=='__main__':
    #eliminar usuario
    usuario = Usuario(id_usuario=3)
    usuario_eliminado = UsuarioDao.eliminar(usuario)
    log.debug(f'Usuario eliminado: = {usuario_eliminado}')

    # Actualizar usuario
    usuario = Usuario(id_usuario=1,username='',password='369')
    usuario_modificado = UsuarioDao.actualizar(usuario)
    log.debug(f'Usuario Modificado: = {usuario_modificado}')

    # Insertar usuario
    usuario = Usuario(username='kelly', password='231')
    usuario_insertado = UsuarioDao.insertar(usuario)
    log.debug(f'Usuario insertado: = {usuario_insertado}')

    # listar o seleccionar
    usuarios = UsuarioDao.seleccionar()
    for usuario in usuarios:
        log.debug(usuario)

