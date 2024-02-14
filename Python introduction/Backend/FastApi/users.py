from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

# Entidad user
class User(BaseModel):
    id: int
    name: str
    surname: str
    url: str     
    age: int

users_list = [User(id= 1, name= "Abel", surname= "Gebel", url= "https://abel.gebel", age= 35),
              User(id= 2, name= "Abel", surname= "Geb", url= "https://abel.com", age= 30),
              User(id= 3, name= "A", surname= "Gebel", url= "https://gebel.com", age= 20)    
]



@app.get("/usersjason")
async def users():
    return [
            {"name": "Abel", "surname": "Gebel", "url": "https://abel.gebel", "age": 35},
            {"name": "Abel", "surname": "Geb", "url": "https://abel.com", "age": 30},
            {"name": "A", "surname": "Gebel", "url": "https://gebel.com", "age": 20}
        ]

#path
@app.get("/user/{id}")
async def user(id: int):
    return search_user(id)

@app.get("/users")
async def user():
    return users_list

#Query
@app.get("/userquery")  #http://127.0.0.1:8000/userquery/?id=1
async def user(id: int):
    return search_user(id)


@app.post("/user/")  
async def user(user: User):
    if type(search_user(user.id))==User:
        return {"ERROR, EL USUARIO YA EXISTE"}
    else:
        users_list.append(user)



@app.put("/user/")
async def user(user: User):

    found = False
    for index, saved_user in enumerate(users_list):
        if saved_user.id == user.id:
            users_list[index] = user
            found = True
    if not found:
        return  {"ERROR, NO SE HA AGREGADO EL USUARIO"}


@app.delete("/user/{id}")
async def user(id: int):
    found = False

    for index, saved_user in enumerate(users_list):
        if saved_user.id == id:
            del users_list[index]
            found = True
    if not found:
        return  {"ERROR, NO SE HA ELIMINADO EL USUARIO"}




def search_user(id: int):
    users = filter(lambda user: user.id == id, users_list)
    try:
        return list(users)[0]
    except:
        return {"ERROR"}    




