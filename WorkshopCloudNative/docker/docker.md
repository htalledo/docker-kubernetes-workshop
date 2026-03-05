# Consultar imagenes
docker images

# Consultar contenedores (vivos)
docker ps

# Consultar contenedores (vivos y muertos)
docker ps -a

# Detener contenedor 
docker stop <ID/alias>

# Eliminar un contenedor detenido
docker rm <ID/alias>

# Eliminar imagenes
docker rmi <ID>

# Construir imagen docker
docker build -t containersoga/mi-hola-mundo .
Tecnicas para el tag : 1.0.1 - > Hash del commit de GIT 

# Correr imagen de docker
docker run containersoga/mi-hola-mundo

# Construir imagen nginx hello world
docker build -t containersoga/nginx-helloworld .

# Correr imagen nginx hello world
docker run -d -p 8088:80 --name contenedor-nginx containersoga/nginx-helloworld

# Revisar los logs de un contenedor
docker logs contenedor-nginx

# Revisar los logs de un contenedor, atrapando la consola
docker logs -f contenedor-nginx

# Revisar los logs de un contenedor con un tail
docker logs --tail 10 contenedor-nginx

# Conectarse a un contenedor
docker exec -it contenedor-nginx /bin/bash
docker exec -it contenedor-nginx sh

# Compilar los servicios de un docker compose
docker-compose build

# Correr los servicios de un docker compose (opcionalmente --build)
docker-compose up -d

# Dar de baja servicios de un docker compose
docker-compose down

# Publicar imagen docker
docker push containersoga/nginx-helloworld