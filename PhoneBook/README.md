
mvn -v

mvn package

mvn clean install

java -jar target/phonebook.jar

```
docker build -t phonebook-java . 
docker images --all
docker run -it --rm -p 5085:8090 --name phonebook_container phonebook-java
docker run -d --restart=always --name phonebook_container -p 5085:8090 phonebook-java
docker run -d --restart=always -v с:/volumes/spring/uploading:/app/uploading --name phonebook_container -p 5085:8090 phonebook-java
docker run -d --restart=always -v /volumes/spring/uploading:/app/uploading --name phonebook_container -p 5085:8090 phonebook-java
docker ps -a
docker stop phonebook_container
docker rm phonebook_container

docker images --all
docker rmi phonebook-java

docker login
docker tag phonebook-java:latest andrxpie/phonebook-java:latest
docker push andrxpie/phonebook-java:latest

docker pull andrxpie/phonebook-java:latest
docker ps -a
docker run -d --restart=always --name phonebook_container -p 5085:8090 andrxpie/phonebook-java


docker pull andrxpie/phonebook-java:latest
docker images --all
docker ps -a
docker stop phonebook_container
docker rm phonebook_container
docker run -d --restart=always --name phonebook_container -p 5085:8090 andrxpie/phonebook-java

---------------/etc/nginx/sites-available/--------------------------

server {
    server_name   slush.itstep.click *.slush.itstep.click;
    location / {
       proxy_pass         http://localhost:5085;
       proxy_http_version 1.1;
       proxy_set_header   Upgrade $http_upgrade;
       proxy_set_header   Connection keep-alive;
       proxy_set_header   Host $host;
       proxy_cache_bypass $http_upgrade;
       proxy_set_header   X-Forwarded-For $proxy_add_x_forwarded_for;
       proxy_set_header   X-Forwarded-Proto $scheme;
    }
}

sudo nginx -t
sudo systemctl restart nginx
sudo systemctl status nginx
```