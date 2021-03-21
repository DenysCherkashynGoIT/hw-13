package ua.hw13;

import ua.hw13.entities.User;
import ua.hw13.http.CustomClient;

public class Application {
    //initialize new User-instance for use into examples below
    private static User user = new User();
    static {
        user.setName("Denys");
        user.setUsername("DenysCherkashyn");
        user.setEmail("d.a.cherkashin@ukr.net");
        user.setAddress("Schevchenko str", "Kyivskiy", "Kharkov", "620-01");
        user.setPhone("0506754992");
        user.setWebsite("https://goit.ua");
    }

    public static void main(String[] args) {
        CustomClient client = new CustomClient();
        //* ***************************************************************************************** *//
        //      Задание 1#
        //  Программа должна содержать методы для реализации следующего функционала:
        //  * создание нового объекта в https://jsonplaceholder.typicode.com/users.
        //      Возможно, вы не увидите обновлений на сайте. Метод создания работает правильно, если в ответ на JSON
        //      с объектом вернулся такой же JSON, но с полем id со значением на 1 больше,чем самый большой id на сайте.
            client.userCreate(user);
        System.out.println(client.responseToString());

        //  * обновление объекта в https://jsonplaceholder.typicode.com/users.
        //      Возможно, обновления не будут видны на сайте напрямую. Будем считать, что метод работает правильно,
        //      если в ответ на запрос придет обновленный JSON (он должен быть точно таким же, какой вы отправляли).
        //  Для прримера, изменим имя и телефон пользователя с id=8
             client.userGetById(8);
             User gettedUser = client.responseToObject(User.class);
             gettedUser.setName("Denys.Cherkashyn");
             gettedUser.setPhone("BROKEN");
             client.userUpdate(gettedUser);
        //System.out.println(client.responseToString());

        //  * удаление объекта из https://jsonplaceholder.typicode.com/users.
        //      Здесь будем считать корректным результат - статус из группы 2хх в ответ на запрос.
            client.userDelete(gettedUser);
        //System.out.println(client.response());
            client.userDelete(6);
        //System.out.println(client.response());

        //  * получение информации обо всех пользователях https://jsonplaceholder.typicode.com/users
            client.usersGet();
        //System.out.println(client.responseToString());

        //  * получение информации о пользователе с определенным id https://jsonplaceholder.typicode.com/users/{id}
            client.userGetById(4);
        //System.out.println(client.responseToString());

        //  * получение информации о пользователе с опредленным username - https://jsonplaceholder.typicode.com/users?username={username}
            client.userGetByUsername("Karianne");
        //System.out.println(client.responseToString());


        //* ***************************************************************************************** *//
        //      Задание 2#
        //  Дополните программу методом, который будет выводить все комментарии к последнему посту определенного
        //  пользователя и записывать их в файл.
        //      https://jsonplaceholder.typicode.com/users/1/posts Последним будем считать пост с наибольшим id.
        //      https://jsonplaceholder.typicode.com/posts/10/comments
        //  Файл должен называться "user-X-post-Y-comments.json", где Х - номер пользователя, Y - номер поста.
            client.commentsGetByLastPostToFile(5);


        //* ***************************************************************************************** *//
        //      Задание 3#
        //  Дополните программу методом, который будет выводить все открытые задачи для пользователя Х.
        //      https://jsonplaceholder.typicode.com/users/1/todos.
        //  Открытыми считаются все задачи, у которых completed = false.
            client.todosOpenGetByUserId(3);
        //System.out.println(client.responseToString());
    }
}
