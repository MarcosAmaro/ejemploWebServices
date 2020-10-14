from flask import Flask, jsonify, request, make_response
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

cursos = [
    {
        'id' : 1,
        'lenguaje' : 'Java',
        'precio' : 2000,
        'duracion' : 3
    },
    {
        'id' : 2,
        'lenguaje' : 'Python',
        'precio' : 1000,
        'duracion' : 2
    },
    {
        'id' : 3,
        'lenguaje' : 'Erlang',
        'precio' : 5000,
        'duracion' : 6
    }
]

id = 3
error400 = {'error': 400, 'descripcion' : 'Faltan datos del curso'}
error404 = {'error': 404, 'descripcion' : 'Curso no encontrado'}
error415 = {'error': 415, 'descripcion' : 'Formato desconocido'}

@app.route('/')
def index():
    return "Hello, World!"

@app.route('/cursos', methods=['GET'])
def traerListadoCursos():
    return jsonify(cursos)

@app.route('/cursos/<int:idCurso>', methods=['GET'])
def traerCurso(idCurso):
    curso = buscarCurso(idCurso)
    if not curso is None:
        return jsonify(curso)
    else:
        return make_response(jsonify(error404), 404)

@app.route('/cursos', methods=['POST'])
def crearCurso():
    if not request.json:
        return make_response(jsonify(error415), 415)

    claves = ['lenguaje', 'precio', 'duracion']
    if not all(clave in request.json for clave in claves):
        return make_response(jsonify(error400), 400)

    return jsonify(crear(request))

@app.route('/cursos/<int:idCurso>', methods=['PUT'])
def modificarCurso(idCurso):
    if not request.json:
        return make_response(jsonify(error415), 415)

    claves = ['lenguaje', 'precio', 'duracion']
    if not all(clave in request.json for clave in claves):
        return make_response(jsonify(error400), 400)

    curso = buscarCurso(idCurso)
    if curso is None:
        return jsonify(crear(request))

    curso['lenguaje'] = request.json['lenguaje']
    curso['precio'] = request.json['precio']
    curso['duracion'] = request.json['duracion']

    return jsonify(curso)

@app.route('/cursos/<int:idCurso>', methods=['DELETE'])
def borrarCurso(idCurso):
    curso = buscarCurso(idCurso)
    if curso is None:
        return make_response(jsonify(error404), 404)

    cursos.remove(curso)

    return jsonify(curso)

def buscarCurso(idCurso):
    for curso in cursos:
        if curso['id'] == idCurso:
            return curso

    return None

def crear(request):
    global id
    id = id + 1
    curso = {
        'id': id,
        'lenguaje': request.json['lenguaje'],
        'precio': request.json['precio'],
        'duracion': request.json['duracion']
    }

    cursos.append(curso)
    return curso

if __name__ == '__main__':
    app.run()
