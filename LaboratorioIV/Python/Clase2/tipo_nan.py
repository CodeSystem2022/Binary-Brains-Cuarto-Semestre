import math
from decimal import Decimal

# NaN (Not a number)
a = float('NaN')
print(f'a = {a}')

#modulo math
a = float('nan')
print(f'es nan? = {math.isnan(a)}')

#decimal
a = Decimal('nan')
print(f'es nan? = {math.isnan(a)}')