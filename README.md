[![Build Status](https://travis-ci.com/delock1/apilab2.svg?branch=master)](https://travis-ci.com/delock1/apilab2)
# Технология разработки программного обеспечения
# Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных
## Сметанин Андрей Михайлович, Группа 3МБД2001
## Цель лабораторной работы: 
Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).


Приложение представляет из себя простой микросервис, реализующий CRUD на примере внутренней телефонной базы.
Для работы приложения требуется запущенная БД postgresql. 
#### Подготовка базы данных 
В файле <code>./src/main/resources/application.properties</code> следует указать в параметре <code>spring.datasource.username = </code> имя пользователя для доступа в БД, в параметре <code>spring.datasource.password = </code> пароль для доступа к БД. В параметре <code>spring.datasource.url = </code> необходимо указать адрес для доступа к БД, например для доступа к БД запущенной на локальном компьютере значение будет <code>jdbc:postgresql://localhost:5432/postgresql</code>, для БД запущенной в docker на локальной машине значение будет <code>jdbc:postgresql://172.17.0.1:5432/postgresql</code>.   
Настройка базы данных осуществляется с помощью <code>./src/main/resources/schema.sql</code>. Для этого необходимо выполнить команду <code>psql -h <адрес_БД> -p <порт_БД> -U <имя_пользователя> -d public -f "schema.sql"</code> .  
Тестовые данные для БД находятся в <code> ./src/main/resources/data.sql </code> . Для этого необходимо выполнить команду <code>psql -h <адрес_БД> -p <порт_БД> -U <имя_пользователя> -d public -f "data.sql"</code> .    
Также можно установить postgresql с помощью docker использую комманды <code>docker pull postgres</code> для скачивания и <code>docker run -e POSTGRES_PASSWORD=root -p 5432:5432 postgres</code> для запуска.



#### Клонирование репозитария
Для клонирования репозитория необходимо выполнить команду <code>git clone https://github.com/delock1/lab1.git</code> или же скачать zip-архив и распаковать его.
#### Сборка проекта с помощью Maven
Сборка приложения осуществляется при помощи автоматической системы сборки проектов Maven. Для сборки необходимо выполнить команду  <code>mvn package -Dmaven.test.skip=true</code>(с пропуском тестирования) находясь в директории проекта. После окончания выполнения команды появится папка <code>target</code> в которой находится скомпилированный код и файл <code>apilab-1.0.jar</code>.
#### Сборка и запуск Docker-образа 
Для сборки Docker образа следует выполнить команду <code> docker build -t apilab:v1 . </code> находясь в директории с <code>Dockerfile</code> и собранным <code>apilab-1.0.jar</code> .  
Запуск осуществляется командой <code>docker run -p 8080:8080 apilab:v1 </code>, где первым указывается порт в локальной системе, а вторым порт docker.  
#### Примеры запросов к apilab . 
Формат JSON:
<code>{name: "string", department: "string ",room: integer, callnumber: integer}</code>


##### Получить список всех номеров телефонов: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/persons</code>
В ответ будет получен JSON. 
##### Получить запись по id: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/persons/{id}</code> 
В ответ будет получен JSON с результатом. 
##### Добавить запись: 
<code>curl -X POST http://127.0.0.1:8080/api/v1/persons -d ‘{«name»: «Имя″, "department": "Отдел", "room": 101, "callnumber": 155}’ -H «Content-Type:application/json»</code>
В ответ будет получен статус <code>200 ОК</code>.
##### Удалить запись: 
<code>curl -i -X DELETE http://127.0.0.1:8080/api/v1/persons/del/{id}</code>
В ответ будет получен статус <code>204 No Content</code>.

##### Также приложение возвращает значение hostname: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/status</code>
В ответ будет получен JSON в виде <code>{hostname: "hostname"}</code>. 
  
    
      
        
 # Лабораторная работа №3: CI/CD и деплой приложения в Heroku
# Цель работы: 
## Целью лабораторной работы является знакомство с CI/CD и его реализацией на примере Travis CI и Heroku.

## Ссылка на развернутое приложение: 
[Ссылка на развернутое приложение](https://labapi2.herokuapp.com/api/v1/status "Ссылка на развернутое приложение")

