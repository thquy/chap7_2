package murach.controllers;

import murach.business.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "viewAlbums";

        if (action.equals("checkUser")) {
            String productCode = request.getParameter("productCode");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            // Lấy danh sách bài hát theo productCode
            List<Map<String,String>> songs = getSongsByAlbum(productCode);

            request.setAttribute("productCode", productCode);
            request.setAttribute("songs", songs);

            if (user == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/downloads.jsp");
                rd.forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "register";

        if (action.equals("register")) {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            User user = new User(email, firstName, lastName);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            String productCode = request.getParameter("productCode");

            List<Map<String,String>> songs = getSongsByAlbum(productCode);
            request.setAttribute("productCode", productCode);
            request.setAttribute("songs", songs);

            RequestDispatcher rd = request.getRequestDispatcher("/downloads.jsp");
            rd.forward(request, response);
        }
    }

    private List<Map<String, String>> getSongsByAlbum(String productCode) {
        List<Map<String, String>> songs = new ArrayList<>();

        switch (productCode) {
            case "mck99":
                Map<String, String> song1 = new HashMap<>();
                song1.put("title", "Chìm Sâu");
                song1.put("file", "media/chim-sau.mp3");
                songs.add(song1);

                Map<String, String> song2 = new HashMap<>();
                song2.put("title", "Va Vào Giai Điệu Này");
                song2.put("file", "media/va-vao.mp3");
                songs.add(song2);

                Map<String, String> song3 = new HashMap<>();
                song3.put("title", "Tại Vì Sao");
                song3.put("file", "media/tai-vi-sao.mp3");
                songs.add(song3);
                break;

            case "vuBT":
                Map<String, String> song4 = new HashMap<>();
                song4.put("title", "Đông Kiếm Em");
                song4.put("file", "media/dong-kiem-em.mp3");
                songs.add(song4);

                Map<String, String> song5 = new HashMap<>();
                song5.put("title", "Bước Qua Mùa Cô Đơn");
                song5.put("file", "media/buoc-qua.mp3");
                songs.add(song5);

                Map<String, String> song6 = new HashMap<>();
                song6.put("title", "Lạ Lùng");
                song6.put("file", "media/la-lung.mp3");
                songs.add(song6);
                break;

            case "brayCB":
                Map<String, String> song7 = new HashMap<>();
                song7.put("title", "Con Trai Cưng");
                song7.put("file", "media/con-trai-cung.mp3");
                songs.add(song7);

                Map<String, String> song8 = new HashMap<>();
                song8.put("title", "Ex’s Hate Me");
                song8.put("file", "media/ex-hate-me.mp3");
                songs.add(song8);

                Map<String, String> song9 = new HashMap<>();
                song9.put("title", "Cho Bảo");
                song9.put("file", "media/cho-bao.mp3");
                songs.add(song9);
                break;

            case "karik421":
                Map<String, String> song10 = new HashMap<>();
                song10.put("title", "Người Lạ Ơi");
                song10.put("file", "media/nguoi-la-oi.mp3");
                songs.add(song10);

                Map<String, String> song11 = new HashMap<>();
                song11.put("title", "Anh Không Đòi Quà");
                song11.put("file", "media/anh-khong-doi-qua.mp3");
                songs.add(song11);

                Map<String, String> song12 = new HashMap<>();
                song12.put("title", "Điều Anh Biết");
                song12.put("file", "media/dieu-anh-biet.mp3");
                songs.add(song12);
                break;

            default:
                Map<String, String> songDefault = new HashMap<>();
                songDefault.put("title", "No songs available");
                songDefault.put("file", "#");
                songs.add(songDefault);
        }

        return songs;
    }

}
