from flask import Flask
def create_app():
    app = Flask(__name__, instance_relative_config=False)
    with app.app_context():
        from routes.route import router
        from routes.routeEquipo import routeEquipo
        app.register_blueprint(router)
        app.register_blueprint(routeEquipo)
    return app