package ru.job4j.cars.store;

import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Temp {
    public static Date subtractDays() {
        Date date = new Date(System.currentTimeMillis());
        int days = 1;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
    }

    public static void main(String[] args) {
        System.out.println("Data day - one: " + subtractDays());
//        public User saveUser(User user);
//
//        public Post savePost(Post post);

//        public boolean deletePostId(int id);
        AdRepository adRepository = new AdRepository();
        User user = User.of("John Smith", "SmithJohn@gmail.com", "John");
        Post post = Post.of("Lexus RX200t, 2016 год",
                "- Климат-контроль 2-зонный, Обогрев рулевого колеса, Подогрев передних сидений,"
                        + " Электрообогрев лобового стекла,"
                        + " Электроскладывание зеркал, Система доступа без ключа, Светодиодные фары",
                "3 649 000 ₽",
                false
        );
        Car car = Car.of("Lexus RX200t",
                "SUV",
                "бензин, 2.0 л., 238 л.с., налог ",
                "АКПП",
                "белый",
                "4WD",
                "107 432"
        );
        // adRepository.saveUser(user);
        user.setId(1);
        car.addUser(user);
        Photo photoF = Photo.of("Lexus RX200t.jpg");
        var foto1 = adRepository.savePhoto(photoF);
        photoF.setId(foto1.getId());
        var car2 = adRepository.saveCar(car);
        car.setId(car2.getId());
        post.addUser(user);
        post.addPhoto(photoF);
        post.addCar(car);

        var savePost = adRepository.savePost(post);
        System.out.println("То что сохранили в БД Объект пост : " + savePost);

//        var lasD = adRepository.lastDay();
//        for (Post post1 : lasD) {
//            System.out.println("ТО что нашли за последние день : " + post1);
//        }
//        var photo = adRepository.whenPhotoTrue();
//        for (Post post1 : photo) {
//            System.out.println("То что нашли объявления с фото : " + post1);
//        }
//        var makrAuto = adRepository.whenMarkAuto("Kia Sportage");
//        for (Post post1 : makrAuto) {
//            System.out.println("То что нашли объявления по марке авто : " + post1);
//        }
//        var emailFind = adRepository.findByEmail("root@local");
//        for (User user1 : emailFind) {
//            System.out.println("То что нашли user email : " + user1);
//        }
//        var userBuID = AdRepository.instOf().findUserById(1);
//        for (User user1 : userBuID) {
//            System.out.println("То что нашли объявления с фото : " + user1);
//        }
//        var postById = adRepository.findPostBiId(1);
//        for (Post post1 : postById) {
//            System.out.println("То что нашли объявления с фото : " + post1);
//        }
    }
}
