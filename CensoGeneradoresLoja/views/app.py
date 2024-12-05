from flask import Flask, render_template

def create_app():
    app = Flask(__name__, instance_relative_config=False)

    # Configuración general de la aplicación
    app.config['SECRET_KEY'] = 'tu_clave_secreta_aqui'  # Cambiar por una clave segura
    app.config['TEMPLATES_AUTO_RELOAD'] = True

    with app.app_context():
        # Importación y registro de los Blueprints
        from routes.route import router
        from routes.routeEquipo import routeEquipo

        app.register_blueprint(router)
        app.register_blueprint(routeEquipo)

        # Manejo de errores personalizados
        @app.errorhandler(404)
        def page_not_found(e):
            return render_template('errors/404.html'), 404

        @app.errorhandler(500)
        def internal_server_error(e):
            return render_template('errors/500.html'), 500

    return app

# Ejecutar la aplicación si se llama directamente
if __name__ == "__main__":
    app = create_app()
    app.run(host="0.0.0.0", port=5000, debug=True)
