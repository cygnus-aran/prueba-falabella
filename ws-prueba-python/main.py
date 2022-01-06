import string

from flask import Flask, jsonify
from flask_restful import Api, Resource

app = Flask(__name__)
api = Api(app)

letras = list(string.ascii_uppercase)

class Patente(Resource):
    def get(self, patente):
        pat = [char for char in patente]
        respuesta = ""
        id = 1
        n = 0
        for iteration, x in enumerate(pat[0:4]):
            if iteration == 3:
                id = id + (letras.index(x) * 1000)
            elif iteration == 2:
                id = id + (letras.index(x) * 26000)
            elif iteration == 1:
                id = id + (letras.index(x) * 660000)
            elif iteration == 0:
                id = id + (letras.index(x) * 17875000)

        for y in pat[4:7]:
            respuesta = respuesta + y

        id = id + int(respuesta)

        respuesta = str(id);

        return {"respuesta": respuesta}


class Id(Resource):
    def get(self, id):
        n = ""
        id = id - 1;
        i1 = id // 17875000
        id = id % 17875000
        i2 = id // 660000
        id = id % 660000
        i3 = id // 26000
        id = id % 26000
        i4 = id // 1000
        id = id % 1000
        if id < 10:
            n = "00" + str(id)
        elif id < 100:
            n = "0" + str(id)
        else:
            n = str(id)
        respuesta = str(letras[i1] + letras[i2] + letras[i3] + letras[i4] + n)
        return {"respuesta": respuesta}


api.add_resource(Patente, "/prueba/patente/<string:patente>")
api.add_resource(Id, "/prueba/id/<int:id>")

if __name__ == "__main__":
    app.run(debug=True)
