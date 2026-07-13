package utils;

import java.io.FileWriter;
//import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import api.UserAPI;

public class ApiHtmlGenerator {

    public static String createHtml() throws Exception {

        Response response =
                UserAPI.getUsers(ConfigReader.getApi());

        JsonPath jp = response.jsonPath();

        Map<String, Object> user = jp.getMap("data");

        System.out.println(user.get("id"));
        System.out.println(user.get("first_name"));
        System.out.println(user.get("email"));


        StringBuilder html = new StringBuilder();

        html.append("<html><body>");
        html.append("<table border='1'>");

        html.append("<tr>");
        html.append("<th>ID</th>");
        html.append("<th>First Name</th>");
        html.append("<th>Last Name</th>");
        html.append("<th>Email</th>");
        html.append("</tr>");


        html.append("<tr>");

        html.append("<td>")
            .append(user.get("id"))
            .append("</td>");

        html.append("<td>")
            .append(user.get("first_name"))
            .append("</td>");

        html.append("<td>")
            .append(user.get("last_name"))
            .append("</td>");

        html.append("<td>")
            .append(user.get("email"))
            .append("</td>");

        html.append("</tr>");


        html.append("</table>");
        html.append("</body></html>");


     //   String file =
     //   		"C:\\apache-tomcat-11.0.23\\webapps\\api-test\\apiUsers.html";

        String file = "apiUsers.html";

        FileWriter writer = new FileWriter(file);
        writer.write(html.toString());
        writer.close();

        return file;
    }
}