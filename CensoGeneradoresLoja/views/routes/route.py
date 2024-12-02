from flask import Blueprint, abort, request, render_template, redirect, flash
import json
import requests
router = Blueprint('router', __name__)

@router.route('/')
def home():
    
    return render_template('fragmento/inicial/login.html')

@router.route('/admin')
def admin():    
    return render_template('fragmento/inicial/admin.html')

@router.route('/admin/person/register')
def view_register_person():    
    r = requests.get("http://localhost:8099/api/person/listType")
    data = r.json()
    print(r.json())
    return render_template('fragmento/persona/registro.html', lista = data["data"])

@router.route('/admin/person/search/<criterio>/<texto>')
def view_buscar_person(criterio, texto):  
    url = "http://localhost:8099/api/person/list/search/"
    if criterio == 'apellidos':  
        r = requests.get(url+texto)       
    elif criterio == 'dni':
        r = requests.get(url+"ident/"+texto) 
    
    data1 = r.json()
    if(r.status_code == 200):
        if type(data1["data"]) is dict:
            #print(type(data1["data"]))
            list=[]
            list.append(data1["data"])
            return render_template('fragmento/persona/lista.html', lista = list)
        else:
            return render_template('fragmento/persona/lista.html', lista = data1["data"])
    else:        
        return render_template('fragmento/persona/lista.html', lista = [], message = 'No existe el elemento')
        #return render_template('fragmento/persona/editar.html', lista = data["data"], person = data1["data"])
    
@router.route('/admin/person/order/<atributo>/<tipo>')
def view_order_person(atributo, tipo):  
    url = "http://localhost:8099/api/person/list/order/"+atributo+"/"+tipo
    
    r = requests.get(url) 
    
    data1 = r.json()
    if(r.status_code == 200):
        return render_template('fragmento/persona/lista.html', lista = data1["data"])
    else:        
        return render_template('fragmento/persona/lista.html', lista = [], message = 'No existe el elemento')

@router.route('/admin/person/edit/<id>')
def view_edit_person(id):    
    r = requests.get("http://localhost:8099/api/person/listType")
    data = r.json()
    r1 = requests.get("http://localhost:8099/api/person/get/"+id)
    data1 = r1.json()
    if(r1.status_code == 200):
        return render_template('fragmento/persona/editar.html', lista = data["data"], person = data1["data"])
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/person/list")

@router.route('/admin/person/list')
def list_person(msg=''):
    r = requests.get("http://localhost:8099/api/person/list")
    #print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/persona/lista.html', lista = data["data"], message = msg)

@router.route('/admin/person/save',  methods=["POST"])
def save_person():
    headers = {'Content-type': 'application/json'}
    form = request.form
    
    dataF = {"tipo":form["tipo"], "apellidos":form["ape"], "nombres":form["nom"], "identificacion":form["iden"], "direccion":form["dir"], "fono":form["fono"]}
    r = requests.post("http://localhost:8099/api/person/save", data=json.dumps(dataF), headers=headers)
   
    dat = r.json()
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
        return redirect("/admin/person/list")
    else:
        flash(str(dat["data"]), category='error')
        return redirect("/admin/person/list")
    #print(r.json())
    #data = r.json()
    #if(data[""])

@router.route('/admin/person/update',  methods=["POST"])
def update_person():
    headers = {'Content-type': 'application/json'}
    form = request.form
    
    dataF = {"id":form["id"],"tipo":form["tipo"], "apellidos":form["ape"], "nombres":form["nom"], "identificacion":form["iden"], "direccion":form["dir"], "fono":form["fono"]}
    print(dataF)
    r = requests.post("http://localhost:8099/api/person/update", data=json.dumps(dataF), headers=headers)
    print(r)
    dat = r.json()
    if r.status_code == 200:
        flash("Se ha modificado correctamente", category='info')
        return redirect("/admin/person/list")
    else:
        flash(str(dat["data"]), category='error')
        return redirect("/admin/person/list")
