### Docker镜像加速
```json
{
  "experimental" : true,
  "insecure-registries" : [
    "pej6yiio.mirror.aliyuncs.com",
    "dockerhub.azk8s.cn",
    "reg-mirror.qiniu.com"
  ],
  "debug" : true,
  "registry-mirrors" : [
    "https://pej6yiio.mirror.aliyuncs.com"
  ]
}
```


### 下载并启动MongoDB
```bash
docker pull mongo

docker run --name mongo -p 27017:27017 -v ~/docker-data/mongo:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo

docker ps 

docker ps -a

docker exec -it mongo bash

```

### 登陆MongoDB并创建数据和用户

```
mongo -u admin -p admin
show dbs;

use springbucks;

db.createUser(
    {
        user: "springbucks",
        pwd: "springbucks",
        roles:[
            {
                role: "readWrite",
                db: "springbucks"
            }
        ]
    }
);

show users;

```

### 下载并启动Redis

```bash
docker pull redis

docker run --name redis -p 6379:6379 -d redis

docker exec -it redis bash

```

### 登陆Redis
```
redis-cli

keys *;

```

### 启动MySQL
```

docker run --name mysql5.7 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root123 -d mysql:5.7

docker exec -it mysql5.7 bash


```

### 登陆MySQL

```
mysql -uroot -proot123

show databases;
use mysql;
show tables;
```