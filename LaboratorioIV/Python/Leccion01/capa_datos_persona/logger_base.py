import logging as log

# Llamamos una configuración básica

log.basicConfig(level=log.INFO,
                format='%(asctime)s:%(levelname)s [%(filename)s:%(lineno)s] %(message)s', # Parametros: Hora, Nivel que lanzó, Nombre del archivo y línea, Mensaje que envía
                datefmt='%I:%M:%S %p',  # Configuración de la hora
                handlers=[log.FileHandler('capa_datos.log'), # Nombre del archivo
                          log.StreamHandler() # Muestra la información por consola y también en un archivo
                ])

if __name__ == '__main__':
    log.debug('Mensaje a nivel debug')
    log.info('Mensaje a nivel info')
    log.warning('Mensaje a nivel warning')
    log.error('Mensaje a nivel error')
    log.critical('Mensaje a nivel critical')
