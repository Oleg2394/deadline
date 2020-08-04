
# Подготовка приложения app-deadline.jar к тестированию в СУБД MySql

## Перед началом тестирования

1. На ПК должна быть установлена JDK, IntelliJ IDEA, Docker DESKTOP

## Начало работы Этап первый
1. В docker-compose.yml прописать настройки запуска субд (образ, порты) и переменные окружения: 
```
version: '3.7'
services:
  mysql:
    image: mysql:8.0.18
    restart: always
    ports:
      - "3306:3306"
    volumes:
      - ./init_db:/docker-entrypoint-initdb.d
    environment:
      - MYSQL_RANDOM_ROOT_PASSWORD=yes
      - MYSQL_DATABASE=app
      - MYSQL_USER=app
      - MYSQL_PASSWORD=pass
```                                                                                                                                                         
                                                                                                                                                                        
### Установка и запуск Этап второй
2. Запустить Docker DESKTOP (Проверить что служба Docker запустилась)
3. Выполнить команду docker-compose up (Для установки и запуска контейнера)   
4. Запустить приложение командой:
4.1.   ```java -jar artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.password=pass ```
5. Запустить автотесты.
6. Перед повторным запуском автотестов следует остановить контейнер командой `docker-compose down` и повторить шаги 3-4.1.
