from fastapi import FastAPI

app = FastAPI()

@app.get("/")
async def root():
    return "Hola FastAPI"


@app.get("/url")
async def url():
    return { "url_curso":"https://mouredev.com/python" }





# Inicia el server: uvicorn main:app --reload
# Detener el server: CTRL+C

# Documentación con Swagger: http://127.0.0.1:8000/docs
# Documentación con Redocly: http://127.0.0.1:8000/redoc