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

@router.route('/admin/generator/register')
def view_register_generator():
    url = "http://localhost:8099/api/generator/listType"
    data = make_request('GET', url)
    if data:
        return render_template('fragmento/generador/registro.html', lista=data["data"])
    flash("Error al cargar los datos de tipo de generador.", category='error')
    return redirect('/')

@router.route('/admin/generator/search/<criterio>/<texto>')
def view_search_generator(criterio, texto):
    base_url = "http://localhost:8099/api/generator/list/search/"
    if criterio == 'name':
        url = base_url + texto
    elif criterio == 'id':
        url = base_url + "ident/" + texto
    else:
        flash("Criterio de búsqueda inválido.", category='error')
        return redirect('/admin/generator/list')

    data = make_request('GET', url)
    if data:
        lista = data["data"]
        if isinstance(lista, dict):  # Si el resultado es un dict, lo transformamos en una lista
            lista = [lista]
        return render_template('fragmento/generador/lista.html', lista=lista)
    flash("Error al buscar generadores.", category='error')
    return redirect('/admin/generator/list')

@router.route('/admin/generator/order/<atributo>/<tipo>')
def view_order_generator(atributo, tipo):
    url = f"http://localhost:8099/api/generator/list/order/{atributo}/{tipo}"
    data = make_request('GET', url)
    if data:
        return render_template('fragmento/generador/lista.html', lista=data["data"])
    flash("Error al ordenar la lista de generadores.", category='error')
    return redirect('/admin/generator/list')

@router.route('/admin/generator/edit/<id>')
def view_edit_generator(id):
    tipo_url = "http://localhost:8099/api/generator/listType"
    generator_url = f"http://localhost:8099/api/generator/get/{id}"

    tipo_data = make_request('GET', tipo_url)
    generator_data = make_request('GET', generator_url)

    if tipo_data and generator_data:
        return render_template('fragmento/generador/editar.html', lista=tipo_data["data"], generator=generator_data["data"])
    flash("Error al cargar los datos del generador para edición.", category='error')
    return redirect('/admin/generator/list')

@router.route('/admin/generator/list')
def list_generators():
    url = "http://localhost:8099/api/generator/list"
    data = make_request('GET', url)
    if data:
        return render_template('fragmento/generador/lista.html', lista=data["data"])
    flash("Error al cargar la lista de generadores.", category='error')
    return render_template('fragmento/generador/lista.html', lista=[])

@router.route('/admin/generator/save', methods=["POST"])
def save_generator():
    headers = {'Content-Type': 'application/json'}
    form = request.form
    dataF = {
        "type": form["type"],
        "name": form["name"],
        "id": form["id"],
        "location": form["location"],
        "contact": form["contact"]
    }
    url = "http://localhost:8099/api/generator/save"
    response = make_request('POST', url, data=dataF, headers=headers)
    if response:
        flash("Generador guardado correctamente.", category='info')
    else:
        flash("Error al guardar el generador.", category='error')
    return redirect('/admin/generator/list')

@router.route('/admin/generator/update', methods=["POST"])
def update_generator():
    headers = {'Content-Type': 'application/json'}
    form = request.form
    dataF = {
        "id": form["id"],
        "type": form["type"],
        "name": form["name"],
        "id": form["id"],
        "location": form["location"],
        "contact": form["contact"]
    }
    url = "http://localhost:8099/api/generator/update"
    response = make_request('POST', url, data=dataF, headers=headers)
    if response:
        flash("Generador actualizado correctamente.", category='info')
    else:
        flash("Error al actualizar el generador.", category='error')
    return redirect('/admin/generator/list')
