#2.5 Valor Infinito Positivo y negativo
import math
from decimal import Decimal  #imporamos la clase decimal


# Manejo de valores infinitos
infinito_positivo = float('inf') # Representa el valor de inf positivo, con el constructor float
print(f"f'Infinito positivo: {infinito_positivo}")
print(f'Es infinito?: {math.isinf((infinito_positivo))}')

infinito_negtivo = float(' -inf')
print(f"Infinito negativo: {infinito_negtivo}")
print(f'Es negativo?: {math.isinf((infinito_negtivo))}')
