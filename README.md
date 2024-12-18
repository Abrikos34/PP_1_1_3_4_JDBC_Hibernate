# JDBC Hibernate Project

## Описание
Этот проект демонстрирует работу с базой данных через JDBC, используя паттерн проектирования MVC. В проекте выполняются основные операции с таблицей пользователей:
- Создание таблицы
- Добавление пользователей
- Удаление пользователей по id
- Получение всех пользователей
- Очистка таблицы
- Удаление таблицы

## Требования
1. Установленный MySQL сервер
2. Конфигурированный доступ к базе данных
3. Java 17 или выше

## Структура проекта
- **model**: Классы для представления данных.
- **service**: Логика работы с данными.
- **dao**: Доступ к базе данных через JDBC.
- **util**: Утилитные классы для работы с подключениями.
- **test**: Юнит-тесты для проверки методов.

## Запуск проекта
1. Установите MySQL и создайте базу данных с именем `user_database`.
2. Настройте подключение к базе данных в классе `Util`.
3. Запустите `Main.java` для выполнения всех операций с пользователями.
