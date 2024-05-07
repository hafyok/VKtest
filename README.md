
# Тестовое задание от VK
Тестовое задание от ВК. Буду благодарен хотя за фидбек. 
## Задание
Задача:
Написать приложение, отображающее вывод товаров, используя
данные из https://dummyjson.com/products.
Приложение должно подгружать данные из интернета, кэширование
не требуется. Обязательно реализовать отображение полей title,
description и thumbnail. Дизайн можно выбрать на свое усмотрение,
но реализация должна соответствовать material guidelines. Данные
необходимо загружать страницами по 20 штук (управляется query
параметрами skip и limit. Например, /products?skip=40&limit=20
выведет 20 продуктов, начиная с 41-го). Использование сторонних
библиотек не воспрещается, но оно должно быть обоснованным.

В качестве референса экрана списка товаров можно (но не
обязательно) выбрать один из скриншотов ниже:
<p align="center">
<img src="https://github.com/hafyok/VKtest/assets/91025133/c63ec06b-6446-4e16-8573-adae6dbf7172">
<img src="https://github.com/hafyok/VKtest/assets/91025133/27fd8bce-db2c-487b-ac06-e6729315d2d3">
</p>

### Используемые технологии

 - Kotlin
 - Jetpack Compose
 - Retrofit2 (для загрузки данных)
 - Архитектура MVVM
 
 Для загрузки изображений использовал встроенный инструмент Jetpack Compose - AcyncImage. 

 Проект изначально взят с yuriykravets/BookShelf в качестве шаблона.

 ### Демо
 <p align="center">
<img src="https://github.com/hafyok/VKtest/assets/91025133/2871001f-8c8d-471f-ab2c-98f23eebc052">
</p>
 <p align="center">
<img src="https://github.com/hafyok/VKtest/assets/91025133/7827f758-0c65-4c2c-90bb-bee8f0890ac1">
</p>
 <p align="center">
<img src="https://github.com/hafyok/VKtest/assets/91025133/0f9de3a2-d627-4f76-a456-89aa9299c62f">
</p>


