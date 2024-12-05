from flask import Blueprint, abort, request, render_template, redirect, flash
import json
import requests

routeEquipo = Blueprint('routeEquipo', __name__)

# Listar generadores
@routeEquipo.route('/admin/generators/list')
def list_generators(msg=''):
    r = requests.get("http://localhost:8099/api/generator/list")
    if r.status_code == 200:
        data = r.json()
        return render_template('fragmento/generador/lista.html', lista=data["data"], message=msg)
    else:
        flash("Error al obtener la lista de generadores", category='error')
        return render_template('fragmento/generador/lista.html', lista=[], message='No se pudieron obtener los datos.')

# Registrar un nuevo generador
@routeEquipo.route('/admin/generator/register')
def view_register_generator():
    r = requests.get("http://localhost:8099/api/generator/listType")
    r1 = requests.get("http://localhost:8099/api/brand/list")
    if r.status_code == 200 and r1.status_code == 200:
        data = r.json()
        data1 = r1.json()
        return render_template('fragmento/generador/registro.html', lista=data["data"], marcas=data1["data"])
    else:
        flash("Error al obtener tipos o marcas", category='error')
        return redirect('/admin/generators/list')

# Guardar un generador
@routeEquipo.route('/admin/generators/save', methods=["POST"])
def save_generator():
    headers = {'Content-type': 'application/json'}
    form = request.form

    dataF = {
        "owner": form["owner"],
        "brand": form["brand"],
        "type": form["type"],
        "features": form["features"],
        "model": form["model"]
    }

    r = requests.post("http://localhost:8099/api/generator/save", data=json.dumps(dataF), headers=headers)

    if r.status_code == 200:
        flash("Generador guardado correctamente", category='info')
    else:
        dat = r.json()
        flash(f"Error al guardar el generador: {dat.get('data', 'Error desconocido')}", category='error')

    return redirect("/admin/generators/list")

# Editar un generador
@routeEquipo.route('/admin/generator/edit/<id>')
def view_edit_generator(id):
    r = requests.get("http://localhost:8099/api/generator/get/" + id)
    r1 = requests.get("http://localhost:8099/api/generator/listType")
    r2 = requests.get("http://localhost:8099/api/brand/list")
    
    if r.status_code == 200 and r1.status_code == 200 and r2.status_code == 200:
        generator = r.json()
        types = r1.json()
        brands = r2.json()
        return render_template('fragmento/generador/editar.html', generator=generator["data"], types=types["data"], brands=brands["data"])
    else:
        flash("Error al cargar los datos del generador", category='error')
        return redirect("/admin/generators/list")

# Actualizar un generador
@routeEquipo.route('/admin/generators/update', methods=["POST"])
def update_generator():
    headers = {'Content-type': 'application/json'}
    form = request.form

    dataF = {
        "id": form["id"],
        "owner": form["owner"],
        "brand": form["brand"],
        "type": form["type"],
        "features": form["features"],
        "model": form["model"]
    }

    r = requests.post("http://localhost:8099/api/generator/update", data=json.dumps(dataF), headers=headers)

    if r.status_code == 200:
        flash("Generador actualizado correctamente", category='info')
    else:
        dat = r.json()
        flash(f"Error al actualizar el generador: {dat.get('data', 'Error desconocido')}", category='error')

    return redirect("/admin/generators/list")

# Ordenar generadores
@routeEquipo.route('/admin/g
