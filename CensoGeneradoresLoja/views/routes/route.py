from flask import Blueprint, request, render_template, redirect, flash
import json
import requests

router = Blueprint('router', __name__)

# Función auxiliar para manejar solicitudes HTTP
def make_request(method, url, data=None, headers=None):
    try:
        if method == 'GET':
            response = requests.get(url)
        elif method == 'POST':
            response = requests.post(url, data=json.dumps(data), headers=headers)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error en la solicitud HTTP: {e}")
        return None

@router.route('/')
def home():
    return render_template('fragmento/inicial/login.html')

@router.route('/admin')
def admin():
    return render_template('fragmento/inicial/admin.html')

@router.route('/admin/person/register')
def view_register_person():
    url = "http://localhost:8099/api/person/listType"
    data = make_request('GET', url)
    if data:
        return render_template('fragmento/persona/registro.html', lista=data["data"])
    flash("Error al cargar los datos de tipo de persona.", category='error')
    return redirect('/')

@router.route('/admin/person/search/<criterio>/<texto>')
def view_buscar_person(criterio, texto):
    base_url = "http://localhost:8099/api/person/list/search/"
    if criterio == 'apellidos':
        url = base_url + texto
    elif criterio == 'dni':
        url = base_url + "ident/" + texto
    else:
        flash("Criterio de búsqueda inválido.", category='error')
        return redirect('/admin/person/list')

    data = make_request('GET', url)
    if data:
        lista = data["data"]
        if isinstance(lista, dict):  # Si el resultado es un dict, lo transformamos en una lista
            lista = [lista]
        return render_template('fragmento/persona/lista.html', lista=lista)
    flash("Error al buscar personas.", category='error')
    return redirect('/admin/person/list')

@router.route('/admin/person/order/<atributo>/<tipo>')
def view_order_person(atributo, tipo):
    url = f"http://localhost:8099/api/person/list/order/{atributo}/{tipo}"
    data = make_request('GET', url)
    if data:
        return render_template('fragmento/persona/lista.html', lista=data["data"])
    flash("Error al ordenar la lista de personas.", category='error')
    return redirect('/admin/person/list')

@router.route('/admin/person/edit/<id>')
def view_edit_person(id):
    tipo_url = "http://localhost:8099/api/person/listType"
    person_url = f"http://localhost:8099/api/person/get/{id}"

    tipo_data = make_request('GET', tipo_url)
    person_data = make_request('GET', person_url)

    if tipo_data and person_data:
        return render_template('fragmento/persona/editar.html', lista=tipo_data["data"], person=person_data["data"])
    flash("Error al cargar los datos de la persona para edición.", category='error')
    return redirect('/admin/person/list')

@router.route('/admin/person/list')
def list_person():
    url = "http://localhost:8099/api/person/list"
    data = make_request('GET', url)
    if data:
        return render_template('fragmento/persona/lista.html', lista=data["data"])
    flash("Error al cargar la lista de personas.", category='error')
    return render_template('fragmento/persona/lista.html', lista=[])

@router.route('/admin/person/save', methods=["POST"])
def save_person():
    headers = {'Content-Type': 'application/json'}
    form = request.form
    dataF = {
        "tipo": form["tipo"],
        "apellidos": form["ape"],
        "nombres": form["nom"],
        "identificacion": form["iden"],
        "direccion": form["dir"],
        "fono": form["fono"]
    }
    url = "http://localhost:8099/api/person/save"
    response = make_request('POST', url, data=dataF, headers=headers)
    if response:
        flash("Persona guardada correctamente.", category='info')
    else:
        flash("Error al guardar la persona.", category='error')
    return redirect('/admin/person/list')

@router.route('/admin/person/update', methods=["POST"])
def update_person():
    headers = {'Content-Type': 'application/json'}
    form = request.form
    dataF = {
        "id": form["id"],
        "tipo": form["tipo"],
        "apellidos": form["ape"],
        "nombres": form["nom"],
        "identificacion": form["iden"],
        "direccion": form["dir"],
        "fono": form["fono"]
    }
    url = "http://localhost:8099/api/person/update"
    response = make_request('POST', url, data=dataF, headers=headers)
    if response:
        flash("Persona actualizada correctamente.", category='info')
    else:
        flash("Error al actualizar la persona.", category='error')
    return redirect('/admin/person/list')
