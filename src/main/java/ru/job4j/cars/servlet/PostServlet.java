package ru.job4j.cars.servlet;

import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.store.AdRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * postnew.do
 */
public class PostServlet extends HttpServlet {
    @Override//сюда прилетает введенные данные из web/candidate/edit.jsp после валидации онклик()
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        boolean bln = Boolean.parseBoolean(req.getParameter("status"));
        HttpSession session = req.getSession();
        User userid = (User) session.getAttribute("user");
        System.out.println("Что за ID Юзера Post: " + userid);

        var desc1 = (String) req.getParameter("body");
        var desc2 =  (String) req.getParameter("transm");
        var desc3 =  req.getParameter("drive");
        System.out.println("Описание сервлет ПостСервел : "
                + desc1 + " " + desc2 + " " + desc3
                );

        Post post = Post.of(req.getParameter("header"),
                req.getParameter("description"),
                req.getParameter("price"), bln);

        Car car = Car.of(req.getParameter("mark"),
                req.getParameter("body"),
                req.getParameter("engine"),
                req.getParameter("transm"),
                req.getParameter("color"),
                req.getParameter("drive"),
                req.getParameter("mileage")
        );
        String fht = (String) req.getParameter("header");
        Photo photo = Photo.of(fht + ".jpg");
        post.addUser(userid);
        post.addCar(car);
        post.addPhoto(photo);
        var t = AdRepository.instOf().savePost(post);
        System.out.println("PostServlet save " + t);
        resp.sendRedirect(req.getContextPath() + "/candidate.do");

    }
}
