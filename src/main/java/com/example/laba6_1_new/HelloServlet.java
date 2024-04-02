
package com.example.laba6_1_new;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("username");
        String age = request.getParameter("userage");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] courses = request.getParameterValues("courses");

        File file = new File("C:\\Users\\annyt\\IdeaProjects\\LABA6_1_NEW\\src\\main\\java\\com\\example\\laba6_1_new\\file.txt");
        int count = 0;
        try {
            Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name());
            scanner.useDelimiter("\\s+");

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.equalsIgnoreCase(name)) {
                    count++;
                }
            }



            scanner.close();
        } catch (FileNotFoundException e) {
            writer.println("<p >File not found</p>");
        }

        // В сервлете
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
// Предполагается, что переменные name, age, gender, country и courses уже инициализированы и содержат данные.
        out.println("<html><head><title>Student Data</title></head><body>");
        out.println("<style>/* style.css */\n" +
                "body {\n" +
                "font-family: 'Arial', sans-serif;\n" +
                "background-color: #f4f4f4;\n" +
                "margin: 0;\n" +
                "padding: 0;\n" +
                "display: flex;\n" +
                "justify-content: center;\n" +
                "align-items: center;\n" +
                "height: 100vh;\n" +
                "}\n" +
                "\n" +
                "header {\n" +
                "width: 100%;\n" +
                "background-color: #4CAF50; /* Зеленый цвет фона шапки */\n" +
                "padding: 10px 0;\n" +
                "text-align: center;\n" +
                "}\n" +
                "\n" +
                "header img {\n" +
                "max-height: 100px; /* Высота вашей картинки */\n" +
                "}\n" +
                "\n" +
                ".container {\n" +
                "width: 50%; /* Ширина контейнера */\n" +
                "background-color: #fff;\n" +
                "padding: 15px;\n" +
                "border: 3px solid #4CAF50; /* Зеленая рамка */\n" +
                "border-radius: 8px;\n" +
                "box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" +
                "margin-top: 20px; /* Отступ сверху */\n" +
                "}\n" +
                "\n" +
                "#studentData {\n" +
                "text-align: center; /* Выравнивание данных по центру */\n" +
                "color: #333; /* Цвет текста */\n" +
                "}\n" +
                "\n" +
                "input[type='text'] {\n" +
                "color: #5cb85c; /* Цвет текста в полях */\n" +
                "font-weight: bold; /* Жирное начертание текста */\n" +
                "background-color: #eef9ee; /* Светло-зеленый фон полей */\n" +
                "border: 1px solid #4CAF50; /* Зеленая рамка вокруг полей */\n" +
                "}\n" +
                "\n" +
                "input[type='submit'] {\n" +
                "background-color: #5cb85c;\n" +
                "color: white;\n" +
                "border: none;\n" +
                "cursor: pointer;\n" +
                "font-size: 16px; /* Размер шрифта кнопки */\n" +
                "padding: 12px 20px; /* Отступы внутри кнопки */\n" +
                "border-radius: 4px; /* Скругление углов кнопки */\n" +
                "}\n" +
                "\n" +
                "input[type='submit']:hover {\n" +
                "background-color: #4cae4c;\n" +
                "}</style>");
        out.println("<form action='submitData' method='POST'>"); // 'submitData' это URL, который обрабатывает данные на сервере
        out.println("<p> found " + name + " " + count + " times</p>");
        out.println("<p align='center' id='name'>Name: <input type='text' name='name' value='" + name + "' readonly></p>");
        out.println("<p align='center' id='age'>Age: <input type='text' name='age' value='" + age + "' readonly></p>");
        out.println("<p align='center' id='gender'>Gender: <input type='text' name='gender' value='" + gender + "' readonly></p>");
        out.println("<p align='center' id='country'>Country: <input type='text' name='country' value='" + country + "' readonly></p>");
        out.println("<h4 align='center'>Courses</h4>");
        for (String course : courses) {
            out.println("<p align='center'><input type='text' name='courses' value='" + course + "' readonly></p>");
        }

        out.println("</form>");
        out.println("</body></html>");
        out.close();
    }
}