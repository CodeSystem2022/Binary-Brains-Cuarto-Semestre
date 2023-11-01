import math
from decimal import Decimal
# manejo de valores infinitos

infinito_positivo = float('inf')
print(f'El valor de infinito_positivo es {infinito_positivo} y su tipo es {type(infinito_positivo)}')
print(f'ES infinito?: {math.isinf(infinito_positivo)}')

infinito_negativo = float('-inf')
print(f'El valor de infinito_negativo es {infinito_negativo} y su tipo es {type(infinito_negativo)}')

print(f'ES infinito?: {math.isinf(infinito_negativo)}')

#MOdulo math
infinito_positivo = math.inf
print(f'El valor de infinito_positivo es {infinito_positivo} y su tipo es {type(infinito_positivo)}')
print(f'ES infinito?: {math.isinf(infinito_positivo)}')

infinito_negativo = -math.inf
print(f'El valor de infinito_positivo es {infinito_negativo} y su tipo es {type(infinito_negativo)}')
print(f'ES infinito?: {math.isinf(infinito_negativo)}')

#Clase decimal
infinito_positivo = Decimal('Infinity')
print(f'El valor de infinito_positivo es {infinito_positivo} y su tipo es {type(infinito_positivo)}')
print(f'ES infinito?: {math.isinf(infinito_positivo)}')

infinito_negativo = Decimal('-Infinity')
print(f'El valor de infinito_positivo es {infinito_negativo} y su tipo es {type(infinito_negativo)}')
print(f'ES infinito?: {math.isinf(infinito_negativo)}')