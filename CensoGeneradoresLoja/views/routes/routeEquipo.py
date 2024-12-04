from flask import Blueprint, abort, request, render_template, redirect, flash
import json
import requests

routeEquipo = Blueprint('routeEquipo', __name__)

# Listar dispositivos (equipos)
@routeEquipo.route('/admin/devices/list')
def list_devices(msg=''):
    r = requests.get("http://localhost:8099/api/device/list")
    if r.status_code == 200:
        data = r.json()
        return render_template('fragmento/equipo/lista.html', lista=data["data"], message=msg)
    else:
        flash("Error al obtener la lista de dispositivos", category='error')
        return render_template('fragmento/equipo/lista.html', lista=[], message='No se pudieron obtener los datos.')

# Registrar un nuevo dispositivo
@routeEquipo.route('/admin/device/register')
def view_register_device():
    r = requests.get("http://localhost:8099/api/device/listType")
    r1 = requests.get("http://localhost:8099/api/brand/list")
    if r.status_code == 200 and r1.status_code == 200:
        data = r.json()
        data1 = r1.json()
        return render_template('fragmento/equipo/registro.html', lista=data["data"], marcas=data1["data"])
    else:
        flash("Error al obtener tipos o marcas", category='error')
        return redirect('/admin/devices/list')

# Guardar un dispositivo
@routeEquipo.route('/admin/devices/save', methods=["POST"])
def save_device():
    headers = {'Content-type': 'application/json'}
    form = request.form

    dataF = {
        "person": form["client"],
        "brand": form["marca"],
        "tipo": form["tipo"],
        "caracteristicas": form["caracteristica"],
        "modelo": form["modelo"]
    }

    r = requests.post("http://localhost:8099/api/device/save", data=json.dumps(dataF), headers=headers)

    if r.status_code == 200:
        flash("Dispositivo guardado correctamente", category='info')
    else:
        dat = r.json()
        flash(f"Error al guardar el dispositivo: {dat.get('data', 'Error desconocido')}", category='error')

    return redirect("/admin/devices/list")

# Editar un dispositivo
@routeEquipo.route('/admin/device/edit/<id>')
def view_edit_device(id):
    r = requests.get("http://localhost:8099/api/device/get/" + id)
    r1 = requests.get("http://localhost:8099/api/device/listType")
    r2 = requests.get("http://localhost:8099/api/brand/list")
    
    if r.status_code == 200 and r1.status_code == 200 and r2.status_code == 200:
        device = r.json()
        types = r1.json()
        brands = r2.json()
        return render_template('fragmento/equipo/editar.html', device=device["data"], tipos=types["data"], marcas=brands["data"])
    else:
        flash("Error al cargar los datos del dispositivo", category='error')
        return redirect("/admin/devices/list")

# Actualizar un dispositivo
@routeEquipo.route('/admin/devices/update', methods=["POST"])
def update_device():
    headers = {'Content-type': 'application/json'}
    form = request.form

    dataF = {
        "id": form["id"],
        "person": form["client"],
        "brand": form["marca"],
        "tipo": form["tipo"],
        "caracteristicas": form["caracteristica"],
        "modelo": form["modelo"]
    }

    r = requests.post("http://localhost:8099/api/device/update", data=json.dumps(dataF), headers=headers)

    if r.status_code == 200:
        flash("Dispositivo actualizado correctamente", category='info')
    else:
        dat = r.json()
        flash(f"Error al actualizar el dispositivo: {dat.get('data', 'Error desconocido')}", category='error')

    return redirect("/admin/devices/list")

# Ordenar dispositivos
@routeEquipo.route('/admin/devices/order/<atributo>/<tipo>')
def view_order_devices(atributo, tipo):
    url = f"http://localhost:8099/api/device/list/order/{atributo}/{tipo}"
    r = requests.get(url)

    if r.status_code == 200:
        data = r.json()
        return render_template('fragmento/equipo/lista.html', lista=data["data"])
    else:
        flash("Error al ordenar los dispositivos", category='error')
        return render_template('fragmento/equipo/lista.html', lista=[], message='Error al ordenar los datos.')
