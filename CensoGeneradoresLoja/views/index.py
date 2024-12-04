from app import create_app

# Crear la aplicación
app = create_app()

if __name__ == '__main__':
    # Configuraciones de la aplicación
    app.secret_key = 'censo_generadores_loja_secreto'  # Cambiar por una clave segura en producción
    app.config['SESSION_TYPE'] = 'filesystem'  # Almacenar sesiones en el sistema de archivos
    app.config['TEMPLATES_AUTO_RELOAD'] = True  # Recarga automática de plantillas durante el desarrollo
    
    # Ejecutar el servidor
    app.run(debug=True, host="0.0.0.0", port=5000)
