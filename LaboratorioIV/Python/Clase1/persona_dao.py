from capa_datos_persona.Persona import Persona
from capa_datos_persona.conexion import Conexion
from capa_datos_persona.cursor_del_pool import CursorDelPool
from logger_base import log


class PersonaDAO:
    """
    DAO: Data Access Object
    CRUD:
                    Create -> Insertar
                    Read -> Seleccionar
                    Update -> Actualizar
                    Delete -> Eliminar
    """

    _SELECCIONAR = 'SELECT * FROM persona ORDER BY id_persona'
    _INSERTAR = 'INSERT INTO persona(nombre,apellido,email) VALUES (%s,%s,%s)'
    _ACTUALIZAR = 'UPDATE persona SET nombre=%s, apellido=%s, email=%s WHERE id_persona=%s'
    _ELIMINAR = 'DELETE FROM persona WHERE id_persona=%s'

    # Definimos los métodos de clase
    @classmethod
    def seleccionar(cls):
        # armamos las conexiones automáticas

        # obtenemos el cursor
        with CursorDelPool() as cursor:
            # creamos la query y se ejecuta la sentencia
            cursor.execute(cls._SELECCIONAR)
            registros = cursor.fetchall()
            personas = []  # creamos una lista de personas que se encuentra vacía
            # recorremos el registro con un ciclo for each
            for registro in registros:
                # cada registro es representado como una columna (id_persona, nombre, apellido e email)
                persona = Persona(registro[0], registro[1], registro[2], registro[3])
                personas.append(persona)
                return personas

    # Método Insertar
    @classmethod
    def insertar(cls, persona):  # tiene que recibir un parámetro
        with CursorDelPool() as cursor:
            valores = (persona.nombre, persona.apellido, persona.email)
            cursor.execute(cls._INSERTAR, valores)  # Ejecutamos el cursor
            log.debug(f'Persona Insertada: {persona}')
            return cursor.rowcount

    # Método Actualizar
    @classmethod
    def actualizar(cls, persona):
         with CursorDelPool() as cursor:
            valores = (persona.nombre, persona.apellido, persona.email, persona.id_persona)
            cursor.execute(cls._ACTUALIZAR, valores)
            log.debug(f'Persona actualizada: {persona}')
            return cursor.rowcount

    # Método Eliminar
    @classmethod
    def eliminar(cls, persona):
          with CursorDelPool() as cursor:
                valores = (persona.id_persona,)
                cursor.execute(cls._ELIMINAR, valores)
                log.debug(f'Los objetos eliminados son: {persona}')
                return cursor.rowcount


if __name__ == '__main__':
    # Eliminar un registro
    persona1 = Persona(id_persona=18)
    personas_eliminadas = PersonaDAO.eliminar(persona1)
    log.debug(f'Personas eliminadas: {personas_eliminadas}')

    # Actualizar un registro
    persona1 = Persona(1, 'Juan José', 'Pena', 'jpena@mail.com')
    personas_actualizadas = PersonaDAO.actualizar(persona1)
    log.debug(f'Personas actualizadas: {personas_actualizadas}')

    # Insertar un registro
    persona1 = Persona(nombre='Mateo', apellido='Torres', email='mateotorres@mail.com')
    personas_insertadas = PersonaDAO.insertar(persona1) #insertamos utilizamos PersonaDAO
    log.debug(f'Personas insertadas: {personas_insertadas}')

    # Seleccionar objetos
    personas = PersonaDAO.seleccionar()
    for persona in personas:
        log.debug(persona)