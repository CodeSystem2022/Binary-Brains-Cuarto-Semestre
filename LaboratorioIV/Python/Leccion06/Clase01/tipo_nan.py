import math
from decimal import Decimal

# NaN (Not a Number)
a = float('NaN')
print(f'a: {a}')

# modulo math
a = float('nan')
print(f'Es de tipo NaN(Not a Number)?: {math.isnan(a)}')

# Modulo decimal
a = Decimal('nan')
print(f'Es de tipo NaN(Not a Number)?: {math.isnan(a)}')