# Explore With Me
В рамках дипломного проекта реализовано приложение, представляющее из себя афишу, в которой пользователи могут предлагать мероприятия и собирать компанию для участия в них.

<span style="font-size:48px;">***Используемые технологии:***</span>


Java 11

REST API

Spring

Maven

микросервисы, Docker

PostgreSQL

JPA, Hibernate

Lombok

Postman

<span style="font-size:48px;">***Используемые технологии:***</span>

<img width="1440" alt="explore" src="https://github.com/Kirillzhukov737/java-explore-with-me/assets/110101893/060a9841-3fdb-4900-a50c-21e280b73a46">

Приложение содержит два микросервиса:

<span style="font-size:48px;">***main-service***</span>

<span style="font-size:48px;">***для бизнес-логики***</span>

<span style="font-size:48px;">***stat-service***</span>

для сбора статистики просмотра событий по ip,
который состоит из трех модулей (модуль общих DTO, модуль сервиса статистики, модуль клиента сервиса статистики)
У каждого микросервиса есть своя база данных.
Микросервисы и базы данных запускаются в собственных Docker контейнерах (4 шт).

<span style="font-size:48px;">***Основная функциональность:***</span>

<span style="font-size:48px;">***Неавторизованные пользователи***</span>

- просматривать все события, в том числе по категориям
- видеть детали отдельных событий
- видеть закрепленные подборки событий
- оставлять комментарии

<span style="font-size:48px;">***Авторизованные пользователи***</span>

- добавление в приложение новые мероприятия
- редактировать их и просматривать после добавления
- подача заявок на участие в интересующих мероприятиях
- создатель мероприятия может подтверждать заявки, которые отправили другие пользователи сервиса
- 
<span style="font-size:48px;">***Администраторы***</span>
  
- добавление, изменение и удаление категорий для событий
- добавление, удаление и закрепление на главной странице подборки мероприятий
- модерация событий, размещённых пользователями, — публикация или отклонение
  
<span style="font-size:48px;">***Эндпоинты***</span>

<span style="font-size:48px;">***main-service***</span>

POST /users/{userId}/events - добавить новое событие

GET /users/{userId}/events/{eventId} - получить событие

PATCH /users/{userId}/events/{eventId} - изменить событие

GET /users/{userId}/events - получить события пользователя

GET /users/{userId}/events/{eventId}/requests - получить запросы пользователя на участие в событии

PATCH /users/{userId}/events/{eventId}/requests - изменить статус (подтверждение, отмена) заявок на участие пользователя в событии

GET /categories - получить все категории

GET /categories/{catId} - получить категорию

GET /compilations - получить все подборки событий

GET /compilations/{compId} - получить подборку событий

GET /admin/events - получить события по любым параметрам:

users - список id пользователей
states - список статусов события (PENDING, PUBLISHED, CANCELED)
categories - список id категорий событий
rangeStart - начало временного отрезка в формате yyyy-MM-dd HH:mm:ss
rangeEnd - конец временного отрезка в формате yyyy-MM-dd HH:mm:ss
from - параметр для пагинации
size - параметр для пагинации
PATCH /admin/events/{eventId} - изменить событие

GET /events - получить события по любым параметрам:

text - текст для поиска в названии и описании событий
categories - список id категорий событий
paid - только платные события (true/false)
rangeStart - начало временного отрезка в формате yyyy-MM-dd HH:mm:ss
rangeEnd - конец временного отрезка в формате yyyy-MM-dd HH:mm:ss
onlyAvailable - только доступные события, т.е. у которых еще не исчерпан лимит участников (true/false)
sort - способ сортировки событий (EVENT_DATE, VIEWS)
from - параметр для пагинации
size - параметр для пагинации
GET /events/{id} - получить событие

GET /comments/{eventId} - Получает список всех комментариев события по его идентификатору со страницами

POST /comments/users/{userId}/events/{eventId} - запрос на добавление нового комментария от пользователя к событию

PATCH /comments/users/{userId}/{commentId} - запрос на обновление комментария пользователем по его ID

GET /comments/users/{userId}/comments - запрос на получение списка комментариев, созданных пользователем

DELETE /comments/users/{userId}/{commentId} - запрос на удаление комментария пользователем по его ID

GET /comments/users//{userId}/{commentId} - запрос на получение комментария пользователя по его ID

POST /users/{userId}/requests - добавить запрос на участие в событии

GET /users/{userId}/requests - получить запросы пользователя на участие в событиях

DELETE /users/{userId}/requests/{requestId}/cancel - отменить запрос на участие в событии

POST /admin/users - добавить пользователя

GET /admin/users - получить всех пользователей

DELETE /admin/users/{userId} - удалить пользователя

POST /admin/compilations - добавить подборку событий

DELETE /admin/compilations/{compId} - удалить подборку событий

PATCH /admin/compilations/{compId} - обновить подборку событий

POST /admin/categories - добавить новую категорию

GET /admin/categories/{catId} - получить категорию событий

DELETE /admin/categories/{catId} - удалить категорию

GET /admin/comments/{commentId} - получить комментария по идентификатору

GET /admin/comments/search - поиск комментариев по тексту

<span style="font-size:48px;">***stats-service***</span>
GET /stats - Получение статистики по посещениям
POST /hit - Сохранение информации о том, что на uri конкретного сервиса был отправлен запрос пользователем
