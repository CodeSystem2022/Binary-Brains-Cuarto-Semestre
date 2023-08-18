class Usuario:
    def __init__(self, id_usuario=None, username=None, password=None ):
        self.id_usuario = id_usuario
        self.username = username
        self.password = password

    def __str__(self):
        return f'Usuario: {self._id_usuario}{self.username}{self.password}'

    #Metodos get y set
    @property
    def id_usuario(self):
        return self._id_usuario
    @id_usuario.setter
    def id_usuario(self,id_usuario):
        self.id_usuario = id_usuario
    @property
    def username(self):
        return self.username
    @username.setter
    def username(self, username):
        self.username = username

    @property
    def password(self):
        return self.password

    @password.setter
    def password(self, password):
        self.password = password


def cursorDelPool():
    return None